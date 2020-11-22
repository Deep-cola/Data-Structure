package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 七种常见的比较算法
 * 插入排序 : 插入排序、希尔排序
 * 选择排序 : 选择排序、堆排序
 * 交换排序 : 冒泡排序、快速排序
 * 归并排序 : 归并排序
 * @author: Deepcola
 * @time: 2020/11/21 15:15
 */
public class Sort {

    /**
     * 交换数组中的两个元素
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    /**
     * 插入排序: 数组分为有序序列和无序序列，每次从无序序列中选择第一个元素插入到有序序列的合适位置直至数组有序
     * 时间复杂度:
     *      最好情况 -> 数组有序:O(N),每次只需要比较一次，总共比较 N-1 次就好
     *      最差情况 -> 数组逆序:O(N^2),每次只需要比较有序序列的长度，总共需要 N(N-1)/2 次
     *      平均情况 -> 随机数组:O(N^2)
     * 空间复杂度: O(1),只需常数级别空间
     * 稳定性：稳定。相等元素的相对位置不会发生改变。
     * 越有序越快, 适用于小规模或者基本有序数据
     */
    public void insertSort(int[] array) {
        if (array == null || array.length == 0) return;
        // 一个元素时被看作有序
        for (int i = 1; i < array.length; i++) {
            // 将待排序元素暂存起来
            int temp = array[i];
            // 标记有序序列的最后一个元素
            int j = i - 1;
            // 从有序序列的最后一个元素开始向前遍历, 和待排序元素进行比较寻找插入的合适位置
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    // 当前元素大于待排序元素, 当前元素后移一位
                    array[j + 1] = array[j];
                }else {
                    // 找到小于待排序的元素的元素时, 就不需要再继续比较
                    break;
                }
            }
            // 将待排序元素插入找到元素的后一个
            array[j + 1] = temp;
        }
    }

    /**
     * 希尔排序: 插入排序在数组规模小或者基本有序比较高效, 作为插入排序的优化。
     *          希尔排序根据增量数组将数组进行分组使得 规模小, 进行插入排序; 元素基本有序时，对整个基本有序数组插入排序.
     * 时间复杂度:
     *      最好情况 -> 数O(N^1.3),
     *      最差情况 -> O(N^2),
     *      平均情况 -> O(N^1.5)
     * 空间复杂度: O(1),只需常数级别空间
     * 稳定性：不稳定。分组时相等的元素可能被分为不同组，导致相对顺序发生转换
     */
    public void shellSort(int[] array) {
        if (array == null || array.length == 0) return;
        // 增量数组
        int[] drr = {5,3,1};
        // 根据每一次的增量进行分组，然后进行插入排序
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    /**
     * 希尔排序:对每一次的分组进行插入排序
     *      注意：一组之间两个元素相隔一个增量 gap
     */
    public void shell(int[] array, int gap) {
        // 一组的相邻元素之间相隔 gap, 进行插入排序即可
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i - gap;
            for (; j >= 0; j = j - gap) {
                if (temp < array[j]) {
                    array[j + gap] = array[j];
                }else {
                    break;
                }
            }
            array[j + gap] = temp;
        }
    }

    /**
     * 选择排序: 将数组分为有序序列和无序序列, 每次从无序序列中选择一个最小的元素插入到无序序列第一个元素, 同时有序序列长度 +1
     * 时间复杂度: 不论什么情况下, 都需要两两元素之间进行比较
     *      最好情况 -> O(N^2),
     *      最差情况 -> O(N^2),
     *      平均情况 -> O(N^2)
     * 空间复杂度: O(1),只需常数级别空间
     * 稳定性：不稳定。
     */
    public void selectSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                // 在一趟遍历中寻找最小元素换至无序序列第一个位置
                if (array[j] < array[i]) {
                    swap(array, j , i);
                }
            }
        }
    }

    /**
     * 堆排序: 1.建立大根堆, 堆顶元素就是最大元素,
     *        2.交换堆顶元素和最后一个元素, 那么最后一个位置就可以确定,需要调整元素(无序序列)长度 -1,
     *        3.通过向下调整维护大根堆，然后重复上一步, 直至无序序列长度为 0
     * 时间复杂度:
     *      最好情况 -> O(N*logN),
     *      最差情况 -> O(N*logN),
     *      平均情况 -> O(N*logN)
     * 空间复杂度: O(1),只需常数级别空间
     * 稳定性：不稳定。
     */
    public void heapSort(int[] array) {
        if (array == null || array.length == 0) return;
        // 建大根堆
        createHeap(array);
        // 交换堆顶元素和末尾元素, 那么末尾元素就是最大值, 不用继续调整
        // 向下调整俄维持大根堆，然后重复上一步
        int length = array.length - 1;
        while (length >= 0) {
            swap(array, 0, length);
            length--;
            // 向下调整
            adjustDown(array, 0, length);
        }
    }

    /**
     * 建堆
     */
    public void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    /**
     * 向下调整
     */
    public void adjustDown(int[] array, int parent, int length) {
        int child = 2 * parent + 1;
        while (child <= length) {
            // 查找两个孩子中较大的元素
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, parent, child);
                // 继续向下调整顺序
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    /**
     * 冒泡排序: 1.相邻的元素两两交换使得数组最大值移到最后一个位置,
     *         2.每一趟排序确定一个无序序列中的最大值后移到无序序列最后一个位置，然后无序序列长度 -1,
     *         3.进行下一趟排序，直至整个数组有序
     *         (在这里，实现方法优化: 定义一个 flag, 当某一趟排序没有发生元素交换时, 就说明数组已经有序)
     * 时间复杂度:
     *      最好情况 -> O(N),
     *      最差情况 -> O(N^2),
     *      平均情况 -> O(N^2)
     * 空间复杂度: O(1),只需常数级别空间
     * 稳定性：稳定。元素交换只发生相邻元素之间
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length; i++) {
            // 标记每一次是否发生元素交换
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 快速排序: 选择一个基准, 将数组中小于基准的元素放在基准左边, 大于基准的放在元素右边。
     *         递归快速排序左右序列。
     * 时间复杂度:
     *      最好情况 -> O(N*lonN),
     *      最差情况 -> O(N^2),
     *      平均情况 -> O(N*logN)
     * 空间复杂度: O(logN)
     * 稳定性：不稳定
     */
    public void quickSort(int[] array) {
        if (array == null || array.length == 0) return;
        quick(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     */
    public void quick(int[] array, int begin, int end) {
        // begin == end 时栈满溢出, 所以需要判断掉
        if (begin >= end) return;
        int prior = partition(array, begin, end);
        quick(array, begin, prior - 1);
        quick(array, prior + 1, end);
    }

    /**
     * 选取基准将数组分成两部分, 需要小于基准的元素在基准左边, 大于基准的元素在右边
     */
    public int partition(int[] array, int begin, int end) {
        // 取第一个元素作为基准
        int temp = array[begin];
        while (begin < end) {
            // 右指针寻找小于基准的元素换至前面空位置
            while (begin < end && array[end] >= temp) {
                end--;
            }
            if (begin < end) {
                array[begin] = array[end];
            }else {
                break;
            }
            // 左指针寻找大于基准的元素换至后面空位置
            while (begin < end && array[begin] <= temp) {
                begin++;
            }
            if (begin < end) {
                array[end] = array[begin];
            }else {
                break;
            }
        }
        array[begin] = temp;
        return begin;
    }

    /**
     * 归并排序:
     * 时间复杂度:
     *      最好情况 -> O(N*logN),
     *      最差情况 -> O(N*logN),
     *      平均情况 -> O(N*logN)
     * 空间复杂度: O(N)
     * 稳定性：稳定
     */
    public void mergeSort(int[] array) {
        if (array == null || array.length == 0) return;
        mergeSortInternal(array, 0, array.length - 1);
    }

    /**
     * 递归拆分,内部合并
     */
    public void mergeSortInternal(int[] array, int start, int end) {
        // begin == end 时栈满溢出, 所以需要判断掉
        if (start >= end) return;
        int mid = (start + end) / 2;
        // 递归拆分
        mergeSortInternal(array, start, mid);
        mergeSortInternal(array, mid + 1, end);
        // 归并
        merge(array, start, end, mid);
    }

    /**
     * 二路归并
     */
    public void merge(int[] array, int start, int end, int mid) {
        // 两个序列的起始
        int s1 = start;
        int s2 = mid + 1;

        int[] tempArr = new int[end - start + 1];
        // 标记排序数组的下标
        int k = 0;
        while (s1 <= mid && s2 <= end) {
            if (array[s1] <= array[s2]) {
                tempArr[k++] = array[s1++];
            }else {
                tempArr[k++] = array[s2++];
            }
        }
        // 此时某一个片段已经遍历完
        while (s1 <= mid) {
            tempArr[k++] = array[s1++];
        }
        while (s2 <= end) {
            tempArr[k++] = array[s2++];
        }
        // 从 tempArr 拷贝数组到 Array
        for (int i = 0; i < tempArr.length; i++) {
            array[i + start] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
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

//        // 插入排序
//        long start = System.currentTimeMillis();
//        sort.insertSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("插入排序:" + (end - start));

//        // 希尔排序
//        long start = System.currentTimeMillis();
//        sort.shellSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("希尔排序:" + (end - start));

//        // 选择排序
//        long start = System.currentTimeMillis();
//        sort.selectSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("选择排序:" + (end - start));

//        // 堆排序
//        long start = System.currentTimeMillis();
//        sort.heapSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("  堆排序:" + (end - start));

//        // 冒泡排序
//        long start = System.currentTimeMillis();
//        sort.bubbleSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("冒泡排序:" + (end - start));

//        // 快速排序
//        long start = System.currentTimeMillis();
//        sort.quickSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("快速排序:" + (end - start));

//        // 归并排序
//        long start = System.currentTimeMillis();
//        sort.mergeSort(array);
//        long end = System.currentTimeMillis();
//        System.out.println("归并排序:" + (end - start));

    }
}
