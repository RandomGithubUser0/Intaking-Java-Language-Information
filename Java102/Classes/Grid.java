package Java102.Classes;

import java.util.ArrayList;

public class Grid<T> {
	private final ArrayList<ArrayList<T>> grid;
	public final int sideLength;

	private static int highestSideLength = 0;

	public Grid(int sideLength, T defaultVal) { // Constuctor
		this.sideLength = sideLength;
		this.grid = new ArrayList<ArrayList<T>>(sideLength);
		for (int i = 0; i < sideLength; i++) {
			grid.add(new ArrayList<>(sideLength));
			for (int j = 0; j < sideLength; j++) {
				grid.get(i).add(defaultVal);
			}
		}
		if (sideLength > highestSideLength){
			highestSideLength = sideLength;
		}
	}

	public T get(int row, int col) { // Returns the value of the array (Can be anything, so T is used)
		return grid.get(row).get(col);
	}

	public void set(int row, int col, T val) { // void indicates that no value is returned
		grid.get(row).set(col, val);
	}

	public ArrayList<T> diagonal(){
		ArrayList<T> diagonalList = new ArrayList<>();
		for (int i = 0; i < sideLength; i++){
			diagonalList.add(get(i, i));
		}
		return diagonalList;
	}	

	public static int maxSideLength(){
		return highestSideLength;
	}

	@Override
	public String toString() {
		String str = "";
		for (ArrayList<T> row : grid) {
			for (T element : row) {
				str += element + " ";
			}
			str += "\n";
		}
		return str;
	}
}