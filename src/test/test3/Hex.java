package test.test3;

import java.util.Scanner;

public class Hex {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		StringBuffer str=new StringBuffer(in.next());
		StringBuffer sb = str.reverse();
		int decimal=0;
		int  index=0;
		for (int i = 0; i < str.length()-2; i++) {
			if(sb.charAt(i)>='0'&&sb.charAt(i)<='9') {
				index=Integer.parseInt(sb.substring(i, i+1));			
			}else {
				switch (sb.charAt(i)) {
				case 'A': index=10;break;
				case 'B': index=11;break;
				case 'C': index=12;break;
				case 'D': index=13;break;
				case 'E': index=14;break;
				case 'F': index=15;break;
				default:
				}			
			}
			decimal+=(int)Math.pow(16, i)*index;
		}
		System.out.println(decimal);
		in.close();
	}
}
