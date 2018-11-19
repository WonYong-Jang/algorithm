package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분 합 
 */
public class baek1806 {

	static int N, S, start, end, len, result;
	static int[] data = new int[100005];
	static long sum;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		start = end = 0;
		sum =0;
		result = 1000000;
		solve();
		if(result == 1000000) System.out.println(0);
		else System.out.println(result);
	}
	public static void solve() // 투 포인터 
	{
		sum = 0;
		len = 0;
		while(true)
		{
			int dx = start, dy = end;
			while(end < N && sum < S) {
				len++; 
				sum += data[++end];
			}
			
			while(start < end && sum >= S)
			{
				result = min(result, len);
				len--;
				sum -= data[++start];	
			}
			
			if(dx == start && dy == end) break;
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}





