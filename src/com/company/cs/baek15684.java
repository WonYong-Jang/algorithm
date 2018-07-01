package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리 조작   
 */
public class baek15684 {

	static int N, M, H, result = 0; // (H, N) 좌표
	static boolean flag = false;
	static int[][] map = new int[51][51]; // 진행 방향을 표시 
	static int[][] visited = new int[51][51]; // 방문 표시  
	static int[] dxArr= {1, 0, 0}, dyArr= {0, -1, 1}; // 남 서 동  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dx=0, dy=0;
		N = Integer.parseInt(st.nextToken()); // Y 축   
		M = Integer.parseInt(st.nextToken()); // 현재 놓여 있는 가로선 갯수 
		H = Integer.parseInt(st.nextToken()); // 가로선 놓을 수 있는 최대 갯수 X 축  
		for(int i=0; i< M; i++) // 가로선 input 
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = 2; // 동쪽 
			map[dx][dy+1] = 1; // 서쪽 
		}
		for(int i=0; i<=3; i++)
		{
			dfs(0 , i, 1 ,1);
			if(flag) break;
		}
		if(!flag) System.out.println(-1);
	}
	public static void dfs(int curCnt ,int lineCnt, int dx, int dy) // 0 ~ 3 개 까지 둘수 있다. 
	{
		if(flag) return;
		if(curCnt == lineCnt)
		{
			result =0;
			
			for(int i=1; i<=N; i++) // 각 열 별로 사다리 검사 시작  
			{
				visited[1][i] = 1;
				move(1, i, i);
				visited[1][i] = 0;
			}
			if(result == N) {
				System.out.println(lineCnt); 
				flag = true;
			}
			return;
		}
		else 
		{
			for(int i= dx; i<= H; i++)
			{
				for(int j= dy; j<= N-1 ; j++)
				{
					if(map[i][j] == 0 && map[i][j+1] == 0) 
					{
						map[i][j] =2; // 동쪽
						map[i][j+1] =1; // 서쪽 
						dfs(curCnt+1, lineCnt, i , j);
						map[i][j] =0; // 동쪽
						map[i][j+1] =0; // 서쪽 
					}
				}
			}
		}
	}
	public static void move(int dx, int dy, int target) {
		if(isCheck(dx,dy)) {
			if(target == dy) result++;
			return;
		}
		int dir = map[dx][dy];
		int rDx = dx + dxArr[dir] , rDy = dy + dyArr[dir];
		if(visited[rDx][rDy] == 1) {
			rDx = dx + dxArr[0]; rDy = dy + dyArr[0]; // 아래
		}
		visited[rDx][rDy] = 1;
		move(rDx,rDy, target);
		visited[rDx][rDy] = 0;
		
	}
	public static boolean isCheck(int dx, int dy) {
		return dx > 0 && dy > 0 && dx > H & dy <= N;
	}
}
