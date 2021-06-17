package test.test3;

import java.util.Scanner;


public class Jump {
    static public void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=s.nextInt();
        int maxd=0;
        boolean result=false;
        for(int i=0;i<n;i++){
            int dn=a[i]+i;
            maxd=Math.max(maxd,dn);
            if(maxd==i&&i!=n-1) break;//最大的位置在当前位置，说明不能继续往前走了
            if(maxd>=n-1){
                result=true;
                break;
            }
        }
		
//		  for (int i = 0; i < a.length; i++) { int dn=a[i]+i; maxd=Math.max(maxd, dn);
//		  if(maxd==dn&&i!=n-1)break; if(maxd>=n-1) { result=true; break; } }
		 
        System.out.println(result);
        s.close();
    }
}

