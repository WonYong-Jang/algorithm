package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 프로세스 연결하기
 */
public class swExpert1767 {

	public static int[][] map = new int[13][13];
	public static int N, Len;
	public static int maxConnectCnt = 0, minConnectSum = Integer.MAX_VALUE, defaultCnt=0;
	public static int[] coreArr = new int[13];
	public static int[] connectArr = new int[13];
	public static ArrayList<Point> arr = new ArrayList<>(); // core array 
	public static int[] dxArr = {0, 1, 0 ,-1}, dyArr = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k <= testCase; k++)
		{
			N = Integer.parseInt(br.readLine());
			init(); // 초기화  
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp == 1) 
					{   
						if(i == 1 || j == 1 || i == N || j == N) defaultCnt++; // 벽에 바로 붙어 있는 경우
						else arr.add(new Point(i,j));
					}
				}
			}
			Len = arr.size();
			
			for(int i=0; i<4; i++)
			{
				dfs(0,i);
				remove(0,i);
			}
			System.out.println("#"+k+" "+minConnectSum);
		}
	}
	public static void dfs(int index, int dir)
	{
		move(index,dir);
		
		if(index == Len-1) 
		{
			int tmpConnect = connect();
			int tmpSum = cSum();
			if(tmpConnect > maxConnectCnt) {
				maxConnectCnt = tmpConnect;
				minConnectSum = tmpSum;
			}
			else if(tmpConnect == maxConnectCnt) {
				minConnectSum = Integer.min(minConnectSum, tmpSum);
			}
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			dfs(index+1, i);
			remove(index+1, i);
		}
	}
	public static void move(int index, int dir)
	{
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(arr.get(index).dx, arr.get(index).dy));
		int sum=0;
		while(!que.isEmpty())
		{
			Point point = que.poll();
			int rDx = dxArr[dir]+ point.dx;
			int rDy = dyArr[dir]+ point.dy;
			if(rDx == 0 || rDy ==0 || rDx == N+1 || rDy == N+1) {
				coreArr[index] = 1;
				connectArr[index] = sum;
				return;
			}
			else if(map[rDx][rDy] > 0) {
				coreArr[index] = 0;
				connectArr[index] = 0;
				return;
			}
			else {
				map[rDx][rDy] = index + 2; // 2는 단순 flag 
				que.add(new Point(rDx,rDy));
				sum++;
			}
		}
	}
	public static void remove(int index, int dir) // 방문 기록 지우기  
	{
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(arr.get(index).dx, arr.get(index).dy));
		while(!que.isEmpty())
		{
			Point point = que.poll();
			int rDx = dxArr[dir]+ point.dx;
			int rDy = dyArr[dir]+ point.dy;
			if(rDx >0 && rDy >0 && rDx<= N && rDy <= N)
			{
				if(map[rDx][rDy] == index +2) {
					map[rDx][rDy] = 0;
					que.add(new Point(rDx,rDy));
				}
			}
		}
	}
	public static int connect() {
		int sum=0;
		for(int i=0; i<Len; i++)
			sum += coreArr[i];
		return sum;
	}
	public static int cSum() {
		int sum=0;
		for(int i=0; i<Len; i++)
			sum += connectArr[i];
		return sum;
	}
	public static void init()
	{
		arr.clear();
		maxConnectCnt = 0; minConnectSum = Integer.MAX_VALUE; defaultCnt=0;
		for(int i=0; i< Len; i++)
		{
			coreArr[i] =0; connectArr[i] = 0;
		}
	}
	public static class Point {
		int dx, dy;
		Point(int x, int y) {
			dx =x; dy = y;
		}
	}
}
