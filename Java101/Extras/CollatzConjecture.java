package Java101.Extras;
/*

    Choose any number x.
    Using a while loop, every y miliseconds delay, run a function on x and print the new value.
    Do this until the number reaches 1.
 
 */

public class CollatzConjecture {
    static int x = 69;
    static int y = 25; // Delay
    public static int ReturnConjecture(int n){
        int NewN = 0;
        if (n % 2 == 0){
            NewN = n/2;
        } else {
            NewN = (3 * n) + 1;
        }
        return NewN;
    }
    public static void main(String[] args) {
        while (x != 1){
            x = ReturnConjecture(x);
            System.out.println(x);
            try {
                Thread.sleep(y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
