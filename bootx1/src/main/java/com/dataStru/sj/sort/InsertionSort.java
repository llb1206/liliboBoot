package com.dataStru.sj.sort;

import java.util.Arrays;

public class InsertionSort {
    static int[] insertionSort(int[] arr) {

        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] s = new int[]{9, 5, 6, 7, 2, 8, 1};
        int[] arr = insertionSort(s);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
