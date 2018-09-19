package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 사다리 조작 
 */
public class baek15684 {

	static int N, M, H, ans; // 세로선 , 가로선, 세로선 마다 놓을수 있는 가로선 위치  ( H , N) 좌표 
	static int[][] map = new int[35][15];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int dx = 0 , dy = 0;
		ans = - 1;
		for(int i=0; i< M; i++)
		{
			st = new StringTokenizer(br.readLine());
			// -1 왼쪽이동  / 1 오른쪽이동 ==>  플래크 표시 해두기 
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = 1; // 오른쪽 이동 
			map[dx][dy+1] = -1; // 왼쪽 이동 
		}
		// 가로선 0개 부터 3개 까지 둘수 있다.
		
		for(int i=0; i<=3; i++)
		{
			solve(-1 , 0, i);
			if(ans != -1) break;
		}
		
		System.out.println(ans);
	}
	public static void solve(int index ,int cnt, int depth)
	{
		if(depth == cnt)
		{
			if(check()) {
				ans = depth;
				return;
			}
		}
		else 
		{
			for(int i= index+1; i< H * N; i++)
			{
				int dx = i / N + 1;
				int dy = i % N + 1;
				if(dy + 1 > N) continue;
				if(map[dx][dy] != 0 || map[dx][dy+1] != 0) continue; // 범위 넘거나 이미 가로선 있는 경우 패스 
				map[dx][dy] = 1; // 오른쪽 이동 
				map[dx][dy+1] = -1; // 왼쪽 이동
				solve(i, cnt+1, depth);
				map[dx][dy] = 0;  // 해제 
				map[dx][dy+1] = 0; 
				
				if(ans != -1) return;
			}
		}
		
	}
	public static boolean check() // 각 세로선 마다 체크 하기 
	{
		boolean flag = true;
		for(int i=1; i<= N; i++ ) // i번 세로선 i 나오는지 첵크 
		{
			int target = i;
			for(int j=1; j<= H; j++)
			{
				if(map[j][target] == -1 ) target--; // 왼쪽 이동 
				else if(map[j][target] == 1) target++; // 오른쪽 이동 
			}
			if(i != target) return false; // 같은 선이 안나오면 
		}
		return flag;
	}
}
