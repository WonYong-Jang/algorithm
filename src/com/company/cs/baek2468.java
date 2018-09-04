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
 * 안전 영역 
 */
public class baek2468 {

	static boolean flag;
	static int N, K, ans;
	static int[][] map = new int[105][105]; 
	static int[][] visit = new int[105][105]; 
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		int temp =0;
		K =0; ans =0; flag = false;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp; 
				K = max(K, temp); // 가장 높은 높이 구하기 
			}
		}
		for(int i=0; i<= K; i++)
		{
			bSearch(i);
		}
		
		bw.write(ans+"\n");
		bw.flush();
	}
	public static void bSearch(int k)
	{
		int cnt = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				visit[i][j] = 0;
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(map[i][j] <= k || visit[i][j] == 1) continue;
				bfs(i,j,k);
				cnt++;
			}
		}
		ans = max(ans, cnt);
		
	}
	public static void bfs(int dx, int dy, int k)
	{
		que.clear();
		que.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || k >= map[nx][ny]  || visit[nx][ny] == 1) continue;
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny));
			}	
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= N;
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
