package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * M x N 보드 완주하기 
 */
public class baek9944 {

	static final int INF = Integer.MAX_VALUE;
	static int[][] map = new int[35][35];
	static int[][] visit = new int[35][35];
	static int N, M, ans, maxValue;
	static int[] dxArr = {-1, 1, 0, 0}; // 위 아래 왼쪽 오른쪽 
	static int[] dyArr = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int testCase = 0;
		while((str = br.readLine()) != null)
		{
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			testCase++;
			init(); // 각 테스트 케이스 마다 초기화 
			for(int i= 1; i<= N; i++)
			{
				str = br.readLine();
				for(int j=1; j<= M; j++)
				{
					if(str.charAt(j-1) == '*') {
						map[i][j] = 1; // 벽을 1로 설정
						maxValue--; // 최대 배열에서 벽의 갯수 제외 
					}
					else map[i][j] = 0; // 지나갈수 있는 길 0 으로 설정 
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					if(map[i][j] == 1) continue;
					
					for(int k=0; k< 4; k++)
					{
						visit[i][j] = 1;
						solve(i,j, 1 , k , 1); 
						visit[i][j] = 0;
					}
				}
			}
			if(ans == INF) System.out.println(-1);
			else System.out.println("Case "+testCase+": "+ans);
		}
	}
	public static void solve(int dx, int dy, int turnCnt, int dir, int visitCnt)
	{
		
		int nx = dx + dxArr[dir];
		int ny = dy + dyArr[dir];
		
		if(!isRange(nx,ny) || visit[nx][ny] == 1 || map[nx][ny] == 1)
		{
			// 해당 방향으로 더이상 못갈경우 방향 갯수 하나 추가해주면서 다른 방향 갈수 있는지 검사 (나머지 3방향 )
			int flag = 0; // 4방향 중 한 방향으로 갈수 있는 방향이 있는 지 확인 
			
			for(int i=0; i< 4; i++)
			{
				if(i == dir) continue;
				nx = dx + dxArr[i];
				ny = dy + dyArr[i];
				if(!isRange(nx,ny) || visit[nx][ny] == 1 || map[nx][ny] == 1) continue;
				
				flag = 1; // 다음으로 갈 방향이 있는 flag  게임 계속 진행 ! 
				
				visit[nx][ny] = 1;
				solve(nx, ny, turnCnt+1, i , visitCnt+1);
				visit[nx][ny] = 0;
			}
			if(flag == 0) { // 게임 종료 
				if(visitCnt == maxValue) // 방문 할 수 있는 곳을 모두 방문 한 경우 
				{
					ans = min(ans, turnCnt);
				}
			}
			return;
		}
		else if(map[nx][ny] == 0 && visit[nx][ny] == 0 )
		{
			visit[nx][ny] = 1;
			solve(nx, ny, turnCnt, dir, visitCnt+1);
			visit[nx][ny] = 0;
		}
	}
	public static void init()
	{
		ans = INF;
		maxValue = N * M;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
