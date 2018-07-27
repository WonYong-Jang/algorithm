package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1793 타일링 ( Dynamic programming ) 
 */
public class DP {

	// 점화식 1, 3, 5, 11 ...  ==>  C(n) = C(n-1) + 2 * C(n-2)
	static BigInteger[] map = new BigInteger[251]; 
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str;
		while((str = br.readLine()) != null)
		{
			st = new StringTokenizer(str);
			N = Integer.parseInt(str);
			map[0] = BigInteger.valueOf(1); // 사물 0개를 일렬로 나열하는 방법의 수는 0! = 1 
			map[1] = BigInteger.valueOf(1);
			map[2] = BigInteger.valueOf(3);
			for(int i=3; i<= N; i++)
			{
				BigInteger mul = map[i-2].multiply(BigInteger.valueOf(2));
				map[i] = map[i-1].add(mul);
			}
			System.out.println(map[N]);
		}
	}

}
