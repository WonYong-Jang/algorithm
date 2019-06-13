package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long ans;
	static int N;
	static long[][] data = new long[100005][2];
	static long[] map = new long[100005];
	static long[] dp = new long[100005];
	static long[] temp = new long[100005];
	static long[] ansList = new long[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num =0;
		ans = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i][0] = num;
			//map[num] = i;
		}
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i][1] = num;
			//dp[i] = map[num];
			//ansList[i] = map[num];
		}
		mapping(0);
		qSort(1,N);
		long result = ans;
		for(int i=N; i > 1; i--)
		{
			ans = ans - (N - ansList[i]) + (ansList[i]-1);
			result = min(result, ans);
		}
		ans = 0;
		mapping(1);
		qSort(1, N);
		result = min(result, ans);
		for(int i=N; i > 1; i--)
		{
			ans = ans - (N - ansList[i]) + (ansList[i]-1);
			result = min(result, ans);
		}
		
		System.out.println(result);
	}
	public static void qSort(int s, int e)
	{
		if(s == e) return;
		int mid = (s + e) / 2;
		
		qSort(s,mid);
		qSort(mid+1,e);
		merge(s,e);
	}
	public static void merge(int s, int e)
	{
		for(int i = s; i <= e; i++)
		{
			temp[i] = dp[i];
		}
		int i =0, j=0, k=0, mid =0;
		mid = (s + e) / 2;
		i = k = s;
		j = mid + 1;
		
		while(i <= mid && j <= e)
		{
			if(temp[i] <= temp[j]) dp[k++] = temp[i++];
			else
			{
				dp[k++] = temp[j++];
				ans += (long)(mid-i+1);
			}
		}
		
		while(i <= mid) dp[k++] = temp[i++];
		while(j <= e) dp[k++] = temp[j++];
	}
	public static void mapping(int flag)
	{
		int num = 0;
		if(flag == 0) // 0 재배열 
		{
			for(int i=1; i<= N; i++)
			{
				num = (int)data[i][0];
				map[num] = i;
			}
			for(int i=1; i<= N; i++)
			{
				num = (int)data[i][1];
				dp[i] = map[num];
				ansList[i] = map[num];
			}
		}
		else // 1 재배열 
		{
			for(int i=1; i<= N; i++)
			{
				num = (int)data[i][1];
				map[num] = i;
			}
			for(int i=1; i<= N; i++)
			{
				num = (int)data[i][0];
				dp[i] = map[num];
				ansList[i] = map[num];
			}
		}
	}
	public static long min(long a, long b) { return a > b ? b : a; }
}
/**
4
1
2
3
4
4
3
2
1
 */


