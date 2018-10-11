package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 행렬 찾기. 
 */
public class swExpert1258 {

	static int N;
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0 ,1, 0 ,-1};
	static Queue<Node> que = new LinkedList<>();
	static PriorityQueue<Node> ans = new PriorityQueue<>(new mySort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			que.clear(); ans.clear();
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					visit[i][j] = 0;
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(visit[i][j] == 1) continue;
					if(map[i][j] > 0 )
					{
						solve(i, j);
					}
				}
			}
			System.out.print("#"+k+" "+ ans.size()+" ");
			while(!ans.isEmpty())
			{
				Node n = ans.poll();
				System.out.print(n.dx+" "+ n.dy+" ");
			}
			System.out.println();
		}	
	}
	public static void solve(int dx, int dy)
	{
		int edx = 0, edy =0;
		que.add(new Node(dx, dy, 0));
		visit[dx][dy] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			edx = n.dx;
			edy = n.dy; // 끝점 찾기 위
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				if(map[nx][ny] > 0 )
				{
					que.add(new Node(nx, ny, 0));
					visit[nx][ny] = 1;
				}
			}
		}
		
		int tx = edx - dx + 1;
		int ty = edy - dy + 1;
		ans.add(new Node(tx, ty, tx*ty));
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
	static class mySort implements Comparator<Node>
	{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost ) return 1;
			else {
				if(a.dx < b.dx) return -1;
				else if(a.dx > b.dx) return 1;
				else return 0;
			}
		}
	}
	static class Node {
		int dx ,dy, cost;
		Node(int a, int b, int c) {
			dx =a; dy=b; cost =c;
		}
	}
}
