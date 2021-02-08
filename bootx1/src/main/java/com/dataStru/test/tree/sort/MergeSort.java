package com.dataStru.test.tree.sort;

import java.util.Arrays;

/**
 * @author 15000
 * 动画地址  https://cloud.tencent.com/developer/article/1377640
 */
public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        /**
         * 把数组分成了两半  第一半从low 开始 第二半动mid+1开始
         */
        // 左段起始指针
        int i = low;
        // 右段起始指针
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中  看动画理解  地址上面
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

    /**
     * 每次传一段  然后段段切割 轮回不止
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //  第一阶段  左右切割  并没有真正的切割数组  也是数组分段
            // 左边  将数组切割成段  先左后右
            mergeSort(arr, low, mid);
            // 右边
            mergeSort(arr, mid + 1, high);
            // 第二阶段  开始合并
            // 左右归并 排序融合
            // 这是最小的那一段
            merge(arr, low, mid, high);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int arr[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(" --------------------------------------");
        System.out.println(Arrays.toString(arr));
    }
}