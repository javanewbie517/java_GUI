package test.test1;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		StringBuffer str=new StringBuffer(scanner.next());
		System.out.println(str.reverse());
		scanner.close();
		
	}

}
