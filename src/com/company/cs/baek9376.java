package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek9376 {

	static int H, W, ans;
	static char[][] map = new char[101][101];
	static int[][][] visit = new int[101][101][2]; // 0 : 첫번째 죄수 , 1: 두번째 죄수 	
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static int sdx, sdy, edx, edy;
	
	//static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k =1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int check = 0; // 죄소 1, 2 구분 
			for(int i=1; i<= H; i++)
			{
				String str = br.readLine();
				for(int j=1; j<= W; j++)
				{
					char temp = str.charAt(j-1);
					map[i][j] = temp;
					if(temp =='$') 
					{
						//que.add(new Node(i, j, check, 0)); // 죄수 위치 설정
						//visit[i][j][check] = 1; 
						if(check ==0 ) {
							sdx = i; sdy = j; // 죄수 1
							check++;
						}
						else {
							edx = i; edy = j; // 죄수 2 
						}
					}
				}
			}
			init();
			for(int i=0; i<4; i++)
			{
				visit[sdx][sdy][0] = 1;
				solve(sdx, sdy, 0, 0);
				visit[sdx][sdy][0] = 0;
			}
			System.out.println(ans);
		}
	}
	public static void solve(int dx, int dy, int num, int cnt)
	{
		//System.out.println(dx+" "+dy+" "+num+" "+cnt);
		
		if(num == 2) // 두개 다 도착  
		{
			ans = min(ans, cnt);
			return;
		}
		else if(num == 1) // 첫번째 죄수는 도착 , 두번째 죄수 탈출 중 
		{
			for(int i=0; i<4; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(!isRange(nx, ny)) { // 탈출 했을 때 
					solve(nx,ny, 2 , cnt); // 벽통과 갯수 그대로 가지고 감 
				}
				else if(map[nx][ny]== '*' || visit[nx][ny][num] == 1) continue;
				else if(map[nx][ny]== '#')
				{
					if(visit[nx][ny][0] == 1) solve(nx, ny, num, cnt);
					else {
						visit[nx][ny][1] = 1;
						solve(nx, ny, num, cnt+1);
						visit[nx][ny][1] = 0;
					}
				}
				else {
					visit[nx][ny][1] = 1;
					solve(nx, ny, num, cnt);
					visit[nx][ny][1] = 0;

				}
			}
		}
		else if(num ==0)
		{
			for(int i=0; i<4; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(!isRange(nx, ny)) { // 탈출 했을 때 
					solve(edx, edy, 1 , cnt); // 벽통과 갯수 그대로 가지고 감 
				}
				else if(map[nx][ny]== '*' || visit[nx][ny][num] == 1) continue;
				else if(map[nx][ny]== '#')
				{
					visit[nx][ny][0] = 1;
					solve(nx, ny, num, cnt+1);
					visit[nx][ny][0] = 0;
				}
				else
				{
					visit[nx][ny][0] = 1;
					solve(nx, ny, num, cnt);
					visit[nx][ny][0] = 0;
				}
			}
		}
	}
	public static void init()
	{
		ans = 100 * 105;
		for(int i=0; i<= H; i++)
		{
			for(int j=0; j<= W; j++)
			{
				for(int k=0; k<2; k++)
				{
					visit[i][j][k] = 0;
				}
			}
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy>=1 && dx <= H && dy <=W;
	}
	static class Node {
		int dx, dy, num, cnt; // 몇번 죄수 인지, 방문 몇개  통과 했는지 ! 
		Node(int a, int b, int c, int d) {
			dx = a; dy = b; num = c; cnt = d;
		}
	}
}
