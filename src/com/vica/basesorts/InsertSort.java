package com.vica.basesorts;

import com.vica.base.SortBase;

import java.util.Scanner;

/**
 * 简单插入排序
 * Created by Vica tony on 2016/7/31.
 */
public class InsertSort extends SortBase {

    public InsertSort(int[] data) {
        super(data);
    }

    /**
     * 执行直接插入排序
     */
    public void execute(){
        execute(1);
    }

    /**
     * 执行插入排序
     * @param setup 索引增量，若为1则为直接插入排序，否则为希尔排序单步
     */
    protected void execute(int setup){
        for(int i=setup; i<getData().length;i++){
            int j=i;
            int prepare=getData()[j];
            while (j>setup-1&&prepare<getData()[j-setup]){
                getData()[j]=getData()[j-setup];
                j-=setup;
            }
            getData()[j]=prepare;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int num = in.nextInt();
            int[] array = new int[num];
            for(int i=0;i<num;i++){
                array[i]=in.nextInt();
            }
            for(int i=1;i<array.length;i++){
                int j=i;
                int tmp = array[j];
                while(j>0&&array[j-1]>tmp){
                    array[j]=array[j-1];
                    j--;
                }
                array[j]=tmp;
            }
            for(int i=0;i<num;i++){
                System.out.println(""+array[i]);
            }
        }
    }
}
