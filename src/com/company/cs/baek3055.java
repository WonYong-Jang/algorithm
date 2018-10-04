package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 탈출 
 */
public class baek3055 {

	static int R, C, edx, edy, ans;
	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		edx = 0; edy =0; ans = -1;
		for(int i=1; i<= R; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= C; j++)
			{
				if(str.charAt(j-1) == '*') {
					map[i][j] = 2; // 홍수
					que.add(new Node(i, j, 2, 0));
					visit[i][j] = 2;
				}
				else if(str.charAt(j-1) == '.') map[i][j] = 0; // 빈곳 
				else if(str.charAt(j-1) == 'S') { // 시작 
					map[i][j] = 1;
					visit[i][j] = 1;
					que.add(new Node(i, j, 1, 0));
				}
				else if(str.charAt(j-1) == 'D') { // 도착 
					map[i][j] = 9;
					edx = i; edy =j; // 도착점 기록
				}
				else if(str.charAt(j-1) == 'X') map[i][j] = -1; // 돌 
			}
		}
		solve();
		if(ans == -1) System.out.println("KAKTUS");
		else System.out.println(ans);
		
	}
	public static void solve()
	{
		int len =0;
		while(!que.isEmpty())
		{
			len = que.size();
			for(int k=0; k< len; k++)
			{
				Node n = que.poll();
				int type = n.type;
				 
				
				if(n.dx == edx && n.dy == edy) {
					ans = n.min;
					break;
				}
				
				if(type == 1)
				{
					for(int i=0; i<4; i++)
					{
						int nx = n.dx + dxArr[i];
						int ny = n.dy + dyArr[i];
						
						if(!isRange(nx, ny) || visit[nx][ny] > 0) continue;
						if(map[nx][ny] ==0 || map[nx][ny] == 9)
						{
							que.add(new Node(nx, ny, type, n.min+1));
							visit[nx][ny] = 1;
						}
					}
				}
				
				else if(type == 2)
				{
					for(int i=0; i<4; i++)
					{
						int nx = n.dx + dxArr[i];
						int ny = n.dy + dyArr[i];
						
						if(!isRange(nx, ny) || visit[nx][ny] == 2) continue;
						if(map[nx][ny] == 0)
						{
							que.add(new Node(nx, ny, type, n.min+1));
							visit[nx][ny] =2;
						}
					}
				}
			}
			
			len = que.size();
			for(int k=0; k< len; k++)
			{
				Node n = que.poll();
				
				if(n.type == 1 && visit[n.dx][n.dy] == 2) continue;
				que.add(n);
			}
			
		}
	}
	public static void debug()
	{
		for(int i=1; i<= R; i++)
		{
			for(int j=1; j<= C; j++)
			{
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx <= R && dy <= C;
	}
	static class Node{
		int dx, dy, type, min;
		Node(int a, int b, int c, int d) {
			dx = a; dy = b; type =c; min = d;
		}
	}
}
