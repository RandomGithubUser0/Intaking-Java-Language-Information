package Java101Projects.Extras;
/* 
 
Basic factorial recursion function in java. O(n)
 
*/

public class BasicFactorialRecursion {
    static int Factorial(int n){
        if (n == 0){
            return 1;
        }
        return n * BasicFactorialRecursion.Factorial(n - 1);
    }
    public static void main(String[] args) {
        int FactorialOf = 5;
        int FResult = Factorial(FactorialOf);
        System.out.println(FResult);
    }
}
