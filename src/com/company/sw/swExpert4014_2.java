package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 활주로 건설 
 */
public class swExpert4014_2 {
	
	static int N, X, ans;
	static int[][] map = new int[25][25];
	static int[][] visit = new int[25][25];
	static int[] dxArr = {-1, 0, 1, 0 }, dyArr = {0, 1, 0, -1}; // 북 동 남 서 
	static int[] back = {2, 3, 0, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			ans =0;
			init();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
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
				solve(i, 1 , 1, map[i][1]);
			}
			
			init();
			
			for(int i=1; i<= N; i++)
			{
				solve(1, i , 2, map[1][i]);
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int dx, int dy, int dir, int target)
	{
		int nx = dx + dxArr[dir];
		int ny = dy + dyArr[dir];
		
		if(!isRange(nx, ny)) {
			ans++; return;
		}
		if(visit[nx][ny] == 1) return;
	
		if(map[nx][ny] == target) solve(nx, ny, dir, target);
		else if(map[nx][ny] > target && map[nx][ny] - target == 1) 
		{
			if(check(dx,dy, back[dir], 1, map[dx][dy]))
			{
				solve(nx, ny,dir, map[nx][ny]);
			}
			else return;
		}
		else if(map[nx][ny] < target && target - map[nx][ny] == 1) {
			if(check(nx, ny, dir, 1, map[nx][ny])) {
				nx = dx ; ny = dy; // 다음 갈 방향 잡기 
				for(int i=0; i<X; i++)
				{
					nx+=dxArr[dir]; 
					ny+=dyArr[dir];
				}
				solve(nx, ny, dir, map[nx][ny]);
			}
			else return;
		}
	}
	public static boolean check(int dx, int dy, int dir, int cnt, int target)
	{
		if(visit[dx][dy] == 1 || map[dx][dy] != target) return false;
		else {
			int nx = dx + dxArr[dir];
			int ny = dy + dyArr[dir];
			visit[dx][dy] = 1;
			if(cnt == X) return true;
			else {
				if(!isRange(nx, ny)) return false;
				else return check(nx, ny, dir, cnt+1, target);
			}
		}
	}
	public static void init()
	{
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				visit[i][j] = 0;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
}



