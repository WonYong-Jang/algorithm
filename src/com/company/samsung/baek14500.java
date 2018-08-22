package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트로미노 
 */
public class baek14500 {

	static int[][] data = new int[501][501];
	static int[][] visit = new int[501][501];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static int N, M, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int i=1; i<= N; i++) // input 
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 1;
				solve(i,j, 1, data[i][j]);
				exception(i,j);
				visit[i][j] = 0;
			}
		}
		System.out.println(ans);
	}
	public static void solve(int dx, int dy,int cnt, int sum) // dfs 로 진행 
	{
		if(cnt == 4) // 사이즈 4개 확인 후 가장 큰 값 저장 
		{
			ans = max(sum, ans);
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			int nx = dx + dxArr[i];
			int ny = dy + dyArr[i];
			if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
			
			visit[nx][ny] = 1;
			solve(nx,ny, cnt+1, sum + data[nx][ny]);
			visit[nx][ny] = 0;
		}
	}
	public static void exception(int dx, int dy) // ㅗ ,ㅜ , ㅏ ,ㅓ 찾기   
	{
		// 방향 마다 다 확인 
		if(dx-1 >= 1 && dy+2 <= M) ans = max(ans,data[dx][dy] +data[dx][dy+1]+data[dx][dy+2]+data[dx-1][dy+1]);// ㅗ
		if(dx+1 <= N && dy+2 <= M) ans = max(ans,data[dx][dy] +data[dx][dy+1]+ data[dx][dy+2]+ data[dx+1][dy+1]);// ㅜ
		if(dx+2 <= N && dy-1 >=1) ans = max(ans,data[dx][dy]+data[dx+1][dy]+data[dx+2][dy]+data[dx+1][dy-1]); // ㅓ
		if(dx+2 <= N && dy+1 <= M) ans = max(ans,data[dx][dy]+ data[dx+1][dy]+ data[dx+2][dy]+ data[dx+1][dy+1]); // ㅏ 
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx<= N && dy <= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	
}
