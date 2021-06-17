package test.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * 信息加密
 *
 * @author 一条寂寞的鱼
 * @date 2021/06/17
 */
public class InformationEncryption {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		List<String> list=new ArrayList<>();
		while(scanner.hasNext()) {
			int N=scanner.nextInt();
			scanner.nextLine();
			String str="abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZA";
		for (int i = 0; i < N; i++) {
			String s=scanner.nextLine();
			String str1="";
			for (int j = 0; j < s.length(); j++) {
				String ss=s.substring(j,j+1);
				char[]a=ss.toCharArray();
				if(a[0]>='a'&&a[0]<='z'||a[0]>='A'&&a[0]<='Z') {
					int index=str.indexOf(ss);
				str1+=str.substring(index+1,index+2);
				}else {
					str1+=ss;
				}				
			}
			list.add(str1);
		}
		}
		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.println(str);
		}
		scanner.close();
	
	}

}
