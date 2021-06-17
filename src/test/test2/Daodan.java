package test.test2;

import java.util.Scanner;

public class Daodan {
      
    public static void main(String[] args) {
        //记录最大的位置
    	Scanner scan=new Scanner(System.in);
    	int n=scan.nextInt();
    	int weizhi[]=new int[n];
    	for (int i = 0; i < n; i++) {
			weizhi[i]=scan.nextInt();
		}      
        int temp[] = new int[weizhi.length];
        temp[weizhi.length-1] = 1;
        name(temp,weizhi,weizhi.length-2); //从第7个位置开始
           System.out.println(temp[0]);
        scan.close();
    }
 
    private static void f(int[] temp,int[]weizhi, int k) {
        if(k==-1) {
            return;
        }
         
        int max=0;//最大连续
        int z = 0;
        for(int i=k+1;i<=weizhi.length-1;i++) {
            if(weizhi[i]<=weizhi[k]) {
                if(temp[i]>=max) {
                    max = temp[i];
                    z = i;
                }
            }
            temp[k] = temp[z]+1;
            f(temp,weizhi, k-1);
        }
    }
private static void name(int[]temp,int[]weizhi,int k) {
	if(k==-1) return;
	
	int z=0,max=0;
	for (int i = k+1; i < weizhi.length; i++) {
		if(weizhi[i]<=weizhi[k]) {
			if(temp[i]>max) {
				max=temp[i];
				z=i;
			}
		}
		temp[k]=temp[z]+1;
		name(temp, weizhi, k-1);
	}
	
}
}

/*
300   207   155   300  288  299   170   158   65
6    4        2    5    4     4    3     2     1
*/
