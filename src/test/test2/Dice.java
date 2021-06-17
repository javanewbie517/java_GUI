package test.test2;

import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		int[]a= {0,1,2,3,4,5,6};
		char[]ch=string.toCharArray();
		int temp=0;
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case 'L':
				temp=a[5];
				a[5]=a[2];
				a[2]=a[6];
				a[6]=a[1];
				a[1]=temp;
				break;
			case 'R':
				temp=a[6];
				a[6]=a[2];
				a[2]=a[5];
				a[5]=a[1];
				a[1]=temp;
				break;
			case 'B':
				temp=a[3];
				a[3]=a[6];
				a[6]=a[4];
				a[4]=a[5];
				a[5]=temp;
				break;
			case 'F':
				temp=a[3];
				a[3]=a[5];
				a[5]=a[4];
				a[4]=a[6];
				a[6]=temp;
				break;
			case 'A':
				temp=a[1];
				a[1]=a[4];
				a[4]=a[2];
				a[2]=a[3];
				a[3]=temp;
				break;
			case 'C':
				temp=a[1];
				a[1]=a[3];
				a[3]=a[2];
				a[2]=a[4];
				a[4]=temp;
				break;
			default:
				break;
			}
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		scanner.close();
	}
}
