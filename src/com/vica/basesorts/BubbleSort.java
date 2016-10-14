package com.vica.basesorts;

import com.vica.base.SortBase;

/**
 * 基本冒泡排序
 * Created by Vica tony on 2016/7/31.
 */
public class BubbleSort extends SortBase {


    public BubbleSort(int[] data) {
        super(data);
    }

    /**
     * 执行简单冒泡排序
     */
    public void execute(){
        for(int i=1;i<getData().length;i++){
            for(int j=0;j<getData().length-i;j++){
                if(getData()[j]>getData()[j+1]){
                    swap(j+1,j);
                }
            }
        }
    }
}
