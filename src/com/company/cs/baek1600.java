package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 말이 되고픈 원숭이 
 */
public class baek1600 {

	static int N, M, K;
	static int[][] map = new int[202][202];
	static int[][][] visit = new int[31][202][202];
	static int[] dxArr = {-1, 0, 1, 0, 1, 1, -1, -1}, dyArr = {0, 1, 0, -1, 1, -1, -1, 1}; // 북 동 남 서 
	static int[] jump = {129, 65, 130, 18, 20, 36, 72, 40};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		
	}
	public static void solve()
	{
		que.add(new Node(1,1, 0));
		visit[0][1][1] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == N && n.dy == M) {
				System.out.println(visit[n.cnt][N][M] - 1);
				return;
			}
			
			if(n.cnt < K ) // 말처럼 점프 가능 횟수 
			{
				for(int i=0; i< 8; i++)
				{
					int nx = n.dx , ny = n.dy;
					for(int j=0; j<8; j++)
					{
						if( (jump[i] & (1 << j)) > 0)
						{
							nx += dxArr[j] ;
							ny += dyArr[j] ;
						}
					}
					if(!isRange(nx, ny)|| map[nx][ny] == 1) continue;
					if(visit[n.cnt+1][nx][ny] == 0 || visit[n.cnt+1][nx][ny] > visit[n.cnt][n.dx][n.dy] + 1)
					{
						visit[n.cnt+1][nx][ny] = visit[n.cnt][n.dx][n.dy] + 1;
						que.add(new Node(nx, ny, n.cnt + 1));
					}
				}
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || map[nx][ny] == 1) continue;
				if(visit[n.cnt][nx][ny] == 0 || visit[n.cnt][nx][ny] > visit[n.cnt][n.dx][n.dy] + 1)
				{
					visit[n.cnt][nx][ny] = visit[n.cnt][n.dx][n.dy] + 1;
					que.add(new Node(nx, ny, n.cnt));
				}
			}
		}
		
		System.out.println(-1);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy, cnt;
		Node(int x, int y, int z) {
			 dx = x; dy = y;  cnt = z;
		}
	}
}





