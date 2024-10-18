public class Main {
	public static void main(String[] args) {
		int[] arr = new int[100];
		int index = 0;
		while (index < 100) {
			arr[index] = 2 - index % 2;
		}
		System.out.println(arr[50]);
		index = index + 1;
	}
}