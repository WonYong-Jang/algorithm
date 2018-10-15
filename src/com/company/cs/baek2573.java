package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 빙산 
 */
public class baek2573 {

	static int N, M, cnt, ans;
	static int[][] map = new int[305][305];
	static int[][] visit = new int[305][305];
	static Queue<Node> que = new LinkedList<>();
	static Queue<Node> tQue = new LinkedList<>();
	static int[][] tVisit = new int[305][305];
	static int[] dxArr = {-1,0,1,0}, dyArr = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		int temp = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp > 0) {
					cnt++;
				}
				else if(temp == 0) {
					visit[i][j] = 1;
					que.add(new Node(i, j));
				}
			}
		}
		
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		int min =0, len = 0;
		
		while(!que.isEmpty())
		{
			len = que.size();
			min++;
			
			for(int i=0; i< len; i++)
			{
				Node n = que.poll();
				boolean flag = false;
				
				for(int k=0; k<4; k++)
				{
					int nx = n.dx + dxArr[k];
					int ny = n.dy + dyArr[k];
					if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
					
					if(map[nx][ny] > 0 ) {
						flag = true;
						map[nx][ny]--;
					}
					if(map[nx][ny] == 0) {
						que.add(new Node(nx, ny));
						visit[nx][ny] = 1;
						cnt--; // 빙산 갯수 
					}
					
				}
				if(flag) que.add(new Node(n.dx, n.dy));
			}
			
			tQue.clear();
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					tVisit[i][j] = 0;
					if(map[i][j] > 0 && tQue.isEmpty()) {
						tQue.add(new Node(i,j));
						tVisit[i][j] = 1;
					}
				}
			}
			int result = check();
			
			if(result != cnt) {
				ans = min;
				break;
			}
		}
	}
	public static int check()
	{
		int chk = 0;
		while(!tQue.isEmpty())
		{
			Node n = tQue.poll();
			chk++;
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || tVisit[nx][ny] == 1 || map[nx][ny] == 0) continue;
				tVisit[nx][ny] = 1;
				tQue.add(new Node(nx, ny));
			}
		}
		return chk;
	}
	public static void debug()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy<= M;
	}
	static class Node{
		int dx, dy;
		Node(int a, int b) {
			 dx=a; dy=b;
		}
	}
}
