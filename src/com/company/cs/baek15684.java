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
	static int[][] map = new int[32][11]; // 진행 방향을 표시 
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
			dfs(0 , i, 1);
			if(flag) break;
		}
		if(!flag) System.out.println(-1);
	}
	public static void dfs(int curCnt ,int lineCnt, int row) // 0 ~ 3 개 까지 둘수 있다. 
	{
		if(flag) return;
		if(curCnt == lineCnt)
		{
			result =0;
			int target =0, rDx =0, rDy =0;
			for(int i=1; i<= N; i++) // 각 열 별로 사다리 검사 시작  
			{
				target = i; // target == i 같아야 겠지 
				for(int j=1; j<= H; j++) // 각 행별로 검사 
				{
					if(map[j][target] == 0) continue;
					else // 방향 전환이 있을때 
					{
						if(map[j][target] == 1) target -= 1;
						else if(map[j][target] == 2) target += 1;
					}
				}
				if(target == i) result++;
				else break;
			}
			if(result == N) {
				System.out.println(lineCnt); 
				flag = true;
			}
			return;
		}
		else 
		{
			for(int i= row; i<= H; i++)
			{
				for(int j= 1; j<= N-1 ; j++)
				{
					if(map[i][j] == 0 && map[i][j+1] == 0) 
					{
						map[i][j] =2; // 동쪽
						map[i][j+1] =1; // 서쪽 
						dfs(curCnt+1, lineCnt, row);
						map[i][j] =0; // 동쪽
						map[i][j+1] =0; // 서쪽 
					}
				}
			}
		}
	}
	public static boolean isCheck(int dx, int dy) {
		return dx > 0 && dy > 0 && dx > H & dy <= N;
	}
}
