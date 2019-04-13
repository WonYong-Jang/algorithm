package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1로 만들기 2 
 */
public class baek12852 {

	static final int INF = 987654321;
	static int N;
	static int[] dp = new int[1000005];
	static int[] ans = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=2; i<= N; i++)
		{
			dp[i] = dp[i-1] + 1;
			ans[i] = i-1;
			if(i % 2 == 0 ) {
				if(dp[i] > dp[i/2] + 1) 
				{
					dp[i] = dp[i/2] + 1;
					ans[i] = i/2;
				}
			}
			if(i % 3 == 0 ) {
				if(dp[i] > dp[i/3] + 1) 
				{
					dp[i] = dp[i/3] + 1;
					ans[i] = i/3;
				}
			}
		}
		//System.out.println(dp[N]);
		bw.write(dp[N]+"\n");
		int target = N;
		while(target > 0 )
		{
			bw.write(target+" ");
			target = ans[target];
		}
		bw.flush();
	}
	
	public static int min(int a, int b) { return a > b ? b : a; }
}