package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture;

import cn.gtcommunity.epimorphism.api.machine.multiblock.GlassElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.client.particle.CropParticleData;
import com.gregtechceu.gtceu.api.gui.fancy.*;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.utils.DummyWorld;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.server.ServerLifecycleHooks;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IndustrialGreenhouseMachine extends GlassElectricMultiblockMachine {

    private static final CropParticleData DATA = new CropParticleData(40);

    public IndustrialGreenhouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////


    @Override
    public void attachSideTabs(TabsWidget sideTabs) {
        sideTabs.attachSubTab(new IFancyUIProvider() {
            @Override
            public Widget createMainPage(FancyMachineUIWidget fancyMachineUIWidget) {
                return new WidgetGroup(0, 0, 162, 121);
            }

            @Override
            public IGuiTexture getTabIcon() {
                return new ResourceTexture("minecraft:textures/item/wheat_seeds.png");
            }

            @Override
            public Component getTitle() {
                return Component.translatable("aaa");
            }

            @Override
            public void attachTooltips(TooltipsPanel tooltipsPanel) {

            }
        });
        super.attachSideTabs(sideTabs);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void clientTick() {
        super.clientTick();
        if (recipeLogic.isActive() && getOffsetTimer() % 41 == 0) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 1 && k == 1) continue;
                    var pos = getPos();
                    var frontFacing = getFrontFacing();
                    var sideFacing = frontFacing.getClockWise();
                    int x = pos.getX() - frontFacing.getStepX() * (j + 1) - sideFacing.getStepX() * (k - 1);
                    int y = pos.getY() + 2;
                    int z = pos.getZ() - frontFacing.getStepZ() * (j + 1) - sideFacing.getStepZ() * (k - 1);
                    getLevel().addParticle(DATA, x, y, z, 0, 0, 0);
                }
            }
        }
    }

