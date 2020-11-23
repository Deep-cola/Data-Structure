package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @description: 集合
 * @author: Deepcola
 * @time: 2020/11/23 7:49
 */
public class CollectionTest {

    /**
     * Collection 方法的使用
     * 1.boolean add(E e):
     *          Ensures that this collection contains the specified element (optional operation).
     *          把元素e放入集合, 添加成功返回 true, 失败返回 false
     * 2.void clear():
     *          Removes all of the elements from this collection (optional operation).
     *          删除集合中的所有元素
     * 3.boolean isEmpty():
     *          Returns true if this collection contains no elements.
     *          判断集合是否为空, 集合为空返回 true, 不为空返回 false
     * 4.boolean remove(Object e):
     *          Removes a single instance of the specified element from this collection, if it is present (optional operation).
     *          删除集合中的元素e中的一个（如果存在）. 删除成功返回 true, 失败返回 false
     * 5.int size():
     *          Returns the number of elements in this collection.
     *          返回集合中的元素个数
     * 6.Object[] toArray():
     *          Returns an array containing all of the elements in this collection.
     *          返回一个装有所有集合元素的数组
     */
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();


        // 集合是否为空
        System.out.println("集合是否为空: " + collection.isEmpty());// true

        // 添加元素
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(1);


        // 集合是否为空
        System.out.println("集合是否为空: " + collection.isEmpty());// false

        // 打印集合元素
        for (int i: collection) {
            System.out.print(i + ", ");// 1，2，3，4，1
        }
        System.out.println();

        // 集合元素数量
        System.out.println("集合元素数量: " + collection.size());// 5

        // 删除一个元素
        System.out.println("是否删除成功: " + collection.remove(1));// true
        System.out.println("是否删除成功: " + collection.remove(5));// false

        // 删除集合中所有元素, 返回数组所有元素
        System.out.println("clear 前: " + Arrays.toString(collection.toArray()));// [2,3,4,1]
        collection.clear();
        System.out.println("clear 后: " + Arrays.toString(collection.toArray()));// []
    }
}
