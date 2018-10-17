package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가스관 
 */
public class baek2931 {

	static int N, M, sdx, sdy, edx, edy, tdx, tdy, ans; // 시작점과 끝점 10 , 11 
	static int[][] map = new int[30][30];
	static int[][] visit = new int[30][30];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static int[] back = {2,3,0,1}; // 반대 방향 인덱스 
	static int[] pipe = {5, 6, 3, 9, 12, 10, 15};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = -1;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp = str.charAt(j-1);
				int num =0;
				if(temp == '.') num = -1;
				else if(temp == 'M') {
					sdx = i; sdy = j;
					num =10;
				}
				else if(temp == 'Z') {
					edx = i; edy = j;
					num =11;
				}
				else if(temp == '|') num =0;
				else if(temp == '1') num =1;
				else if(temp == '2') num =2;
				else if(temp == '3') num =3;
				else if(temp == '4') num =4;
				else if(temp == '-') num =5;
				else if(temp == '+') num =6;
				map[i][j] = num;	
			}
		}
		visit[sdx][sdy] = 1;
		visit[edx][edy] = 1;
		solve(sdx,sdy,-1);
		solve(edx,edy,-1);
		check();
		char tmp = ' ';
		if(ans == 0) tmp = '|';
		else if(ans == 1) tmp = '1';
		else if(ans == 2) tmp = '2';
		else if(ans == 3) tmp = '3';
		else if(ans == 4) tmp = '4';
		else if(ans == 5) tmp = '-';
		else if(ans == 6) tmp = '+';
		
		System.out.println(tdx+" "+tdy+" "+ tmp);
	}
	public static void solve(int dx, int dy, int target) // 누수된 좌표 찾기 
	{
		int nx =0, ny =0;
		if(target == -1) 
		{
			boolean check = false;
			for(int i=0; i<4; i++) // 연결 가스관 찾기 
			{
				nx = dx + dxArr[i];
				ny = dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
				if(map[nx][ny] >= 0) { // 처음 연결된 가스관 찾았다면 
					check = true;
					break;
				}
			}
			if(check)
			{
				visit[nx][ny] = 1;
				solve(nx, ny, map[nx][ny]); // 시작점, 끝점과 연결된 점
			}
		}
		else  
		{
			for(int i=0; i<4; i++)
			{
				if( (pipe[target] & (1 << i)) >0 ) {
					nx = dx + dxArr[i];
					ny = dy + dyArr[i];
					if(visit[nx][ny] == 1) continue;
					
					if(map[nx][ny] == -1) {
						tdx = nx; tdy = ny;
						
						return;
					}
					else {
						visit[nx][ny] = 1;
						solve(nx,ny,map[nx][ny]);
					}
				}
			}
		}
	}
	public static void check()
	{
		for(int i=0; i<=6; i++)
		{
			map[tdx][tdy] = i; // 누수된 곳에 가스관 넣어보고 확인 
			if(go()) {
				ans = i;
				break;
			}
		}
	}
	public static boolean go()
	{
		boolean result = true;
		for(int i=0; i<4; i++)
		{
			int nx = tdx + dxArr[i];
			int ny = tdy + dyArr[i];
			if(!isRange(nx, ny)) continue;
			int backDir = (1 << back[i]);
			int curDir = (1 << i);
			boolean cur = false, next = false;
			if( (pipe[map[tdx][tdy]] & curDir) > 0) cur = true;
			if( map[nx][ny] >= 0) 
			{
				if((pipe[map[nx][ny]] & backDir) > 0) next = true;
			}
			
			if( (!cur && next) || (cur && !next) ) return false;
		}
		
		return result;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy >=1 && dx<= N && dy<= M;
	}
}







