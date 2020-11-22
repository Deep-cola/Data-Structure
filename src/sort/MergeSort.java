package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 归并排序的实现以及优化
 * @author: Deepcola
 * @time: 2020/11/22 11:58
 */
public class MergeSort {
    /**
     * 递归实现归并排序
     */
    class MergeSortRec {
        public void mergeSort(int[] array) {
            mergeInternal(array, 0, array.length - 1);
        }

        /**
         * 递归分散, 内部合并
         */
        public void mergeInternal(int[] array, int start, int end) {
            if (start >= end) return;
            int mid = (start + end) / 2;
            // 拆分
            mergeInternal(array, start, mid);
            mergeInternal(array, mid + 1, end);
            // 合并
            merge(array, start, end, mid);
        }

        /**
         * 合并
         */
        public void merge(int[] array, int start, int end, int mid) {
            int tmepArr[] = new int[end - start + 1];
            int s1 = start;
            int s2 = mid + 1;
            // 排序数组的遍历位置
            int k = 0;
            while (s1 <= mid && s2 <= end) {
                if (array[s1] <= array[s2]) {
                    tmepArr[k++] = array[s1++];
                }else {
                    tmepArr[k++] = array[s2++];
                }
            }
            // 此时有一个序列已经遍历完
            while (s1 <= mid) {
                tmepArr[k++] = array[s1++];
            }
            while (s2 <= end) {
                tmepArr[k++] = array[s2++];
            }

            // 将排序数组放入原数组
            for (int i = 0; i < tmepArr.length; i++) {
                array[i + start] = tmepArr[i];
            }
        }
    }

    /**
     * 非递归实现归并排序
     */
    class MergeSortNor {
        public void mergeSort(int[] array) {
            for (int i = 1; i < array.length; i *= 2) {
                mergeSortNor(array, i);
            }
        }

        /**
         * 非递归-归并
         */
        public void mergeSortNor(int[] array, int gap) {
            int len = array.length;
            int[] tempArr = new int[len];
            int k = 0;
            int s1 = 0;
            int e1 = s1 + gap - 1;
            int s2 = e1 + 1;
            int e2 = (s2 + gap - 1 < len) ? s2 + gap - 1 : len - 1 ;
            // 是不是有两个归并序列
            while (s2 < len) {
                while (s1 <= e1 && s2 <= e2) {
                    if (array[s1] <= array[s2]) {
                        tempArr[k++] = array[s1++];
                    }else {
                        tempArr[k++] = array[s2++];
                    }
                }
                while (s1 <= e1) {
                    tempArr[k++] = array[s1++];
                }
                while (s2 <= e2) {
                    tempArr[k++] = array[s2++];
                }
                // 继续归并
                s1 = e2 + 1;
                e1 = s1 + gap - 1;
                s2 = e1 + 1;
                e2 = (s2 + gap - 1 < len) ? s2 + gap - 1 : len - 1 ;
            }
            // 只有一个归并段
            while (s1 <= len - 1) {
                tempArr[k++] = array[s1++];
            }
            for (int i = 0; i < tempArr.length; i++) {
                array[i] = tempArr[i];
            }
        }

    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[100_000];

//        // 随机数组
//        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(100_000);
//        }
//        System.out.println(Arrays.toString(array));

//        // 有序数组
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
//        System.out.println(Arrays.toString(array));

//        // 逆序数组
//        int index = 0;
//        for (int i = array.length - 1; i >= 0; i--) {
//            array[index++] = i;
//        }
//        System.out.println(Arrays.toString(array));


//        // 归并排序-递归
//        MergeSortRec mergeSortRec = mergeSort.new MergeSortRec();
//        long start = System.currentTimeMillis();
//        mergeSortRec.mergeSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("归并排序-递归: " + (end - start));

//        // 归并排序-非递归
//        MergeSortNor mergeSortNor = mergeSort.new MergeSortNor();
//        long start = System.currentTimeMillis();
//        mergeSortNor.mergeSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("归并排序-非递归: " + (end - start));
    }
}
