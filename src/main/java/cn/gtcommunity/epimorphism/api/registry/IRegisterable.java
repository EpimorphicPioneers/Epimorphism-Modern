package cn.gtcommunity.epimorphism.api.registry;

import javax.annotation.Nonnull;

public interface IRegisterable<K> {

    @Nonnull
    K getId();

}
