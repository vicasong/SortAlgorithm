package com.vica.hightsort;

import com.vica.basesorts.InsertSort;

/**
 * 希尔排序，直接插入排序的改进
 * Created by Vica tony on 2016/7/31.
 */
public class ShellSort extends InsertSort {

    public ShellSort(int[] data) {
        super(data);
    }

    /**
     * 执行希尔排序
     */
    @Override
    public void execute() {
        int setup=getData().length/2;
        while (setup>0){
            execute(setup);
            setup=setup/2;
        }
    }
}
