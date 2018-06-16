package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소  
 *
 */
public class baek14502 {
	
	public static class Point {
		int dx,dy;
		Point(int x, int y) {
			dx =x; dy =y;
		}
	}
	public static int[][] map = new int[9][9]; // 바이러스 확산 표시 맵    
	public static int[][] originMap = new int[9][9]; 
	public static int N, M;
	public static int maxValue = -1; // 최대 안전영역의 수  
	public static int[] dxArr = {0,0,-1,1}, dyArr = {1,-1,0,0};
	public static ArrayList<Point> arr = new ArrayList<>(); // 숫자 2 저장해 놓은 list
	public static void initMap() {
		for(int i=1; i<= N; i++)
			for(int j=1; j<= M; j++)
				map[i][j] = originMap[i][j];
	}
	public static int calSafeZone() {
		int result =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(map[i][j] == 0) result++;
			}
		}
		return result;
	}
	public static void dfs(int dx, int dy, int cnt) {
		
		if(cnt == 3) {
			
			int tempValue = bfs();
			maxValue = Integer.max(tempValue, maxValue);
			
			initMap();
			return;
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(map[i][j] != 0) continue;
				map[i][j] = originMap[i][j] = 5;
				dfs(i,j,cnt+1);
				map[i][j] = originMap[i][j] = 0;
				
			}
		}
			
	}
	public static int bfs() {
		Queue<Point> que = new LinkedList<>();
		
		que.addAll(arr);
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int rDx = dxArr[i] + point.dx;
				int rDy = dyArr[i] + point.dy;
				if(rDx >=1 && rDy >=1 && rDx <= N && rDy <=M && map[rDx][rDy] == 0) {
					que.offer(new Point(rDx,rDy));
					map[rDx][rDy] = 2; // 바이러스 표시 
				}
			}
		}
		int result = calSafeZone(); // 0 갯수 count 
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++) 
			{
				int num = Integer.parseInt(st.nextToken());
				originMap[i][j] = map[i][j] = num;
				if(num == 2) arr.add(new Point(i,j));
			}
		}
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(map[i][j] != 0) continue; // map 0 이 아니라면 continue  
				map[i][j] = originMap[i][j] = 5; // 3개의 벽 5로 표시    
				dfs(i,j,1);
				map[i][j] = originMap[i][j] = 0; // 검사 완료한 벽 0으로 초기화   
			}
		}
		System.out.println(maxValue);
	}

}
