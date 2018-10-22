package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek16234 {

	static int N, L, R ,ans;
	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	static Queue<Node> temp = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		ans =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		int min = -1;
		boolean flag = true;
		while(true)
		{
			if(!flag) 
			{
				ans = min;
				break;
			}
			min++;
			flag = false;
			
			init();
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(visit[i][j] == 1) continue;
					if(check(i, j)) {
						flag = true;
					}
				}
			}
		}
	}
	public static boolean check(int dx, int dy)
	{
		que.clear(); temp.clear();
		que.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		int sum =0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			sum += map[n.dx][n.dy];
			temp.add(n);
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				int num = abs(map[nx][ny] , map[n.dx][n.dy]);
				
				if(num >= L && num <= R)
				{
					que.add(new Node(nx, ny));
					visit[nx][ny] = 1;
				}
			}
		}
		
		if(temp.size() >= 2)
		{
			
			int value = sum / temp.size();
			
			while(!temp.isEmpty())
			{
				Node n = temp.poll();
				map[n.dx][n.dy] = value;
			}
			
			return true;
		}
		else return false;
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
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
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx=a; dy=b;
		}
	}
}
