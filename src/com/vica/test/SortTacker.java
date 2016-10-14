package com.vica.test;

import com.vica.base.SortBase;
import com.vica.basesorts.*;
import com.vica.hightsort.HeapSort;
import com.vica.hightsort.QuickSort;
import com.vica.hightsort.ShellSort;
import com.vica.othersort.BucketSort;

/**
 * 任务执行者
 * Created by Vica tony on 2016/8/1.
 */
public class SortTacker extends Thread {
    private long[][] result;
    private int[][][] data;
    final private int[] task;
    private int taskIndex=0;
    private SortTaskCallback callback=null;
    private int prograss=0;

    /**
     * 构造任务执行者
     * @param task 任务列表
     * @param taskIndex 算法Id（0-8，目前就9种算法）
     */
    public SortTacker(int[] task, int taskIndex){
        this.task=task;
        this.taskIndex=taskIndex;
    }

    /**
     * 分配结果存放数组
     * @param result 该算法任务结果存放数组，由父容器指定
     */
    public void setResult(long[][] result){
        this.result=result;
    }

    /**
     * 指定算法输入数据源
     * @param data 随机数据源，来自父容器，在执行前就已经生成
     */
    public void setData(int[][][] data){
        this.data=data;
    }

    /**
     * 设置回调
     * @param callback
     */
    public void setCallback(SortTaskCallback callback){
        this.callback=callback;
    }

    @Override
    public void run() {
        executeRun();
    }

    /**
     * 运行任务
     */
    private void executeRun(){
        for(int i=0;i<task.length;i++){
            for(int j=0;j<task.length;j++) {
                prograss+=1;//任务进度，总工作量为task.length的平方
                callback.onProgressChanced(taskIndex, prograss);
                runTest(i, j);
            }
        }
        callback.onFinished(taskIndex, result);
    }

    /**
     * 执行算法
     * @param i 指定当前工作的数据量在任务表中的索引
     * @param j 指定当前工作的数据范围在任务表中的索引
     */
    private void runTest(int i, int j) {
        //防止对公共数据源修改，在此克隆一份用以排序使用
        int[] source = this.data[i][j].clone();
        SortBase sort=null;
        switch (taskIndex){//根据算法Id选取工作，并执行
            case 0:
                sort=task0(source);
                break;
            case 1:
                sort=task1(source);
                break;
            case 2:
                sort=task2(source);
                break;
            case 3:
                sort=task3(source);
                break;
            case 4:
                sort=task4(source);
                break;
            case 5:
                sort=task5(source,task[j]);
                break;
            case 6:
                sort=task6(source);
                break;
            case 7:
                sort=task7(source,task[j]);
                break;
            case 8:
                sort=task8(source);
                break;
        }
        result[i][j]=sort.getTicks();
    }


    /**
     * 冒泡排序
     * @param data
     * @return
     */
    private SortBase task0(int[] data){
        BubbleSort bubbleSort = new BubbleSort(data);
        bubbleSort.startTicks();
        bubbleSort.execute();
        bubbleSort.stopTicks();
//        System.out.println("冒泡排序：" + bubbleSort.getTicks() + "ms");
//        bubbleSort.print();
        return bubbleSort;
    }

    /**
     * 插入排序
     * @param data
     * @return
     */
    private SortBase task1(int[] data){
        InsertSort insertSort = new InsertSort(data);
        insertSort.startTicks();
        insertSort.execute();
        insertSort.stopTicks();
//        System.out.println("插入排序：" + insertSort.getTicks() + "ms");
//        insertSort.print();
       return insertSort;
    }

    /**
     * 选择排序
     * @param data
     * @return
     */
    private SortBase task2(int[] data){
        SelectSort selectSort = new SelectSort(data);
        selectSort.startTicks();
        selectSort.execute();
        selectSort.stopTicks();
//        System.out.println("选择排序：" + selectSort.getTicks() + "ms");
//        selectSort.print();
        return selectSort;
    }

    /**
     * 希尔排序
     * @param data
     * @return
     */
    private SortBase task3(int[] data){
        ShellSort shellSort = new ShellSort(data);
        shellSort.startTicks();
        shellSort.execute();
        shellSort.stopTicks();
//        System.out.println("希尔排序：" + shellSort.getTicks() + "ms");
//        shellSort.print();
        return shellSort;

    }

    /**
     * 快速排序
     * @param data
     * @return
     */
    private SortBase task4(int[] data){
        QuickSort quickSort = new QuickSort(data);
        quickSort.startTicks();
        quickSort.execute();
        quickSort.stopTicks();
//        System.out.println("快速排序：" + quickSort.getTicks() + "ms");
//        quickSort.print();
        return quickSort;
    }

    /**
     * 桶排序
     * @param data
     * @param dataMax
     * @return
     */
    private SortBase task5(int[] data, int dataMax){
        BucketSort bucketSort = new BucketSort(data);
        bucketSort.startTicks();
        bucketSort.execute(dataMax);
        bucketSort.stopTicks();
//        System.out.println("桶排序：" + bucketSort.getTicks() + "ms");
//        bucketSort.print();
        return bucketSort;
    }

    /**
     * 堆排序
     * @param data
     * @return
     */
    private SortBase task6(int[] data){
        HeapSort heapSort = new HeapSort(data);
        heapSort.startTicks();
        heapSort.execute();
        heapSort.stopTicks();
//        System.out.println("堆排序：" + heapSort.getTicks() + "ms");
//        heapSort.print();
        return heapSort;
    }

    /**
     * 基数排序
     * @param data
     * @param dataMax
     * @return
     */
    private SortBase task7(int[] data, int dataMax){
        RadixSort radixSort = new RadixSort(data);
        radixSort.startTicks();
        radixSort.execute(dataMax);
        radixSort.stopTicks();
//        System.out.println("基数排序：" + radixSort.getTicks() + "ms");
//        radixSort.print();
        return radixSort;
    }

    /**
     * 归并排序
     * @param data
     * @return
     */
    private SortBase task8(int[] data){
        MergeSort mergeSort = new MergeSort(data);
        mergeSort.startTicks();
        mergeSort.execute();
        mergeSort.stopTicks();
//        System.out.println("归并排序：" + radixSort.getTicks() + "ms");
//        mergeSort.print();
        return mergeSort;
    }
}
