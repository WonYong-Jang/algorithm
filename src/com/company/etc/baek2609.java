package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 공약수 최소 공배수 
 */
public class baek2609 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int result1=0;
		if(N > M) result1 = gcd(N, M);
		else result1 = gcd(M, N);
		System.out.println(result1);
		System.out.println(result1* (N/result1) * (M/result1));
	}
	public static int gcd(int a, int b)  
	{
		int result =0;
		// a, b 두 수 중 작은 값으로 1부터 다 확인하면서 
		// 나누어 떨어지는 수들 중 가장 큰 값 
		for(int i=1; i<=b; i++) // O( min(a,b) )
		{
			if(a % i ==0 && b % i ==0) result =i;
		}
		return result;
	}
	/*
	public static int gcd(int a, int b) // 유클리드 호제법 
	{
		if(b == 0 ) return a;
		else gcd(b, a % b);
	}
	 */
}





