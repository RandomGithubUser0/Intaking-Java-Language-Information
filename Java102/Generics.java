package Java102;

public class Generics<T> {
    public static <T> String printArray(T[] arr){
        String Return = "";
        for (int i = 0; i < arr.length; i++){
            Return = Return + " | " + arr[i];
        }
        return Return;
    }
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};
        System.out.println(printArray(integers));
    }
}
