package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 보급로 
 */
public class swExpert1249 {

	static int N;
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase ; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<= N; i++)
			{
				String str = br.readLine();
				for(int j=1; j<= N; j++)
				{
					visit[i][j] = -1;
					map[i][j] = str.charAt(j-1) - '0';
				}
			}
			
			solve();
			//debug();
			bw.write("#"+k+" "+visit[N][N]+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		que.clear();
		que.add(new Node(1,1));
		visit[1][1] = 0;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny)) continue;
				
				if(visit[nx][ny] == -1 || visit[nx][ny] > visit[n.dx][n.dy] + map[nx][ny])
				{
					visit[nx][ny] = map[nx][ny] + visit[n.dx][n.dy];
					que.add(new Node(nx, ny));
				}
			}
		}
	}
	public static void debug()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy<= N;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node{
		int dx, dy;
		Node(int a, int b) { 
			dx = a; dy = b;
		}
	}
}
