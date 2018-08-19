package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N-Queen 
 */
public class baek9663 {
	
	static int N, ans =0;
	static int[] col = new int[16]; // 열 기록 배열  1 ~ 15 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			col[1] = i;
			solve(1);
		}
		System.out.println(ans);
	}
	public static void solve(int row)
	{
		if(!isPromise(row)) return;
		
		if(row == N)
		{
			ans++;
			return;
		}
		for(int i= 1; i<= N; i++)
		{
			col[row+1] = i;
			solve(row+1);
		}
	}
	public static boolean isPromise(int row)
	{
		for(int i=1; i< row; i++)
		{
			if(col[i] == col[row] || ( abs( i, row) == abs(col[row] , col[i]) ) ) return false;
		}
		return true;
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
}
