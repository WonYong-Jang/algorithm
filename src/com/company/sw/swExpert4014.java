package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 활주로 건설  
 */
public class swExpert4014 {

	static int[][] map = new int[22][22];
	static int[][] visited = new int[22][22];
	static int[] dxArr = {0, 1, 0, -1}, dyArr = {1, 0, -1, 0}; // 동 남 서 북  
	static int N, K,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k <= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result=0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<= N; i++) // 행 별로 검사  
			{
				dfs(i, 1, 0);
				initMap(i,1,0); 
			}
			
			for(int i=1; i<= N; i++) // 열 별로 검사  
			{
				dfs(1, i, 1);
				initMap(1,i, 1); 
			}
			System.out.println("#" + k + " " + result);
		}
	}
	public static void dfs(int dx, int dy, int dir)
	{
		if(isCheck(dx,dy,dir)) {
			result++;
			return;
		}
		int rDx = dx + dxArr[dir], rDy = dy + dyArr[dir];
		int nTarget = map[rDx][rDy];
		int cTarget = map[dx][dy];
		if( cTarget == nTarget ) dfs(rDx, rDy, dir);
		else if( cTarget > nTarget && cTarget - nTarget == 1) {
			if(visited[rDx][rDy]==1) return;
			visited[rDx][rDy]=1;
			
			if(!check(rDx,rDy,dir,1)) return;
			for(int i=0; i< K-1;i++)
			{
				rDx+=dxArr[dir];
				rDy+=dyArr[dir];
			}
			dfs(rDx,rDy,dir);
		}
		else if( nTarget > cTarget && nTarget - cTarget == 1) {
			if(visited[dx][dy]==1) return;
			visited[dx][dy] = 1;
			
			int back = direction(dir);
			if(!check(dx,dy,back,1)) return;
			dfs(rDx,rDy,dir);
		}
		else return;
		
	}
	public static boolean check(int dx,int dy,int dir,int cnt)
	{
		if(cnt == K) return true;
		int rDx = dx + dxArr[dir], rDy = dy + dyArr[dir];
		int nTarget = map[rDx][rDy];
		int cTarget = map[dx][dy];
		if(nTarget == cTarget && visited[rDx][rDy] ==0) {
			visited[rDx][rDy]= 1;
			return check(rDx,rDy,dir,cnt+1);
		}
		else return false;
	}
	public static boolean isCheck(int dx, int dy ,int dir)
	{
		boolean flag = false;
		if(dir == 0 && dy == N) flag = true;
		else if(dir == 1 && dx == N) flag = true;
		return flag;
	}
	public static int direction(int dir)
	{
		int result =0;
		switch(dir) // 동 남 ==> 서 북   
		{
		case 0:result=2;break;
		case 1:result=3;break;
		}
		return result;
	}
	public static void initMap(int dx,int dy,int dir) {
		
		for(int i=1; i<= N; i++)
		{
			if(dir == 0) visited[dx][i]=0;
			else visited[i][dy] = 0;
		}
	}
}


