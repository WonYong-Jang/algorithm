package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탈출 
 *
 */
public class baek14923 {

	static int N, M;
	static int[][] map = new int[1005][1005];
	static int[][][] visit = new int[1005][1005][2];
	static int[] dxArr = {1, -1, 0, 0}, dyArr = {0, 0, 1, -1};
	static int sdx,sdy, edx, edy; // 시작점, 끝점 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		edx = Integer.parseInt(st.nextToken());
		edy = Integer.parseInt(st.nextToken());
	
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		if(visit[edx][edy][0] == 0 && visit[edx][edy][1] ==0) System.out.println(-1);
		else if(visit[edx][edy][0] != 0 ) System.out.println(visit[edx][edy][0] - 1);
		else System.out.println(visit[edx][edy][1] - 1);
	}
	public static void solve()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(sdx, sdy, 0));
		visit[sdx][sdy][0] = 1; // 처음을 1로 설정해서 최종적으로 결과에서 1을 빼주기 ! 
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy) return;
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny][n.pass] > 0) continue;
				if(map[nx][ny] == 1 && n.pass == 0)
				{
					que.add(new Node(nx, ny, 1));
					visit[nx][ny][1] = visit[n.dx][n.dy][n.pass] + 1;
				}
				else if(map[nx][ny] == 0)
				{
					que.add(new Node(nx, ny, n.pass));
					visit[nx][ny][n.pass] = visit[n.dx][n.dy][n.pass] + 1;
				}
			}
		}
	}
	public static boolean isRange(int a, int b)
	{
		return a>=1 && b>=1 && a<= N && b<= M;
	}
	static class Node{
		int dx, dy, pass; //x, y좌표값 / 벽 통과 여부  
		Node(int a, int b, int c) {
			dx =a; dy =b; pass =c;
		}
	}
}
