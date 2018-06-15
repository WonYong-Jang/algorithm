package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 미로 탐색  
 */
public class baek2178 {
	
	public static class Point {
		int dx, dy;
		Point(int x, int y) {
			dx=x; dy=y;
		}
	}
	public static char[][] map = new char[101][101]; 
	public static int[][] visited = new int[101][101];
	public static int[] dxArr = {1, -1, 0, 0};
	public static int[] dyArr = {0, 0, 1, -1};
	public static int N, M; // 가로 세로 
	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(1,1)); // 시작점  
		visited[1][1] = 1;
		while(!que.isEmpty()) {
			int dx = que.peek().dx;
			int dy = que.peek().dy;
			que.poll();
			
			if(dx == N && dy == M) break;
			for(int i=0; i<4; i++) 
			{
				int rDx = dx + dxArr[i];
				int rDy = dy + dyArr[i];
				// 범위를 넘어 가지 않고, 미로에서 이동할 수 있는 값 1 인 경우, 방문한적이 없는 경우  
				if(rDx >=1 && rDy >=1 && rDx <= N && rDy <= M && visited[rDx][rDy] == 0 && map[rDx][rDy] == '1') { 
					que.offer(new Point(rDx,rDy));
					visited[rDx][rDy] = visited[dx][dy] + 1;
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++) { // input 
				map[i+1][j] = str.charAt(j-1);
			}
		}
		bfs();
		
		System.out.println(visited[N][M]);
	}

}
