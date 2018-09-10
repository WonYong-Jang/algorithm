package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비숍 
 */
public class baek1799 {
	
	// O( 2^N*N) ==> O( 2^(N/2*N/2) )  ??
	// 흑 과 백 체크 무늬로 나눈부분 합 ==> 시간 복잡도 O( 2^100 ) ==> O( 2^5*5 )
	static int N, cnt;
	static int[] ans = new int[2]; 
	static int[][] map = new int[11][11];
	static int[][] colorArr = new int[11][11];
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
				if(i % 2 == 0 ) colorArr[i][j] = j % 2;
				else if(i % 2 == 1) colorArr[i][j] = (j + 1) % 2;
			}
		}
		
		solve(-1,1,0); // 흑 나눠서 계산 
		solve(-1,1,1); // 백 
		
		System.out.println(ans[0]+ans[1]);
	}
	public static void solve(int index, int cnt, int color)
	{
		
		int dx=0, dy=0;
		for(int i=index+1; i< N * N; i++)
		{
			dx = i / N;
			dy = i % N;
			if(map[dx][dy] == 0 ) continue;
			if( colorArr[dx][dy] != color) continue; // 다른 색 검사하는 경우 패스
			
			if(isPromising(i, cnt))
			{
				ans[color] = max(ans[color], cnt); // 가장 많은 비숍 갯수 구하기 
				check[cnt] = i; 
				solve(i,cnt+1,color);
			}
		}
		check[cnt] = -1;
	}
	public static boolean isPromising(int index, int cnt) // 현재 가지고 있는 비숍 대각선들 확인하기 위해 
	{
		int sdx =0, sdy =0, edx =0, edy =0;
		edx = index / N;
		edy = index % N;
		
		for(int i=1; i< cnt; i++)
		{
			sdx = check[i] / N;
			sdy = check[i] % N;
			// 대각선에 있는지 확인 
			if( (sdx > edx ? sdx - edx : edx - sdx) == (sdy > edy ? sdy - edy : edy - sdy) ) return false;
		}
		return true;
	}
	public static void debug()
	{
		for(int i=1; i<= 30; i++)
		{
			System.out.print(check[i]+" ");
		}
		
		System.out.println();
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		for(int i=0; i< N*N; i++) check[i] = -1;
	}
}
