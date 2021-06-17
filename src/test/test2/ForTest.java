package test.test2;

import java.util.Arrays;

/**
 * @author 一条寂寞的鱼
 *
 */
public class ForTest {
	public static void main(String[] args) {
		int x, y, z;
		out:for (x = 1000; x < 9999; x++) {
			if (x % 100 == 0) {
				continue;
			}
			for (y = 10; y < 100; y++) {
				for (z = 10; z < 100; z++) {
					if (y * z == x) {
						String[] a = (x+"").split(""); // 将x拆分成String数组
						String[] b = (y + "" + z).split(""); // 将y+z 拆分成String[],注意拼接时的""要放中间
						Arrays.sort(a); // 这次用数据的工具排序，
						Arrays.sort(b);
						if (Arrays.equals(a, b)) {
							System.out.print(x+" ");
							continue out;//同样为防止重复而跳出
						}
					}
				}
			}
		}
	}

}
