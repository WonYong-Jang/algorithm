package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2048 
 */
public class baek12100 {

	static int N, ans;
	static int[] dxArr = {1, 0, -1, 0}, dyArr = {0, -1, 0, 1}; 
	static int[][] map = new int[25][25];
	static int[][][] originMap = new int[6][25][25]; // 최대 5번 
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	public static void dfs(int depth, int dir)
	{
		if(depth == 5)
		{
			check();
			return;
		}
		
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				originMap[depth][i][j] = map[i][j];
		
		for(int i=0; i<4; i++) // 4 방향 확인 
		{
			solve(i);
			dfs(depth+1, i);
			init(depth);
		}
	}
	public static void solve(int dir)
	{
		if(dir == 0) // 북쪽 shift
		{
			for(int i=1; i<= N; i++)
				shift(1,i,0);
		}
		else if(dir == 1) // 동 
		{
			for(int i=1; i<= N; i++)
				shift(i, N, 1);
		}
		else if(dir == 2) // 남 
		{
			for(int i=1; i<= N; i++)
				shift(N, i, 2);
		}
		else if(dir == 3) // 서 
		{
			for(int i=1; i<= N; i++)
				shift(i, 1, 3);
		}
	}
	public static void shift(int dx, int dy, int dir) // 해당 방향으로 shift 
	{
		int sdx = dx, sdy = dy; // 시작점 기록
		int nx= dx, ny =dy;
		for(int i=1; i<= N; i++) // 기존에 있는 값 큐에 넣고 shift 준비 
		{ // 기존에 있던 배열 값들은 0 초기화 
			if(i == 1 && map[nx][ny] != 0)
			{
				que.add(map[dx][dy]);
				map[dx][dy] = 0;
			}
			else 
			{
				nx += dxArr[dir];
				ny += dyArr[dir];
				if(map[nx][ny] == 0) continue;
				que.add(map[nx][ny]);
				map[nx][ny] = 0;
			}
		}
		
		int target = -1;
		while(!que.isEmpty())
		{
			int n = que.poll();
			if(target == -1) { // 합칠 값이 없을 때 
				map[sdx][sdy] = n;
				target = n;
			}
			else {
				if(target == n) { // 같은 숫자 합치기 
					target = -1;
					map[sdx][sdy] += n;
					sdx += dxArr[dir]; // 다음 좌표 
					sdy += dyArr[dir];
				}
				else {
					sdx += dxArr[dir]; // 다음 좌표 
					sdy += dyArr[dir];
					map[sdx][sdy] = n;
					target = n; // target 에 숫자 넣어놓고 다음 숫자 같은지 확인 하기 위해서 
				}
			}
		}
	}
	public static void init(int depth) // 원본 배열 복사 
	{
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				map[i][j] = originMap[depth][i][j];
		
	}
	public static void check() // 가장 큰 값 확인 
	{
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				ans = max(ans, map[i][j]);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) { 
			dx = a; dy = b;
		}
	}
}

