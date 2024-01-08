package cn.gtcommunity.epimorphism.common.item.behaviors;

import cn.gtcommunity.epimorphism.utils.EPTransformUtil;
import com.gregtechceu.gtceu.api.item.component.IInteractionItem;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class OrganismCaptureBehavior implements IInteractionItem {
    public static final String OC_ENTITY = "OC_Entity";

    public static final OrganismCaptureBehavior INSTANCE = new OrganismCaptureBehavior();
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        return player != null && hasEntity(itemStack) && release(itemStack, level, blockPos, direction) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (player != null && !hasEntity(stack) && capture(interactionTarget, stack)) {
            player.setItemInHand(usedHand, stack);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext context) {
        return IInteractionItem.super.onItemUseFirst(itemStack, context);
    }

    private boolean capture(LivingEntity entity, ItemStack itemStack) {
        if (entity.getCommandSenderWorld().isClientSide()) return false;

        if (entity instanceof Player || !entity.canChangeDimensions() || !entity.isAlive()) return false;
        saveEntity(itemStack, entity);
        return true;
    }

    private boolean release(ItemStack itemStack, Level level, BlockPos blockPos, Direction direction) {
        if (!hasEntity(itemStack)) return false;
        LivingEntity entity = readEntity(itemStack, level);
        if (entity != null) {
            blockPos = blockPos.relative(direction);
            entity.absMoveTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0);
            itemStack.setTag(null);
            level.addFreshEntity(entity);
            return true;
        }
        return false;
    }

    private void saveEntity(ItemStack itemStack, LivingEntity entity) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putString(OC_ENTITY, EPTransformUtil.entityToString(entity));
        entity.saveWithoutId(compoundTag);
        entity.remove(Entity.RemovalReason.KILLED);
    }

    private LivingEntity readEntity(ItemStack itemStack, Level level) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        String key = compoundTag.getString(OC_ENTITY);
        Entity entity = EPTransformUtil.stringToEntity(key, level, compoundTag, true);
        if (entity instanceof LivingEntity) return (LivingEntity) entity;
        return null;
    }

    public static boolean hasEntity(ItemStack itemStack) {
        if (itemStack == null) return false;

        return itemStack.hasTag() && itemStack.getTag().contains(OC_ENTITY);
    }

    public static String getEntityName(ItemStack itemStack) {
        if (hasEntity(itemStack)) {
            return LocalizationUtils.format(new ResourceLocation("entity." + itemStack.getOrCreateTag().getString(OrganismCaptureBehavior.OC_ENTITY)).toLanguageKey());
        }
        return LocalizationUtils.format("epimorphism.universal.tooltip.none");
    }
}
