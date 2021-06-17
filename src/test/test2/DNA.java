package test.test2;

import java.util.Scanner;

/**
 * dna
 *
 * @author 一条寂寞的鱼
 * @date 2021/06/17
 */
public class DNA {
	/**
	 * 主要
	 *
	 * @param args arg游戏
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String  s=scanner.next();
		int minlength=scanner.nextInt();
		String ssString="";
		double max=0;
		for (int i = minlength; i < s.length(); i++) {
			for (int j = 0; j < s.length()-i; j++) {
				String str=s.substring(j, j+i);
				double r=rate(str);
				if(r>max) {
					max=r;
					ssString=str;
				}
			}
		}
		System.out.println(ssString);
		scanner.close();
	}
	public static double rate(String str) {
		double sum=0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='C'||str.charAt(i)=='G') {
				sum++;
			}
		}
		return sum/str.length();
	}
}
