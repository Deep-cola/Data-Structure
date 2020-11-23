package list;

/**
 * @description: 单链表
 * 无头单向非循环链表的实现
 * @author: Deepcola
 * @time: 2020/11/23 14:29
 */
public class MySinglyLinkedList {

    /**
     * Definition for singly-linked list.
     */
    class SinglyNode {
        int val;
        SinglyNode next;
        public SinglyNode(int val) {
            this.val = val;
        }
    }

    public SinglyNode head;// 头结点

    /**
     * 头插法
     */
    public void addFirst(int val) {
        SinglyNode node = new SinglyNode(val);
        // 第一次插入结点
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    /**
     * 尾插法
     */
    public void addLast(int val) {
        SinglyNode node = new SinglyNode(val);
        // 第一次插入结点
        if (this.head == null) {
            this.head = node;
            return;
        }
        // 遍历到尾部
        SinglyNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 插入结点
        cur.next = node;
    }

    /**
     * 任意位置插入
     */
    public void addIndex(int index, int val) {
        // index 不合法
        if (index < 0 || index > size()) return;
        // 下标为 0, 头插法
        if (index == 0) {
            addFirst(val);
            return;
        }
        // 查找 index 的前驱
        SinglyNode prev = searchPrev(index);
        SinglyNode node = new SinglyNode(val);
        // 插入
        node.next = prev.next;
        prev.next = node;
    }

    /**
     * 查找 index 结点的前驱
     */
    public SinglyNode searchPrev(int index) {
        int count = 0;
        SinglyNode cur  = this.head;
        while (count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    /**
     * 查找在单链表当中是否包含关键字 key
     */
    public boolean contains(int val) {
        SinglyNode cur = this.head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public void remove(int val) {
        if (this.head.val == val) {
            this.head = this.head.next;
            return;
        }
        SinglyNode cur = this.head;// 遍历查找关键字
        SinglyNode prev = null;// 遍历结点的前驱结点
        // 查找关键字
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                return;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int val) {
        SinglyNode prev = this.head;
        SinglyNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        // 判断头结点是否是删除结点
        if (this.head.val == val) {
            this.head = this.head.next;
        }
    }

    /**
     * 获取单链表的结点个数
     */
    public int size() {
        SinglyNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 打印单链表
     */
    public void display() {
        SinglyNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 删除单链表所有结点
     */
    public void clear() {
        this.head = null;
    }


    public static void main(String[] args) {
        MySinglyLinkedList mySinglyList = new MySinglyLinkedList();

        // 添加元素
        mySinglyList.addFirst(1);
        mySinglyList.addFirst(2);
        mySinglyList.addIndex(0,1);
        mySinglyList.addIndex(3,4);
        mySinglyList.addLast(1);
        mySinglyList.addLast(5);

        // 打印单链表
        mySinglyList.display();// 1 2 1 4 1 5

        // 查找在单链表当中是否包含关键字 key
        System.out.println(mySinglyList.contains(5));// true
        System.out.println(mySinglyList.contains(6));// false

        // 删除第一次出现关键字为key的节点
        mySinglyList.remove(5);
        mySinglyList.display();// 1 2 1 4 1

        // 删除所有出现的关键字
        mySinglyList.removeAllKey(1);
        mySinglyList.display();// 2 4

        // 清空单链表
        mySinglyList.clear();
        mySinglyList.display();//
    }
}
