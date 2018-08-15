package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * M x N 보드 완주하기 
 */
public class baek9944 {

	static int[][] map = new int[31][31];
	static int[][] visit = new int[31][31];
	static int N, M, ans;
	static int[] dxArr = {-1, 1, 0, 0}; // 위 아래 왼쪽 오른쪽 
	static int[] dyArr = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while((st = new StringTokenizer(br.readLine())) != null)
		{
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			init(); // 초기화 
			for(int i= 1; i<= N; i++)
			{
				str = br.readLine();
				for(int j=1; j<= M; j++)
				{
					if(str.charAt(j-1) == '*') map[i][j] = 1; // 벽을 1로 설정 
					else map[i][j] = 0; // 지나갈수 있는 길 0 으로 설정 
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					if(map[i][j] == 1) continue;
					for(int k=0; k<4; k++) // 4방향 검색 시작 
					{
						int nx = i + dxArr[k];
						int ny = j + dyArr[k];
						visit[i][j] = 1;
						solve(i, j, 0, -1);
						visit[i][j] = 0;
					}
				}
			}
			
		}
	}
	public static void solve(int dx, int dy, int cnt, int dir)
	{
		
		for(int i=0; i<4; i++) // 4방향 검색 시작 
		{
			int nx = dx + dxArr[i];
			int ny = dy + dyArr[i];
			
		}
	}
	public static void init()
	{
		ans = 905;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
