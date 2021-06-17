package test.test3;

import java.util.Scanner;

public class Max {
		
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[]arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
		}
		int pre=arr[0],max=0;
		for (int i = 1; i < arr.length; i++) {
			pre=Integer.max(pre+arr[i], arr[i]);
			max=Integer.max(max, pre);
		}
		System.out.println(max);
		in.close();
	}
		
}
