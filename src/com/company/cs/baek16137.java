package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 견우와 직녀 
 */
public class baek16137 {

	static int N, M, ans;
	static int[][] map = new int[15][15];
	static int[][] visit = new int[15][15];
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<Node> arr = new ArrayList<>(); // 넣을 수 있는 0 배열 
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i< N; i++)
		{
			for(int j=0; j< N; j++)
			{
				if(map[i][j] ==0 ) { // 교차로 판별 
					if(isOK(i,j)) {
						arr.add(new Node(i,j,0,0));
					}
				}
			}
		}
		
		solve();
		init();
		for(int i=0; i< arr.size(); i++)
		{
			map[arr.get(i).dx][arr.get(i).dy] = M;
			solve();
			map[arr.get(i).dx][arr.get(i).dy] = 0;
			init();
		}
		
		/*
		System.out.println(arr.size());
		//map[2][1] = M;
		solve();
		debug();
		*/
		
		System.out.println(ans);
	}
	public static void solve()
	{
		que.clear();
		que.add(new Node(0,0,0,0));
		visit[0][0] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == N-1 && n.dy == N-1) {
				ans = min(n.cnt, ans);
				return;
			}
			//System.out.println(n.dx+" "+n.dy+" "+n.cnt);
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || map[nx][ny] == 0 || visit[nx][ny] == 1) continue;
				if(map[nx][ny] == 1)  // 지날수 있는 거리 
				{
					que.add(new Node(nx, ny, n.cnt+1, 0));
					visit[nx][ny] = 1;
				}
				if(map[nx][ny] > 1 && n.flag ==0) 
				{
					if( (n.cnt + 1) % map[nx][ny] == 0 ) // 입장 할수 있는 시간 이면 
					{  
						que.add(new Node(nx, ny, n.cnt+1, 1));
						visit[nx][ny] = 1;
					}
					else
					{ // 대기 
						que.add(new Node(n.dx, n.dy, n.cnt+1, n.flag));
					}
				}
			}
		}
	}
	public static boolean isOK(int dx, int dy)
	{
		int cnt =0;
		
		// 위 아래 
		if(isRange(dx-1, dy) && isRange(dx+1, dy) && map[dx-1][dy] ==1 && map[dx+1][dy] ==1) cnt++;
		if(isRange(dx, dy-1) && isRange(dx, dy+1) && map[dx][dy-1] ==1 && map[dx][dy+1] ==1) cnt++;
		// 왼쪽 오른쪽 
		
		if(cnt >=1 ) return true; // 건널목 
		else return false; // 교차로 
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=0 && dy >=0 && dx < N && dy < N;
	}
	public static void debug()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static void init()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	static class Node {
		int dx, dy, cnt, flag;
		Node(int a, int b, int c, int d) {
			dx = a; dy = b; cnt = c; flag =d;
		}
	}
}


/**
5 5
1 1 1 0 0
0 6 0 0 0
1 1 2 1 1
1 1 2 1 1
1 1 2 1 1

5 10
1 2 1 3 1
1 1 0 0 1
13 0 0 0 1
1 1 1 1 1
1 1 1 1 1
 */

