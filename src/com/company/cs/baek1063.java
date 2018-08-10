package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 킹 
 */
public class baek1063 {

	static final int N = 8;
	static int[][] map = new int[N+1][N+1];
	static int[] dxArr = {-1 ,0, 1, 0, -1, -1, 1, 1}; // 북, 동, 남, 서, 북동, 북서, 남동, 남서 ( 0 ~ 7 )  
	static int[] dyArr = {0, 1, 0, -1, 1, -1, 1, -1};
	
	static String str1, str2;
	static int K, kx, ky, sx, sy; // 킹 위치 / 돌 위치 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dx=0, dy=0;
		
		str1 = st.nextToken(); // 킹의 위치
		dx = str1.charAt(1) - '0'; dy = str1.charAt(0) - 'A' + 1; // int 변환
		dx = N + 1 - dx; // 예 ) 행 가장 아래 1 설정을 8로 바꿈 
		map[dx][dy] = 1; // 킹의 위치 set 
		kx = dx; ky = dy;
		
		str2 = st.nextToken(); // 돌의 위치
		dx = str2.charAt(1) - '0'; dy = str2.charAt(0) - 'A' + 1; // int 변환 
		dx = N + 1 - dx; // 예 ) 행 가장 아래 1 설정을 8로 바꿈 
		map[dx][dy] = 2; // 돌의 위치 set
		sx = dx; sy = dy;
		
		K = Integer.parseInt(st.nextToken());
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			solve(st.nextToken());
		}
		
		ans(kx,ky);
		System.out.println();
		ans(sx,sy);
		
	}
	public static void solve(String ch)
	{
		int ndx=0, ndy=0, idx=0; // 다음으로 갈 방향  
	
		switch(ch)
		{
		case "T": idx=0; break;
		case "R": idx=1; break;
		case "B": idx=2; break;
		case "L": idx=3; break;
		case "RT": idx=4; break;
		case "LT": idx=5; break;
		case "RB": idx=6; break;
		case "LB": idx=7; break;
		}
		
		ndx = dxArr[idx] + kx;
		ndy = dyArr[idx] + ky;
		if(isRange(ndx,ndy)) // 범위 내로 들어올때만 이동 
		{
			if(ndx == sx && ndy == sy) // 킹 위치와 돌위치가 같은 경우 
			{
				int nsx = sx + dxArr[idx]; // 돌 또한 같은 방향으로 이동 
				int nsy = sy + dyArr[idx];
				
				if(isRange(nsx,nsy)) // 돌 이동 가능하면 돌, 킹 둘다 이동 
				{
					map[ndx][ndy] = 1; map[nsx][nsy] = 2;
					kx = ndx; ky = ndy; sx = nsx; sy = nsy; // 좌표값 업데이트 
				}
			}
			else { // 왕만 이동해도 되는 경우 
				map[ndx][ndy] = 1; map[kx][ky] = 0; // 기존값 지우고 왕의 위치 업데이트 
				kx = ndx ; ky = ndy;
			}
		}
	}
	public static void ans(int dx, int dy)
	{
		int[] dyIdx = {0,8,7,6,5,4,3,2,1};
		char result =0;
		switch(dy)
		{
		case 1: result= 'A'; break;
		case 2: result= 'B'; break;
		case 3: result= 'C'; break;
		case 4: result= 'D'; break;
		case 5: result= 'E'; break;
		case 6: result= 'F'; break;
		case 7: result= 'G'; break;
		case 8: result= 'H'; break;
		}
		System.out.print(result);
		System.out.print(dyIdx[dx]);
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >= 1 && dx <= N && dy <= N;
	}
}







