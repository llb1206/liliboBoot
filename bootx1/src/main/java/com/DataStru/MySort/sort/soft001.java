package com.DataStru.MySort.sort;

import java.util.Arrays;

public class soft001 {
    /**
     * 冒泡排序
     *+-
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
            int preIndex = i - 1;
            int current = arr[i];
            //please  想象一下，将要排序的值 拉起，就跟栈排序类似，符合条件再下坠
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序   先写出一个插入排序，再将插入排序的步长设置，但是最后一定是1，变成整体性的插入排序  就完全ojbk
     *
     * @param arr
     */
    public static void shellSoft(int[] arr) {
        for (int step = arr.length; step > 0; step /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int preIndex = i - step;
                int current = arr[i];
                //please  想象一下，将要排序的值 拉起，就跟栈排序类似，符合条件再下坠
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + step] = arr[preIndex];
                    //preIndex--;
                    preIndex -= step;
                }
                arr[preIndex + step] = current;
            }
        }
        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args) {
        int[] arrays = {6, 9, 3, 8, -1, 2, 7, 5};
        //mapPaoSoft(arrays);
        //selectSoft(arrays);
        //insertSoft(arrays);
        shellSoft(arrays);
    }
}
