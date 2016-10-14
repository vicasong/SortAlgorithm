package com.vica.test;

/**
 * 排序算法测试
 * Created by Vica tony on 2016/8/1.
 */
public class SortsTest {



    public static void main(String[] args) {

        //int[] task={10,20,50,100,200,500,1000,2000,5000,10000};
        //int[] task={10,20,50,100,200,500,1000,2000,5000,10000,20000,50000,100000,200000,300000};

        //工作清单，例如{10，20}就表示进行2x2即4次工作，分别为
        // 10的数据量和10的数据范围、10的数据量和20的数据范围、20的数据量和10的数据范围、20的数据量和20的数据范围
        //数据量越大且数据范围越小则重复数据越多，反之则数据更平缓

        int[] task={500,1000,2000,5000,10000,20000,30000};
        //指定工作清单
        SortTestManager testThread=new SortTestManager(task);
        //算法Id名称序列
        final String[] taskName={"冒泡","插入","选择","希尔","快速","桶","堆","基数","归并"};
        //获取当前系统时钟毫秒
        final long start=System.currentTimeMillis();
        //设置监听器
        SortInfoListener infoListener=new SortInfoListener() {
            @Override
            public void OnSortTaskProgressChanged(int currentTask, int finished, int allTask) {
                long now=System.currentTimeMillis()-start;
                System.out.println(((double)now/1000)+"s，任务"+taskName[currentTask]+"排序已完成，任务完成"+finished+"/"+allTask);
            }

            @Override
            public void OnSortTaskFinished(long[][][] result) {
                //任务完成时输出结果
                long now=System.currentTimeMillis()-start;
                System.out.println("运行结束，总耗时："+((double)now/1000)+"s");
                for(int i=0;i<result.length;i++){
                    System.out.println(taskName[i]+"排序算法运行耗时（ms）：");
                    for(int j=0;j<result[0].length;j++){
                        for(int l=0;l<result[0][0].length;l++){
                            System.out.print(result[i][j][l]+"       \t");
                        }
                        System.out.println();
                    }
                }
            }
        };
        testThread.setOnFinishedCallback(infoListener);

        //开始任务
        testThread.executeTest();
    }

}
