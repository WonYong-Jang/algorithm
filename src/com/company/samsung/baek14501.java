package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사 
 */
public class baek14501 {

	static final int date = 0;
	static final int money = 1;
	static int N, ans=0;
	static int[][] data = new int[16][2]; // 1 ~ 5 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num1 = 0, num2 =0;
		for(int i=1; i<= N; i++) // input
		{
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			data[i][date] = num1; data[i][money] = num2;
		}
		
		for(int i=1; i<= N; i++)
		{
			if( i + data[i][date] -1 > N ) continue;
			solve( i + data[i][date], data[i][money]);
		}
		System.out.println(ans);
	}
	public static void solve(int cnt, int sum)
	{
		ans = max(ans, sum); // 최대 수익 
		if(cnt > N) return; // 일정이 넘어가게 되면 리턴 
		
		for(int i=cnt; i<= N; i++)
		{
			if( i + data[i][date] -1 > N ) continue;
			solve( i + data[i][date], data[i][money] + sum);
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}

