package com.vica.test;

/**
 * Created by Vica tony on 2016/8/1.
 */
public interface SortTaskCallback {

    public void onFinished(int taskIndex, long[][] result);

    /**
     * 任务进度改变
     * @param taskIndex 排序算法Id
     * @param current 当前任务
     */
    public void onProgressChanced(int taskIndex, int current);
}
