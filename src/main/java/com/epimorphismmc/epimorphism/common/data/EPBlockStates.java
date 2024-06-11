package com.epimorphismmc.epimorphism.common.data;

public class EPBlockStates {
    //    public static void cropBlockState(DataGenContext<Block, EPCropBlock> context,
    // RegistrateBlockstateProvider provider) {
    //        provider.getVariantBuilder(context.get())
    //                .forAllStatesExcept(state -> {
    //                    var crop_state = state.getValue(EPCropBlock.STATE.getProperty());
    //                    var stick_type = state.getValue(EPCropBlock.VARIANT.getProperty());
    //                    if (crop_state.hasPlant()) {
    //                        if (crop_state.isCross()) {
    //                            return ConfiguredModel.builder()
    //
    // .modelFile(provider.models().getExistingFile(provider.modLoc("block/crop_block_cross_sticks_" +
    // stick_type.getSerializedName())))
    //                                    .build();
    //                        } else {
    //                            return
    // provider.models().getExistingFile(provider.modLoc("block/crop_block_single_sticks_" +
    // stick_type.getSerializedName()));
    //                        }
    //                    } else {
    //                        if (crop_state.isCross()) {
    //                            return
    // provider.models().getExistingFile(provider.modLoc("block/crop_block_cross_sticks_" +
    // stick_type.getSerializedName()));
    //                        } else {
    //                            return
    // provider.models().getExistingFile(provider.modLoc("block/crop_block_single_sticks_" +
    // stick_type.getSerializedName()));
    //                        }
    //                    }
    //                });
    //    }
}
