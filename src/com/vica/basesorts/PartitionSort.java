package com.vica.basesorts;

import com.vica.base.SortBase;

/**
 * 划分排序
 * Created by Vica tony on 2016/7/31.
 */
public class PartitionSort extends SortBase {

    public PartitionSort(int[] data) {
        super(data);
    }

    /**
     * 执行划分排序
     * @param low 低位索引
     * @param hight 高位索引
     * @param base 基准值
     * @return 基准值的索引
     */
    protected int execute(int low, int hight, int base){
        int low_p=low-1;
        int hight_p=hight;
        while (true){
            while (low_p<hight&&getData()[++low_p]<base);
            while (hight_p>low&&getData()[--hight_p]>base);
            if(low_p>=hight_p)
                 break;
            else
                swap(low_p,hight_p);
        }
        swap(low_p,hight);
        return low_p;
    }
}
