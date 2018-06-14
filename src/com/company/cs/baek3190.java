package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 뱀 ( 시물레이션)  
 */
public class baek3190 {
	public static class Point{
		int dx, dy, axis;
		Point(int x, int y, int z) {
			dx=x; dy=y; axis=z;
		}
	}
	public static Deque<Point> que = new ArrayDeque<>();
	public static boolean finish = false;
	public static int N, time; // 보드판 크기, 방향, 경과 시간 
	// 오른쪽 : 1 , 아래 : 2 , 위 : 3 , 왼쪽 : 4 
	public static int[][] map = new int[101][101];
	public static char[] turnInfo = new char[10001]; // 방향 전환 기록 배열 
	public static void turn() {
		Point point = que.peekFirst();
		int dx =0, dy=0, rDx=0, rDy=0, nextAxis=0;
		switch(turnInfo[time])
		{
		case 'D': // 오른쪽 방향 일때  
			if(point.axis == 1) {
				dx =1; nextAxis=2; 
			}
			else if(point.axis == 2) {
				dy = -1; nextAxis=4;
			}
			else if(point.axis ==3) {
				dy =1; nextAxis=1;
			}
			else {
				dx = -1; nextAxis=3;
			}
			break;
		case 'L': // 왼쪽 방향 일때
			if(point.axis == 1) {
				dx = -1; nextAxis=3;
			}
			else if(point.axis == 2) {
				dy =1; nextAxis=1;
			}
			else if(point.axis == 3) {
				dy = -1; nextAxis=4;
			}
			else {
				dx = 1; nextAxis=2;
			}
			break;
		}
		rDx = dx + point.dx;
		rDy = dy + point.dy;
		if(rDx < 1 || rDy < 1 || rDx > N || rDy > N || map[rDx][rDy] == 1) {
			finish = true; // 게임 종료
			return;
		}
		else if(map[rDx][rDy] != 2) { // 꼬리 자르기  
			Point temp = que.pollLast();
			map[temp.dx][temp.dy] = 0;
		}
		
		que.offerFirst(new Point(rDx,rDy,nextAxis));
		map[rDx][rDy] =1;
	}
	public static void move() {
		Point point = que.peekFirst();
		int dx =0, dy=0, rDx=0, rDy=0;
		switch(point.axis) 
		{
			case 1: // 오른쪽 이동  
				dy=1;
				break;
			case 2: // 아래로 이동 
				dx=1;
				break;
			case 3: // 위로 이동  
				dx=-1;
				break;
			case 4: // 왼쪽으로 이동  
				dy=-1;
				break;
		}
		// 이동 할때 경계선을 넘었는지 확인과 사과가 있는지 확인 !
		rDx = dx + point.dx;
		rDy = dy + point.dy;
		if(rDx < 1 || rDy < 1 || rDx > N || rDy > N || map[rDx][rDy] == 1) {
			finish = true; // 게임 종료
			return;
		}
		else if(map[rDx][rDy] != 2) { // 꼬리 자르기  
			Point temp = que.pollLast();
			map[temp.dx][temp.dy] = 0;
		}
		que.offerFirst(new Point(rDx,rDy,point.axis));
		map[rDx][rDy] =1;
		
	}
	public static void snake() {
		time = 0; // 시간 0 초기화  
		map[1][1] = 1; // 현재 노드가 위치 해있는곳 표시  
		que.offer(new Point(1,1,1));
		while(!finish) {
			if(turnInfo[time] == 'D' || turnInfo[time] == 'L') turn();
			else move();
			time++;  
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine()); // 사과의 갯수 
		for(int i =0; i< K ; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		for(int j= 0; j< L; j++) {
			st = new StringTokenizer(br.readLine());
			int tIndex = Integer.parseInt(st.nextToken());
			char turn = st.nextToken().charAt(0);
			turnInfo[tIndex] = turn;
		}
		 
		snake();
		System.out.println(time);
	}

}
