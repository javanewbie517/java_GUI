package test.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		while (sca.hasNext()) {
			String string = sca.next();
			boolean repeat=substring(string);
			boolean var=various(string);
			if(repeat&&var&&string.length()>=8) {
				list.add("OK");
			}else {
				list.add("NG");
			}
		}
		for(String s:list) {
			System.out.println(s);
		}
		sca.close();
	}
	public static boolean substring(String str) {
		for(int len=2;len<=str.length()/2;len++){
			for (int i = 0; i < str.length()-len; i++) {
				String s1=str.substring(i, i+len);
				String s2=str.substring(i+len);
				if(s2.contains(s1)) return false;
			}
		}
		return true;
	}
	public static boolean various(String str) {
		int s1=0,s2=0,s3=0,s4=0;//大小写字母，数字，其他字符
	
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='0'&&str.charAt(i)<='9'&&s3==0) {
				s3=1;
			}else if(str.charAt(i)>='a'&&str.charAt(i)<='z'&&s2==0) {
				s2=1;
			}else if(str.charAt(i)>='A'&&str.charAt(i)<='Z'&&s3==0) {
				s1=1;
			}else if(s4==0){
				s4=1;
			}		
		}
		if(s1+s2+s3+s4>=3)return true;
		else {
			return false;
		}
		
	}

}
