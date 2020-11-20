package heap;

import java.util.Arrays;

/**
 * @description: 堆
 * 向下调整、建堆、向上调整等
 * @author: Deepcola
 * @time: 2020/11/20 13:32
 */
public class MyHeap {

    public int[] elem;// 底层数组
    public int usedSize;// 堆的大小
    public MyHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    /**
     * 交换函数
     * 用于交换给定的数组的两个下标的值
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 建堆
     * 堆只有两种情况: 大根堆和小根堆，以大根堆为例
     * 给定一个数组建成一个大根堆,在元素进入以后进行判断是否还是一个队，不是的话需要进行适当的调整,
     */
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        // 从第一个不是叶子结点(叶子结点度为0，不需要调整)的结点也就是最后一个父结点开始调整，直至根节点时为堆
        // 这个结点下标为 (最后一个结点的下标-1)/2,
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, this.usedSize - 1);
        }
    }


    /***
     * 向下调整
     * 1.计算该父结点的孩子结点下标(根节点下标为0)
     *      如果孩子存在: 左孩子 index = 2 * parent + 1; 右孩子 index = 2 * parent + 2
     * 2.如果孩子结点较大的大于父结点，交换两个结点,然后向下调整使得继续为大根堆; 反之，去调整下一个结点
     * @param parent 需要调整的父结点
     * @param length 堆的大小
     */
    public void adjustDown(int parent, int length) {
        // 左孩子结点下标
        int child = 2 * parent + 1;
        // 左孩子是否存在
        while (child <= length) {
            // 左孩子存在就判断有没有右孩子
            // 选择较大结点值的孩子下标为 child;
            if (child + 1 < length && this.elem[child] < this.elem[child + 1]) {
                // 右孩子比较大
                child++;
            }
            // 目前为止。child 下标所在的元素是孩子中较大的
            // 比较其与父结点的大小
            if (this.elem[child] > this.elem[parent]) {
                // 孩子结点比较大，需要与父结点交换
                swap(this.elem, child, parent);
                // 向下调整，查看子树是否为大根堆
                // 只需要比较与父结点交换的子树便可
                parent = child;
                child = 2 * parent + 1;
            }else {
                // 不需要调整
                break;
            }
        }
    }

    /**
     * 插入一个元素
     * 首先判断数组是否已满，从而需要扩容
     * 插入一个元素是在堆的尾部插入, 在插入之后需要其继续为大根堆，所以需要进行调整，将插入元素调整到合适位置
     */
    public void push(int val) {
        // 数组满了 -> 需要扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        this.elem[this.usedSize++] = val;
        adjustUp(this.usedSize - 1);
    }

    /**
     * 向上调整
     * 1.计算其父结点的下标
     *      index = (child - 1) / 2
     * 2.如果大于父结点的值，需要和父结点交换; 反之，不需要交换
     * 3.一直向上直至合适位置,使得堆还是大根堆
     * @param child 需要调整的结点
     */
    public void adjustUp(int child) {
        // 计算父节点的下标
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            // 父结点的值小于其孩子结点 -> 需要交换
            if (this.elem[parent] < this.elem[child]) {
                // 交换两个结点
                swap(this.elem, parent, child);
                // 向上继续判断是否为大根堆
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    /**
     * 删除堆顶元素
     * 1.堆为空时，无法删除
     * 2.删除对顶元素为了不影响其大根堆的性质, 所以先将堆顶元素与末尾元素交换, 然后删除最后一个元素(没有影响);
     * 3.最后从堆顶开始向下调整, 使得其继续为大根堆
     */
    public void pop() {
        if (isEmpty()) return;
        // 交换堆顶结点和末尾结点
        swap(this.elem, 0, this.usedSize - 1);
        // 删除最后一个元素
        this.usedSize--;
        adjustDown(0, this.usedSize - 1);
    }

    /**
     * 判断数组是否已满
     */
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }



    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};

        // 建堆
        myHeap.createHeap(array);

        //插入一个元素
        myHeap.push(80);

        // 弹出堆顶元素
        myHeap.pop();

        System.out.println();
    }
}