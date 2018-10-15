package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기 
 */
public class baek14499 {

	static int N, M, sdx, sdy, cmd;
	static int[] dice = new int[7]; // 1 ~ 6  / 6 :  바닥면 / 1 : 윗면 
	static int[][] map = new int[30][30];
	static int[] dxArr = {0, 0, 0, -1, 1}, dyArr = {0,1, -1, 0, 0}; // 동 서 북 남 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		cmd = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< cmd; i++)
		{
			int cur = Integer.parseInt(st.nextToken());
			command(cur);
		}
	}
	public static void command(int dir) // 해당 방향으로 주사위 굴리기 
	{
		int num1=0, num2=0, num3=0, num4=0, num5=0, num6=0;
		
		int nx = sdx + dxArr[dir];
		int ny = sdy + dyArr[dir];
		if(!isRange(nx,ny)) return; // 범위 넘어 가면
		
		sdx = nx;
		sdy = ny; // 그렇지 않으면 좌표 업데이트 
		
		if(dir == 1) // 동쪽  
		{
			// 4 -> 1 , 1 -> 3, 6 -> 4 , 3 -> 6
			num4 = dice[4]; num1 = dice[1]; num6 = dice[6]; num3 = dice[3];
			dice[1] = num4; dice[3] = num1; dice[4] = num6; dice[6] = num3;
		}
		else if(dir ==2) // 서쪽 
		{
			// 4 -> 6, 1-> 4, 3->1, 6->3
			num4 = dice[4]; num1 = dice[1]; num3 = dice[3]; num6 = dice[6];
			dice[6] = num4; dice[4] = num1; dice[1] = num3; dice[3] = num6;
		}
		else if(dir ==3) // 북쪽 
		{
			// 2->1, 1->5, 5->6, 6->2 
			num2 = dice[2]; num1 = dice[1]; num5= dice[5]; num6 = dice[6];
			dice[1] = num2; dice[5] = num1; dice[6] = num5; dice[2] = num6;
		}
		else if(dir ==4) // 남쪽 
		{
			// 2-> 6, 1-> 2, 5-> 1, 6-> 5
			num2 = dice[2]; num1 = dice[1]; num5= dice[5]; num6 = dice[6];
			dice[6] = num2; dice[2] = num1; dice[1] = num5; dice[5] = num6;
		}
		
		if(map[sdx][sdy] == 0) {
			map[sdx][sdy] = dice[6]; // 바닥면 복사 
		}
		else {
			dice[6] = map[sdx][sdy];
			map[sdx][sdy] = 0;
		}
		System.out.println(dice[1]);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=0 && dy>=0 && dx< N && dy < M;
	}
}
