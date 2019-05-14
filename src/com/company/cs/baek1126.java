package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 같은 탑 
 */
public class baek1126 {

	static int N;
	static final int INF = -987654321;
	static int[] data = new int[55];
	static int[][] dp = new int[55][500005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<= 500000; j++ )
			{
				dp[i][j] = -1;
			}
		}
		
		int result = solve(1, 0);
		if(result <= 0 ) System.out.println(-1);
		else System.out.println(result);
	}
	public static int solve(int cur, int diff)
	{
		
		if(cur > N)
		{
			if(diff == 0) return 0;
			else return INF;
		}
		else if(dp[cur][diff] != -1) return dp[cur][diff];
		else
		{
			int ret = INF;
			
			ret = max(ret, solve(cur+1, diff)); // 지나가는 경우 
			ret = max(ret, solve(cur+1, diff + data[cur])); // 큰쪽에 쌓는 경우 
			
			if(diff > data[cur])
			{
				ret = max(ret,  data[cur] + solve(cur+1, diff - data[cur]));
			}
			else
			{
				ret = max(ret, diff + solve(cur+1, data[cur] - diff));
			}
			
			return dp[cur][diff] = ret;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}






