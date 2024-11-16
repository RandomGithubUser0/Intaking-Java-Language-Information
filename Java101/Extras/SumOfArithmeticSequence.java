package Java101.Extras;
/* 

Add x values to an array. (with +2 arithmetic progression) T
Then sum it all up with the arithmetic sum formula and for loop.
All the elements should be printed out in a single string.

*/
public class SumOfArithmeticSequence {
    static int AmountAddition = 25;
    static double[] ToAdd = new double[AmountAddition];
    public static void main(String[] args) {
        // Add all elements to Array
        for (int index = 0; index < AmountAddition; index = index + 1){
            double x = 0;
            if (index > 0){
                x = ToAdd[index - 1];
            }
            ToAdd[index] = x + 2;
        }
        // Add all elements up
        double sum = 0;
        for (int index = 0; index < ToAdd.length; index += 1){
            sum += ToAdd[index];
        }   
        System.out.println("O(n) for Loop: " + sum);
        // Arithmetic Sum Variation
        double ArithmeticSum = (ToAdd.length * (ToAdd[0] + ToAdd[ToAdd.length - 1])) / 2.0;
        System.out.println("Arithmetic Sum Calculation: " + ArithmeticSum);
        // Print All Terms in a single Line
        String Doubles = "Terms: ";
        for (int index = 0; index < AmountAddition; index += 1){
            Doubles = Doubles + "| " + ToAdd[index] + " |";
        }
        System.out.println(Doubles);
    } 
}
