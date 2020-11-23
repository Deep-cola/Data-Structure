package list;

import java.util.Arrays;

/**
 * @description: 顺序表(考虑扩容)
 * @author: Deepcola
 * @time: 2020/11/23 13:40
 */
public class MyArrayList {

    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[5];
        this.usedSize = 0;
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
        this.usedSize = 0;
    }


    /**
     * 判断顺序表是否已满
     */
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 扩容
     */
    public void expansion() {
        this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
    }

    /**
     * 打印顺序表
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     * 在 pos 位置新增元素
     */
    public void add(int pos, int data) {
        // pos 非法，不能插入
        if (pos < 0 || pos > this.usedSize) return;
        // 顺序表装满, 需要扩容
        if (isFull()) {
            this.expansion();
        }
        // 插入位置后面的元素都应该后移
        // 需要重后向前移动
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.usedSize++;
        // 插入元素
        this.elem[pos] = data;
    }

    /**
     * 判断是否包含某个元素
     */
    public boolean contains(int toFind) {
        // 遍历数组检索是否有 toFind
        for (int i: this.elem) {
            if (i == toFind) return true;
        }
        return false;
    }

    /**
     * 查找某个元素对应的位置
     */
    public int search(int toFind) {
        // 遍历数组查找
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) return i;
        }
        return -1;
    }

    /**
     * 获取 pos 位置的元素
     */
    public int getPos(int pos) {
        // pos 位置不合法
        if (pos < 0 || pos >this.usedSize - 1) return -1;
        return this.elem[pos];
    }

    /**
     * 将 pos 位置的怨元素设为 value
     */
    public void setPos(int pos, int value) {
        // pos 位置不合法
        if (pos < 0 || pos >this.usedSize - 1) return;
        // 更新 value
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字 key
     */
    public void remove(int toRemove) {
        int index = 0;
        for (;index < toRemove;index++) {
            if (this.elem[index] == toRemove) {
                break;
            }
        }
        for (int i = index + 1; i < this.usedSize; i++) {
            this.elem[i - 1] = this.elem[i];
        }
        this.usedSize--;
    }

    /**
     * 获取顺序表长度
     */
    public int size() {
        return this.usedSize;
    }

    /**
     * 清空顺序表长度
     */
    public void clear() {
        this.usedSize = 0;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(5);

        // 插入元素
        myArrayList.add(0,3);
        myArrayList.add(0,2);
        myArrayList.add(0,1);
        myArrayList.add(3,4);
        myArrayList.add(4,5);

        // 打印顺序表
        myArrayList.display();// 1 2 3 4 5

        // 尝试扩容
        myArrayList.add(5,6);
        myArrayList.display();// 1 2 3 4 5 6

        // 返回顺序表长度
        System.out.println("顺序表元素个数: " + myArrayList.size());// 顺序表元素个数: 6

        // 判断是否包含某个元素
        System.out.println(myArrayList.contains(1));// true
        System.out.println(myArrayList.contains(7));// false

        // 获取某个位置的元素
        System.out.println(myArrayList.getPos(0));// 1

        // 更改某个下标对应的元素
        myArrayList.setPos(0,6);
        myArrayList.display();// 6 2 3 4 5 6

        // 删除第一次出现的关键字 key
        myArrayList.remove(6);
        myArrayList.display();// 2 3 4 5 6
    }
}
