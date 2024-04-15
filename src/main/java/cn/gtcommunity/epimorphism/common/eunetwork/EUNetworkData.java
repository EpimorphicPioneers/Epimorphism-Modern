package cn.gtcommunity.epimorphism.common.eunetwork;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.utils.EPLevelUtil;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EUNetworkData extends SavedData {

    public static final String NETWORK_DATA = Epimorphism.MOD_ID + "data";

    public static volatile EUNetworkData data;

    private static final String NETWORKS = "networks";

    private static final String UNIQUE_ID = "uniqueID";

    private final Int2ObjectMap<EUNetwork> mNetworks = new Int2ObjectOpenHashMap<>();

    private int mUniqueID = 0;

    public EUNetworkData() {/**/}

    public EUNetworkData(@Nonnull CompoundTag tag) {
//        read(tag);
    }


    // called when the server instance changed, e.g. switching single player saves
    public static void release() {
        if (data != null) {
            data = null;
            Epimorphism.LOGGER.debug("EUNetworkData has been unloaded");
        }
    }

    @Nonnull
    public static EUNetworkData getInstance() {
        if (EUNetworkData.data == null) {
            ServerLevel level = EPLevelUtil.getCurrentServer().overworld();
            EUNetworkData.data = level.getDataStorage()
                    .computeIfAbsent(EUNetworkData::new, EUNetworkData::new, NETWORK_DATA);
            Epimorphism.LOGGER.debug("EUNetworkData has been successfully loaded");
        }
        return EUNetworkData.data;
    }

    @Nonnull
    public static EUNetwork getNetwork(int id) {
        return getInstance().mNetworks.getOrDefault(id, EUNetwork.INVALID);
    }

    @Nonnull
    public static Collection<EUNetwork> getAllNetworks() {
        return getInstance().mNetworks.values();
    }

    /*
     * Get a set of block pos with given dimension key, a pos represents a flux tile entity
     * that wants to load the chunk it's in
     *
     * @param dim dimension
     * @return all block pos that want to load chunks they are in
     */
    /*@Nonnull
    public static LongSet getTickets(@Nonnull RegistryKey<World> dim) {
        return get().tickets.computeIfAbsent(dim.getLocation(), d -> new LongOpenHashSet());
    }*/

//    @Nullable
//    public EUNetwork createNetwork(@Nonnull Player creator, @Nonnull String name) {
//        final int max = 10;
//        final UUID uuid = creator.getUUID();
//        int i = 0;
//        for (var n : mNetworks.values()) {
//            if (n.getOwnerUUID().equals(uuid) && ++i >= max) {
//                return null;
//            }
//        }
//        do {
//            mUniqueID++;
//        } while (mNetworks.containsKey(mUniqueID));
//
//        final ServerEUNetwork network = new ServerEUNetwork(mUniqueID, name, creator);
//
//        mNetworks.put(network.getNetworkID(), network);
//        return network;
//    }

    public void deleteNetwork(@Nonnull EUNetwork network) {
        if (mNetworks.remove(network.getNetworkID()) == network) {
            network.onDelete();
        }
    }

    @Override
    public boolean isDirty() {
        // always dirty as a convenience
        return true;
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        compound.putInt(UNIQUE_ID, mUniqueID);

        ListTag list = new ListTag();
        for (EUNetwork network : mNetworks.values()) {
            CompoundTag tag = new CompoundTag();
            network.writeCustomTag(tag, EUNetConstants.NBT_SAVE_ALL);
            list.add(tag);
        }
        compound.put(NETWORKS, list);

        return compound;
    }

//    private void read(@Nonnull CompoundTag compound) {
//        mUniqueID = compound.getInt(UNIQUE_ID);
//
//        ListTag list = compound.getList(NETWORKS, Tag.TAG_COMPOUND);
//        for (int i = 0; i < list.size(); i++) {
//            ServerEUNetwork network = new ServerEUNetwork();
//            network.readCustomTag(list.getCompound(i), EUNetConstants.NBT_SAVE_ALL);
//            if (network.getNetworkID() > 0) {
//                mNetworks.put(network.getNetworkID(), network);
//            }
//        }
//    }
}
