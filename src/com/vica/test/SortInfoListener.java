package com.vica.test;

/**
 * Created by Vica tony on 2016/8/1.
 */
public interface SortInfoListener {
    public void OnSortTaskProgressChanged(int currentTask, int finished, int allTask);

    public void OnSortTaskFinished(long[][][] result);
}
