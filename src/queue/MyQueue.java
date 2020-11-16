package queue;

/**
 * @description: 使用链表实现队列
 * @author: Deepcola
 * @time: 2020/11/16 14:50
 */

public class MyQueue {

    /**
     * 定义结点
     */
    class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    /**
     * 入队
     * 1.队列为空时(第一次入队) -> 头结点和尾结点都指向入队结点
     * 2.正常 -> 入队结点从队尾进入，需要尾结点先连接插入结点 tail.next = node; 然后尾结点后移至最后一个元素 tail = node;
     */
    public void offer(int val) {
        Node node = new Node(val);
        // 队列为空-第一次入队
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            return;
        }
        // 连接新结点 -> 尾结点后移
        this.tail.next = node;
        this.tail = node;
    }

    /**
     * 出队
     * 1.队列为空时 -> 无法出队
     * 2.队列只有一个元素 -> 元素出队后队列为空，所以头结点和尾结点都为 null
     * 3.正常 -> 头结点后移 head = head.next;
     */
    public int poll() {
        // 队列为空
        if (isEmpty()) {
//            throw new RuntimeException("队列为空");
            System.out.println("队列为空");
            return -1;
        }
        Node oldHead = this.head;
        // 队列中只有一个元素
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
            return oldHead.val;
        }
        this.head = this.head.next;
        return oldHead.val;

    }

    /**
     * 查看队头元素
     * 1.队列为空时 -> 无法查看
     * 2.正常
     */
    public int peek() {
        // 队列为空
        if (isEmpty()) {
//            throw new RuntimeException("队列为空");
            System.out.println("队列为空");
            return -1;
        }
        return this.head.val;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.poll());// 1
        System.out.println(myQueue.peek());// 2
    }
}
