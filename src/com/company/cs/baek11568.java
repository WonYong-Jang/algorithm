package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 민준이의 계략 
 */
public class baek11568 {

	static int N;
	static int[] data = new int[1005];
	static int[] dp = new int[1005];
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
		
		dp[1] = data[1];
		int size = 1;
		for(int i=2; i<= N; i++)
		{
			if(dp[size] < data[i])
			{
				dp[++size] = data[i];
			}
			else {
				int idx = lower_bound(1, size, data[i]);
				dp[idx] = data[i];
			}
		}
		System.out.println(size);
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid=0, result =0;
		
		while(s <= e)
		{
			mid = (s + e) / 2;
			if(dp[mid] < target) {
				s = mid + 1;
			}
			else {
				e = mid - 1;
				result = mid;
			}
		}
		return result;
	}
}
