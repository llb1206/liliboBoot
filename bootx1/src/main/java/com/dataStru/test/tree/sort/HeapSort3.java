package com.dataStru.test.tree.sort;

import java.util.Arrays;

/**
 * 数组下标0的元素也参与排序
 *
 * @author stoneWang_L
 */
public class HeapSort3 {

    private static void heapSort(int[] arr, int count) {
        //完成构建大顶堆
        for (int i = (count - 2) / 2; i >= 0; i--)
            shiftDown(arr, count, i);
        System.out.println("构建完成的大顶堆:" + Arrays.toString(arr));

        //将大顶堆头结点（最大数）与最后一个元素交换位置，然后除去最后这个最大的元素，再shiftDown操作维护该（除去最后一个元素的数组）堆为大顶堆。循环直到升序排序完成
        for (int j = count - 1; j > 0; j--) {
            swap(arr, 0, j);
            shiftDown(arr, j, 0);
        }
    }
    /**
     * @param arr         数组
     * @param count       元素个数
     * @param currentRoot 当前根节点的下标
     */
    private static void shiftDown(int[] arr, int count, int currentRoot) {
        while (2 * currentRoot + 1 < count) {
            int max = 2 * currentRoot + 1; //初始赋值left孩子
            if (max + 1 < count && arr[max + 1] > arr[max])
                max += 1;
            if (arr[currentRoot] >= arr[max])
                break;
            swap(arr, currentRoot, max);
            currentRoot = max;
        }
    }

    //交换
    public static void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {312, 126, 272, 226, 28, 165, 123, 8, 12};
        heapSort(arr, arr.length);
        System.out.println("堆排序后:" + Arrays.toString(arr));
    }
}