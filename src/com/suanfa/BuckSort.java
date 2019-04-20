package com.suanfa;

public class BuckSort {
   /* private int[] bucket;
    private int[] array;

    // size是一个范围
    public  TestBucketSort(int[] array) {
        this.array = array;
        int max = array[0];
        int min = array[0];
        for(int i=0; i<array.length; ++i){
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        bucket = new int[max-min+1]; //算出需要开辟多少个空间

    }

    public void sort() {
        for (int i = 0; i < array.length; ++i) {
            bucket[array[i]]++;
        }
    }

    // 遍历桶，并得到每个桶中数n，并输出n次该桶下标
    public void print() {
        for (int i = 0; i < bucket.length; i++){
            for (int j = 0; j < bucket[i]; j++){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,1,5,9,6,5,0};
        TestBucketSort order = new TestBucketSort(array);
        order.sort();
        order.print();
    }
*/
}
