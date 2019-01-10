package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 등차 수열 
 */
public class baek1994 {

	static int N, result;
	static int[] data = new int[2005];
	static int[][] dp = new int[2005][2005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data, 1, N+1);
		
		for(int i=1; i<= N-1; i++)
		{
			for(int j= i+1; j<= N; j++)
			{
				if(data[i] == data[j]) continue; // 중복 
				solve(i,j, 1);
			}
		}
		System.out.println(result+1);
		
	}
	public static void solve(int i, int j, int sum)
	{
		if(dp[i][j] > 0) return;
		
		dp[i][j] = sum;
		result = max(result, sum);
		
		if(j== N) return;
		
		int target = 2*data[j] - data[i];
		int idx = lower_bound(j+1, N+1, target);
		
		if(data[idx] != target || idx > N) return;
		else solve(j, idx, sum+1);
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid=0;
		while(s < e)
		{
			mid = (s + e) / 2;
			if(data[mid] < target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}






