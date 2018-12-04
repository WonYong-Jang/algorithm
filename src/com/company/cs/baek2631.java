package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 줄 세우기 
 */
public class baek2631 {

	static int N;
	static int[] data = new int[205];
	static int[] dp = new int[205];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = data[1];
		int size = 1;
		for(int i=2; i<= N; i++)
		{
			if(dp[size] < data[i]) {
				dp[++size] = data[i];
			}
			else {
				int idx = lower_bound(1,size,data[i]);
				dp[idx] = data[i];
			}
		}
		System.out.println(N-size);
	}
	public static int lower_bound(int l, int h, int target)
	{
		int result = 0, mid = 0;
		
		while(l <= h)
		{
			mid = (l + h) / 2;
			if(dp[mid] < target) {
				l = mid + 1;
			}
			else {
				h = mid - 1;
				result = mid;
			}
		}
		
		return result;
	}
}




