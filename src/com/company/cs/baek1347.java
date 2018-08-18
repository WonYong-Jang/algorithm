package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 미로 만들기 
 */
public class baek1347 {

	static int N, curDir; // 현재 가르키고 있는 방향 
	static int dx, dy; // 현재 위치 좌표
	static int sdx, sdy, edx, edy; // 시작점과 끝점 기록 
	static int[][] map = new int[103][103]; // 시작점이 정해져 있지 않으므로 중앙에 놓고 시작 
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; // 북 동 남 서  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		curDir = 2; // 처음 아래 방향 보고 있도록 설정
		
		int mid = 51; // N 을 기준으로 중간 값 계산 
		dx = dy = sdx = sdy = edx = edy = mid;
		map[dx][dy] = 1; // 시작점 방문 표시 
		if(N == 0)
		{
			System.out.println('.');
		}
		else 
		{
			String cmd = br.readLine();
			int nx=0, ny=0;
			for(int i =0; i<N; i++)
			{
				if(cmd.charAt(i) == 'F') // 해당방향으로 전진 
				{
					nx = dx + dxArr[curDir];
					ny = dy + dyArr[curDir];
					map[nx][ny] = 1;
					dx = nx; dy = ny; // 현재 좌표 업데이트 
					
					boundary(nx, ny);
				}
				else direction(cmd.charAt(i)); // 방향 전환 
			}
			
			for(int i=sdx; i<= edx; i++)
			{
				for(int j=sdy; j<= edy; j++)
				{
					if(map[i][j] == 1) System.out.print('.');
					else System.out.print('#');
				}
				System.out.println();
			}
		}
	}
	public static void direction(char dir)
	{	
		if(dir == 'R') // 오른쪽 방향 회전 
		{
			curDir = (curDir + 1) % 4;
		}
		else if(dir =='L') // 왼쪽 방향 회전 
		{
			curDir = ( curDir + 3 ) % 4;
		}
	}
	public static void boundary(int dx, int dy) // 해당 방향으로 전진할때마다 boundary 갱신 
	{
		sdx = min(sdx,dx); sdy = min(sdy,dy);
		edx = max(edx,dx); edy = max(edy,dy);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}


/**
5
FRFLF
 */









