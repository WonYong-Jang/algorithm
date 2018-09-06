package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 보물섬 
 */
public class baek2589 {

	static int N, M, ans;
	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans =0;
		for(int i=1; i<= N; i++) // input 
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				if(str.charAt(j-1) == 'W') map[i][j] = 0; // 바다 
				else map[i][j] = 1; // 육지 
			}
		}
		
		for(int i=1; i<= N; i++) 
		{
			for(int j=1; j<= M; j++)
			{
				if(visit[i][j] == 1 || map[i][j] == 0) continue;
				solve(i, j);
				init();
			}
		}
		System.out.println(ans);
	}
	public static void solve(int dx, int dy)
	{
		que.clear();
		que.add(new Node(dx, dy, 0));
		visit[dx][dy] = 1;
		int temp =0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			temp = max(temp, n.cnt);
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] == 0) continue;
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny, n.cnt+1));
			}
		}
		
		ans = max(ans, temp);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx<= N && dy <= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	static class Node {
		int dx, dy, cnt;
		Node(int x, int y, int z) {
			dx = x; dy = y; cnt = z;
		}
	}
}
