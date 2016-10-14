package com.vica.base;

/**
 * 排序基类
 * Created by Vica tony on 2016/7/31.
 */
public class SortBase {

    private int[] data;
    private long ticks;

    public SortBase(int[] data){
        this.data=data;
        ticks=0;
    }

    /**
     * 设置数据序列
     * @param data 数据序列
     */
    protected void setData(int[] data){
        this.data=data;
    }

    /**
     * 用以交换数据位置
     * @param form 第一位置
     * @param to 第二位置
     */
    protected void swap(int form, int to){
        int temp=data[form];
        data[form]=data[to];
        data[to]=temp;
    }

    /**
     * 获取数据序列
     * @return 数据序列
     */
    public int[] getData(){
        return data;
    }

    /**
     * 开始计时
     */
    public void startTicks(){
        ticks=System.currentTimeMillis();
    }

    /**
     * 停止计时
     */
    public void stopTicks(){
        ticks=System.currentTimeMillis()-ticks;
    }

    /**
     * 获取计时器毫秒数
     * @return 计时毫秒
     */
    public long getTicks(){
        return ticks;
    }

    /**
     * 在控制台输出当前数据序列
     */
    public void print(){
        print(data);
    }

    /**
     * 在控制台输出指定数据序列
     * @param data 指定数据序列
     */
    public void print(int[] data){
        for(int i:data){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
