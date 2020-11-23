package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: map
 * @author: Deepcola
 * @time: 2020/11/23 8:21
 */
public class MapTest {

    /**
     * map 方法的使用
     * 1.V get(Object k):
     *          Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *          根据k查找对应的 value, 存在相应的 key 就返回相应的 value
     * 2.V getOrDefault(Object k, V defaultValue)
     *          Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
     *          根据k查找指定的value，没有找到用默认值代替
     * 3.V put(K key, V value)
     *          Associates the specified value with the specified key in this map (optional operation).
     *          将 key-value 放入Map
     * 4.boolean containsKey(Object key):
     *          Returns true if this map contains a mapping for the specified key.
     *          判断是否包含key
     * 5.boolean containsValue(Object value):
     *          Returns true if this map maps one or more keys to the specified value.
     *          判断是否包含value
     * 6.Set<map, Entry<K，V>> entrySet():
     *          Returns a Set view of the mappings contained in this map.
     *          返回所有键值对
     * 7.boolean isEmpty():
     *          Returns true if this map contains no key-value mappings.
     *          判断是否为空
     * 8.int size():
     *          Returns the number of key-value mappings in this map.
     *          返回键值对数量
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        // 判空
        System.out.println("map是否为空" + map.isEmpty());// true

        // 添加键值对
        map.put("沈从文","边城");
        map.put("雨果","悲惨世界");
        map.put("紫金陈","坏小孩");
        map.put("曹雪芹","红楼梦");

        // 判空
        System.out.println("map是否为空" + map.isEmpty());// false

        // 返回键值对数量
        System.out.println("键值对数量: " + map.size());// 4

        // 打印所有键值对
        System.out.println(map.entrySet());// [沈从文=边城, 雨果=悲惨世界, 紫金陈=坏小孩, 曹雪芹=红楼梦]

        // 是否包含某个 key 或者 value
        System.out.println(map.containsKey("沈从文"));// true
        System.out.println(map.containsValue("西游记"));// false

        // 如果不包含某个值就使用默认值嗲提
        System.out.println(map.getOrDefault("吴承恩", "西游记"));// 西游记

        // 当 key 相同时, 会覆盖原来的 value
        map.put("紫金陈","无证之罪");
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.print(entry + " ");// 沈从文=边城 雨果=悲惨世界 紫金陈=无证之罪 曹雪芹=红楼梦
        }

    }
}
