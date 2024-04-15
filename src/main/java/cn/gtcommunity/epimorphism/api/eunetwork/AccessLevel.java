package cn.gtcommunity.epimorphism.api.eunetwork;

import net.minecraft.ChatFormatting;

import javax.annotation.Nonnull;

public enum AccessLevel {
    OWNER(/*FluxTranslate.OWNER,*/ ChatFormatting.GOLD),
    USER(/*FluxTranslate.USER, */ChatFormatting.BLUE),
    BLOCKED(/*FluxTranslate.BLOCKED, */ChatFormatting.GRAY);

    private static final AccessLevel[] VALUES = values();

//    private final FluxTranslate localization;
    private final ChatFormatting formatting;

    AccessLevel(/*FluxTranslate localization, */ChatFormatting formatting) {
//        this.localization = localization;
        this.formatting = formatting;
    }

    @Nonnull
    public static AccessLevel fromKey(byte key) {
        return VALUES[key];
    }

    public byte getKey() {
        return (byte) ordinal();
    }

//    @Nonnull
//    public String getFormattedName() {
//        return formatting + localization.get();
//    }

    public boolean canUse() {
        return this != BLOCKED;
    }

    public boolean canEdit() {
        return canUse() && this != USER;
    }

    public boolean canDelete() {
        return this == OWNER;
    }
}
