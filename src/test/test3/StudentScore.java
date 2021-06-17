package test.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScore {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int []a=new int[n];
		List<Integer>list=new ArrayList<>();//记录最大值
		for (int i = 0; i < a.length; i++) {
			a[i]=in.nextInt();
		}
		String c;
		int A,B,max;//规范化的话，建议一行只声明一个变量
		for (int i = 0; i < m; i++) {
			c=in.next();
			A=in.nextInt();
			B=in.nextInt();
			if(c.equals("U")) {
				a[A-1]=B;//更新
			}else if(c.equals("Q")){
				max=0;
				for (int j = A-1; j <=B-1; j++) {
					if(a[j]>max) max=a[j];
				}
				list.add(max);
			}
		}
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		in.close();
	}
}
