package com.learn.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/01/02 18:48:00
 */
public class ParallelQuickSort extends RecursiveAction {

    private int[] array;
    private int left;
    private int right;

    public ParallelQuickSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }
    private int partition(int left,int right) {
       int pivot = array[right];
       int i = left - 1;
       for (int j = left; j < right; j++){
           if (array[j] <= pivot){
               i++;
               int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
           }
       }

       int temp = array[i + 1];
       array[i + 1] = array[right];
       array[right] = temp;
       return i + 1;

    }

    @Override
    protected void compute() {
        if (left < right){
            int partitionIndex = partition(left, right);
            ParallelQuickSort leftTask = new ParallelQuickSort(array,left,partitionIndex - 1);
            ParallelQuickSort rightTask = new ParallelQuickSort(array,partitionIndex + 1, right);

            leftTask.fork();
            rightTask.fork();

            leftTask.join();
            rightTask.join();

        }
    }

    public static void parallelQuickSort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelQuickSort(array,0,array.length - 1));
    }

    public static void main(String[] args) {
        int[] array = { 12,23,87,26,9,28,7};
        parallelQuickSort(array);
        for (int i : array){
            System.out.println(i + "");
        }
    }
}
