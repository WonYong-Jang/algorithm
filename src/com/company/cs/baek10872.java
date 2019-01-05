package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팩토리얼 
 */
public class baek10872 {

	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		System.out.println(fac(N));
	}
	public static int fac(int n)
	{
		if(n <= 1) return 1;
		else return n * fac(n-1);
	}
}
