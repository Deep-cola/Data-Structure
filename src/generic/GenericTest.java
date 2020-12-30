package generic;

import java.util.ArrayList;

/**
 * @description: 泛型
 * @author: Deepcola
 * @time: 2020/11/25 13:42
 */
public class GenericTest<T> {

    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<String> strArray = new ArrayList<>();

        Class intClass = intArray.getClass();
        Class strClass = strArray.getClass();

        if (strClass.equals(intClass)) {
            System.out.println("这说明运行时类型相同");
        }





//        // 装箱
//        Integer i1 = 10;// 自动装箱
//        Integer i2 = new Integer(10);// 显示装箱
//        Integer i3 = Integer.valueOf(10);// 显示装箱
//
//        // 拆箱
//        int j1 = i1; // 自动拆箱
//        int j2 = i2.intValue();// 显示拆箱

    }
}

