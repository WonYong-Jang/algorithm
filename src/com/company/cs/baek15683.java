package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek15683 {

	public static int[][] map = new int[9][9];
	public static int[][] originMap = new int[9][9];
	public static int N,M, minValue = Integer.MAX_VALUE;
	public static ArrayList<Point> cctv = new ArrayList<>();
	public static int[] dxArr= {0, 1, 0, -1}, dyArr = {1, 0, -1, 0};
	public static int[] arr1 = {1,2,4,8};
	public static int[] arr2 = {5, 10};
	public static int[] arr3 = {9,3,6,12};
	public static int[] arr4 = {13, 7,14 ,11};
	public static int[] arr5 = {15};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp >=1 && temp <=5) cctv.add(new Point(i,j, temp));
			}
		}
		int len = cctv.size();
		dfs(0, len -1);
		System.out.println(minValue);
	}
	public static void dfs(int curIndex, int len)
	{
		if(len == curIndex) {
			// 전체 검사하면서 0의 갯수 검사 후 전 단계 map 으로 초기화 해주는 작업  
			calZero();
			return;
		}
		if(curIndex == 0) 
		{
			for(int i=0; i< arr1.length ; i++)
			{
				for(int j=0; j< 4; j++)
				{
					if( (arr1[i] & (1<<j)) > 0)
					{
						// 검사 진행 
						move(cctv.get(curIndex).dx,cctv.get(curIndex).dy, j);
					}
				}
			}
		}
		if(curIndex == 1) 
		{
			for(int i=0; i< arr2.length ; i++)
			{
				for(int j=0; j< 4; j++)
				{
					if( (arr2[i] & (1<<j)) > 0)
					{
						// 검사 진행 
						move(cctv.get(curIndex).dx,cctv.get(curIndex).dy, j);
					}
				}
			}
		}
		if(curIndex == 2) 
		{
			for(int i=0; i< arr3.length ; i++)
			{
				for(int j=0; j< 4; j++)
				{
					if( (arr3[i] & (1<<j)) > 0)
					{
						// 검사 진행 
						move(cctv.get(curIndex).dx,cctv.get(curIndex).dy, j);
					}
				}
			}
		}
	}
	public static void move(int dx,int dy, int dir)
	{
		int rDx = dx +dxArr[dir];
		int rDy = dy +dyArr[dir];
		if(rDx > 0 && rDy >0 && rDx <= N && rDy <= M && map[rDx][rDy]==0 ) {
			map[rDx][rDy]= 7;
			move(rDx,rDy,dir);
		}
		else if(map[rDx][rDy] >=1 && map[rDx][rDy] <=5) move(rDx,rDy,dir); //cctv 통과 
		else return;
	}
	public static void calZero() 
	{
		int cnt =0;
		for(int i=1; i<= N; i++)
			for(int j=1; j<= M; j++)
				if(map[i][j]==0) cnt++;
		minValue = Integer.min(minValue, cnt);
	}
	public static class Point{
		int dx,dy, type;
		Point(int x, int y, int z) {
			dx =x; dy = y; type = z;
		}
	}
}
