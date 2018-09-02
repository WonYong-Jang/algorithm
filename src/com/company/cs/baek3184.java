package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 양 
 */
public class baek3184 {

	static int N, M, sheep, wolf;
	static char[][] map = new char[255][255];
	static int[][] visit = new int[255][255];
	static int[] dxArr = {0, 0 , 1, -1}, dyArr = {1, -1 ,0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sheep = 0; wolf = 0;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1);
			}
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(map[i][j] == '#' || visit[i][j] == 1) continue;
				bfs(i,j);
			}
		}
		System.out.println(sheep+" "+wolf);
	}
	public static void bfs(int dx, int dy)
	{
		que.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		int sheepNum = 0, wolfNum = 0;
		int flag = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
		
			if(map[n.dx][n.dy] == 'o') sheepNum++;
			else if(map[n.dx][n.dy] == 'v') wolfNum++;
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) ) {
					flag =1;
					continue;
				}
				
				if(map[nx][ny]=='#' || visit[nx][ny]==1) continue;
				que.add(new Node(nx, ny));
				visit[nx][ny] = 1;
			}
		}
		if(flag == 1) return;
		if(sheepNum > wolfNum) sheep += sheepNum;
		else if(sheepNum <= wolfNum) wolf += wolfNum;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) { 
			dx = x; dy = y;
		}
	}
}
