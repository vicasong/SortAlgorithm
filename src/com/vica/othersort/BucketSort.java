package com.vica.othersort;

import com.vica.base.SortBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序
 * Created by Vica tony on 2016/8/1.
 */
public class BucketSort extends SortBase {

    public BucketSort(int[] data) {
        super(data);
    }

    /**
     * 执行桶排序
     * @param maxupper 数据最大上限
     */
    public void execute(int maxupper) {
        maxupper+=1;
        int[] buckets = new int[maxupper];
        for (int i = 0; i < getData().length; i++) {
            buckets[getData()[i]] += 1;
        }
        int temp[] =new int[getData().length];
        int index=0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                temp[index++]=i;
                buckets[i] -= 1;
            }
        }
        setData(temp);

    }
}
