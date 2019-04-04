package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/** 
 * 인접한 비트의 개수 
 *
 */
public class baek2698 {

	static int N, K;
	static int[][][] dp = new int[105][105][2];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		
		for(int i=2; i<= 100; i++)
		{
			for(int j=0; j< 100; j++)
			{
				if(j == 0) dp[i][j][1] += dp[i-1][j][0];
				else dp[i][j][1] = dp[i-1][j-1][1] + dp[i-1][j][0];
				
				dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
			}
		}
		
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int result = dp[N][K][0] + dp[N][K][1];
			bw.write(result+"\n");
		}
		bw.flush();
	}

}
