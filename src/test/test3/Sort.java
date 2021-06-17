package test.test3;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sort {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		Set<Integer> set = new TreeSet<>((o1, o2) -> -o2.compareTo(o1));//也是升序
		for (int i = 0; i < n; i++) {
			set.add(in.nextInt());
		}
		for (Integer integer : set) {
			System.out.print(integer+" ");
		}
		in.close();
		
	}
}
