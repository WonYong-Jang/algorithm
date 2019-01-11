package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS2 
 */
public class baek9252 {

	static int N, M;
	static char[] sn = new char[4005];
	static char[] tm = new char[4005];
	static String s, t, result;
	static int[][] L = new int[4005][4005]; // LCS 길이 
	static int[][] S = new int[4005][4005]; // LCS 문자 추적하기 위한 배열  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = t = "";
		s = br.readLine();
		t = br.readLine();
		result = "";
		
		N = s.length();
		M = t.length();
		
		for(int i=1; i<= N; i++) // base case
		{
			sn[i] = s.charAt(i-1);
			L[i][0] = 0;
		}
		for(int i=1; i<= M; i++) // base case 
		{
			tm[i] = t.charAt(i-1);
			L[0][i] = 0;
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(sn[i] == tm[j]) 
				{
					L[i][j] = L[i-1][j-1] + 1;
					S[i][j] = 0;
				}
				else
				{
					L[i][j] = max(L[i-1][j], L[i][j-1]);
					if(L[i][j] == L[i][j-1]) { // 왼쪽에서 왔다면 1로 체킹 
						S[i][j] = 1;
					}
					else { // 오른쪽에서 왔다면 2로 체킹 
						S[i][j] = 2;
					}
				}
			}
		}
		solve(N, M);
		System.out.println(L[N][M]);
		System.out.println(result);
		
	}
	public static void solve(int dx, int dy)
	{
		if(!isRange(dx, dy)) return;
		
		if(S[dx][dy] == 0)
		{
			solve(dx-1,dy-1);
			result += sn[dx];
		}
		else if(S[dx][dy] == 1) solve(dx,dy-1);
		else if(S[dx][dy] == 2) solve(dx-1, dy);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}









