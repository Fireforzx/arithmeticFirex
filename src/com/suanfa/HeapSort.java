package com.suanfa;

import static com.suanfa.QuickSort.swap;

public class HeapSort {

   public static void heapSort(int[] arr){
       if (arr == null || arr.length < 2){
           return;
       }
       for (int i = 0; i < arr.length; i++){
           int index  = i;
           while (arr[index] >arr[(index - 1)/2]){
               swap(arr, index, (index - 1)/2);
               index = (index - 1)/2;
           }
       }
       int heapSize = arr.length;
       swap(arr, 0, --heapSize);
       while (heapSize > 0){
           heapify(arr, 0, heapSize);
           swap(arr, 0, --heapSize);
       }
   }

   //思路：非大根堆转大根堆
   public static void heapify(int []arr, int index, int heapSize){
       int left = index * 2 + 1;//不能溢出，所以输入数组大小，，初始定义第一个指针为1，
                                // 我们要找到非0最大值放置于0的位置，并与最后一个交换拿出
       while (left < heapSize){
           int largest = arr[left + 1] > arr[left] && left + 1 < heapSize ? left + 1 : left;//切记不可超过树大小，找到最大值
           largest = arr[largest] > arr[index] ? largest : index;
           if (largest == index){//注意如果最大值就是0处值，则说明已经找到跳出
               break;
           }
           //这里我们只是把被置换头部的子树重新变为大根
           swap(arr, largest, index);
           index = largest;
           left = index * 2 + 1;
       }


   }


}
