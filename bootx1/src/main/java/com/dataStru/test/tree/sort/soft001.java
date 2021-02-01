package com.dataStru.test.tree.sort;

import java.util.Arrays;

public class soft001 {
    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void mapPaoSoft(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //因为这里是加了一个1，会出现数组越界异常
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序  一直选择最小的或者是最大的
     *
     * @param arr
     */
    public static void selectSoft(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //初始值默认为为剩余未筛选的第一个,写清作用域即可
            int index = i, temp;
            for (int j = i; j < arr.length; j++) {

                if (arr[index] > arr[j]) {
                    index = j;//保存最小值的索引
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 从第二个元素开始，一直与前面的比较，小于的后移，不是互换位置
     *
     * @param arr
     */
    public static void insertSoft(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int index2 = i;
            for (int j = i; j > 1; j--) {
                if (arr[index] < arr[j - 1]) {
                    arr[j] = arr[j - 1];//前一个后移
                } else {
                    index2=;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 3, 8, -1, 2, 7, 5};
        //mapPaoSoft(arr);
        //selectSoft(arr);
        insertSoft(arr);
    }
}
