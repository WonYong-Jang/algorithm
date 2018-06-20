package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek15685 {
	
	// 방향 ==> 0 : 오른쪽  / 1 : 위쪽 / 2 : 왼쪽 / 3 : 아래  
	public static int N; // 드래곤 커브의 갯수 
	public static final int maxIdx = 100;
	public static int[][] curveMap = new int[101][101]; 
	public static int[][] inputMap = new int[21][4];
	public static int startX, startY;
	public static int[] dxArr = {0,0,1,1}, dyArr= {0,1,0,1}; // 4 꼭지점 구하기 위한 방향 배열 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dx, dy, d, g;
		
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++)
			{
				inputMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i< N; i++) // input 값들을 행 단위로 그리기  (커브 )  
		{
			drawCurve(i);
		}
		int rDx=0, rDy=0, result=0, cnt=0;
		for(int i=0; i< maxIdx ;i++)
		{
			for(int j=0; j< maxIdx; j++)
			{
				cnt =0;
				for(int k=0; k<4; k++)
				{
					rDx = i + dxArr[k];
					rDy = j + dyArr[k];
					if(curveMap[rDx][rDy] == 1) cnt++;
				}
				if(cnt == 4) result++;
			}
		}
		System.out.println(result);
	}
	public static void drawCurve(int index)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		startX = inputMap[index][1]; // x , y 위치 바꾸기  
		startY = inputMap[index][0];
		int direction = inputMap[index][2]; // direction info
		int generation = inputMap[index][3]; // generation info
		arr.add(direction);  
		for(int i=0; i < generation; i++)
		{
			for(int j = arr.size()-1 ; j >=0 ; j--)
			{
				int nextCurve = direction(arr.get(j));
				arr.add(nextCurve);
			}
		}
		
		curveMap[startX][startY]= 1;
		for(int i=0; i< arr.size(); i++)
		{
			move(arr.get(i));
			curveMap[startX][startY]= 1;
		}
		arr.clear();
	}
	public static int direction(int dir) {
		int result =0;
		switch(dir)
		{
		case 0:result=1;break;
		case 1:result=2;break;
		case 2:result=3;break;
		case 3:result=0;break;
		}
		return result;
	}
	public static void move(int dir) {
		switch(dir) 
		{
		case 0: startY+=1; break;
		case 1: startX-=1; break;
		case 2: startY-=1; break;
		case 3: startX+=1; break;
		}
	}
	
}




