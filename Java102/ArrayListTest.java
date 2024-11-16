package Java102;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();       
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.remove(1);
        arr.set(0, "byebye world :(");
        System.out.println(arr);

        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));
        System.out.println(conditions);
    }
}
