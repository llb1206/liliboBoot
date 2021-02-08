package com.DataStru.test.tree.sort;

import java.util.Arrays;

/**
 * @author 15000
 */
public class HeapSort {
    private static void heapSort(int[] arr) {
        int len = arr.length - 1;
        //堆构造
        /**
         * n=8,(n/2-1) = 3  即3 2 1 0这个四个节点才有子节点,先把这个堆构造起来，因为是完全二叉树，节点是顺序序号，对应数组下标
         * 首先从最下面的节点开始推，从下往上推
         */
        for (int index = len / 2 - 1; index >= 0; index--) {
            heapAdjust(arr, index, len);
        }
        //最终构建了一个 完全二叉树
        while (len >= 0) {
            //********将堆顶元素与尾节点交换后，长度减1，尾元素最大，比较完毕 将最值放最后 并且不参与比较
            swap(arr, 0, len--);
            //再次对堆进行调整
            heapAdjust(arr, 0, len);
        }
    }

    /**
     * 构建的时候，index由大往小构造，调整的时候，从顶部 按照节点从小往大构造
     *
     * @param arr
     * @param index
     * @param length
     */
    public static void heapAdjust(int[] arr, int index, int length) {
        int left, right, p;
        //  公式反推，推出节点左右子节点
        //  判断当前父节点有无左节点（即有无孩子节点，left为左节点）
        while ((left = 2 * index + 1) <= length) {
            //j"指针指向左节点"
            p = left;
            //右节点
            right = left + 1;
            //右节点大于左节点//当前把"指针"指向右节点//总之，就是准备找出两个子节点最值与父节点交换
            if (p < length && arr[left] < arr[right]) {
                //就是准备找出两个子节点最值与父节点交换
                p++;
            }
            //将父节点与最值孩子节点交换（如果上面if为真，则arr[p]为右节点，如果为假arr[p]则为左节点）
            if (arr[index] < arr[p]) {
                swap(arr, index, p);
            } else {
                //说明比孩子节点都大，直接跳出循环语句
                break;
            }
            //蹦到下一个节点   这个节点index*2+1  就是下一个需要调整的节点
            index = p;
        }
    }

    public static void swap(int[] arr, int i, int len) {
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }

    public static void main(String[] args) {
        int array[] = {20, 50, 20, 40, 70, 10, 80, 30, 60};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}