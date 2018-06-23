package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 뱀   
 */
public class baek3190 {
	
	public static int[][] map = new int[101][101];
	public static char[] info = new char[10001]; // 시간에 따른 방향 정보 배열 
	public static int N, K, L, curAxis=0, rDx =1, rDy =1, time =0; 
	public static int[] dx = {0, 1, 0, -1}; 
	public static int[] dy = {1, 0, -1, 0};
	public static Deque<Point> que = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dx =0, dy =0, index =0;
		char str;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		for(int i=0; i< K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = 2; // 사과 2로 표현 
		}
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++)
		{
			st = new StringTokenizer(br.readLine());
			index = Integer.parseInt(st.nextToken());
			str = st.nextToken().charAt(0);
			info[index] = str;
		}
		start();
		System.out.println(time);
	}
	public static void start()
	{
		que.add(new Point(1,1)); // 시작점 
		map[1][1] = 1; // 방문 표시  
		while(!que.isEmpty())
		{	
			if(info[time] == 'D') turnRight();
			else if(info[time] == 'L') turnLeft();
			else move();
			time++;
			if(rDx < 1 || rDy <1  || rDx > N || rDy > N || map[rDx][rDy] == 1) break; // 벽을 만나거나 자기 몸과 머리가 만난 경우 
			que.addFirst(new Point(rDx,rDy)); // 방향에 맞게 머리 앞에 추가  
			if(map[rDx][rDy] != 2) { // 사과를 만나지 않는 경우 맨뒤에 꼬리 지워줌     
				Point point = que.pollLast();
				map[point.dx][point.dy] = 0; // 제거 
			}
			map[rDx][rDy] = 1; // 방문 표시  
		}
	}
	public static void move() // 해당 방향으로 이동  
	{
		rDx += dx[curAxis];
		rDy += dy[curAxis];
	}
	public static void turnLeft() // 해당 방향 기준 왼쪽 회전, 방향 update
	{
		switch(curAxis)
		{
		case 0: rDx -= 1; curAxis = 3; break;
		case 1: rDy += 1; curAxis = 0; break;
		case 2: rDx += 1; curAxis = 1; break;
		case 3: rDy -= 1; curAxis = 2; break;
		}
	}
	public static void turnRight() //해당 방향 기준 오른쪽 회전, 방향 update
	{
		switch(curAxis)
		{
		case 0: rDx += 1; curAxis = 1; break;
		case 1: rDy -= 1; curAxis = 2; break;
		case 2: rDx -= 1; curAxis = 3; break;
		case 3: rDy += 1; curAxis = 0; break;
		}
	}
	public static class Point{
		int dx,dy;
		Point(int x, int y) {
			dx =x; dy =y;
		}
	}
}








