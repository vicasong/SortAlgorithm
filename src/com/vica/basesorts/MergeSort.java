package com.vica.basesorts;

import com.vica.base.SortBase;

/**
 * 归并排序
 * Created by Vica tony on 2016/8/1.
 */
public class MergeSort extends SortBase {

    public MergeSort(int[] data) {
        super(data);
    }

    /**
     * 执行归并排序
     */
    public void execute() {
        for (int grep = 1; grep < getData().length; grep = 2 * grep) {
            execute(grep);
        }
    }

    /**
     * 执行归并
     * @param grep 子序列长度（0-1个元素，1-两个元素，...）
     */
    private void execute(int grep) {
        int i = 0;
        for (i = 0; grep * 2 + i - 1 < getData().length; i += 2 * grep) {
            merge(i, i + grep - 1, i + 2 * grep - 1);
        }
        if (i + grep - 1 < getData().length) {
            merge(i, i + grep - 1, getData().length - 1);
        }
    }

    /**
     * 归并
     * @param low 第一子序列起始索引
     * @param mid 第一子序列结束索引
     * @param height 第二子序列结束索引
     */
    private void merge(int low, int mid, int height) {

        int leftStart = low;
        int rightStart = mid + 1;
        int[] temp = new int[height - low + 1];
        int index = 0;
        while (leftStart <= mid && rightStart <= height) {
            if (getData()[leftStart] < getData()[rightStart]) {
                temp[index++] = getData()[leftStart++];
            } else {
                temp[index++] = getData()[rightStart++];
            }
        }

        while (leftStart <= mid) {
            temp[index++] = getData()[leftStart++];
        }

        while (rightStart <= height) {
            temp[index++] = getData()[rightStart++];
        }

        for (leftStart = low, index = 0; leftStart <= height; leftStart++, index++) {
            getData()[leftStart] = temp[index];
        }

    }
}
