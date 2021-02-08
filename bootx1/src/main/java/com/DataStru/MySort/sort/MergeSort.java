package com.DataStru.MySort.sort;

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
        // 这个是有一个截止限定的 最小的不能超过中位，第二段不超过顶位，取得时候不要越界
        while (i <= mid && j <= high) {
            //看看哪一段的起始值 是最值
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //  都已经轮回完了
        // 把左边剩余的数移入数组  --下面这两个while  肯定只剩一下一个  而且都是排序好的了
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 把新数组中的数覆盖 arr数组  在最小值基础上
        for (int v = 0; v < temp.length; v++) {
            arr[v + low] = temp[v];
        }
    }

    /**
     * 每次传一段  然后段段切割 轮回不止
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        //首先 要 一直嘚切割，切割成一个个的独立的单元
        //切割成1 1 1 1   所有只要<  至少不是单个  需要切割
        if (low < high) {
            //  第一阶段  左右切割  并没有真正的切割数组  也是数组分段
            //  左边  将数组切割成段  先左后右
            //  一直在分割  直到都是 0,0时候
            mergeSort(arr, low, mid);
            // 右边
            // 一直在分割  直到都是 0,0时候
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