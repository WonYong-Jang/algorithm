package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek1107 {

	static int N, M, len, ans;
	static int[] visit = new int[12];
	static ArrayList<Integer> data = new ArrayList<>();
	static int[] output = new int[12];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< M; i++)
		{
			int temp = Integer.parseInt(st.nextToken());
			visit[temp]++; // 임시로 
		}
		
		for(int i=0; i<=9; i++)
			if(visit[i] == 0) data.add(i);
		
		
		len = data.size();
		
		ans = abs(100, N);
		
		for(int i=1; i<= 10; i++)
		{
			solve(i, 0, 0);
		}
		
		System.out.println(ans);
	}
	public static void solve(int depth, int cnt, int index)
	{
		if(depth == cnt)
		{
			int sum = 0, multi = 1;
			for(int i=depth-1; i >= 0; i--)
			{
				sum += output[i] * multi;
				multi *= 10;
			}
			System.out.println(sum);
			int temp = abs(sum, N);
			ans = min(temp + depth, ans);
			
			return;
		}
		else 
		{
			for(int i=0; i< len; i++)
			{
				output[cnt] = data.get(i);
				solve(depth, cnt+1, i);
				
			}
		}
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static void init()
	{
		for(int i=0; i <= 9; i++) visit[i] = 0;
	}
}
