package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class baek1726 {

	static int N, M;
	static int sdx, sdy, sdir, edx, edy, edir;
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		sdir = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		edx = Integer.parseInt(st.nextToken());
		edy = Integer.parseInt(st.nextToken());
		edir = Integer.parseInt(st.nextToken())-1;
		
		solve();
		//debug();
	}
	public static void solve()
	{
		que.add(new Node(sdx, sdy,sdir,0));
		que.add(new Node(sdx, sdy,( sdir+2 ) % 4,1));
		que.add(new Node(sdx, sdy,(sdir+3 ) % 4,1));
		visit[sdx][sdy] = 0;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			System.out.println(n.dx + " " + n.dy + " "+ n.dir + " " + n.cmd);
			
			if(n.dx == edx && n.dy == edy && n.dir == edir) {
				System.out.println(n.cmd);
				return;
			}
			
			int nx =0, ny =0;
			for(int i=0; i<4; i++)
			{
				nx = n.dx;
				ny = n.dy;
				for(int k=0; k<3; k++)
				{
					nx+= dxArr[i];
					ny+= dyArr[i];
					if(!isRange(nx,ny) || map[nx][ny] == 1) break;
					
					if(visit[nx][ny] == -1)
					{
						visit[nx][ny] = n.cmd +1;
						que.add(new Node(nx, ny, n.dir, n.cmd+1));
						que.add(new Node(nx, ny, (n.dir + 2) % 4, n.cmd+1));
						que.add(new Node(nx, ny, (n.dir + 3) % 4, n.cmd+1));
					}
					else if (visit[nx][ny] != -1 && visit[nx][ny] > n.cmd + 1)
					{
						visit[nx][ny] = n.cmd +1;
						que.add(new Node(nx, ny, n.dir, n.cmd+1));
					}
					
				}
			}
			
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= M;
	}
	public static void debug()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				System.out.print(visit[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	static class Node{
		int dx, dy, dir, cmd;
		Node(int a, int b, int c, int d){
			dx=a; dy=b; dir=c; cmd=d;
		}
	}
}
