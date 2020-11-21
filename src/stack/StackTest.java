package stack;

import binarytree.BinaryTree;

import java.util.Stack;

/**
 * @description: Stack方法的使用
 * @author: Deepcola
 * @time: 2020/11/20 23:52
 */
public class StackTest {
    /**
     * Stack 方法的使用
     * 1.boolean empty();
     *      Tests if this stack is empty.
     *      判断栈是否为空, 返回值是 boolean 类型. 空栈返回 true; 不是空栈返回 false
     * 2.E push(E item);
     *      Pushes an item onto the top of this stack.
     *      在栈顶插入一个元素, 返回值是 E 类型，也就是会返回插入的值
     * 3.E pop();
     *      Removes the object at the top of this stack and returns that object as the value of this function.
     *      弹出栈顶元素，返回值是 E 类型. 会返回弹出的栈顶元素
     * 4.E peek();
     *      Looks at the object at the top of this stack without removing it from the stack.
     *      查看栈顶元素但是不弹出, 返回值是 E 类型, 返回栈顶元素并不弹出
     * 5.int search(Object O);
     *      Returns the 1-based position where an object is on this stack.
     *      查找栈中是否有某个元素 O, 返回值是 int 类型, 元素存在返回该元素的下标, 元素不存在返回 -1
     *      元素下标从 1 开始, 栈顶元素被认为是下标为 1 的元素, 依次向下
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // 判断栈是否为空
        System.out.println(stack.isEmpty());

        // 元素入栈
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));

        // 元素出栈
        System.out.println(stack.pop());

        // 查看栈顶元素
        System.out.println(stack.peek());

        // 查找元素
        System.out.println(stack.search(4));
    }
}
