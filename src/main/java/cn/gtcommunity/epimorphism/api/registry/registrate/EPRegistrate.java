package cn.gtcommunity.epimorphism.api.registry.registrate;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.block.EPMetaMachineBlock;
import cn.gtcommunity.epimorphism.api.blockentity.EnhanceBlockEntityType;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.item.MetaMachineItem;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EPRegistrate extends GTRegistrate {

    protected static final EPRegistrate INSTANCE = new EPRegistrate();

    protected EPRegistrate() {
        super(Epimorphism.MOD_ID);
    }

    // Block Entities
    @Override
    public <T extends BlockEntity> EnhanceBlockEntityBuilder<T, Registrate> blockEntity(BlockEntityBuilder.BlockEntityFactory<T> factory) {
        return blockEntity(self(), factory);
    }

    @Override
    public <T extends BlockEntity> EnhanceBlockEntityBuilder<T, Registrate> blockEntity(String name, BlockEntityBuilder.BlockEntityFactory<T> factory) {
        return blockEntity(self(), name, factory);
    }

    @Override
    public <T extends BlockEntity, P> EnhanceBlockEntityBuilder<T, P> blockEntity(P parent, BlockEntityBuilder.BlockEntityFactory<T> factory) {
        return blockEntity(parent, currentName(), factory);
    }

    @Override
    public <T extends BlockEntity, P> EnhanceBlockEntityBuilder<T, P> blockEntity(P parent, String name, BlockEntityBuilder.BlockEntityFactory<T> factory) {
        return (EnhanceBlockEntityBuilder<T, P>) entry(name, callback -> EnhanceBlockEntityBuilder.create(this, parent, name, callback, factory));
    }

    @Override
    public MultiblockMachineBuilder multiblock(String name, Function<IMachineBlockEntity, ? extends MultiblockControllerMachine> metaMachine) {
        return MultiblockMachineBuilder.createMulti(this, name, metaMachine, EPMetaMachineBlock::new, MetaMachineItem::new, MetaMachineBlockEntity::createBlockEntity);
    }

    public static EPRegistrate getInstance() {
        return INSTANCE;
    }

}
