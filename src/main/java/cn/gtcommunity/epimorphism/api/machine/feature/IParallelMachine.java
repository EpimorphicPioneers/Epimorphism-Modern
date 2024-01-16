package cn.gtcommunity.epimorphism.api.machine.feature;

public interface IParallelMachine {
    int getMaxParallel();

    int getParallelNumber();

    void setParallelNumber(int number);
}
