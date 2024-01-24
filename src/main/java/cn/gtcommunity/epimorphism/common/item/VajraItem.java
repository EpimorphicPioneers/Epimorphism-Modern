package cn.gtcommunity.epimorphism.common.item;

/*
 * Referenced some code from Mekanism
 *
 * https://github.com/mekanism/Mekanism/
 * */

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class VajraItem extends ComponentItem{

    public static final Set<ToolAction> ALWAYS_SUPPORTED_ACTIONS = Set.of(ToolActions.AXE_DIG, ToolActions.HOE_DIG, ToolActions.SHOVEL_DIG, ToolActions.PICKAXE_DIG, ToolActions.SWORD_DIG);
    private static final long DESTROY_ENERGY = 3000L;

    public VajraItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState block) {
        return true;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if (ALWAYS_SUPPORTED_ACTIONS.contains(toolAction)) {
            var electricItem = GTCapabilityHelper.getElectricItem(stack);
            if (electricItem != null) {
                long energyAvailable = electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, true);
                return energyAvailable > 0L;
            }
        }
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, false);
        }
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 0;
    }

//    @Override
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
//        if (slot != EquipmentSlot.MAINHAND) return super.getAttributeModifiers(slot, stack);
//
//        var electricItem = GTCapabilityHelper.getElectricItem(stack);
//        FloatingLong energy = energyContainer == null ? FloatingLong.ZERO : energyContainer.getEnergy();
//        FloatingLong energyCost = MekanismConfig.gear.disassemblerEnergyUsageWeapon.get();
//        if (energy.greaterOrEqual(energyCost)) {
//            //If we have enough energy to act at full damage, use the cached multimap rather than creating a new one
//            // This will be the case the vast majority of the time
//            return attributeCache.get();
//        }
//        //If we don't have enough power use it at a reduced power level
//        int minDamage = MekanismConfig.gear.disassemblerMinDamage.get();
//        int damageDifference = MekanismConfig.gear.disassemblerMaxDamage.get() - minDamage;
//        double damage = minDamage + damageDifference * energy.divideToLevel(energyCost);
//        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", damage, AttributeModifier.Operation.ADDITION));
//        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", MekanismConfig.gear.disassemblerAttackSpeed.get(), Operation.ADDITION));
//        return builder.build();
//    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            tooltipComponents.add(Component.translatable("metaitem.generic.electric_item.tooltip",
                    electricItem.getCharge(),
                    electricItem.getMaxCharge(),
                    GTValues.VNF[electricItem.getTier()]));
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }


    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    public static boolean canDestroyBlock(ItemStack stack) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            return electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, true) >= DESTROY_ENERGY;
        }
        return false;
    }

    public static void discharge(ItemStack stack) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, false);
        }
    }
}
