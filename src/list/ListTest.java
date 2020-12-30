package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: list 的使用
 * @author: Deepcola
 * @time: 2020/11/24 23:31
 */
public class ListTest {

    /**
     * list 的使用: list 是接口, 不能直接实例化(new), 需要实例化它的实现类(ArrayList/LinkedList).
     * 1.boolean add(E e)
     *          Appends the specified element to the end of this list (optional operation).
     *          尾插元素 e. 插入成功返回 true;
     * 2.void add(int index, E element)
     *          Inserts the specified element at the specified position in this list (optional operation).
     *          在 index 下标处插入元素 element. 无返回值
     * 3.boolean addAll(Collection<? extends E> c)
     *          Appends all of the elements in the specified collection to the end of this list,
     *          in the order that they are returned by the specified collection's iterator (optional operation).
     *          按照指定集合的迭代器将 c(集合) 中的元素尾插到 list 里面. 插入成功返回 true
     * 4.E remove(int index)
     *          Removes the element at the specified position in this list (optional operation).
     *          删除 list 中下标为 index 的元素, 同时返回这个删除的元素
     * 5.boolean remove(Object o)
     *          Removes the first occurrence of the specified element from this list, if it is present (optional operation).
     *          删除 list 中第一次出现的元素 o, 删除成功返回 true, 没有这个元素返回 false
     * 6.E get(int index)
     *          Returns the element at the specified position in this list.
     *          获得 index 下标的元素值
     * 7.E set(int index, int element)
     *          Replaces the element at the specified position in this list with the specified element (optional operation).
     *          更改 index 下标处的元素值为 element, 返回的是原来 index 下标对应的值
     * 8.boolean contains(Object o)
     *          Returns true if this list contains the specified element.
     *          如果包含某个元素 o 返回 true
     * 9.int indexOf(Object o)
     *          Returns the index of the first occurrence of the specified element in this list,
     *          or -1 if this list does not contain the element.
     *          返回元素 o 第一次出现的下标, 如果没有这个元素就返回 -1
     * 10.int lastIndexOf(Object o)
     *          Returns the index of the last occurrence of the specified element in this list,
     *          or -1 if this list does not contain the element.
     *          返回元素 o 最后一次出现的下标, 如果没有这个元素就返回 -1
     * 11.List<E> subList(int fromIndex, int toIndex)
     *          Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     *          截取一部分 list,返回在 fromIndex - toIndex 之间的 list 元素(左闭右开)
     * 12.void clear()
     *          Removes all of the elements from this list (optional operation).
     *          删除 list 中的所有元素
     */
    public static void main(String[] args) {
        // <String>--泛型, 所有元素为该类型
        List<String> list = new ArrayList<>();

        // 添加元素——尾插
        list.add("及时雨");
        list.add("智多星");
        list.add("黑旋风");
        list.add(0,"武者");

        // 打印list
        System.out.println(list);// [武者, 及时雨, 智多星, 黑旋风]

        // 可以添加重复元素
        String[] strings = {"武者","浪里白条","拼命三郎"};
        list.addAll(Arrays.asList(strings));
        System.out.println(list);// [武者, 及时雨, 智多星, 黑旋风, 武者, 浪里白条, 拼命三郎]

        // 是否包含某个元素
        System.out.println(list.contains("武者"));// true
        System.out.println(list.contains("花和尚"));// false

        // 得到某个元素第一次 / 最后一次出现的下标
        System.out.println(list.indexOf("武者"));// 0
        System.out.println(list.lastIndexOf("武者"));// 4
        System.out.println(list.indexOf("花和尚"));// -1


        // 获得指定下标的元素 / 更改指定下标的值
        System.out.println(list.get(4));// 武者
        System.out.println(list.set(4, "豹子头"));// 武者
        System.out.println(list.get(4));// 豹子头

        // 根据下标或者元素值删除某个元素
        System.out.println(list.remove(0));// 武者
        System.out.println(list.remove("武者"));// false
        System.out.println(list);// [及时雨, 智多星, 黑旋风, 豹子头, 浪里白条, 拼命三郎]

        // 截取一部分list
        System.out.println(list.subList(1, 3));// [智多星, 黑旋风]

        // 清空 list
        list.clear();
        System.out.println(list);// []
    }
}
