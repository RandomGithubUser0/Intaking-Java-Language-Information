package Java101Projects.Extras;
/*

Add elements to a square matrix.
Then, based on a variable make each element equal to a number. (They are also consider squares)
Then, calculate the area of the entire square as an area. 
Additionally, print out the elements of the 2D matrix.

*/ 

public class SquareMatrixProblem {
	static int SquareDimensionX = 3;
	static int SubSquareDimensionX = 2;
	static int[][] Matrix = new int[3][3]; //3 by 3 matrix
	public static void main(String[] args) {
		// O(n^2 for loop)
		for (int i = 0; i < SquareDimensionX; i += 1){
			for (int u = 0; u < SquareDimensionX; u += 1){
				Matrix[i][u] = (int) Math.pow(SubSquareDimensionX, 2);
			}
		}
		// Calculate Areas
		double area = (int) Math.pow(SubSquareDimensionX, 2) * (int) Math.pow(SquareDimensionX, 2);
		System.out.println("Formula Solution: " + area);
		// Inefficient Solution (Add up all the squares)
		double Sum = 0;
		for (int i = 0; i < Matrix.length; i += 1){
			for (int u = 0; u < Matrix.length; u += 1){
				Sum += Matrix[i][u];
			}
		}
		System.out.println(Sum);
	}
}