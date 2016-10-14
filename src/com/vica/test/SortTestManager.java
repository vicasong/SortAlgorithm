package com.vica.test;

import java.util.Random;

/**
 * 测试管理器
 * Created by Vica tony on 2016/8/1.
 */
public class SortTestManager {

    final private int sortKinds = 9;
    private int jobFinished = 0;
    private long[][][] result;
    private int[][][] data;
    private int[] task;

    //private int allWork = 0;
    private SortInfoListener listener = null;

    private SortTaskCallback callback = new SortTaskCallback() {
        @Override
        public void onFinished(int taskIndex, long[][] result) {
//            System.out.println("任务" + taskIndex + "完成");
            SortTestManager.this.setJobFinished(taskIndex);
        }

        @Override
        public void onProgressChanced(int taskIndex, int current) {
            //System.out.println("任务" + taskIndex + "正在进行" + current + "/" + allWork);
        }
    };

    /**
     * 矩阵型任务测试
     *
     * @param task 测试任务
     */
    public SortTestManager(int[] task) {
        this.task = task;
        result = new long[sortKinds][task.length][task.length];
        //allWork = task.length * task.length;
        data=new int[task.length][task.length][];
    }

    /**
     * 设置任务完成回调
     *
     * @param listener
     */
    public void setOnFinishedCallback(SortInfoListener listener) {
        this.listener = listener;
    }

    private synchronized void setJobFinished(int taskIndex) {
        jobFinished += 1;
        if (listener != null) {
            listener.OnSortTaskProgressChanged(taskIndex, jobFinished, sortKinds);
            if (jobFinished == sortKinds) {
                listener.OnSortTaskFinished(result);
            }
        }
    }

    /**
     * 生成随机数据源
     */
    private void setData() {
        for (int i = 0; i < task.length; i++) {
            for (int j = 0; j < task.length; j++) {
                data[i][j] = random(task[i], task[j] + 1);
            }
        }
    }

    /**
     * 执行任务
     */
    public void executeTest() {
        setData();
        for (int i = 0; i < sortKinds; i++) {
            //新建任务执行者
            SortTacker tacker = new SortTacker(task, i);
            //分发数据源，此处为防止taacker修改数据源可以在此克隆一份
            tacker.setData(data);
            //分发结果容器
            tacker.setResult(result[i]);
            //分发回调
            tacker.setCallback(callback);
            tacker.start();
        }
    }

    /**
     * 随机数组
     *
     * @param size     数组大小
     * @param maxupper 数值最大上限（排除）
     * @return
     */
    private int[] random(int size, int maxupper) {
        maxupper -= 1;
        int[] rand = new int[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int data = random.nextInt(maxupper) + 1;
            rand[i] = data;
        }
        return rand;
    }

}
