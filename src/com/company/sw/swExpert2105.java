package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 디저트 까페 ! 
 */
public class swExpert2105 {

	static int[][] map = new int[25][25];
	static int[] output = new int[105];
	static int sdx, sdy , N, ans;
	static int[] dxArr = {1, 1, -1, -1}, dyArr = {1, -1, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			init();
			
			ans = -1;
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
				for(int j=1; j<= N; j++)
				{
					// 가장 자리와 시작해봤자 모양 안나오면 제외 
					if(j == 1 || j == N || i >= N-1) continue; 
					output[map[i][j]]++; // 먹고 출발 
					sdx= i; sdy = j; // 시작점 정하고 시작 
					solve(i, j, 0, 1 , 1);
					output[map[i][j]]--;
				}
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int dx, int dy, int dir, int cnt, int chk)
	{
		if(dx == sdx && dy == sdy && cnt != 1 && chk == 4) // chk 방향 변환 4번 다 한 경우 확인 
		{
			ans = max(ans, cnt);
			return;
		}
		
		int nx = dx + dxArr[dir];
		int ny = dy + dyArr[dir];
		if(!isRange(nx, ny)) return; // 범위 넘어갈때 
		if(nx ==sdx && ny == sdy && chk == 4) { // 다음이 시작점 일때 
			solve(nx, ny, dir, cnt, chk);
		}
		else if( output[map[nx][ny]] > 0 ) return; // 중복 숫자 제거 
		else 
		{
			output[map[nx][ny]]++;
			solve(nx, ny, dir, cnt+1, chk);
			solve(nx, ny, (dir+1) % 4, cnt+1, chk + 1); // 방향 바꿈 
			output[map[nx][ny]]--;
		}
		
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		for(int i=1; i<= 100; i++) // 디저트 체크 
			output[i] = 0;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy>=1 && dx<= N && dy<= N;
	}
}




