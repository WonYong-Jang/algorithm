package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 2
 */
public class baek14442 {

	static int[][] map = new int[1001][1001];
	static int[][][] visit = new int[1001][1001][11];
	static int N, M, K;
	static int[] dxArr = {0, 0, 1, -1}, dyArr= {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		solve();
		
		for(int i=0; i<= K; i++)
		{
			if(visit[N][M][i] != 0) {
				System.out.println(visit[N][M][i]);
				return;
			}
			
		}
		System.out.println(-1);
	}
	public static void solve()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(1,1,0));
		visit[1][1][0] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == N && n.dy == M) return;
			
			for(int i=0; i< 4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx,ny) || visit[nx][ny][n.pass] > 0 ) continue;
				
				if(map[nx][ny] == 1 && n.pass < K)
				{
					visit[nx][ny][n.pass+1] = visit[n.dx][n.dy][n.pass] + 1;
					que.add(new Node(nx,ny, n.pass+1 ));
				}
				else if(map[nx][ny] == 0)
				{
					visit[nx][ny][n.pass] = visit[n.dx][n.dy][n.pass] + 1;
					que.add(new Node(nx,ny, n.pass));
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy, pass; // pass 0 벽통과 한번도 하지 않은 경우 !
		Node(int x, int y, int z) {
			dx = x; dy = y; pass = z;
		}
	}
}
