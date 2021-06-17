package test.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Paper {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int total=scanner.nextInt();
		int[]a=new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=scanner.nextInt();
		}
		Arrays.sort(a);
		boolean judge=true;
		first:for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					for (int j2 = 0; j2 < a.length; j2++) {
						if(a[i]+a[i]+a[j2]==total) {
							judge=true;
							break first;
					}
				}
			}
			
		}
		if(judge)System.out.println("Y");
			else {
				System.out.println("N");
			}
			scanner.close();
	}
}
