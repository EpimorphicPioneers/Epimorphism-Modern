//package cn.gtcommunity.cn.gtcommunity.epimorphism.common.eunetwork;
//
//import cn.gtcommunity.cn.gtcommunity.epimorphism.api.eunetwork.AccessLevel;
//import cn.gtcommunity.cn.gtcommunity.epimorphism.api.eunetwork.NetworkMember;
//import cn.gtcommunity.cn.gtcommunity.epimorphism.utils.EPLevelUtils;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.entity.player.Player;
//
//import javax.annotation.Nonnull;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.UUID;
//
//public class ServerEUNetwork extends EUNetwork {
//    private static final Comparator<TileFluxDevice> sDescendingOrder =
//            (lhs, rhs) -> Integer.compare(rhs.getTransferHandler().getPriority(),
//                    lhs.getTransferHandler().getPriority());
//
//    /**
//     * See {@link #ANY}
//     */
//    private static final Class<?>[] sLogicalTypes =
//            {IFluxDevice.class, IFluxPlug.class, IFluxPoint.class, IFluxNode.class};
//
//    private final ArrayList<TileFluxDevice>[] mDevices;
//
//    // LinkedList doesn't create large arrays, should be better
//    private final LinkedList<TileFluxDevice> mToAdd = new LinkedList<>();
//    private final LinkedList<TileFluxDevice> mToRemove = new LinkedList<>();
//
//    private boolean mSortConnections = true;
//
//    private final TransferIterator mPlugTransferIterator = new TransferIterator(false);
//    private final TransferIterator mPointTransferIterator = new TransferIterator(true);
//
//    private long mBufferLimiter = 0;
//
//    {
//        @SuppressWarnings("unchecked") final ArrayList<TileFluxDevice>[] devices =
//                (ArrayList<TileFluxDevice>[]) Array.newInstance(ArrayList.class, sLogicalTypes.length);
//        Arrays.setAll(devices, type -> new ArrayList<>());
//        mDevices = devices;
//    }
//
//    ServerEUNetwork() {
//    }
//
//    ServerEUNetwork(int id, String name,  @Nonnull Player owner) {
//        super(id, name, owner);
//    }
//
//    /*public void addConnections() {
//        if (toAdd.isEmpty()) {
//            return;
//        }
//        Iterator<IFluxConnector> iterator = toAdd.iterator();
//        while (iterator.hasNext()) {
//            IFluxConnector flux = iterator.next();
//            FluxCacheType.getValidTypes(flux).forEach(t -> FluxUtils.addWithCheck(getConnections(t), flux));
//            MinecraftForge.EVENT_BUS.post(new FluxConnectionEvent.Connected(flux, this));
//            iterator.remove();
//            sortConnections = true;
//        }
//    }
//
//    public void removeConnections() {
//        if (toRemove.isEmpty()) {
//            return;
//        }
//        Iterator<IFluxConnector> iterator = toRemove.iterator();
//        while (iterator.hasNext()) {
//            IFluxConnector flux = iterator.next();
//            FluxCacheType.getValidTypes(flux).forEach(t -> getConnections(t).removeIf(f -> f == flux));
//            iterator.remove();
//            sortConnections = true;
//        }
//    }*/
//
//    private void handleConnectionQueue() {
//        TileFluxDevice device;
//        while ((device = mToAdd.poll()) != null) {
//            for (int type = 0; type < sLogicalTypes.length; type++) {
//                if (sLogicalTypes[type].isInstance(device)) {
//                    var list = getLogicalDevices(type);
//                    assert !list.contains(device);
//                    mSortConnections |= list.add(device);
//                }
//            }
//        }
//        while ((device = mToRemove.poll()) != null) {
//            for (int type = 0; type < sLogicalTypes.length; type++) {
//                if (sLogicalTypes[type].isInstance(device)) {
//                    var list = getLogicalDevices(type);
//                    assert list.contains(device);
//                    mSortConnections |= list.remove(device);
//                }
//            }
//        }
//        if (mSortConnections) {
//            getLogicalDevices(PLUG).sort(sDescendingOrder);
//            getLogicalDevices(POINT).sort(sDescendingOrder);
//            mSortConnections = false;
//        }
//    }
//
//    @Nonnull
//    @Override
//    public ArrayList<TileFluxDevice> getLogicalDevices(int logic) {
//        return mDevices[logic];
//    }
//
//    @Override
//    public void onEndServerTick() {
//        mStatistics.startProfiling();
//
//        handleConnectionQueue();
//
//        mBufferLimiter = 0;
//
//        List<TileFluxDevice> devices = getLogicalDevices(ANY);
//        for (var d : devices) {
//            d.getTransferHandler().onCycleStart();
//        }
//
//        List<TileFluxDevice> plugs = getLogicalDevices(PLUG);
//        List<TileFluxDevice> points = getLogicalDevices(POINT);
//        if (!points.isEmpty() && !plugs.isEmpty()) {
//            // push into stack because they called too many times below
//            final TransferIterator plugIterator = mPlugTransferIterator.reset(plugs);
//            final TransferIterator pointIterator = mPointTransferIterator.reset(points);
//            CYCLE:
//            while (pointIterator.hasNext()) {
//                while (plugIterator.hasNext()) {
//                    TileFluxDevice plug = plugIterator.next();
//                    TileFluxDevice point = pointIterator.next();
//                    if (plug.getDeviceType() == point.getDeviceType()) {
//                        break CYCLE; // Storage always have the lowest priority, the cycle can be broken here.
//                    }
//                    // we don't need to simulate this action
//                    long actual = plug.getTransferHandler().removeFromBuffer(point.getTransferHandler().getRequest());
//                    if (actual > 0) {
//                        point.getTransferHandler().addToBuffer(actual);
//                        continue CYCLE;
//                    } else {
//                        // although the plug still need transfer (buffer > 0)
//                        // but it reached max transfer limit, so we use next plug
//                        plugIterator.increment();
//                    }
//                }
//                break; // all plugs have been used
//            }
//        }
//
//        long limiter = 0;
//        for (var d : devices) {
//            TransferHandler h = d.getTransferHandler();
//            h.onCycleEnd();
//            limiter += h.getRequest();
//            if (h.getChange() != 0) {
//                d.markChunkUnsaved();
//            }
//        }
//        mBufferLimiter = limiter;
//
//        mStatistics.stopProfiling();
//    }
//
//    @Override
//    public long getBufferLimiter() {
//        return mBufferLimiter;
//    }
//
//    @Nonnull
//    @Override
//    public AccessLevel getPlayerAccess(@Nonnull Player player) {
//        if (FluxPlayer.isPlayerSuperAdmin(player)) {
//            return AccessLevel.SUPER_ADMIN;
//        }
//        return super.getPlayerAccess(player);
//    }
//
//    @Override
//    public boolean canPlayerAccess(@Nonnull Player player) {
//        if (super.canPlayerAccess(player)) {
//            return true;
//        }
//    }
//
//    @Override
//    public void onDelete() {
//        super.onDelete();
//        getLogicalDevices(ANY).forEach(TileFluxDevice::disconnect);
//        Arrays.fill(mDevices, null);
//        mToAdd.clear();
//        mToRemove.clear();
//    }
//
//    @Override
//    public boolean isValid() {
//        return true;
//    }
//
//    @Override
//    public boolean enqueueConnectionAddition(@Nonnull TileFluxDevice device) {
//        if (device.getDeviceType().isController() && getLogicalDevices(CONTROLLER).size() > 0) {
//            return false;
//        }
//        if (!mToAdd.contains(device) && !getLogicalDevices(ANY).contains(device)) {
//            mToAdd.offer(device);
//            mToRemove.remove(device);
//            mConnectionMap.put(device.getGlobalPos(), device);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void enqueueConnectionRemoval(@Nonnull TileFluxDevice device, boolean unload) {
//        if (!mToRemove.contains(device) && getLogicalDevices(ANY).contains(device)) {
//            mToRemove.offer(device);
//            mToAdd.remove(device);
//            if (unload) {
//                // create a fake device on server side, representing it has ever connected to
//                // this network but currently unloaded
//                mConnectionMap.put(device.getGlobalPos(), PhantomFluxDevice.makeUnloaded(device));
//            } else {
//                // remove the tile entity
//                mConnectionMap.remove(device.getGlobalPos());
//            }
//        }
//    }
//
//    public void markSortConnections() {
//        mSortConnections = true;
//    }
//
//    @Override
//    public int changeMembership(@Nonnull Player player, @Nonnull UUID targetUUID, byte type) {
//        final AccessLevel access = getPlayerAccess(player);
//        boolean editPermission = access.canEdit();
//        boolean ownerPermission = access.canDelete();
//        // check permission
//        if (!editPermission) {
//            return EUNetConstants.RESPONSE_NO_ADMIN;
//        }
//
//        // editing yourself
//        final boolean self = player.getUUID().equals(targetUUID);
//        // current member in the network
//        final NetworkMember current = getMemberByUUID(targetUUID);
//
//        // create new member
//        if (type == EUNetConstants.MEMBERSHIP_SET_USER && current == null) {
//            final Player target = EPLevelUtils.getCurrentServer()
//                    .getPlayerList().getPlayer(targetUUID);
//            if (target != null) {
//                NetworkMember m = NetworkMember.create(target, AccessLevel.USER);
//                mMemberMap.put(m.getPlayerUUID(), m);
//                return EUNetConstants.RESPONSE_SUCCESS;
//            } else {
//                // the player is offline now
//                return EUNetConstants.RESPONSE_INVALID_USER;
//            }
//        } else if (current != null) {
//            // super admin can still transfer ownership to self
//            if (self && current.getAccessLevel() == AccessLevel.OWNER) {
//                return EUNetConstants.RESPONSE_INVALID_USER;
//            }
//            boolean changed = false;
//            if (type == EUNetConstants.MEMBERSHIP_SET_ADMIN) {
//                // we are not owner or super admin
//                if (!ownerPermission) {
//                    return EUNetConstants.RESPONSE_NO_OWNER;
//                }
//                changed = current.setAccessLevel(AccessLevel.ADMIN);
//            } else if (type == EUNetConstants.MEMBERSHIP_SET_USER) {
//                changed = current.setAccessLevel(AccessLevel.USER);
//            } else if (type == EUNetConstants.MEMBERSHIP_CANCEL_MEMBERSHIP) {
//                changed = mMemberMap.remove(targetUUID) != null;
//            } else if (type == EUNetConstants.MEMBERSHIP_TRANSFER_OWNERSHIP) {
//                if (!ownerPermission) {
//                    return EUNetConstants.RESPONSE_NO_OWNER;
//                }
//                getAllMembers().forEach(f -> {
//                    if (f.getAccessLevel().canDelete()) {
//                        f.setAccessLevel(AccessLevel.USER);
//                    }
//                });
//                mOwnerUUID = targetUUID;
//                current.setAccessLevel(AccessLevel.OWNER);
//                changed = true;
//            }
//            return changed ? EUNetConstants.RESPONSE_SUCCESS : EUNetConstants.RESPONSE_INVALID_USER;
//        } else if (type == EUNetConstants.MEMBERSHIP_TRANSFER_OWNERSHIP) {
//            if (!ownerPermission) {
//                return EUNetConstants.RESPONSE_NO_OWNER;
//            }
//            // super admin can still transfer ownership to self
//            if (self && access == AccessLevel.OWNER) {
//                return EUNetConstants.RESPONSE_INVALID_USER;
//            }
//            Player target = EPLevelUtils.getCurrentServer().getPlayerList().getPlayer(targetUUID);
//            // is online
//            if (target != null) {
//                getAllMembers().forEach(f -> {
//                    if (f.getAccessLevel().canDelete()) {
//                        f.setAccessLevel(AccessLevel.USER);
//                    }
//                });
//                NetworkMember m = NetworkMember.create(target, AccessLevel.OWNER);
//                mMemberMap.put(m.getPlayerUUID(), m);
//                mOwnerUUID = targetUUID;
//                return EUNetConstants.RESPONSE_SUCCESS;
//            } else {
//                return EUNetConstants.RESPONSE_INVALID_USER;
//            }
//        } else {
//            return EUNetConstants.RESPONSE_INVALID_USER;
//        }
//    }
//
//    /*private void addToLite(IFluxDevice flux) {
//        Optional<IFluxDevice> c = all_connectors.getValue().stream().filter(f -> f.getCoords().equals(flux.getCoords
//        ())).findFirst();
//        if (c.isPresent()) {
//            changeChunkLoaded(flux, true);
//        } else {
//            SimpleFluxDevice lite = new SimpleFluxDevice(flux);
//            all_connectors.getValue().add(lite);
//        }
//    }
//
//    private void removeFromLite(IFluxDevice flux) {
//        all_connectors.getValue().removeIf(f -> f.getCoords().equals(flux.getCoords()));
//    }
//
//    private void changeChunkLoaded(IFluxDevice flux, boolean chunkLoaded) {
//        Optional<IFluxDevice> c = all_connectors.getValue().stream().filter(f -> f.getCoords().equals(flux.getCoords
//        ())).findFirst();
//        c.ifPresent(fluxConnector -> fluxConnector.setChunkLoaded(chunkLoaded));
//    }
//
//    @Override
//    public void addNewMember(String name) {
//        NetworkMember a = NetworkMember.createMemberByUsername(name);
//        if (network_players.getValue().stream().noneMatch(f -> f.getPlayerUUID().equals(a.getPlayerUUID()))) {
//            network_players.getValue().add(a);
//        }
//    }
//
//    @Override
//    public void removeMember(UUID uuid) {
//        network_players.getValue().removeIf(p -> p.getPlayerUUID().equals(uuid) && !p.getAccessPermission().canDelete
//        ());
//    }*/
//}
