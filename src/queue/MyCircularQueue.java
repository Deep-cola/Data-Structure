package queue;

/**
 * @description: 基于数组实现循环队列
 * @author: Deepcola
 * @time: 2020/11/16 15:29
 */
public class MyCircularQueue {

    private int[] elem;
    private int usedSize;
    private int front;// 头部指针
    private int rear;// 尾部指针

    /** Initialize your data structure here. Set the size of the queue to be k. */
    /**
     * 设计循环队列需要一个额外的空间来区分是队满还是队空
     */
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    /**
     * 1.队列已满 -> 无法插入
     * 2.正常 -> 将元素插入进去后，尾部指针后移，需要计算尾部后移以后的下标(从 k 到 0 需要注意)
     */
    public boolean enQueue(int value) {
        // 队列已满
        if (isFull()) return false;
        this.elem[this.rear] = value;
        // rear 后移
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    /**
     * 1.队列为空 -> 无法删除
     * 2.正常 -> front 后移，需要计算头部后移以后的下标(从 k 到 0 需要注意)
     */
    public boolean deQueue() {
        // 队列为空
        if (isEmpty()) return false;
        // front 后移
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return this.elem[this.front];
    }

    /** Get the last item from the queue. */
    /**
     * 尾部指针的上一个才是最后一个元素，所以需要分析在 0 下标时的情况
     */
    public int Rear() {
        if (isEmpty()) return -1;
        // 尾部指针的上一个才是最后一个元素
        return this.elem[(this.rear == 0 ? this.elem.length - 1 : this.rear - 1)];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.front == (this.rear + 1) % this.elem.length;
    }


    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));// true
        System.out.println(myCircularQueue.enQueue(2));// true
        System.out.println(myCircularQueue.enQueue(3));// true
        System.out.println(myCircularQueue.enQueue(4));// false
        System.out.println(myCircularQueue.Rear());// 3
        System.out.println(myCircularQueue.isFull());// true
        System.out.println(myCircularQueue.deQueue());// true
        System.out.println(myCircularQueue.enQueue(4));// true
        System.out.println(myCircularQueue.Rear());// 4
    }
}
