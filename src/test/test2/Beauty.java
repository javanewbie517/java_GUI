package test.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Beauty {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int sum=scan.nextInt();
		Map<Integer, Integer>map=new HashMap<>();
		int[]sorc=new int[sum];
		for (int i = 0; i < sum; i++) {
			int score=scan.nextInt();
			map.put(score,0);
			sorc[i]=score;
		}
		int rank=map.size();
		Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> me = it.next();
			int key=me.getKey();
			map.put(key, rank);
			rank--;		
		}
		for (Map.Entry<Integer,Integer> en :map.entrySet()) {
			System.out.println(en.getKey()+"="+en.getValue());
		}
		for (int i = 0; i < sorc.length; i++) {			
			System.out.print(map.get(sorc[i])+" ");		
		}
		scan.close();
	}
}
