package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 경사로  
 */
public class baek14890 {

	static int[][] map = new int[101][101];
	static int[][] visited = new int[101][101];
	static int N, L, result=0; // L : 경사로 길이 
	static int[] dxArr = {0, 1, 0, -1} , dyArr= {1, 0, -1, 0}; // 동남서북  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<= N; i++)
		{
			dfs(i, 0, 0);  // 행별로 확인 동쪽 방향  
		}
		
		for(int i=1; i<= N; i++)
		{
			dfs(0, i, 0);  // 열별로 확인 동쪽 방향  
		}
	}
	public static void dfs(int dx, int dy, int dir)
	{
		if(!(isRange(dx,dy))) return; // 범위 확인  ////////// 
		int target = map[dx][dy];
		int rDx = dx +dxArr[dir], rDy = dy + dyArr[dir];
		int cValue = map[rDx][rDy]; // 비교할 값
		
		if(target == cValue && isRange(rDx,rDy)) dfs(rDx, rDy, dir); // 같은 높이 
		else if(target > cValue && target - cValue == 1) 
		{
			rightBottom(rDx, rDy, dir, 1);
		}
		else if( target < cValue && cValue - target == 1) 
		{
			int back = direction(dir); // 해당 방향 반대 방향 확인 
			leftTop(dx,dy,back, 1);
		}
	}
	public static void rightBottom(int dx, int dy, int dir, int cnt) // 오른쪽 혹은 남쪽 방향 
	{
		int rDx = dx +dxArr[dir], rDy = dy + dyArr[dir];
		if(!isRange(rDx,rDy)) return;
		
		else {
			if( map[dx][dy] == map[rDx][rDy] ) rightBottom(dx,dy,dir,cnt+1);
		}
	}
	public static void leftTop(int dx, int dy, int dir, int cnt) //왼쪽 혹은 북쪽 방향  
	{
		int rDx = dx +dxArr[dir], rDy = dy + dyArr[dir];
	}
	public static int direction(int dir) // 반대 방향 지정 
	{
		int result=0;
		switch(dir)
		{
		case 0:result=2;break;
		case 1:result=3;break;
		case 2:result=0;break;
		case 3:result=1;break;
		}
		return result;
	}
	public static boolean isRange(int dx, int dy)
	{
		if(dx >=1 && dy>=1 && dx<= N && dy <= N) return true;
		else return false;
	}
}
