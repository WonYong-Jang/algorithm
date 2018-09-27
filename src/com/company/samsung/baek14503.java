package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 로봇 청소기 
 */
public class baek14503 {

	static int N, M, ans;
	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; // 북 동 남 서 
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int sdx, sdy, dir;
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		que.add(new Node(sdx, sdy, dir));
		ans = 1;
		visit[sdx][sdy] = 1; // 로봇 청소기 처음 위치는 항상 빈칸 
		
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int dx = n.dx;
			int dy = n.dy;
			boolean gameOver = false; // 후진했을때 뒤에 벽이있을 경우 true 종료 
			boolean flag = false; // 4방향 더 청소할 공간 있으면 true 
			int nextDir = 0, nx = 0, ny = 0;
			while(!gameOver && !flag)
			{
				for(int i=0; i<4; i++) // 해당 지점에서 4방향 탐색 
				{
					nextDir = ( n.dir - i + 3 ) % 4; // 현재 방향에서 왼쪽부터 탐색 
					nx = dx + dxArr[nextDir];
					ny = dy + dyArr[nextDir];
					if(map[nx][ny] ==0 && visit[nx][ny] == 0) // 청소할 곳 발 견 
					{
						visit[nx][ny] = 1;
						que.add(new Node(nx,ny,nextDir));
						flag = true;
						ans++; // 청소한 곳 카운트 
						break;
					}
				}
				
				if(!flag) // 4 방향 다 청소했거나 막혀있는 경우 
				{
					nextDir = (n.dir + 2 ) % 4;
					nx = dx + dxArr[nextDir];
					ny = dy + dyArr[nextDir];
					if(map[nx][ny] == 1) gameOver = true;
					dx = nx; dy = ny; // 뒤로 후진해서 또 검사할 준비 
				}
			}
		}
	}
	static class Node{
		int dx, dy, dir;
		Node(int x, int y, int z) {
			dx = x; dy = y; dir = z;
		}
	}
}
