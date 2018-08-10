package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기 
 */
public class baek1018 {

	static int[][] map = new int[51][51];
	static int N, M, ans = 55 * 55;
	static int[][] white = { //
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0}
	};
	static int[][] black = {
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 1}
	};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int temp = 0;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++) // input 
			{
				if(str.charAt(j-1) == 'W') temp = 0; // 흰색 0으로 설정 
				else temp = 1; // 검정색 1로 설정 
				map[i][j] = temp;
			}
		}
	
		for(int i=1; i<= N - 7; i++) // 8 x 8 만큼 첫번재 인덱스 기준으로 검사 진행 
		{
			for(int j=1; j<= M - 7; j++)
			{
				solve(i, j);
			}
		}
		System.out.println(ans);
	}
	public static void solve(int dx, int dy)
	{
		int temp =0;
		// 배열의 시작 색깔만 확인해서 흰색으로 시작한 경우 white 배열을
		// 검은색으로 시작한경우는 black 배열로 확인을 해주었는데
		// 흰색으로 시작한 경우에서 black 배열로 적용해서 최소가 나올수도 있기 때문에 둘다 비교해 줌 
		for(int i=dx, nx =0 ; i<= dx+7; i++, nx++)
		{
			for(int j=dy, ny=0; j<= dy+7; j++, ny++)
			{
				if(map[i][j] != white[nx][ny]) temp++;
			}
		}
		ans = min(temp, ans);
		temp = 0;
		for(int i=dx, nx =0 ; i<= dx+7; i++, nx++)
		{
			for(int j=dy, ny=0; j<= dy+7; j++, ny++)
			{
				if(map[i][j] != black[nx][ny]) temp++;
			}
		}
		ans = min(temp, ans);
	}
	public static int min(int a, int b)
	{
		return a > b ? b :a ;
	}
}




