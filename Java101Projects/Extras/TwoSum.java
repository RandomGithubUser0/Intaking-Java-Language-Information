package Java101Projects.Extras;
/* 

Write the solution to twosum in java with both the O(n^2) method and the O(n) method.

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/

public class TwoSum {
    static int[] Numbers = {1, 2, 3, 5};
    static int FinalSum = 4;
    public static void main(String[] args) {
        // O(n^2 Method)            
        int[] FirstSolution = new int[2];
        boolean FoundSolution = false;
        for (int i = 0; i < Numbers.length; i++){
            if (FoundSolution == true){
                break;
            }
            int CurrentNumber = Numbers[i];
            for (int u = 0; u < Numbers.length; u++){
                int Number2 = Numbers[u];
                if ((CurrentNumber + Number2 != FinalSum) || (i == u)){
                    continue;
                }
                FoundSolution = true;
                FirstSolution[0] = CurrentNumber;
                FirstSolution[1] = Number2;
            }
        }
        System.out.println(
            "O(n^2): " +
            "Number I: " + FirstSolution[0] +
            " Number II: " + FirstSolution[1]
        );
        // O(n) Method (Unfinished)
    }
}
