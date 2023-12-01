package cn.gtcommunity.epimorphism.api.block;

public interface ITierType {
    default Object getName(){
        return null;
    }

    default Object getTier(){
        return 0;
    }
}
