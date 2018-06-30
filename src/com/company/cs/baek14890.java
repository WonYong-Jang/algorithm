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
	static int N, L, result = 0; // L : 경사로 길이 
	static int[] dxArr = {0, 1, 0, -1} , dyArr = {1, 0, -1, 0}; // 동남서북  
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
		for(int i=1; i<= N; i++) // 행 별로 확인 동쪽 방향  
		{
			dfs(i, 1, 0);
			init();// visited 초기화 작업 
		}
		
		for(int i=1; i<= N; i++)
		{
			dfs(1, i, 1);  // 열별로 확인 남쪽 방향  
			init();// visited 초기화 작업
		}
		System.out.println(result);
	}
	public static void dfs(int dx, int dy, int dir)
	{
		if(isCheck(dx,dy,dir)) 
		{
			result++; return; // 행, 열 별로 확인 후 모든 조건에 만족할 경우 count 
		}
		int rDx = dx + dxArr[dir];
		int rDy = dy + dyArr[dir];
		int target = map[dx][dy] ,cValue = map[rDx][rDy]; // 다음 경사 확인 
		
		if(visited[rDx][rDy] == 0) // 이미 경사로를 놓은 자리인지 확인  
		{
			if(target == cValue) dfs(rDx,rDy, dir); // flat 한 경우
			else if(target > cValue && target - cValue == 1) { // 경사로 차이 1, 
				if(!(isSlope(rDx,rDy,dir, 1 ))) return;
				
				for(int i=0; i< L-1; i++) { // 그 다음 값으로바로 이동 
					rDx += dxArr[dir];
					rDy += dyArr[dir];
				}
				dfs(rDx,rDy,dir);
			}
			else if(target < cValue && cValue - target == 1) { // 경사로 차이 1
				int backDir = direction(dir);
				if(!(isSlope(dx,dy,backDir, 1))) return;
				dfs(rDx,rDy,dir);
			}
			else return; // 경사로 2 이상 차이  
		}
		
	}
	public static boolean isSlope(int dx, int dy, int dir, int cnt) // 경사로가 있을때 경사로 길이만큼 확인 
	{
		if(visited[dx][dy]== 1) return false;
		visited[dx][dy] = 1;
		
		if(cnt == L) return true; // 해당 경사로 길이 만큼  
		int rDx = dx + dxArr[dir], rDy = dy + dyArr[dir];
		if(!(isRange(rDx,rDy))) return false; //범위 확인 
		
		if(map[dx][dy] == map[rDx][rDy]) return isSlope(rDx,rDy,dir, cnt+1);
		return false;
	}
	public static boolean isCheck(int dx, int dy, int dir) // 행, 열이 전체가 다 연결이 되었는지 확인 
	{
		if(dir ==0)
		{
			if(dy ==N) return true; // 경사로를 지나서 끝까지 문제 없이 통과 한 경우  
		}
		else {
			if(dx ==N) return true;
		}
		return false;
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
	
	public static void init() {
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				visited[i][j] = 0;
	}
	public static boolean isRange(int dx, int dy)
	{
		if(dx >=1 && dy>=1 && dx<= N && dy <= N) return true;
		else return false;
	}
}
