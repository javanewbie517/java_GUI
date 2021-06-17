package test.test1;

import java.util.Scanner;

public class FindFriend {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int []p=new int[N];
		int []num=new int[N];
		for (int i = 0; i < p.length; i++) {
			p[i]=scanner.nextInt();
		}
		for (int i = 0; i < p.length; i++) {
			
			for (int j = 0; j < p.length; j++) {
				if(p[i]==p[j])
					num[i]++;
			}
		}
		for (int i = 0; i < num.length; i++) {
			if(num[i]-1>0)
				 System.out.println(num[i]-1);
			else {
				System.out.println("BeiJu");
			}
		}
		scanner.close();
	}

}
