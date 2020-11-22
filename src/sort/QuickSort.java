package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @description: 快速排序的实现、优化
 * @author: Deepcola
 * @time: 2020/11/22 10:10
 */
public class QuickSort {

    /**
     * 交换数组中的两个元素
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 递归实现快速排序
     */
    class QuickSortRec {
        public void quickSort(int[] array) {
            // 快速排序-递归
            quick(array, 0, array.length - 1);
        }

        /**
         * 递归————快速排序
         */
        public void quick(int[] array, int start, int end) {
            // 一个系列只有一个元素时有序
            if (start >= end) return;
            // 查找基准位置
            int prior = partition(array, start, end);
            // 使用基准将数组分成两部分
            quick(array, start, prior - 1);
            quick(array, prior + 1, end);
        }

        /**
         * 取每段序列的第一个元素为基准
         * 按照基准大小, 将数组分成大于基准和小于基准两部分, 分布于基准两侧
         */
        public int partition(int[] array, int start, int end) {
            // 以第一个元素为基准
            int temp = array[start];
            while (start < end) {
                // 左边
                while (start < end && array[end] >= temp) {
                    end--;
                }
                if (start < end) {
                    array[start] = array[end];
                }else {
                    break;
                }
                // 右边
                while (start < end && array[start] <= temp) {
                    start++;
                }
                if (start < end) {
                    array[end] = array[start];
                }else {
                    break;
                }
            }
            // 将基准插入到空位置使得左边都比它小, 右边都比它大
            array[start] = temp;
            return start;
        }
    }


    /**
     * 非递归实现快速排序
     */
    class QuickSortNor {
        public void quickSort(int[] array) {
            // 快速排序-非递归
            quickNor(array, 0 ,array.length - 1);
        }

        /**
         * 非递归————快速排序
         * 每次使用基准把数组分成部分后, 将每一部分的头尾入栈, 以便对这部分进行快速排序
         */
        public void quickNor(int[] array, int start, int end) {
            Stack<Integer> stack = new Stack<>();
            // 查找基准
            int prior = partition(array, start, end);
            // 当序列只剩下一个元素时，不用排序
            if (prior > start + 1) {
                stack.push(start);
                stack.push(prior - 1);
            }
            if (prior < end - 1) {
                stack.push(prior + 1);
                stack.push(end);
            }
            while (!stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();
                prior = partition(array, left, right);
                if (prior > left + 1) {
                    stack.push(left);
                    stack.push(prior - 1);
                }
                if (prior < right - 1) {
                    stack.push(prior + 1);
                    stack.push(right);
                }
            }
        }

        /**
         * 取第一个元素作为基准
         * 将数组分成大于基准和小于基准两部分,分别位于基准左右两侧, 返回基准位置
         */
        public int partition(int[] array, int start, int end) {
            // 以第一个元素为基准
            int temp = array[start];
            while (start < end) {
                // 左边
                while (start < end && array[end] >= temp) {
                    end--;
                }
                if (start < end) {
                    array[start] = array[end];
                }else {
                    break;
                }
                // 右边
                while (start < end && array[start] <= temp) {
                    start++;
                }
                if (start < end) {
                    array[end] = array[start];
                }else {
                    break;
                }
            }
            // 将基准插入到空位置使得左边都比它小, 右边都比它大
            array[start] = temp;
            return start;
        }
    }


    /**
     * 优化: 递归实现快速排序 + 插入排序 + 三数取中选基准
     */
    class QuickSortOpt {
        public void quickSort(int[] array) {
            quick(array, 0, array.length - 1);
        }

        /**
         * 递归————快速排序
         */
        public void quick(int[] array, int start, int end) {
            // 一个系列只有一个元素时有序
            if (start >= end) return;
            // 当数组元素数量小于 100 时, 使用插排
            if (end - start + 1 < 100) {
                // 插排
                for (int i = 1; i < array.length; i++) {
                    int temp = array[i];
                    int j = i - 1;
                    for (; j >= 0; j--) {
                        if (array[j] > temp) {
                            array[j + 1] = array[j];
                        }else {
                            break;
                        }
                    }
                    array[j + 1] = temp;
                }
            }
            // 三数取中放到序列第一个元素作为基准
            midianOfThere(array, start, end);
            // 查找基准位置
            int prior = partition(array, start, end);
            // 使用基准将数组分成两部分
            quick(array, start, prior - 1);
            quick(array, prior + 1, end);
        }

        /**
         * 三数取中换至第一个元素(会作为基准)
         */
        public void midianOfThere(int[] array, int start, int end) {
            int mid = (start + end) / 2;
            // 需要使 array[mid] < array[start] < array[end]
            if (array[mid] >= array[start]) {
                swap(array, start, mid);// array[mid] < array[start]
            }
            if (array[start] >= array[end]) {
                swap(array, start, end);// array[start] < start[end]
            }
            if (array[mid] >= array[end]) {
                swap(array, start, mid);// array[mid] < array[end]
            }
        }

        /**
         * 取每段序列的第一个元素为基准
         * 按照基准大小, 将数组分成大于基准和小于基准两部分, 分布于基准两侧
         */
        public int partition(int[] array, int start, int end) {
            // 以第一个元素为基准
            int temp = array[start];
            while (start < end) {
                // 左边
                while (start < end && array[end] >= temp) {
                    end--;
                }
                if (start < end) {
                    array[start] = array[end];
                }else {
                    break;
                }
                // 右边
                while (start < end && array[start] <= temp) {
                    start++;
                }
                if (start < end) {
                    array[end] = array[start];
                }else {
                    break;
                }
            }
            // 将基准插入到空位置使得左边都比它小, 右边都比它大
            array[start] = temp;
            return start;
        }
    }



    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[100_000];

//        // 随机数组
//        Random random = new Random(10);
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

//        // 快速排序——递归
//        QuickSortRec quickSortRec = quickSort.new QuickSortRec();
//        long start = System.currentTimeMillis();
//        quickSortRec.quickSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("递归-快速排序: " + (end - start));

//        // 快速排序——非递归
//        QuickSortNor quickSortNor = quickSort.new QuickSortNor();
//        long start = System.currentTimeMillis();
//        quickSortNor.quickSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("非递归-快速排序: " + (end - start));

//        // 快速排序——优化(快排+插排+三数取中)
//        QuickSortOpt quickSortOpt = quickSort.new QuickSortOpt();
//        long start = System.currentTimeMillis();
//        quickSortOpt.quickSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("优化-快速排序: " + (end - start));
    }

}
