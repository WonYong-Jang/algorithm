package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 발전소 
 */
public class baek1102 {

	static final int max_value = 1 << 16 ;
	static int N, P, len;
	static int[][] data = new int[20][20];
	static int[] dp = new int[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int cnt = 0, bit = 0;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< N; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		len = (1 << N ) - 1;
		for(int i = 0; i <= len; i++) dp[i] = -1;
		
		String str = br.readLine();
		char temp = 0;
		for(int i=0; i< N; i++)
		{
			temp = str.charAt(i);
			if(temp == 'Y') {
				bit += (1 << i);
				cnt++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		if(P == 0 ) {
			System.out.println(0);
			return;
		}
		int result = solve(bit, cnt);
		if(result >= max_value) System.out.println(-1);
		else System.out.println(result);
	}
	public static int solve(int state, int cnt)
	{
		if(cnt >= P) return 0;
		else if(dp[state] != -1) return dp[state];
		else
		{
			int nextState = 0, num = max_value;
			for(int i=0; i< N; i++)
			{
				if( (state & (1<<i)) > 0)
				{
					for(int j=0; j< N; j++)
					{
						if(i == j) continue;
						if( (state & (1 << j)) > 0) continue;
						nextState = (state | (1 << j));
						num = min(num, data[i][j] + solve(nextState,cnt+1));
					}
				}
			}
			return dp[state] = num;
		}
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}











