package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map = new int[12][12];
	static int[][] visit = new int[12][12];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	static PriorityQueue<Integer> sQue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(visit[i][j] == 1 || map[i][j] == 0) continue;
				solve(i, j);
				cnt++;
			}
		}
		System.out.println(cnt);
		while(!sQue.isEmpty())
		{
			int temp = sQue.poll();
			System.out.print(temp + " ");
		}
	}
	public static void solve(int dx, int dy)
	{
		que.clear();
		visit[dx][dy] = 1;
		int cnt =0;
		que.add(new Node(dx, dy));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			cnt++;
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] == 0) continue;
				que.add(new Node(nx, ny));
				visit[nx][ny] = 1;
			}
		}
		sQue.add(cnt);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx<= N && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy =y;
		}
	}
	
}
