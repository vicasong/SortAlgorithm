package com.vica.basesorts;

import com.vica.base.SortBase;

/**
 * 简单选择排序
 * Created by Vica tony on 2016/7/31.
 */
public class SelectSort extends SortBase {

    public SelectSort(int[] data) {
        super(data);
    }

    /**
     * 执行简单选择排序
     */
    public void execute(){
        for(int i=0;i<getData().length;i++){
            int index=i;
            for(int j=i;j<getData().length-1;j++){
                if(getData()[j+1]<getData()[index])
                    index=j+1;
            }
            if(index!=i) {
                swap(i,index);
            }
        }
    }
}
