package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: Queue 方法的使用
 * @author: Deepcola
 * @time: 2020/11/21 7:42
 */
public class QueueTest {
    /**
     * Queue 方法的使用
     * 1.boolean isEmpty()
     *      Tests if this queue is empty.
     *      队列是否为空, 返回值 boolean 类型. 队列为空时返回 true, 不为空时返回 false
     * 2.boolean add(E e)
     *      Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions,
     *      returning true upon success and throwing an IllegalStateException if no space is currently available.
     *      元素入队, 添加成功返回 true, 否则返回 false. 大多数情况下, 插入操作不能失败, 用于容量限制的队列
     * 3.boolean offer(E e)
     *      Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions,
     *      元素入队, 添加成功返回 true, 否则返回 false.
     * 4.E poll()
     *      Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *      查询并弹出返回队首元素, 返回值为 E 类型. 队列为空时返回 null
     * 5.E remove()
     *      Retrieves and removes the head of this queue.
     *      移除并返回队首元素, 返回值为 E 类型. 队列为空时抛出一个 NoSuchElementException 异常
     * 6.E peek()
     *      Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *      查询但不弹出队首元素, 返回值为 E 类型. 队列为空时返回 null
     * 7.E element()
     *      Retrieves, but does not remove, the head of this queue.
     *      查询但不弹出队首元素, 返回值为 E 类型, 队列为空时抛出一个 NoSuchElementException 异常
     * 	            Throws exception	Returns special value
     * Insert	        add(e)	            offer(e)
     * Remove	        remove()	        poll()
     * Examine	        element()	        peek()
     * 左边一列方法在操作失败会抛出一个异常, 右边的执行失败返回特殊值(null 或者 false)
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 队列是否为空
        System.out.println(queue.isEmpty());

        // 元素入队
        System.out.println(queue.add(1));
        System.out.println(queue.offer(2));

        // 元素出队
        System.out.println(queue.poll());
        System.out.println(queue.remove());

        // 查看队首元素
        System.out.println(queue.peek());
        System.out.println(queue.element());

    }
}
