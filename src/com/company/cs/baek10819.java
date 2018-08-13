package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 차이를 최대로 
 */
public class baek10819 {

	static int N, ans = -1;
	static int[] data = new int[9];
	static int[] visit = new int[9];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<= N; i++)
		{
			visit[i] = 1;
			solve(0, 0, i);
			visit[i] = 0;
		}
		System.out.println(ans);
	}
	public static void solve(int cnt ,int sum, int cur)
	{
		if(cnt == N - 1) {
			ans = max(sum, ans);
			return;
		}
		for(int i=1; i<= N; i++)
		{
			if(visit[i] == 1) continue;
			visit[i] = 1;
			solve(cnt+1, cal(data[cur], data[i]) + sum, i);
			visit[i] = 0;
		}
	}
	public static int max(int a, int b)
	{
		return a>b?a:b;
	}
	public static int cal(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
}
