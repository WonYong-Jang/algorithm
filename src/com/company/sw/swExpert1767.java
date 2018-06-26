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
	public static int maxConnectCnt = 0, minConnectSum = Integer.MAX_VALUE;
	public static int[] coreArr = new int[13];
	public static int[] connectArr = new int[13];
	public static ArrayList<Point> arr = new ArrayList<>(); // core array 
	public static int[] dxArr = {0, 1, 0 ,-1};
	public static int[] dyArr = {1, 0, -1, 0};
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
					if(temp == 1) arr.add(new Point(i,j)); // core 
				}
			}
			Len = arr.size();
			
			for(int i=0; i<4; i++)
			{
				dfs(0, i, 2);
				remove(0,i, 2);
			}
			System.out.println("#"+k+" "+minConnectSum);
		}
	}
	public static void dfs(int index, int dir, int flag)
	{
		move(index,dir, flag);
		if(index == Len - 1) { 
			int tempConnectCnt = connectCnt(); // 연결된 core 갯수  
			int tempConnectSum = sumCnt(); // 연결된 core 들의 선의 길이  
			if(tempConnectCnt > maxConnectCnt) {
				maxConnectCnt = tempConnectCnt;
				minConnectSum = tempConnectSum;
			}
			else if(tempConnectCnt == maxConnectCnt) {
				minConnectSum = Integer.min(minConnectSum, tempConnectSum);
			}
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			dfs(index+1,i, flag+1);
			remove(index+1,i, flag+1);
		}
	}
	public static void move(int index ,int dir, int flag)
	{
		Queue<Point> que = new LinkedList<>();
		int sum =0;
		que.add(new Point(arr.get(index).dx, arr.get(index).dy));
		while(!que.isEmpty())
		{
			Point point = que.poll();
			int rDx = point.dx + dxArr[dir];
			int rDy = point.dy + dyArr[dir];
			if(rDx ==0 || rDy == 0 || rDx == N + 1 || rDy == N + 1)
			{
				connectArr[index] = sum;
				coreArr[index] = 1;
				return;
			}
			else if(map[rDx][rDy] > 0) {
				connectArr[index] = 0;
				coreArr[index] = 0;
				return;
			}
			else {
				que.add(new Point(rDx,rDy));
				map[rDx][rDy] = flag;
				sum++;
			}
		}
	}
	public static int connectCnt() // core 몇 개 연결 되었는지  
	{
		int sum=0;
		for(int i=0; i<Len; i++)
			sum += coreArr[i];
		return sum;
	}
	public static int sumCnt() // 연결된 core 선 길이 합 
	{
		int sum=0;
		for(int i=0; i<Len; i++)
			sum += connectArr[i];
		return sum;
	}
	public static void remove(int index, int dir, int flag) // visited 기록 지우기  
	{
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(arr.get(index).dx, arr.get(index).dy));
		while(!que.isEmpty())
		{
			Point point = que.poll();
			int rDx = point.dx + dxArr[dir];
			int rDy = point.dy + dyArr[dir];
			if(rDx > 0 && rDy > 0 && rDx <= N && rDy <= N)
			{
				if(map[rDx][rDy] == flag) 
				{
					map[rDx][rDy] = 0;
					que.add(new Point(rDx,rDy));
				}
			}
		}
	}
	public static void init()
	{
		arr.clear();
		for(int i=0; i<N; i++)
		{
			coreArr[i] = 0;
			connectArr[i] = 0;
		}
	}
	public static class Point {
		int dx, dy;
		Point(int x, int y) {
			dx =x; dy = y;
		}
	}
}
