package com.vica.basesorts;

import com.vica.base.SortBase;

/**
 * 基排序
 * Created by Vica tony on 2016/8/1.
 */
public class RadixSort extends SortBase {

    public RadixSort(int[] data) {
        super(data);
    }

    /**
     * 读取指定索引和基数位的数字
     * @param index 数据索引
     * @param pow 基数位（1-个位，2-十位，3-百位，依此类推）
     * @return
     */
    private int readDigit(int index, int pow) {
        int number = getData()[index];
        while (pow > 1) {
            number = number / 10;
            pow-=1;
        }
        return number % 10;
    }

    /**
     * 执行基数排序
     * @param maxupper
     */
    public void execute(int maxupper) {
        int pow = 1;
        while (maxupper / 10 > 0) {
            pow += 1;
            maxupper /= 10;
        }
        int[] temp = new int[getData().length];

        for (int p = 1; p <= pow; p++) {
            int[] bucket = new int[10];
            //取指定基数位放置在制定位置
            for (int j = 0; j < getData().length; j++) {
                int b = readDigit(j, p);
                bucket[b] += 1;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = getData().length - 1; i >= 0; i--) {
                int b = readDigit(i, p);
                temp[bucket[b] - 1] = getData()[i];
                bucket[b] -= 1;
            }
            setData(temp.clone());
        }
    }

}
