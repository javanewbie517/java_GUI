package test.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Min {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n =scanner.nextInt();
		int k =scanner.nextInt();
		int []arr=new int [n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i]+" ");
		}
		scanner.close();
	}

}
