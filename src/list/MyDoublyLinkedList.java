package list;

/**
 * @description: 双向链表
 * 无头双向链表的实现
 * @author: Deepcola
 * @time: 2020/11/23 15:38
 */
public class MyDoublyLinkedList {
    /**
     * Definition for doubly-linked list.
     */
    class DoublyNode {
        int val;
        DoublyNode next;
        DoublyNode prev;
        public DoublyNode(int val) {
            this.val = val;
        }
    }

    public DoublyNode head;// 头结点
    public DoublyNode rear;// 尾结点
    /**
     * 头插法
     */
    public void addFirst(int val) {
        DoublyNode node = new DoublyNode(val);
        // 第一次插入
        if (this.head == null) {
            this.head = node;
            this.rear = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    /**
     * 尾插法
     */
    public void addLast(int val) {
        DoublyNode node = new DoublyNode(val);
        // 第一次插入
        if (this.head == null) {
            this.head = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            node.prev = this.rear;
            this.rear = node;
        }
    }

    /**
     * 任意位置插入
     */
    public void addIndex(int index, int val) {
        // 插入下标非法
        if (index < 0 || index > size()) return;
        // index = 0
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size()) {
            addLast(val);
            return;
        }
        // 查找前驱结点
        DoublyNode prev = searchPrev(index);
        DoublyNode node = new DoublyNode(val);
        if (prev == null) return;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
        node.prev = prev;
    }

    /**
     * 查找 index 的前驱结点
     */
    public DoublyNode searchPrev(int index) {
        DoublyNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }


    /**
     * 查找在单链表当中是否包含关键字 key
     */
    public boolean contains(int key) {
        DoublyNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public void remove(int key) {
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        DoublyNode cur = this.head;
        DoublyNode prev = null;// 当前结点的前驱结点
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                return;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
    }

    /**
     *
     */
    public void removeAllKey(int key) {

        DoublyNode cur = this.head.next;
        DoublyNode prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        // 头部结点需要删除
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
    }
    /**
     * 得到双链表的长度
     */
    public int size() {
        int count = 0;
        DoublyNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 打印双链表
     */
    public void display() {
        DoublyNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 清空双链表
     */
    public void clear() {
        this.head = null;
        this.rear = null;
    }

    public static void main(String[] args) {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList();

        // 添加元素
        myDoublyLinkedList.addFirst(3);
        myDoublyLinkedList.addFirst(2);
        myDoublyLinkedList.addFirst(1);
        myDoublyLinkedList.addIndex(0,0);
        myDoublyLinkedList.addIndex(0,1);
        myDoublyLinkedList.addIndex(5,5);
        myDoublyLinkedList.addLast(4);
        myDoublyLinkedList.addLast(1);

        // 打印双链表
        myDoublyLinkedList.display();// 1 0 1 2 3 5 4 1

        // 是否包含某个关键字
        System.out.println(myDoublyLinkedList.contains(1));// true
        System.out.println(myDoublyLinkedList.contains(6));// false

        // 删除第一次出现关键字为key的节点
        myDoublyLinkedList.remove(1);
        myDoublyLinkedList.display();// 0 1 2 3 5 4 1

        // 删除所有出现的关键字 key
        myDoublyLinkedList.removeAllKey(1);
        myDoublyLinkedList.display();// 0 2 3 5 4

        // 清空双链表
        myDoublyLinkedList.clear();
        myDoublyLinkedList.display();//
    }
}
