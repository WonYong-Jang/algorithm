package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 탈옥 
 */
public class baek9376 {

	static final int wall = -1; // 벽 
	static final int door = 2; // 문 
	static final int blank = 0;// 지나갈수 있는 길
	static final int prison = 1; // 죄수 위치 
	
	static int N, M, ans; // 높이 너비
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Deque<Node> que = new ArrayDeque<>();
	static int[][] map = new int[105][105];
	static int[][] outArr;
	static int[][] prison1;
	static int[][] prison2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k <= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) + 1; // 범위 한칸씩 늘려주기 
			M = Integer.parseInt(st.nextToken()) + 1;
			int check =0;
			Node p1= new Node(-1,-1), p2 = new Node(-1,-1), out = new Node(0,0);
			
			for(int i=0; i<= N; i++)
				for(int j=0; j<= M; j++)
					map[i][j] = blank;
			
			ans = N * M ;
			for(int i=1; i< N; i++)
			{
				String str = br.readLine();
				for(int j=1; j< M; j++)
				{
					char temp = str.charAt(j-1);
					if(temp == '*') map[i][j] = wall;
					else if(temp == '#') map[i][j] = door;
					else if(temp == '$') 
					{
						map[i][j] = prison;
						if(check ==0) {
							p1 = new Node(i,j);
							check++;
						}
						else {
							p2 = new Node(i,j);
						}
					}
					else if(temp == '.') map[i][j] = blank;
				}
			}
			
			outArr = solve(out);
			prison1 = solve(p1);
			prison2 = solve(p2);
			
			//debug();
			calculate();
		}
	}
	public static int[][] solve(Node cur)
	{
		que.clear();
		int [][] visit = new int[105][105];
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				visit[i][j] = -1;
			}
		}
		
		que.add(new Node(cur.dx, cur.dy));
		visit[cur.dx][cur.dy] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || map[nx][ny] == wall || visit[nx][ny] != -1) continue;
				if(map[nx][ny] == door)
				{
					visit[nx][ny] = visit[n.dx][n.dy] + 1;
					que.addLast(new Node(nx,ny));
					
				}
				else if(map[nx][ny] == prison || map[nx][ny] == blank)
				{
				
					visit[nx][ny] = visit[n.dx][n.dy];
					que.addFirst(new Node(nx,ny));
					
				}
			}
		}
		
		return visit;
		
	}
	public static void calculate()
	{
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				if(map[i][j] == wall || outArr[i][j] == -1 || prison1[i][j] == -1 || prison2[i][j] == -1) continue;
				 int temp = outArr[i][j] + prison1[i][j] + prison2[i][j]; 
				 if( map[i][j] == door) temp -= 2;
				 
				 ans = min(ans, temp);
			}
		}
		System.out.println(ans);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=0 && dy>=0 && dx<= N && dy<= M;
	}
	
	public static void debug()
	{
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				//System.out.printf("%3d", visit[0][i][j]);
			}
			System.out.println();
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}




