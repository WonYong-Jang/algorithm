package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 곱셈 ( 거듭 제곱 알고리즘 ) 
 */
public class baek1629 {

	static long N, M, L;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		long result = pow(N, M);
		System.out.println(result);
	}
	/*
	 일반 적인 방법 O(N)
	public static long pow(long a, long b)
	{
		if( b == 0 ) return 1;
		else return a * pow(a, b-1);
	}
	*/
	public static long pow(long a, long b)
	{
		long k =0;
		long temp =0;
		if ( b == 0 ) return 1;
		
		else if(b % 2 == 0) {
			k = pow(a, b/2);
			return (k * k) % L;
		}
		else {
			k = pow(a, (b-1)/2);
			temp = (k *k ) % L;
			return (a * temp) % L;
		}
	}
}