//    public static class GreenHouseSlot extends ItemStackTransfer {
//        private static final int NUMBER_OF_GENERATIONS_TO_MAKE = 10;
//
//        final ItemStack input;
//        Block crop;
//        ArrayList<ItemStack> customDrops = null;
//        ItemStack undercrop = null;
//        List<ItemStack> drops;
//        public boolean isValid;
//        boolean isIC2Crop;
//        boolean noHumidity;
//        int growthticks;
//        List<List<ItemStack>> generations;
//
//        Random rn;
//        IRecipe recipe;
//        ItemStack recipeInput;
//
//        int optimalgrowth = 7;
//
//        boolean needsreplanting = true;
//
//        static final GreenHouseWorld fakeworld = new GreenHouseWorld(5, 5, 5);
//
//        @Override
//        public CompoundTag serializeNBT() {
//            return super.serializeNBT();
//            NBTTagCompound aNBT = new NBTTagCompound();
//            aNBT.setTag("input", writeItemStackToNBT(input));
//            aNBT.setBoolean("isValid", isValid);
//            aNBT.setBoolean("isIC2Crop", isIC2Crop);
//            if (!isIC2Crop) {
//                aNBT.setInteger("crop", Block.getIdFromBlock(crop));
//                if (customDrops != null && customDrops.size() > 0) {
//                    aNBT.setInteger("customDropsCount", customDrops.size());
//                    for (int i = 0; i < customDrops.size(); i++)
//                        aNBT.setTag("customDrop." + i, writeItemStackToNBT(customDrops.get(i)));
//                }
//                aNBT.setInteger("dropscount", drops.size());
//                for (int i = 0; i < drops.size(); i++) aNBT.setTag("drop." + i, writeItemStackToNBT(drops.get(i)));
//                aNBT.setInteger("optimalgrowth", optimalgrowth);
//                aNBT.setBoolean("needsreplanting", needsreplanting);
//            } else {
//                if (undercrop != null) aNBT.setTag("undercrop", writeItemStackToNBT(undercrop));
//                aNBT.setInteger("generationscount", generations.size());
//                for (int i = 0; i < generations.size(); i++) {
//                    aNBT.setInteger(
//                            "generation." + i + ".count",
//                            generations.get(i)
//                                    .size());
//                    for (int j = 0; j < generations.get(i)
//                            .size(); j++)
//                        aNBT.setTag(
//                                "generation." + i + "." + j,
//                                writeItemStackToNBT(
//                                        generations.get(i)
//                                                .get(j)));
//                }
//                aNBT.setInteger("growthticks", growthticks);
//                aNBT.setBoolean("noHumidity", noHumidity);
//            }
//            return aNBT;
//        }
//
//        @Override
//        public void deserializeNBT(CompoundTag nbt) {
//            super.deserializeNBT(nbt);
//            isIC2Crop = aNBT.getBoolean("isIC2Crop");
//            isValid = aNBT.getBoolean("isValid");
//            input = readItemStackFromNBT(aNBT.getCompoundTag("input"));
//            if (!isIC2Crop) {
//                crop = Block.getBlockById(aNBT.getInteger("crop"));
//                if (aNBT.hasKey("customDropsCount")) {
//                    int imax = aNBT.getInteger("customDropsCount");
//                    customDrops = new ArrayList<>(imax);
//                    for (int i = 0; i < imax; i++)
//                        customDrops.add(readItemStackFromNBT(aNBT.getCompoundTag("customDrop." + i)));
//                }
//                drops = new ArrayList<>();
//                for (int i = 0; i < aNBT.getInteger("dropscount"); i++)
//                    drops.add(readItemStackFromNBT(aNBT.getCompoundTag("drop." + i)));
//                optimalgrowth = aNBT.getInteger("optimalgrowth");
//                if (optimalgrowth == 0) optimalgrowth = 7;
//                if (aNBT.hasKey("needsreplanting")) needsreplanting = aNBT.getBoolean("needsreplanting");
//            } else {
//                if (aNBT.hasKey("undercrop")) undercrop = readItemStackFromNBT(aNBT.getCompoundTag("undercrop"));
//                generations = new ArrayList<>();
//                for (int i = 0; i < aNBT.getInteger("generationscount"); i++) {
//                    generations.add(new ArrayList<>());
//                    for (int j = 0; j < aNBT.getInteger("generation." + i + ".count"); j++) generations.get(i)
//                            .add(readItemStackFromNBT(aNBT.getCompoundTag("generation." + i + "." + j)));
//                }
//                growthticks = aNBT.getInteger("growthticks");
//                noHumidity = aNBT.getBoolean("noHumidity");
//                rn = new Random();
//            }
//        }
//
//        public boolean addAll(World world, ItemStack input) {
//            if (!GT_Utility.areStacksEqual(this.input, input)) return false;
//            if (this.input.stackSize == 64) return false;
//            int toconsume = Math.min(64 - this.input.stackSize, input.stackSize);
//            int left = addDrops(world, toconsume);
//            input.stackSize -= toconsume - left;
//            this.input.stackSize += toconsume - left;
//            return left == 0;
//        }
//
//        public boolean findCropRecipe(World world) {
//            if (recipe != null) return true;
//            out: for (ItemStack drop : drops) {
//                recipeInput = drop;
//                for (int j = 0; j < CraftingManager.getInstance()
//                        .getRecipeList()
//                        .size(); j++) {
//                    recipe = (IRecipe) CraftingManager.getInstance()
//                            .getRecipeList()
//                            .get(j);
//                    if (recipe.matches(this, world)
//                            && GT_Utility.areStacksEqual(recipe.getCraftingResult(this), input)) {
//                        break out;
//                    } else recipe = null;
//                }
//            }
//            return recipe != null;
//        }
//
//        @Override
//        public ItemStack getStackInSlot(int p_70301_1_) {
//            if (p_70301_1_ == 0) return recipeInput.copy();
//            return null;
//        }
//
//        @Override
//        public ItemStack getStackInSlotOnClosing(int par1) {
//            return null;
//        }
//
//        @Override
//        public ItemStack decrStackSize(int par1, int par2) {
//            return null;
//        }
//
//        @SuppressWarnings("EmptyMethod")
//        @Override
//        public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {}
//
//        public GreenHouseSlot(GT_MetaTileEntity_ExtremeIndustrialGreenhouse tileEntity, ItemStack input, boolean IC2,
//                              boolean noHumidity) {
//            super(null, 3, 3);
//            World world = tileEntity.getBaseMetaTileEntity()
//                    .getWorld();
//            this.input = input.copy();
//            this.isValid = false;
//            if (IC2) {
//                GreenHouseSlotIC2(tileEntity, world, input, noHumidity);
//                return;
//            }
//            Item i = input.getItem();
//            Block b = null;
//            boolean detectedCustomHandler = false;
//            // Custom handlers
//            // FLOWERS //
//            Block bb = Block.getBlockFromItem(i);
//            if (bb == Blocks.air) bb = null;
//            if (bb instanceof BlockFlower) {
//                detectedCustomHandler = true;
//                needsreplanting = false;
//                customDrops = new ArrayList<>(Collections.singletonList(input.copy()));
//                customDrops.get(0).stackSize = 1;
//            }
//            if (!detectedCustomHandler) {
//                if (i instanceof IPlantable) {
//                    if (i instanceof ItemSeeds) b = ((ItemSeeds) i).getPlant(world, 0, 0, 0);
//                    else if (i instanceof ItemSeedFood) b = ((ItemSeedFood) i).getPlant(world, 0, 0, 0);
//                } else {
//                    if (i == Items.reeds) b = Blocks.reeds;
//                    else {
//                        b = Block.getBlockFromItem(i);
//                        if (b != Blocks.cactus) return;
//                    }
//                    needsreplanting = false;
//                }
//                if (!(b instanceof IPlantable)) return;
//                GameRegistry.UniqueIdentifier u = GameRegistry.findUniqueIdentifierFor(i);
//                if (u != null && Objects.equals(u.modId, "Natura")) optimalgrowth = 8;
//
//                if (b instanceof BlockStem) {
//                    fakeworld.block = null;
//                    try {
//                        b.updateTick(fakeworld, 5, 5, 5, fakeworld.rand);
//                    } catch (Exception e) {
//                        e.printStackTrace(System.err);
//                    }
//                    if (fakeworld.block == null) return;
//                    b = fakeworld.block;
//                    needsreplanting = false;
//                }
//            }
//            crop = b;
//            isIC2Crop = false;
//            int toUse = Math.min(64, input.stackSize);
//            if (addDrops(world, toUse) == 0 && !drops.isEmpty()) {
//                input.stackSize -= toUse;
//                this.input.stackSize = toUse;
//                this.isValid = true;
//            }
//        }
//
//        public void GreenHouseSlotIC2(GT_MetaTileEntity_ExtremeIndustrialGreenhouse tileEntity, World world,
//                                      ItemStack input, boolean noHumidity) {
//            if (!ItemList.IC2_Crop_Seeds.isStackEqual(input, true, true)) return;
//            this.isIC2Crop = true;
//            this.noHumidity = noHumidity;
//            recalculate(tileEntity, world);
//            if (this.isValid) input.stackSize--;
//        }
//
//        private boolean setBlock(ItemStack a, int x, int y, int z, World world) {
//            Item item = a.getItem();
//            Block b = Block.getBlockFromItem(item);
//            if (b == Blocks.air || !(item instanceof ItemBlock)) return false;
//            short tDamage = (short) item.getDamage(a);
//            if (item instanceof GT_Item_Ores && tDamage > 0) {
//                if (!world.setBlock(
//                        x,
//                        y,
//                        z,
//                        b,
//                        GT_TileEntity_Ores.getHarvestData(
//                                tDamage,
//                                ((GT_Block_Ores_Abstract) b).getBaseBlockHarvestLevel(tDamage % 16000 / 1000)),
//                        0)) {
//                    return false;
//                }
//                GT_TileEntity_Ores tTileEntity = (GT_TileEntity_Ores) world.getTileEntity(x, y, z);
//                tTileEntity.mMetaData = tDamage;
//                tTileEntity.mNatural = false;
//            } else world.setBlock(x, y, z, b, tDamage, 0);
//            return true;
//        }
//
//        public void recalculate(GT_MetaTileEntity_ExtremeIndustrialGreenhouse tileEntity, World world) {
//            if (isIC2Crop) {
//                CropCard cc = Crops.instance.getCropCard(input);
//                this.input.stackSize = 1;
//                NBTTagCompound nbt = input.getTagCompound();
//                byte gr = nbt.getByte("growth");
//                byte ga = nbt.getByte("gain");
//                byte re = nbt.getByte("resistance");
//                int[] abc = new int[] { 0, -2, 3 };
//                int[] xyz = new int[] { 0, 0, 0 };
//                tileEntity.getExtendedFacing()
//                        .getWorldOffset(abc, xyz);
//                xyz[0] += tileEntity.getBaseMetaTileEntity()
//                        .getXCoord();
//                xyz[1] += tileEntity.getBaseMetaTileEntity()
//                        .getYCoord();
//                xyz[2] += tileEntity.getBaseMetaTileEntity()
//                        .getZCoord();
//                boolean cheating = false;
//                try {
//                    if (world.getBlock(xyz[0], xyz[1] - 2, xyz[2]) != GregTech_API.sBlockCasings4
//                            || world.getBlockMetadata(xyz[0], xyz[1] - 2, xyz[2]) != 1) {
//                        // no
//                        cheating = true;
//                        return;
//                    }
//
//                    world.setBlock(xyz[0], xyz[1], xyz[2], Block.getBlockFromItem(Ic2Items.crop.getItem()), 0, 0);
//                    TileEntity wte = world.getTileEntity(xyz[0], xyz[1], xyz[2]);
//                    if (!(wte instanceof TileEntityCrop)) {
//                        // should not be even possible
//                        return;
//                    }
//                    TileEntityCrop te = (TileEntityCrop) wte;
//                    te.ticker = 1; // don't even think about ticking once
//                    te.setCrop(cc);
//
//                    te.setGrowth(gr);
//                    te.setGain(ga);
//                    te.setResistance(re);
//
//                    if (noHumidity) te.humidity = 0;
//                    else {
//                        te.waterStorage = 200;
//                        te.humidity = te.updateHumidity();
//                    }
//                    te.airQuality = te.updateAirQuality();
//                    te.nutrients = te.updateNutrients();
//
//                    ItemStack tobeused = null;
//
//                    if (undercrop != null) setBlock(undercrop, xyz[0], xyz[1] - 2, xyz[2], world);
//                    else {
//                        te.setSize((byte) (cc.maxSize() - 1));
//                        if (!cc.canGrow(te)) {
//                            // needs special block
//
//                            boolean cangrow = false;
//                            ArrayList<ItemStack> inputs = tileEntity.getStoredInputs();
//                            for (ItemStack a : inputs) {
//                                if (a.stackSize <= 0) continue;
//                                if (!setBlock(a, xyz[0], xyz[1] - 2, xyz[2], world)) continue;
//                                if (!cc.canGrow(te)) continue;
//                                cangrow = true;
//                                undercrop = a.copy();
//                                undercrop.stackSize = 1;
//                                tobeused = a;
//                                break;
//                            }
//
//                            if (!cangrow) return;
//                        }
//                    }
//
//                    te.setSize((byte) cc.maxSize());
//
//                    if (!cc.canBeHarvested(te)) return;
//
//                    // GENERATE DROPS
//                    generations = new ArrayList<>();
//                    int afterHarvestCropSize = 0;
//                    out: for (int i = 0; i < NUMBER_OF_GENERATIONS_TO_MAKE; i++) // get 10 generations
//                    {
//                        ItemStack[] st = te.harvest_automated(false);
//                        afterHarvestCropSize = te.getSize();
//                        te.setSize((byte) cc.maxSize());
//                        if (st == null) continue;
//                        if (st.length == 0) continue;
//                        for (ItemStack s : st) if (s == null) continue out;
//                        generations.add(new ArrayList<>(Arrays.asList(st)));
//                    }
//                    if (generations.isEmpty()) return;
//                    rn = new Random();
//
//                    // CHECK GROWTH SPEED
//
//                    growthticks = 0;
//
//                    for (int i = afterHarvestCropSize; i < cc.maxSize(); i++) {
//                        te.setSize((byte) i);
//                        int grown = 0;
//                        do {
//                            int rate = te.calcGrowthRate();
//                            if (rate == 0) return;
//                            growthticks++;
//                            grown += rate;
//                        } while (grown < cc.growthDuration(te));
//                    }
//
//                    growthticks *= TileEntityCrop.tickRate;
//                    if (growthticks < 1) growthticks = 1;
//
//                    if (tobeused != null) tobeused.stackSize--;
//
//                    this.isValid = true;
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                } finally {
//                    if (!cheating) world.setBlock(xyz[0], xyz[1] - 2, xyz[2], GregTech_API.sBlockCasings4, 1, 0);
//                    world.setBlockToAir(xyz[0], xyz[1], xyz[2]);
//                }
//            } else {
//                drops = new ArrayList<>();
//                addDrops(world, input.stackSize);
//            }
//        }
//
//        public List<ItemStack> getDrops() {
//            return drops;
//        }
//
//        static final Map<String, ItemStack> dropstacks = new HashMap<>();
//
//        public List<ItemStack> getIC2Drops(GT_MetaTileEntity_ExtremeIndustrialGreenhouse tileEntity,
//                                           double timeelapsed) {
//            int r = rn.nextInt(NUMBER_OF_GENERATIONS_TO_MAKE);
//            if (generations.size() <= r) return new ArrayList<>();
//            double growthPercent = (timeelapsed / (double) growthticks);
//            List<ItemStack> generation = generations.get(r);
//            List<ItemStack> copied = new ArrayList<>();
//            for (ItemStack g : generation) copied.add(g.copy());
//            for (ItemStack s : copied) {
//                double pro = ((double) s.stackSize * growthPercent);
//                s.stackSize = 1;
//                tileEntity.dropprogress.merge(s.toString(), pro, Double::sum);
//                if (!dropstacks.containsKey(s.toString())) dropstacks.put(s.toString(), s.copy());
//            }
//            copied.clear();
//            for (Map.Entry<String, Double> entry : tileEntity.dropprogress.entrySet()) if (entry.getValue() >= 1d) {
//                copied.add(
//                        dropstacks.get(entry.getKey())
//                                .copy());
//                copied.get(copied.size() - 1).stackSize = entry.getValue()
//                        .intValue();
//                entry.setValue(
//                        entry.getValue() - (double) entry.getValue()
//                                .intValue());
//            }
//            return copied;
//        }
//
//        public int addDrops(World world, int count) {
//            if (drops == null) drops = new ArrayList<>();
//            if (customDrops != null && !customDrops.isEmpty()) {
//                @SuppressWarnings("unchecked")
//                ArrayList<ItemStack> d = (ArrayList<ItemStack>) customDrops.clone();
//                for (ItemStack x : drops) {
//                    for (Iterator<ItemStack> iterator = d.iterator(); iterator.hasNext();) {
//                        ItemStack y = iterator.next();
//                        if (GT_Utility.areStacksEqual(x, y)) {
//                            x.stackSize += y.stackSize * count;
//                            iterator.remove();
//                        }
//                    }
//                }
//                final int finalCount = count;
//                d.forEach(stack -> {
//                    ItemStack i = stack.copy();
//                    i.stackSize *= finalCount;
//                    drops.add(i);
//                });
//                return 0;
//            } else {
//                if (crop == null) return count;
//                for (int i = 0; i < count; i++) {
//                    List<ItemStack> d = crop.getDrops(world, 0, 0, 0, optimalgrowth, 0);
//                    for (ItemStack x : drops) for (ItemStack y : d) if (GT_Utility.areStacksEqual(x, y)) {
//                        x.stackSize += y.stackSize;
//                        y.stackSize = 0;
//                    }
//                    for (ItemStack x : d) if (x.stackSize > 0) drops.add(x.copy());
//                }
//            }
//            if (!needsreplanting) return 0;
//            for (int i = 0; i < drops.size(); i++) {
//                if (GT_Utility.areStacksEqual(drops.get(i), input)) {
//                    int took = Math.min(drops.get(i).stackSize, count);
//                    drops.get(i).stackSize -= took;
//                    count -= took;
//                    if (drops.get(i).stackSize == 0) {
//                        drops.remove(i);
//                        i--;
//                    }
//                    if (count == 0) {
//                        return 0;
//                    }
//                }
//            }
//            if (!findCropRecipe(world)) return count;
//            int totake = count / recipe.getCraftingResult(this).stackSize + 1;
//            for (int i = 0; i < drops.size(); i++) {
//                if (GT_Utility.areStacksEqual(drops.get(i), recipeInput)) {
//                    int took = Math.min(drops.get(i).stackSize, totake);
//                    drops.get(i).stackSize -= took;
//                    totake -= took;
//                    if (drops.get(i).stackSize == 0) {
//                        drops.remove(i);
//                        i--;
//                    }
//                    if (totake == 0) {
//                        return 0;
//                    }
//                }
//            }
//            return count;
//        }
//    }

    private static class GreenHouseWorld extends DummyWorld {

        public GreenHouseWorld(Level level) {
            super(ServerLifecycleHooks.getCurrentServer().overworld());
        }

    }
}
