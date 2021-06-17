package test.test3;

import java.util.Arrays;
import java.util.Scanner;

public class SupplierProblem {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int N=input.nextInt();
		int M=input.nextInt();
		Supplier[]sup=new Supplier[N];
		Shop[]shops=new Shop[M];
		for (int i = 0; i < sup.length; i++) {
			sup[i]=new Supplier(input.nextInt(),input.nextInt() ,input.nextInt() );
		}
		for (int i = 0; i < shops.length; i++) {
			shops[i]=new Shop(input.nextInt(), input.nextInt());
		}
		Arrays.sort(sup);
		if(Supplier.sum<Shop.sum) System.out.println(-1);
		else {
			for (int i = 0; i < sup.length; i++) {
					
				for (int j = 0; j < shops.length; j++) {
					
					if(sup[i].ceiling!=0) {
						if(shops[j].need!=0) {
							if(sup[i].ceiling>shops[j].need) {//供>需											
								System.out.println(sup[i].id+" "+shops[j].id+" "+shops[j].need);
								sup[i].ceiling-=shops[j].need;
								shops[j].need=0;
							}else {//供<需
								System.out.println(sup[i].id+" "+shops[j].id+" "+sup[i].ceiling);
								shops[j].need-=sup[i].ceiling;
								sup[i].ceiling=0;
								
								break;//前往下一个商店
							 }
						}
					}
				}
				
			}
		}
		input.close();
	}
}

class Supplier implements Comparable{
	int id;
	int ceiling;
	int price;
	public static int sum=0;
	
	 
	public Supplier(int id, int ceiling, int price) {
		super();
		this.id = id;
		this.ceiling = ceiling;
		this.price = price;
	}


	@Override
	public int compareTo(Object o) {
		Supplier s=(Supplier)o;
		return Integer.compare(this.price,s.price);
	}
	
}

class Shop{
	int id;
	int need;
	public static int sum=0;
	Shop(int id, int count) {
		 
		this.id = id;
		this.need = count;
		sum+=need;
	}
		
}