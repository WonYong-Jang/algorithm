package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 다리 만들기 
 */
public class baek2146 {

	static int N, ans, index;
	static int[][] input = new int[105][105];
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr= {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ans = 100000; // 최대값 설정 
		index =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(map[i][j] > 0 ) continue;
				if(input[i][j] == 1) // 영역 나누기 
				{
					setScope(i,j);
				}
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(input[i][j] == 1) solve(i, j);
			}
		}
		
		System.out.println(ans);
	}
	public static void setScope(int dx, int dy)
	{
		index++; // 영역 갯수 증가 
		que.clear();
		que.add(new Node(dx, dy, 0, 0, 0));
		map[dx][dy] = index;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			for(int i=0; i<4; i++)
			{
				int nx = n.dx+ dxArr[i];
				int ny = n.dy +dyArr[i];
				if(!isRange(nx, ny) || map[nx][ny] > 0) continue;
				if(input[nx][ny] == 1)
				{
					map[nx][ny] = index;
					que.add(new Node(nx, ny,0, 0, 0));
				}
			}
		}
	}
	public static void solve(int dx, int dy)
	{
		init();
		que.clear();
		que.add(new Node(dx, dy, 0, 0, map[dx][dy]));
		visit[dx][dy] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				
				if(input[nx][ny] == 0) // 빈 다리 설정 
				{
					visit[nx][ny] = 1;
					que.add(new Node(nx, ny, n.cnt+1, 1, n.scope)); // flag 1로 설정 
				}
				else if(input[nx][ny] == 1)
				{
					if(n.flag == 0 ) continue;
					else if(n.flag == 1 && n.scope != map[nx][ny]) // 같은 섬이 아니고 다리를 건너온 경우 
					{
						ans = min(ans, n.cnt); // 다리 건너온 경우 
						visit[nx][ny] = 1;
					}
				}
			}
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static void init()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	public static void debug()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy<= N;
	}
	static class Node{
		int dx, dy, cnt, flag, scope; // 0 을 통과해서 왔는지 확인 flag  // scope 어느 영역인지
		Node(int a, int b, int c, int d, int e){
			dx = a; dy = b; cnt = c; flag = d; scope = e;
		}
	}
}
