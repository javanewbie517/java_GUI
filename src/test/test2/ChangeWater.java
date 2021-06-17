package test.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeWater {

	public static void main(String[] args) {
		List<List<Object>> list=new ArrayList<>();
		
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			List<Object> l1=new ArrayList<>();
			String string = scanner.nextLine();
			String []s=string.split(" ");
				for (int i = 0; i < s.length; i++) {
					int sum=count(Integer.valueOf(s[i]));
					if(sum!=0) {
						l1.add(sum);
					}
				}
				list.add(l1);
		}
		for (int i = 0; i < list.size(); i++) {
			List<Object> list2=list.get(i);
			for (int j = 0; j < list2.size(); j++) {
				System.out.print(list2.get(j)+" ");
			}
			System.out.println();
		}
		scanner.close();
		
	}
	public static int count(int num) {
		int sum=0;
		while(num>2) {
			sum+=(num/3);
			num=(num/3)+num%3;
		}
		if(num==2) sum++;
		return sum;
	}

}
