package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
//import cn.gtcommunity.epimorphism.common.worldgen.SuperSpaceLevelSource;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class EPDimensionTypes {
    private static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATOR_REGISTER = DeferredRegister.create(Registries.CHUNK_GENERATOR, Epimorphism.MOD_ID);
    public static final ResourceKey<DimensionType> SUPER_SPACE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, Epimorphism.id("super_space"));

    public static void init() {
        initGenerator();
    }

    public static void register(IEventBus bus) {
        CHUNK_GENERATOR_REGISTER.register(bus);
    }

    public static void initGenerator() {
//        CHUNK_GENERATOR_REGISTER.register(EPBiomes.SUPER_SPACE.location().getPath(), () -> SuperSpaceLevelSource.CODEC);
    }

//    public static DimensionOptions mindscapeBuilder(MinecraftServer server, RegistryKey<DimensionOptions> dimensionKey)
//    {
//        DynamicRegistryManager registies = server.getRegistryManager();
//        return new DimensionOptions(
//                registies.get(Registry.DIMENSION_TYPE_KEY).entryOf(DimensionTypes.MINDSCAPE_DIM_TYPE),
//                new MindChunkGenerator(server)
//        );
//    }
//
//    public static ServerWorld createMindscape(MinecraftServer server, BlockPos spawnLocation)
//    {
//        ServerWorld mindscape = server.getWorld(Dimensions.MINDSCAPE_DIMENSION_KEY);
//
//        StructurePlacementData settings = (new StructurePlacementData()).setIgnoreEntities(true).setMirror(BlockMirror.NONE.NONE).setRotation(BlockRotation.NONE);
//        StructureTemplateManager manager = mindscape.getStructureTemplateManager();
//        Identifier mindscapeLibraryLocation = new Identifier(Hexkeys.MOD_ID, "mindscape");
//
//        Optional<StructureTemplate> templateOptional = manager.getTemplate(mindscapeLibraryLocation);
//        if (templateOptional.isPresent())
//        {
//            StructureTemplate template = templateOptional.get();
//            BlockPos pos = new BlockPos(spawnLocation.getX() + (-template.getSize().getX() / 2), DimensionHelper.FLOOR_LEVEL - (template.getSize().getY() - 20), spawnLocation.getZ() + (-template.getSize().getZ() / 2));
//            template.place(mindscape, pos, new BlockPos(0, 0, 0), settings, mindscape.random, 0);
//        }
//
//        return mindscape;
//    }
//
//    public static void verifyMindscape(ServerWorld world)
//    {
//        if(!DimensionHelper.isDimensionOfType(world, DimensionTypes.MINDSCAPE_DIM_TYPE)) return;
//        List<ServerPlayerEntity> players = world.getPlayers();
//        players.forEach(player -> {
//            NbtCompound mindNBT = PlayerHelper.getPersistentTag(player, Hexkeys.IDENTIFIER.toString());
//            String mindscapeOwnerUUID = mindNBT.getString("CURRENT_MINDSCAPE_OWNER_UUID");
//            BlockPos mindscapeCenter = DimensionHelper.getMindscapePos(UUID.fromString(mindscapeOwnerUUID));
//            BlockPos playerPosition = player.getBlockPos();
//            double distanceFromCenter = MathHelper.distanceBetweenBlockPos(mindscapeCenter, playerPosition);
//            if(distanceFromCenter > 3000 || playerPosition.getY() < -40) {
//                player.fallDistance = 0;
//                player.teleport(mindscapeCenter.getX()+0.5, mindscapeCenter.getY(), mindscapeCenter.getZ()+0.5);
//            }
//        });
//    }
}
