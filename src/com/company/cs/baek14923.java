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
 * 미로 탈출 
 *
 */
public class baek14923 {

	static final int INF = Integer.MAX_VALUE;
	static int N, M, ans;
	static int[][] map = new int[1005][1005];
	static int[][] visited = new int[1005][1005];
	static int[] dxArr = {1, -1, 0, 0}, dyArr = {0, 0, 1, -1};
	static int sdx,sdy, edx, edy; // 시작점, 끝점 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		edx = Integer.parseInt(st.nextToken());
		edy = Integer.parseInt(st.nextToken());
		ans = INF;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		if(ans == INF ) System.out.println(-1);
		else System.out.println(ans);
		
	}
	public static void solve()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(sdx,sdy,0,1));
		visited[sdx][sdy] = 1; 
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy) {
				ans = n.cnt; // 최단 거리 찾음 
				break;
			}
			
			for(int i=0; i<4; i++)
			{
				int ndx = dxArr[i] + n.dx;
				int ndy = dyArr[i] + n.dy;
				if(!isRange(ndx, ndy) || visited[ndx][ndy] == 1) continue;
				if(map[ndx][ndy] == 1) // 벽 
				{
					if(n.pass == 0) continue;
					else {
						que.add(new Node(ndx, ndy, n.cnt+1, 0));
					}
				}
				else // 0 일경우  
				{
					que.add(new Node(ndx,ndy, n.cnt+1, n.pass));
				}
				visited[ndx][ndy] = 1;
				
			}
		}
		
	}
	
	public static boolean isRange(int a, int b)
	{
		return a>=1 && b>=1 && a<= N && b<= M;
	}
	static class Node{
		int dx,dy, cnt, pass; //x,y좌표값 /  노드마다 해당 거리저장 /  벽 통과 여부 확인 
		Node(int a, int b, int c, int d) {
			dx =a; dy =b; cnt =c; pass =d;
		}
	}
}
