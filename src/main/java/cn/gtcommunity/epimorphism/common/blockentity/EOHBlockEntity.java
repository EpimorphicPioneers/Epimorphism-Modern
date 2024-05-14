package cn.gtcommunity.epimorphism.common.blockentity;

import com.epimorphismmc.monomorphism.blockentity.MOBlockEntityBase;
import com.gregtechceu.gtceu.api.GTValues;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.stream.IntStream;

import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static com.epimorphismmc.monomorphism.utility.MOMathUtils.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EOHBlockEntity extends MOBlockEntityBase {

    private static final float MAX_ANGLE = 30;
    private static final double EOH_STAR_FIELD_RADIUS = 13;

    private static final String EOH_NBT_TAG = "EOH:";
    private static final String ROTATION_SPEED_NBT_TAG = EOH_NBT_TAG + "rotationSpeed";
    private static final String SIZE_NBT_TAG = EOH_NBT_TAG + "size";
    private static final String TIER_NBT_TAG = EOH_NBT_TAG + "tier";

    public float angle;
    @Getter @Setter
    private float size = 10;
    @Getter @Setter
    private float rotationSpeed = 10;
    @Getter @Setter
    private long tier = 9;

    @Getter
    private final ArrayList<OrbitingObject> orbitingObjects = new ArrayList<>();
    private static final Set<String> BLACKLISTED_BLOCKS = Set.of("twilight_forest", "overworld", "the_end", "EA", "VA");
    private static final Map<String, Block> BLOCKS = new HashMap<>();

    public EOHBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    static {
        ALL_DIM_DISPLAY_BLOCKS.forEach((dimString, dimBlock) -> {
            if (!BLACKLISTED_BLOCKS.contains(dimString)) {
                BLOCKS.put(dimString, dimBlock.get());
            }
        });
    }

    public <T> ArrayList<T> selectNRandomElements(Collection<T> inputList, long n) {
        ArrayList<T> randomElements = new ArrayList<>((int) n);
        ArrayList<T> inputArray = new ArrayList<>(inputList);
        IntStream.range(0, (int) n).forEach(i -> {
            int randomIndex = GTValues.RNG.nextInt(inputArray.size());
            randomElements.add(inputArray.get(randomIndex));
            inputArray.remove(randomIndex);
        });
        return randomElements;
    }

    public void generateImportantInfo() {
        var blocks = selectNRandomElements(BLOCKS.values(), tier + 1);
        for (int i = 0; i < blocks.size(); i++) {
            var block = blocks.get(i);
            float xAngle = nextFloat(-MAX_ANGLE, MAX_ANGLE);
            float zAngle = nextFloat(-MAX_ANGLE, MAX_ANGLE);
            float distance = i + nextFloat(-0.2f, 0.2f);
            float scale = nextFloat(0.2f, 0.9f);
            float rotationSpeed = nextFloat(0.5f, 1.5f);
            float orbitSpeed = nextFloat(0.5f, 1.5f);
            orbitingObjects.add(new OrbitingObject(block, distance, rotationSpeed, orbitSpeed, xAngle, zAngle, scale));
        }
    }

    public void clientTick() {
        angle = Math.abs(++angle);
    }

    @Override
    public AABB getRenderBoundingBox() {
        var pos = getBlockPos();
        return new AABB(pos, pos.offset(1, 1, 1))
                .inflate(EOH_STAR_FIELD_RADIUS, EOH_STAR_FIELD_RADIUS, EOH_STAR_FIELD_RADIUS);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putFloat(ROTATION_SPEED_NBT_TAG, rotationSpeed);
        tag.putFloat(SIZE_NBT_TAG, size);
        tag.putLong(TIER_NBT_TAG, tier);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        rotationSpeed = tag.getFloat(ROTATION_SPEED_NBT_TAG);
        size = tag.getFloat(SIZE_NBT_TAG);
        tier = tag.getLong(TIER_NBT_TAG);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat(ROTATION_SPEED_NBT_TAG, rotationSpeed);
        tag.putFloat(SIZE_NBT_TAG, size);
        tag.putLong(TIER_NBT_TAG, tier);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public record OrbitingObject (Block block, float distance, float rotationSpeed, float orbitSpeed, float xAngle,
                           float zAngle, float scale) {

    }

}
