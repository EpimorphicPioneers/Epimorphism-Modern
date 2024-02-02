package cn.gtcommunity.epimorphism.utils;

public class EPBitUtil {
    /**
     * 判断第几位是否为1
     *
     * @param num   整数
     * @param index 低位起第几位下标
     * @return 是否为1
     */
    public static boolean getStatusType(int num, int index) {
        return (num >> (index - 1) & 1) == 1;
    }

    /**
     * @param num    整数
     * @param index  低位起第几位下标
     * @param status 要修改的状态
     * @return 修改后的整数
     */
    public static int updateStatusType(int num, int index, int status) {
        if (status != 0 && status != 1) {
            throw new IllegalArgumentException();
        }
        if (status == 1) {
            //1向左移(index-1) 和10010 或
            return (1 << (index - 1)) | num;
        } else {
            //先判断原来是不是0,原来是0则直接返回
            if (!getStatusType(num,index)){
                return num;
            }
            //10010 - 1向左移(index-1)
            return num - (1 << (index - 1));
        }
    }
}
