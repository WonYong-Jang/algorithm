package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 
 */
public class baek2206 {

	static int[][] map = new int[1001][1001];
	static int[][][] visit = new int[1001][1001][2]; // 0 벽을 통과 하지 않은 경우 , 1 벽을 통과한 경우!
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String str;
		for(int i=1; i<= N; i++)
		{
			str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1) - '0'; // int 변환 
			}
		}
		solve();
		
		if(visit[N][M][0] == 0 && visit[N][M][1] ==0 ) System.out.println(-1); // 도착 못할 경우 
		else if(visit[N][M][0] != 0) System.out.println(visit[N][M][0]);
		else System.out.println(visit[N][M][1]);
		
	}
	public static void solve()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(1,1,0));
		visit[1][1][0] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == N && n.dy == M) return; // 도착점 도달 최단거리 
			
			for(int i=0; i<4; i++) // 4방향 확인 
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx , ny) || visit[nx][ny][n.pass] > 0) continue; // 범위 넘어가거나 최단 거리기 때문에 방문한점 또 갈 필요없서
				if(map[nx][ny] == 1 && n.pass == 0 ) // 벽 일때 만났을 때 한번도 통과하지 않은 경우 
				{
					que.add(new Node(nx, ny, 1)); // 다음에 통과하지 못하도록 pass 1으로 설정
					visit[nx][ny][1] = visit[n.dx][n.dy][n.pass] + 1;
				}
				else if(map[nx][ny] ==0) {
					que.add(new Node(nx, ny, n.pass)); // 아직 벽 통과하지 않은 경우니 pass 유지
					visit[nx][ny][n.pass] = visit[n.dx][n.dy][n.pass] + 1;
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx <= N && dy <= M;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, pass; // pass 벽 통과 할수 있는 갯수 1 이면 한번 통과 가능 / 0 이면 이미 한번 통과 했음 
		Node(int x, int y, int z) {
			dx =x; dy = y; pass = z;
		}
	}
}





