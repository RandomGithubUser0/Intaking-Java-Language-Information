package Custom.Classes;

public class SortingAlgorithms{
    /*
        BubbleSort Algorithm
        O(n^2) time complexity
    */
    public static int[] BubbleSort(int[] arr){
        int n = 0;
        int index = 0;
        for (int x = 0; x < arr.length; x++){
            // Starting from 0, pick element n
            for (int i = 0; i < arr.length - x; i++){
                // Then, compare it with the next values. If val > n, n = val
                int val = arr[i];
                if ((i == 0) || (n < val)) {
                    n = val;
                    arr[i] = n;
                    arr[index] = val;
                    index = i;
                }
            }
        }
        return arr;
    }
}