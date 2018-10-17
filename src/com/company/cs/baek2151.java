package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 거울 설치 
 */
public class baek2151 {

	static int N, sdx, sdy, edx, edy, ans;
	static int[][][] visit = new int[4][55][55];
	static char[][] map = new char[55][55];
	static int[] reflect = new int[2];
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int chk = 0;
		ans = 50000;
		init();
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= N; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == '#' && chk ==0) {
					sdx = i; sdy =j;
					chk++;
				}
				else if(temp == '#' && chk == 1) {
					edx = i; edy = j;
				}
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		que.add(new Node(sdx,sdy, -1));
		visit[0][sdx][sdy] = 0; visit[1][sdx][sdy] = 0; // 시작 지점 0 초기화 
		visit[2][sdx][sdy] = 0; visit[3][sdx][sdy] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy) { // 도착점 확인 
				ans = min(ans, visit[n.dir][n.dx][n.dy]);
				continue;
			}
			
			int nx =0, ny = 0;
			if(n.dir == -1) // 시작일때 
			{
				for(int i=0; i<4; i++)
				{
					nx = n.dx + dxArr[i];
					ny = n.dy + dyArr[i];
					if(!isRange(nx, ny) || map[nx][ny] == '*') continue;
					que.add(new Node(nx, ny, i));
					visit[i][nx][ny] = 0;
				}
			}
			else
			{
				// 해당지점에서 거울 제외하고 이동할때 
				nx = n.dx + dxArr[n.dir];
				ny = n.dy + dyArr[n.dir]; // 
				if(isRange(nx, ny) && map[nx][ny] != '*')
				{
					if(visit[n.dir][nx][ny] == -1 || visit[n.dir][nx][ny] > visit[n.dir][n.dx][n.dy])
					{
						visit[n.dir][nx][ny] = visit[n.dir][n.dx][n.dy];
						que.add(new Node(nx, ny, n.dir));
					}
				}
				
				if(map[n.dx][n.dy] == '!') // 거울 일때 
				{
					int left = ( n.dir + 1 ) % 4;
					int right = ( n.dir + 3 ) % 4;
					reflect[0] = left; reflect[1] = right;
					for(int i=0; i<2; i++)
					{
						int curDir = reflect[i];
						nx = n.dx + dxArr[curDir];
						ny = n.dy + dyArr[curDir];
						if(isRange(nx, ny) && map[nx][ny] != '*')
						{
							if(visit[curDir][nx][ny] == -1 || visit[curDir][nx][ny] > visit[n.dir][n.dx][n.dy] + 1)
							{
								visit[curDir][nx][ny] = visit[n.dir][n.dx][n.dy] + 1; // 거울 하나 추가 
								que.add(new Node(nx, ny, curDir));
							}
						}
					}
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
		return dx>=1 && dy >=1 && dx<= N && dy <= N;
	}
	public static void init()
	{
		for(int k=0; k<4; k++)
			for(int i=1; i<= N; i++)
				for(int j=1; j<= N; j++)
					visit[k][i][j] = -1;
	}
	static class Node {
		int dx, dy, dir;
		Node(int a, int b, int c){
			dx=a; dy=b; dir=c;
		}
	}
}
