package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/11/21 8:25
 */
public class PriorityQueueTest {
    /**
     * 优先级队列 PriorityQueue 的方法使用
     * 优先级队列是基于一个有优先级的堆, 并且默认是一个小根堆。 默认大小为 11
     * 1.boolean isEmpty()
     *      Tests if this PriorityQueue is empty.
     *      优先级队列是都为空. 队列为空返回 true; 不为空返回 false
     * 2.boolean add(E e)
     *      Inserts the specified element into this priority queue.
     *      插入元素, 成功返回 true, 否则返回 false;
     * 3.boolean offer(E e)
     *      Inserts the specified element into this priority queue.
     *      插入元素, 成功返回 true, 否则返回 false;
     * 4.E poll()
     *      Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *      查询并弹出队首元素(优先级队列弹出的是最值), 队列为空时返回 null
     * 5.boolean remove(Object O)
     *      Removes a single instance of the specified element from this queue, if it is present.
     *      移除一个指定元素 O(如果存在), 否则返回 false
     * 6.E peek()
     *      Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *      查询但弹出队首元素(优先级队列查询的是最值), 队列为空时返回 null
     * 7.void clear()
     *      Removes all of the elements from this priority queue.
     *      删除队列中的所有元素
     * 8.Comparator<? super E> comparator()
     *      Returns the comparator used to order the elements in this queue,
     *      or null if this queue is sorted according to the natural ordering of its elements.
     *      返回值为 null 时, 表示比较器使用默认排序进行排序;
     *      否则, 返回用于排序的比较器
     * 9.boolean contains(Object O)
     *      Returns true if this queue contains the specified element.
     *      检索队列中是否有某个元素 O, 如果存在返回 true, 不存在返回 false
     * 10.Iterator<E> iterator()
     *      Returns an iterator over the elements in this queue.
     *      通过迭代器遍历元素
     * 11.int size()
     *      Returns the number of elements in this collection.
     *      返回元素的个数, 也就是队列的大小
     * 12.Object[] ttoArray()
     *      Returns an array containing all of the elements in this queue.
     *      返回一个包含所有队列中元素的数组
     */

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 优先级队列是否为空
        System.out.println(priorityQueue.isEmpty());// true

        // 插入元素
        priorityQueue.add(7);
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(4);

        // 队列大小
        System.out.println(priorityQueue.size());// 7

        // 弹出队首元素或者删除一个指定元素
        // 弹出的应该是最值
        System.out.println(priorityQueue.poll());// 1
        System.out.println(priorityQueue.remove(9));// false
        System.out.println(priorityQueue.remove(2));// true

        // 查询队首元素
        System.out.println(priorityQueue.peek());// 3

        // 检索队列是否包含某个元素
        System.out.println(priorityQueue.contains(9));// false
        System.out.println(priorityQueue.contains(7));// true

        // 用于排序的比较器
//        System.out.println(priorityQueue.comparator());// null

        // 迭代器
        // 遍历打印元素
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");// 3 5 4 7 8
        }
        System.out.println();

        // 转为数组
        System.out.println(Arrays.toString(priorityQueue.toArray()));// [3,5,4,7,8]

    }
}
