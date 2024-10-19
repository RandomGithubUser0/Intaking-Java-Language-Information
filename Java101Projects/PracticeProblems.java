package Java101Projects;

/* 

Write a function called countOccurrences that takes an integer array arr and an integer n, and returns the number of times that n appears in arr.

Write a function called reverseArray that takes an integer array arr and returns a new array with the elements of arr but in reverse order.

Write a function called sumGrid that takes a 2d double array grid and returns the sum of all the elements. Hint: you can do this with nested for loops (look up what that is).

Write a function called fib that takes an integer n and returns the nth number in the fibonacci sequence (starting with 0 1 ).

*/

public class PracticeProblems {
    static int countOccurences(int target, int[] arr) {
        int Occurences = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != target){
                continue;
            } // Guard Clauses are pretty cool
            Occurences++;
        }
        return Occurences;
    }
    static int[] reverseArray(int[] arr) {
        int[] newarr = new int[arr.length];
        int arrlen = arr.length;
        for (int i = 0; i < arrlen; i++){
            newarr[i] = arr[arrlen - (i + 1)];
        }
        return newarr;
    }
    static double sumGrid(double[][] arr){
        double Sum = 0;
        for (int i = 0; i < arr.length; i++){
            double[] nextarr = arr[i];
            for (int u = 0; u < nextarr.length; u++){
                Sum += nextarr[u];
            }
        }
        return Sum;
    }

    // Extra method for array visualization
    static String IntArrayToString(int[] arr) {
        String Result = "Array: | ";
        for (int i = 0; i < arr.length; i++){
            Result = Result + arr[i] + " | ";
        }
        return Result;
    }
    public static void main(String[] args) {
        // Occurence Counter
        int[] CountFrom = {2, 3, 3, 3, 4};
        int TargetInt = 3;
        int AmountOf = countOccurences(TargetInt, CountFrom);
        System.out.println("The number has repeated: " + AmountOf + " times.");

        // Reverse an int array
        int[] ToReverse = {1, 2, 3, 4};
        int[] Reversal = reverseArray(ToReverse);
        System.out.println(IntArrayToString(Reversal));

        // Sum of array elements
        double[][] ToSum = {{42, 20, 31}, {21, 94, 26}, {21, 22, 23, 42}};
        double FinalSum = sumGrid(ToSum);
        System.out.println(FinalSum);
    }
}
