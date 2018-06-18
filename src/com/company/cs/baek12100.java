package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2048(easy) 삼성기출   
 */
public class baek12100 {
	
	// 방향  ==>   0 : 위 , 1 : 오른쪽 , 2 : 아래 , 3 :왼쪽  
	public static int[][] map = new int[21][21];
	public static int[][][] originMap = new int[6][21][21]; // 5단계 각각 저장할 배열  
	public static int N;
	public static Queue<Point> que = new LinkedList<>(); // 각 행별 큐에 삽입  
	public static Deque<Point> deque = new ArrayDeque<>(); // 행 별로 합쳐진 값들을 담아둘곳  
	public static int maxValue = -1; // 최대값 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++) // input
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				// originMap[0] 에는 처음 input 
				originMap[0][i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i< 4; i++)
		{
			dfs(i,1);
			initMap(0);
		}
		
		System.out.println(maxValue);
	}
	public static void dfs(int axis, int depth) { // depth : ( 최대 5번 ) 
		
		moveAxis(axis, depth); // 방향 별로 합쳐주기 
		chkMaxValue(); // 단계별 가장 큰 값 확
		
		if(depth == 5) { // 5단계 까지만 검사 
			return;
		}
		
		for(int i=0; i< 4; i++)
		{
			dfs(i,depth+1);
			initMap(depth);
		}
	}
	public static void moveAxis(int axis,int depth) {
		int num =0;
		
		if(axis ==0 ) { // 위쪽 방향   
			for(int j=1; j<= N; j++)
			{
				for(int i=1; i<=N; i++)
				{
					que.add(new Point(i,j,map[i][j]));
				}
				if(!que.isEmpty()) sumBlock(); // 전부다 0이 아니라면 검사
				
				for(int i=1; i<=N; i++)
				{
					if(!deque.isEmpty()) num = deque.poll().value;
					else num = 0;
					originMap[depth][i][j] = map[i][j] = num;
				}
			}
		}
		else if(axis == 1) { // 오른쪽 방향  
			for(int i=1; i<=N ; i++)
			{
				for(int j=N; j >=1 ; j--)
				{
					que.add(new Point(i,j,map[i][j]));
				}
				if(!que.isEmpty()) sumBlock(); // 전부다 0이 아니라면 합쳐주기 
				
				for(int j=N; j >=1 ; j--)
				{
					if(!deque.isEmpty()) num = deque.poll().value;
					else num = 0;
					originMap[depth][i][j] = map[i][j] = num;
				}
			}
		}
		else if(axis ==2) { // 아래쪽 방향  
			for(int j=1; j<=N ; j++)
			{
				for(int i=N; i >=1 ; i--)
				{
					que.add(new Point(i,j,map[i][j]));
				}
				if(!que.isEmpty()) sumBlock(); // 전부다 0이 아니라면 검사
				
				for(int i=N; i >=1 ; i--)
				{
					if(!deque.isEmpty()) num = deque.poll().value;
					else num = 0;
					originMap[depth][i][j] = map[i][j] = num;
				}
			}
		}
		else { // 왼쪽 방향    
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<=N; j++)
				{
					que.add(new Point(i,j,map[i][j]));
				}
				if(!que.isEmpty()) sumBlock(); // 전부다 0이 아니라면 검사
				
				for(int j=1; j<= N; j++)
				{
					if(!deque.isEmpty()) num = deque.poll().value;
					else num = 0;
					originMap[depth][i][j] = map[i][j] = num;
				}
			}
		}
		
	}
	public static void sumBlock() { // 방향별로 합치기  
		int num = -1;
		deque.clear();
		while(!que.isEmpty()) {
			Point point = que.peek();
			int value = point.value;
			int dx = point.dx;
			int dy = point.dy;
			que.poll();
			if(value == 0 ) {
				continue;
			}
			else if(value != 0 && num != value) {
				deque.addLast(point);
				num = value;
			}
			else if(value != 0 && value == num) {
				deque.pollLast();
				deque.addLast(new Point(dx,dy,value*2));
				num = -1;
			}
		}
	}
	public static void chkMaxValue() {
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				maxValue = Math.max(maxValue, map[i][j]);
			}
		}
	}
	public static void initMap(int depth) { // 단 단계별로 저장해둔 맵을 초기화  
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				map[i][j] = originMap[depth][i][j];
			}
		}
	}
	public static class Point {
		int dx,dy,value;
		Point(int x,int y, int z) {
			dx = x; dy = y; value = z;
		}
	}
}

/**

10
8  8  4 16 32  0  0  8  8  8
8  8  4   0   0  8  0  0  0  0
16  0  0 16   0  0  0  0  0  0
0  0  0   0   0  0  0  0  0  0
0  0  0  0    0  0  0  0  0  0
0  0  0  0    0  0  0  0  0  0
0  0  0  0    0  0  0  0  0  0
0  0  0  0    0  0  0  0  0  0
0  0  0  0    0  0  0  0  0 16
0  0  0  0    0  0  0  0  0  2

(5번)  위 - 오른쪽 - 오른쪽 - 위 - 오른쪽

=>> 128 
 *  
 */









