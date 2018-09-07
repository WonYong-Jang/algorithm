package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비숍 
 */
public class baek1799 {

	static int N, cnt, ans;
	static int[][] map = new int[12][12];
	static int[] check = new int[105]; // 비숍 가능 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		init(); // 초기화 
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< N ; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dx =0, dy =0;
		for(int i=0; i< N*N; i++)
		{
			dx = i/N; dy = i%N;
			if(map[dx][dy] ==0 ) continue; // 비숍을 놓을 수 없는 곳 
			
			solve(i);
		}
	}
	public static void solve(int index)
	{
		if(!isPromising(index)) return;
		check[++cnt] = index;
		ans = max(ans, cnt); // 최대 비숍 찾기 
		if(index == N*N) return;
		
		int dx =0, dy =0;
		for(int i=index+1; i< N*N; i++)
		{
			dx = i/N; dy = i%N;
			if(map[dx][dy] ==0 ) continue; // 비숍을 놓을 수 없는 곳 
			
			solve(i);
		}
	}
	public static boolean isPromising(int index)
	{
		int sdx=0, sdy=0, edx=0, edy=0;
		for(int i=0; i<= cnt; i++) // 현재까지 가능한 비숍위치에서 추가 했을때 가능한지 검사 
		{
			sdx = check[i] / N;
			sdy = check[i] % N;
			edx = index % N;
			edy = index % N;
			// 대각선에 하나라도 겹치면 아웃 
			if( (sdx > edx ? sdx - edx : edx - sdx) == (sdy > edy ? sdy - edy : edy - sdy)) return false;
		}
		return true;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		cnt = -1; // 현재 비숍 가능 카운트 변수 
		for(int i=0; i< N*N; i++) check[i] = -1;
	}
}
