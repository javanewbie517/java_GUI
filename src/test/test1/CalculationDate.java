package test.test1;


import java.util.*;


public class CalculationDate {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		Calendar c1 = Calendar.getInstance();
		int n=4;
		while ((n--)!=0) {
			int year=scanner.nextInt();
			int daySum=scanner.nextInt();
			c1.set(Calendar.YEAR,year);
			c1.set(Calendar.DAY_OF_YEAR,daySum);
			list.add(""+c1.get(Calendar.YEAR)+"-"+(c1.get(Calendar.MONTH)+1)+"-"+c1.get(Calendar.DATE));
		}
		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.println(str);
		}
		scanner.close();

	}

}
/*
	Scanner scanner=new Scanner(System.in);
	List<String> list=new ArrayList<>();
		while (scanner.hasNext()) {
				int year=scanner.nextInt();
				int daySum=scanner.nextInt();
				String string=year+"-01-01";
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				Date date=null;
				try {
				date = sdf1.parse(string);
				} catch (ParseException e) {
				e.printStackTrace();
				}
				long ms=(daySum-1)*24*60*60*1000L;
				Date date1=new Date(ms+date.getTime());
				list.add(sdf1.format(date1));
				}
				Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()) {
		String str = (String) iterator.next();
		System.out.println(str);
		}
		scanner.close();*/
