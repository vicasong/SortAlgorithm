package com.vica.hightsort;

import com.vica.base.SortBase;

/**
 * 堆排序
 * Created by Vica tony on 2016/8/1.
 */
public class HeapSort extends SortBase {

    public HeapSort(int[] data) {
        super(data);
    }

    /**
     * 建立大顶堆
     *
     * @param index 调整堆的最大索引
     */
    private void createHeap(int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < size && getData()[largest] < getData()[left]) {
            largest = left;
        }
        if (right < size && getData()[largest] < getData()[right]) {
            largest = right;
        }
        if (largest != index) {
            swap(largest, index);
            createHeap(size, largest);
        }
//        for(int i=(index-1)/2;i>=0;i--){
//            int current=i;
//            while (current*2+1<=index){
//                int defualt_big=current*2+1;
//                if(defualt_big<index){
//                    if(getData()[defualt_big]<getData()[defualt_big+1]){
//                        defualt_big+=1;
//                    }
//                }
//                if(getData()[current]<getData()[defualt_big]){
//                    swap(current,defualt_big);
//                    current=defualt_big;
//                }else {
//                    break;
//                }
//            }
//        }
    }

    /**
     * 执行堆排序
     */
    public void execute() {
        for(int i=(getData().length-2)/2;i>=0;i--){
            createHeap(getData().length,i);
        }
        for (int i = getData().length - 1; i > 0; i--) {
            swap(0, i);
            createHeap(i,0);
        }
    }
}
