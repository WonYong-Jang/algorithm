package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 빵집 ( 백트래킹 ) 
 */
public class baek3109 {
	
	static int R, C, ans;
	static char[][] map = new char[10005][505];
	static int[][] visit = new int[10005][505];
	
	static int[] dxArr = {-1, 0, 1}, dyArr = {1, 1, 1}; // 세 방향만 확인 우선 순위 !! 최대한 위쪽으로  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0; 
		for(int i=1; i<= R; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= C; j++)
			{
				map[i][j] = str.charAt(j-1);
			}
		}
		
		for(int i=1; i<= R; i++) // 빵집 차례대로 검사 ! 
		{ 
			ans += solve(i,1);
		}
		bw.write(ans+"\n");
		bw.flush();
	}
	public static int solve(int dx, int dy) // 현재 연결 중인 빵집 인덱스 , (dx, dy) 좌표  
	{ 
		if(isPromising(dx,dy)) // 조건에 맞을때만 진행 
		{
			visit[dx][dy] = 1; // 방문 표시 ==> 방문표시 다시 지워줄 필요없음!!!!!!!!!!!!!가장 오른쪽부터 검사했으므로 시간초과 피하
			if(dy == C) { // 도착 
				return 1; // 도착했을때 1리턴해줌으로써 하나씩 더해나가기 
			}
			
			for(int i=0; i<3; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(solve(nx,ny) == 1) return 1;
			}
		}
		
		return 0;
	}
	public static boolean isPromising(int dx, int dy) // 백트래킹 가지치기 
	{
		if(dx < 1 || dy < 1 || dx > R || dy > C) return false; // 범위 검사 
		if(visit[dx][dy] == 1 || map[dx][dy] == 'x') return false; // 방문 또는 벽 검사 
		else return true;
	}
}





