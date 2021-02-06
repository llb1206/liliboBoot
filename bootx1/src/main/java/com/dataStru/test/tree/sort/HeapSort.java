package com.dataStru.test.tree.sort;

import java.util.Arrays;

public class HeapSort {
    private static void heapSort(int[] arr) {
        int len = arr.length - 1;
        /**
         * 构造堆
         * 在构造有序堆时，我们开始只需要扫描一半的元素（n/2-1 ~ 0）即可，为什么?
         * 因为(n/2-1)~0的节点才有子节点，如图1，n=8,(n/2-1) = 3 小于3的 即3 2 1 0这个四个节点才有子节点
         */
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        while (len >= 0) {
            swap(arr, 0, len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大--尾号最后一个元素
            heapAdjust(arr, 0, len);    //再次对堆进行调整
        }
    }

    public static void heapAdjust(int[] arr, int i, int len) {
        int left, right, j;
        while ((left = 2 * i + 1) <= len) {    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if (j < len && arr[left] < arr[right])    //右节点大于左节点
                j++;     //当前把"指针"指向右节点
            if (arr[i] < arr[j])    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                swap(arr, i, j);
            else         //说明比孩子节点都大，直接跳出循环语句
                break;
            i = j;
        }
    }

    public static void swap(int[] arr, int i, int len) {
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }

    public static void main(String[] args) {
        int array[] = {20, 50, 20, 40, 70, 10, 80, 30, 60, 45};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}