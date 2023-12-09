package cn.gtcommunity.epimorphism.api.structure.utils;

import java.util.ArrayList;
import java.util.List;

public class StructureUtil {

    //  List Utils
    public static <T> int maxLength(List<List<T>> lists) {
        return lists.stream().mapToInt(List::size).max().orElse(0);
    }

    public static <T> List<T> consistentList(List<T> list, int length) {
        if (list.size() >= length) {
            return list;
        }
        List<T> finalList = new ArrayList<>(list);
        T last = list.get(list.size() - 1);
        for (int i = 0; i < length - list.size(); i++) {
            finalList.add(last);
        }
        return finalList;
    }
}
