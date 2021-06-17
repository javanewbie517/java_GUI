package test.test2;

import java.util.Scanner;


public class Legal {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		String []str=string.split("[.]");
		
		boolean j=true;		
			for (int i = 0; i < str.length; i++) {
				if(Integer.parseInt(str[i])>=256||Integer.parseInt(str[i])<0) {
					j=false;
					break;
				}
			}
						
		if(j) System.out.println("YES");
		else  System.out.println("NO");
		scanner.close();
	}

}
