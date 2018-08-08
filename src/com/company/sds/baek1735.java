package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 분수 합 ( 유클리드 호제법 이용 ) 
 */
public class baek1735 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1, a2, b1, b2, divide=0;
		a1 = Integer.parseInt(st.nextToken());
		a2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		b1 = Integer.parseInt(st.nextToken());
		b2 = Integer.parseInt(st.nextToken());
		
		int result1 = a1*b2+ b1*a2 , result2 = a2 * b2;
		
		if(result1 > result2) divide = gcd(result1, result2);
		else divide = gcd(result2, result1);
		
		System.out.println(result1/divide+" "+result2/divide);
	}
	
	public static int gcd(int a, int b) // a > b 일때 
	{
		if(b == 0) return a; // 최대 공약수 찾음 
		else return gcd(b, a % b);
	}
}
