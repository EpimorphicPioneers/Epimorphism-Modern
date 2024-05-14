//package cn.gtcommunity.epimorphism.api.dimension.superspace;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.dimension.DimensionType;
//import org.joml.Vector3d;
//
//import java.util.UUID;
//
//public class EPDimensionHelper {
//    public static final int FLOOR_LEVEL = 64;
//
//    public static boolean isInMindscape(LivingEntity entity)
//    {
//        return isDimensionOfType(entity.level(), DimensionRegistry.DimensionTypes.MINDSCAPE_DIM_TYPE);
//    }
//
//    public static boolean isDimensionOfType(Level world, RegistryKey<DimensionType> dimTypeKey)
//    {
//        // I think it has to be done this way since the soul dimension is not
//        // shared between players like it is in random things SpectreKey dimension
//        DimensionType type = world.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(dimTypeKey);
//        return type != null && type.equals(world.getDimension());
//    }
//
//    public static void flipDimension(ServerPlayer player, MinecraftServer server)
//    {
//        flipDimension(player, player.getUuid(), server);
//    }
//
//    public static BlockPos getMindscapePos(UUID mindscapeOwnerUUID) {
//        Random randX = new Random(mindscapeOwnerUUID.getLeastSignificantBits());
//        Random randY = new Random(mindscapeOwnerUUID.getMostSignificantBits());
//
//        double minimumSpacingBetweenIslands = 20_000;
//        double x = (minimumSpacingBetweenIslands * randX.nextInt(-1000, 1000));
//        double y = FLOOR_LEVEL + 2;
//        double z = (minimumSpacingBetweenIslands * randY.nextInt(-1000, 1000));
//        return new BlockPos(x, y, z);
//    }
//
//    public static void flipDimension(ServerPlayer player, UUID mindscapeOwnerUUID, MinecraftServer server)
//    {
//        CompoundTag mindNBT = PlayerHelper.getPersistentTag(player, Hexkeys.IDENTIFIER.toString());
//        ServerLevel destination;
//        BlockPos mindscapeLocation = getMindscapePos(mindscapeOwnerUUID);
//        double x = mindscapeLocation.getX() + 0.5;
//        double y = FLOOR_LEVEL + 2;
//        double z = mindscapeLocation.getZ() + 0.5;
//
//        if (isInMindscape(player))
//        {
//            RegistryKey<Level> destinationKey =
//                    RegistryKey.of(
//                            Registry.WORLD_KEY,
//                            new Identifier(
//                                    mindNBT.getString(NBTKeys.LAST_DIMENSION_MOD_ID),
//                                    mindNBT.getString(NBTKeys.LAST_DIMENSION_MOD_DIMENSION))
//                    );
//
//            x = mindNBT.getDouble(NBTKeys.LAST_DIMENSION_X);
//            y = mindNBT.getDouble(NBTKeys.LAST_DIMENSION_Y);
//            z = mindNBT.getDouble(NBTKeys.LAST_DIMENSION_Z);
//
//            try
//            {
//                destination = server.getWorld(destinationKey);
//            }
//            catch (Exception e)//sometimes people remove mods. Protect against unknown by sending them to overworld spawn.
//            {
//                destination = server.getOverworld();
//
//                final BlockPos sharedSpawnPos = destination.getSpawnPos();
//                x = sharedSpawnPos.getX();
//                y = sharedSpawnPos.getY();
//                z = sharedSpawnPos.getZ();
//            }
//            player.getAbilities().allowFlying = player.isCreative(); // Remove flying if they aren't in creative mode
//        }
//        else
//        {
//            destination = getOrCreateMindscape(mindscapeOwnerUUID, new BlockPos(x, y, z), server);
//            player.getAbilities().allowFlying = true; // Allow flight in the mind
//        }
//
//        Identifier location = player.getEntityWorld().getDimensionKey().getValue();
//
//        if (!isInMindscape(player))
//        {
//            mindNBT = PlayerHelper.getPersistentTag(player, Hexkeys.IDENTIFIER.toString());
//            // XYZ
//            mindNBT.putDouble(NBTKeys.LAST_DIMENSION_X, player.getX());
//            mindNBT.putDouble(NBTKeys.LAST_DIMENSION_Y, player.getY());
//            mindNBT.putDouble(NBTKeys.LAST_DIMENSION_Z, player.getZ());
//
//            // save the dimension info
//            mindNBT.putString(NBTKeys.LAST_DIMENSION_MOD_ID, location.getNamespace());
//            mindNBT.putString(NBTKeys.LAST_DIMENSION_MOD_DIMENSION, location.getPath());
//        }
//
//        Vector3d newPosByDestination = new Vector3d(x,y,z);
//
//        TeleportHelper.teleportEntity(
//                player,
//                destination,
//                newPosByDestination.x,
//                y,
//                newPosByDestination.z,
//                player.getHeadYaw(),
//                player.getPitch()
//        );
//    }
//
//    private static ServerLevel getOrCreateMindscape(UUID playerUUID, BlockPos spawnLocation, MinecraftServer server)
//    {
//        RegistryKey<Level> worldKey = DimensionRegistry.Dimensions.MINDSCAPE_DIMENSION_KEY; //RegistryKey.of(Registry.WORLD_KEY, dim);
//        ServerLevel mindscape = server.getWorld(worldKey);
//
//        MindscapeStatus mindscapeList = MindscapeStatus.getServerState(server);
//        if(!mindscapeList.hasMindscape(playerUUID)) {
//            DimensionRegistry.createMindscape(server, spawnLocation);
//            mindscapeList.giveMindscape(playerUUID);
//        }
//
//        return mindscape;
//    }
//
//    private static Identifier prefix(String path)
//    {
//        return new Identifier(Hexkeys.MOD_ID, path.toLowerCase(Locale.ROOT));
//    }
//
//    public static class NBTKeys
//    {
//        public static final String LAST_DIMENSION_X = "LAST_DIMENSION_X";
//        public static final String LAST_DIMENSION_Y = "LAST_DIMENSION_Y";
//        public static final String LAST_DIMENSION_Z = "LAST_DIMENSION_Z";
//        public static final String LAST_DIMENSION_MOD_ID = "LAST_DIMENSION_MOD_ID";
//        public static final String LAST_DIMENSION_MOD_DIMENSION = "LAST_DIMENSION_MOD_DIMENSION";
//    }
//}
