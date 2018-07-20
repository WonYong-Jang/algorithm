package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_space {

	static int[][] map;
	static int[][] visited;
	static int[] dxArr = {1, -1, 0, 0}, dyArr = {0, 0, 1, -1};
	static int N, M,sx, sy, ex, ey;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase ; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];
			
		}
	}
	public static void bfs()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(sx,sy)); // 시작점 추가 
		
		while(!que.isEmpty())
		{
			Node node = que.poll();
			if(node.dx == ex && node.dy == ey) break; // 도착 ! 
			int curDis = visited[node.dx][node.dy];
			
			for(int i=0; i<4; i++)
			{
				int rDx = dxArr[i] + node.dx;
				int rDy = dyArr[i] + node.dy;
				if(rDx == sx && rDy == sy) continue;
				
				if(rDx == -1) rDx = N - 1; // 맨 끝점으로 이동 
				else if(rDx == N) rDx = 0;
				else if(rDy == -1) rDy = N - 1;  // 맨 끝점으로 이동 / 범위 넘어 간 경우
				else if(rDy == N) rDy =0;
				//System.out.println(rDx +" "+ rDy);
				int nextDis = visited[rDx][rDy];
				if(nextDis ==0) {
					visited[rDx][rDy] = curDis+1;
					que.add(new Node(rDx,rDy));
				}
				else if(curDis + 1 < nextDis && nextDis > 0 ) // 최단 거리 찾아 나가기  
				{
					visited[rDx][rDy] = curDis+1;
					que.add(new Node(rDx,rDy));
				}
			}
		}
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx =x; dy =y;
		}
	}
}
