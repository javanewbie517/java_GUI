package test.test2;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String net=scan.next().trim();
		String ip1=scan.next().trim();
		String ip2=scan.next().trim();
		String[] s1=net.split("\\.");
		String[] s2=ip1.split("\\.");
		String[] s3=ip2.split("\\.");
		out:for (int i = 0; i < 4; i++) {
			int []inet=tobinary(s1[i]);
			int []i1=tobinary(s2[i]);
			int []i2=tobinary(s3[i]);
			for (int j = 0; j < 8; j++) {
				if((i1[j]&inet[j])!=(i2[j]&inet[j])) {
					System.out.println(0);
					break out;
				}
			}
			if(i==3) System.out.println(1);
		}
	scan.close();
	}
	public static int[] tobinary(String s) {
		String str=Integer.toBinaryString(Integer.valueOf(s));
		char[] ch=str.toCharArray();
		int[]a=new int[]{0,0,0,0,0,0,0,0};
		for (int i = 0; i < ch.length; i++) {
			a[i]=ch[i]-'0';
		}
		return a;
	}

}
