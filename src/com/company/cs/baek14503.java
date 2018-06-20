package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 청소
 *
 */
public class baek14503 {

	// d ==> 0 : 북쪽 / 1 : 동쪽 / 2 : 남쪽 / 3 : 서쪽 
	public static int N, M, startX, startY, startAxis, rDx, rDy, nextAxis , cnt;
	public static int[] dxArr = {0, 1, 0, -1};
	public static int[] dyArr = {-1, 0, 1, 0};
	public static int[][] map = new int[51][51];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startAxis = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start(startX,startY, startAxis);
		countFun();
		System.out.println(cnt);
		
	}
	public static void start(int dx, int dy, int axis) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(dx, dy, axis)); // 시작점   
		map[dx][dy] = 2; // 방문 표시  
		while(!que.isEmpty()) {
			Point point = que.poll();
			int curAxis = point.axis;
			int curDx = point.dx;
			int curDy = point.dy;
			
			if(nextAxis(point)) 
			{
				que.offer(new Point(rDx,rDy,nextAxis));
			}
			else { // 막혀 있는 경우 해당 방향 기준으로 뒤로 후진
				
				while(true) // 뒤에 벽을 만날때 까지 후진  
				{
					int tempX =0, tempY =0;
					switch(curAxis) 
					{
						case 0: point.dx += 1; break;
						case 1: point.dy -= 1; break;
						case 2: point.dx -= 1; break;
						case 3: point.dy += 1; break;
					}

					
					
					if(point.dx >= N || point.dy >= M || point.dx < 0 || point.dy < 0) break;
					else if(map[point.dx][point.dy] == 1 ) {
						break;
					}
					boolean check = nextAxis(point);
					if(check) {
						que.offer(new Point(rDx,rDy,nextAxis)); break;
					}
				}
				
			}
		}
	}
	public static boolean nextAxis(Point point) {
		int axis = point.axis, flag =0;
		if(axis == 0) { // 북쪽 방향바라보고 있을때 왼쪽 방향부터 검사하기    
			for(int i=0; i<4; i++)
			{
				rDx = dxArr[i] + point.dx;
				rDy = dyArr[i] + point.dy;
				if(rDx >=0 && rDy >=0 && rDx < N && rDy < M && map[rDx][rDy] ==0 ) {
					flag = 1; map[rDx][rDy] = 2;
					nextAxis = direction(i);
					break; // 청소할 공간이 있다면 flag 를 1로 바꿔추고 break
				}
			}
		}
		else if(axis == 1) { // 동쪽 방향을 바라보고 있을 때  
			for(int i=0; i<4; i++)
			{
				int index = (3 +i) % 4 ;
				rDx = dxArr[index] + point.dx;
				rDy = dyArr[index] + point.dy;
				if(rDx >=0 && rDy >=0 && rDx < N && rDy < M && map[rDx][rDy] ==0 ) {
					flag = 1; map[rDx][rDy] = 2;
					nextAxis = direction(index);
					break;
				}
			}
		}
		else if(axis == 2) { // 남쪽  
			for(int i=0; i<4; i++)
			{
				int index = (2 +i) % 4 ;
				rDx = dxArr[index] + point.dx;
				rDy = dyArr[index] + point.dy;
				if(rDx >=0 && rDy >=0 && rDx < N && rDy < M && map[rDx][rDy] ==0 ) {
					flag = 1; map[rDx][rDy] = 2;
					nextAxis = direction(index);
					break;
				}
			}
		}
		else if(axis == 3) { // 서쪽  
			for(int i=0; i<4; i++)
			{
				int index = (1 +i) % 4 ;
				rDx = dxArr[index] + point.dx;
				rDy = dyArr[index] + point.dy;
				if(rDx >=0 && rDy >=0 && rDx < N && rDy < M && map[rDx][rDy] ==0 ) {
					flag = 1; map[rDx][rDy] = 2;
					nextAxis = direction(index);
					break;
				}
			}
		}
		if(flag == 1) return true; // 4방향 중 한 방향으로 청소할 공간이 남아 있는 경우  
		else return false; // 4방향이 다 막혀 있을 경우  
	}
	public static int direction(int axis) { // 방향 맵핑   
		int result =0;
		switch(axis)
		{
		case 0: result=3; break;
		case 1: result=2; break;
		case 2: result=1; break;
		case 3: result=0; break;
		}
		return result;
	}
	public static void countFun() {
		for(int i=0; i< N; i++)
		{
			for(int j=0; j< M; j++)
			{
				if(map[i][j] == 2) cnt++;
			}
		}
	}
	public static class Point {
		int dx, dy, axis;
		Point(int x, int y, int z) {
			dx =x ; dy=y; axis =z;
		}
	}
}










