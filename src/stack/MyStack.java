package stack;

/**
 * @description: 使用顺序表实现栈
 * @author: Deepcola
 * @time: 2020/11/16 14:19
 */
public class MyStack {

    private int[] elem;
    private int usedSize;

    public MyStack() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    /**
     * 压栈
     * 1.栈满时 -> 无法压栈
     * 2.正常
     */
    public void push(int elem) {
        // 满栈无法入栈
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        this.elem[this.usedSize++] = elem;
    }

    /**
     * 出栈
     * 1.栈为空时 -> 无法出栈
     * 2.正常
     */
    public int pop() {
        // 空栈无法出栈
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("空栈");
//            System.out.println("空栈");
//            return -1;
        }
        return this.elem[--this.usedSize];
    }

    /**
     * 查看栈顶元素
     * 1.栈为空是 -> 无法查看
     * 2.正常
     */
    public int peek() {
        // 空栈无法查看
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("空栈");
//            System.out.println("空栈");
//            return -1;
        }
        return this.elem[this.usedSize-1];
    }

    /**
     * 判断栈是否已满
     */
    public boolean isFull() {
        return this.elem.length == this.usedSize;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 栈的大小
     */
    public int size() {
        return this.usedSize;
    }



    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.pop();// 空栈
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());// 3
        System.out.println(myStack.peek());// 2
        System.out.println(myStack.size());// 2
    }
}
