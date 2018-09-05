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
 * 성곽 
 */
public class baek2234 {

	static int M, N, maxRoom, maxArea;
	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[] dxArr = {0, -1, 0, 1}, dyArr = {-1, 0, 1, 0}; // 서, 북, 동, 남 
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maxRoom = 0; maxArea = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(1);
		breakWall();
		System.out.println(maxArea);
	}
	public static void solve(int check)
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;// 방문 배열 초기화 
			}
		}
		
		int cnt =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(visit[i][j] == 1) continue;
				bfs(i, j, check);
				cnt++;
			}
		}
		if(check == 1) System.out.println(cnt+"\n"+maxRoom); // 정답 1, 2 출력
	}
	public static void breakWall()
	{
		for(int i=0; i< N * M; i++)
		{
			for(int k=0; k< 4; k++) 
			{
				if( (map[(i/M)+1][(i%M)+1] & ( 1 << k)) > 0) // 벽 제거 하고 검사 
				{
					map[(i/M)+1][(i%M)+1] -= ( 1 << k);
					solve(2);
					map[(i/M)+1][(i%M)+1] += ( 1 << k);
				}
			}
		}
	}
	public static void bfs(int dx, int dy, int check)
	{
		que.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		int cnt =0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			cnt++;
			
			for(int i=0; i< 4; i++) 
			{
				if( (map[n.dx][n.dy] & ( 1 << i)) > 0) continue; // 벽이면 pass 
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				que.add(new Node(nx,ny));
				visit[nx][ny] = 1;
			}	
		}
		if(check == 1) maxRoom = max(maxRoom,cnt); // 가장 큰 방 넓이 찾기 
		else maxArea = max(maxArea, cnt);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
