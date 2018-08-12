package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z 
 */
public class baek1074 {

	static final int MAX = 32768; // 2^15
	// static int[][] map = new int[MAX][MAX]; ==> heap memory error
	static int N, r, c; // ( 항상 2^N * s^N )   찾을 좌표값 r, c  
	static int s , mid, e; // 시작, 중간, 끝 점 
	static int[] dxArr = {0 ,0, 1, 1}; // Z 이동 경로 좌표 
	static int[] dyArr = {0 ,1, 0, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		s = mid = 0; e = 1;
		for(int i=0; i< N; i++) e *= 2; // 2 ^ N 구하기 
		
		solve(0,0,0);
		
	}
	public static void solve(int dx, int dy, int cnt) // 4분할 하면서 재귀 반복 
	{
		int mid = 0;
		if(e - s == 2) { // Z 검색! 2 x 2 모양이 나올때까지 1/4 로 계속해서 분할 !
			int resultCnt = cnt;
			
			for(int i=0; i<4; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(nx == r && ny == c) { // 목표 좌표값 찾음 
					System.out.println(resultCnt);
					return;
				}
				resultCnt++;
			}
			return;
		}
		else mid = (s + e) / 2;  // 중간 값 찾아내서 목표점을 확인후 4개의 사분면 중 선택해서 재귀 반복 !
		e = mid;
		
		if(mid + dx > r && mid + dy <= c) solve(dx, dy+mid, (mid*mid) + cnt); // 1사분면 이동해야 하는 경우
		else if(mid + dx > r && mid + dy > c) solve(dx, dy, cnt); // 2사분면 이동해야 하는 경우 
		else if(mid + dx <= r && mid + dy > c) solve(dx+mid, dy, (mid*mid*2) + cnt); // 3사분면 이동해야 하는 경우
		else if(mid + dx <= r && mid + dy <= c) solve(dx+mid, dy+mid, (mid*mid*3) + cnt); // 4사분면 이동해야 하는 경
		
	}
}









