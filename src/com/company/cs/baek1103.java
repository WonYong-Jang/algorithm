package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 게임 
 */
public class baek1103 {

	static int N, K, flag;
	static int[][] data = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[][] dp = new int[55][55];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String str = "";
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			char hole = ' ';
			for(int j=1; j<= str.length(); j++)
			{
				hole = str.charAt(j-1);
				if(hole == 'H') data[i][j] = -1;
				else data[i][j] = str.charAt(j-1) - '0';
				dp[i][j] = -1;
			}
		}
		flag = 0; 
		int result = solve(1, 1);
		if(flag == 1) System.out.println(-1);
		else System.out.println(result);
		
	}
	public static int solve(int dx, int dy)
	{
		if(!isRange(dx,dy) || data[dx][dy] == -1) return 0;
		else if(flag == 1) return 0;
		else if(visit[dx][dy] == 1)
		{
			flag = 1;
			return 0;
		}
		else if(dp[dx][dy] != -1) return dp[dx][dy];
		else
		{
			int num =0, jump = data[dx][dy];
			visit[dx][dy] = 1;
			for(int i=0; i<4; i++)
			{
				int rdx = dx + (dxArr[i]*jump);
				int rdy = dy + (dyArr[i]*jump);
				
				num = max(num, solve(rdx,rdy) + 1);
			}
			visit[dx][dy] = 0;
			return dp[dx][dy] = num;
		}
	}
	public static int max(int a, int b) { return a> b ? a : b; }
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= K;
	}
}

/**
5 7
3994995
9999999
4H99399
9999999
2993994

6 7
12HHHHH
2214HHH
H1HHHHH
H4H9H2H
HHHHHHH
HHH2HHH
 */
