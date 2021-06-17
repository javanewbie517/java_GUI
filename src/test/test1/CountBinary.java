package test.test1;

import java.util.Scanner;

public class CountBinary {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int sum=0;
		while (N>0) {
			if(N%2==1) {
				sum++;
			}
			N/=2;
		}
		System.out.println(sum);
		scanner.close();
	}
	
}
