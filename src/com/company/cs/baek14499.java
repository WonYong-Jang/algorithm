package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기 
 *   2
 * 4 1 3
 *   5
 *   6
 *   
 * 초기상태 -> 동쪽 
 *   2
 * 6 4 1
 *   5
 *   3
 * 초기상태 -> 서쪽
 *   2
 * 1 3 6
 *   5
 *   4
 * 초기상태 -> 북쪽
 *   6
 * 4 2 3
 *   1
 *   5
 * 초기상태 -> 남쪽
 *   1
 * 4 5 3
 *   6
 *   2
 */
public class baek14499 {
	
	// 1 2 3 4  == > 동 서 북 남  
	static int[][] map = new int[21][21];
	static int[] dice = new int[7]; // 주사위 1 ~ 6 
	static int[] dxArr = {0, 0, -1, 1}, dyArr = {1, -1, 0, 0};
	static Queue<Integer> command = new LinkedList<>(); 
	static int dx=0, dy=0;
	static int N, M, cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dx = Integer.parseInt(st.nextToken());
		dy = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< cnt; i++)
			command.add(Integer.parseInt(st.nextToken()));
		solve();
	}
	public static void solve()
	{
		while(!command.isEmpty())
		{
			int cmd = command.poll();
			int dir = cmd - 1;
			int rDx = dx + dxArr[dir]; 
			int rDy = dy + dyArr[dir];
			if(!isRange(rDx,rDy)) continue;
			direction(rDx,rDy,dir);
			dx = rDx;
			dy = rDy;
		}
	}
	public static void direction(int dx,int dy ,int dir)
	{
		int num1=0, num2=0, num3=0, num4=0, num5=0, num6=0;
		switch(dir)
		{
		case 0: // 동쪽 방향
			num1 = dice[1]; num3 = dice[3]; num4 = dice[4]; num6 = dice[6];
			dice[3] = num1; dice[6] = num3; dice[1] = num4; dice[4] = num6; // 자리 이동  
			break;
		case 1: // 서쪽 방향 
			num1 = dice[1]; num3 = dice[3]; num4 = dice[4]; num6 = dice[6];
			dice[4] = num1; dice[1] = num3; dice[6] = num4; dice[3] = num6; // 자리 이동
			break;
		case 2: // 북쪽 방향 
			num1 = dice[1]; num2 = dice[2]; num5 = dice[5]; num6 = dice[6];
			dice[5] = num1; dice[1] = num2; dice[6] = num5; dice[2] = num6; // 자리 이동
			break;
		case 3: // 남쪽 방향 
			num1 = dice[1]; num2 = dice[2]; num5 = dice[5]; num6 = dice[6];
			dice[2] = num1; dice[6] = num2; dice[1] = num5; dice[5] = num6; // 자리 이동
			break;
		}
		if(map[dx][dy] == 0) map[dx][dy] = dice[6]; // 주사위 바닥면 복사
		else {
			dice[6] = map[dx][dy];
			map[dx][dy] = 0;
		}
		System.out.println(dice[1]);
	}
	
	public static boolean isRange(int dx, int dy) // 범위 확인!
	{
		return dx >= 0 && dy >= 0 && dx < N && dy < M;
	}
}





