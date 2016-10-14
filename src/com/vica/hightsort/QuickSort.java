package com.vica.hightsort;

import com.vica.basesorts.PartitionSort;

/**
 * 快速排序
 * Created by Vica tony on 2016/7/31.
 */
public class QuickSort extends PartitionSort {

    public QuickSort(int[] data) {
        super(data);
    }

    /**
     * 执行指定高低位的快速排序
     * @param low 低位
     * @param hight 高位
     */
    protected void execute(int low, int hight){
        if(low<hight) {
            int base = getData()[hight];
            int base_index = execute(low, hight, base);
            execute(low, base_index-1);
            execute(base_index+1, hight);
        }
    }

    /**
     * 执行快速排序
     */
    public void execute(){
        execute(0,getData().length-1);
    }
}
