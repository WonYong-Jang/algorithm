package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 통나무 옮기기   
 */
public class baek1938 {

	static int N, ans;
	static char[][] map = new char[55][55];
	static int[][][] visit = new int[2][55][55]; 
	static Queue<Node> que = new LinkedList<>();
	static Node start, end;
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	static int[][] turndx = {{0,0}, {-1, 1}};
	static int[][] turndy = {{-1,1}, {0, 0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = new Node(0,0,0,0,0,0,0);
		end = new Node(0,0,0,0,0,0,0);
		int chk1 = 0, chk2 = 0;
		init(); // 초기화 
		ans = 0;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= N; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == 'B' && chk1 ==0) {
					start.sdx = i; start.sdy = j;
					chk1++;
				}
				else if(temp == 'B' && chk1 ==1) {
					start.mdx = i; start.mdy = j;
					chk1++;
				}
				else if(temp == 'B' && chk1 ==2) {
					start.edx = i; start.edy = j;
					if(start.mdy == j) { // 세로가 같으니까 type 0
						start.type = 0;
					}
					else {
						start.type = 1;
					}
				}
				if(temp == 'E' && chk2 ==0) {
					end.sdx = i; end.sdy = j;
					chk2++;
				}
				else if(temp == 'E' && chk2 ==1) {
					end.mdx = i; end.mdy = j;
					chk2++;
				}
				else if(temp == 'E' && chk2 ==2) {
					end.edx = i; end.edy = j;
					if(end.mdy == j) { // 세로가 같으니까 type 0
						end.type = 0;
					}
					else {
						end.type = 1;
					}
				}
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		que.add(start);
		visit[start.type][start.mdx][start.mdy] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			if(n.mdx == end.mdx && n.mdy == end.mdy && n.type == end.type) {
				ans = visit[n.type][n.mdx][n.mdy];
				return;
			}
			int sdx=0, sdy =0, mdx=0, mdy=0, edx=0, edy=0; 
			for(int i=0; i<4; i++) // 회전 없이 네 방향 확인 
			{
				sdx = n.sdx + dxArr[i];
				sdy = n.sdy + dyArr[i];
				mdx = n.mdx + dxArr[i];
				mdy = n.mdy + dyArr[i];
				edx = n.edx + dxArr[i];
				edy = n.edy + dyArr[i];
				if(!isRange(sdx, sdy) || !isRange(mdx, mdy) || !isRange(edx, edy)) continue;
				if(map[sdx][sdy] == '1' || map[mdx][mdy] == '1' || map[edx][edy] == '1') continue;
				if(visit[n.type][mdx][mdy] == -1 || visit[n.type][mdx][mdy] > visit[n.type][n.mdx][n.mdy] + 1)
				{
					visit[n.type][mdx][mdy] = visit[n.type][n.mdx][n.mdy] + 1;
					que.add(new Node(sdx,sdy,mdx,mdy,edx,edy,n.type));
				}
			}
			
			boolean check = true;
			if(n.type == 0) // 세로 방향 이였을 경우 turn
			{
				check = true;
				for(int i=0; i<2; i++) // 회전 없이 네 방향 확인 
				{
					sdx = n.sdx + turndx[0][i];
					sdy = n.sdy + turndy[0][i];
					mdx = n.mdx + turndx[0][i];
					mdy = n.mdy + turndy[0][i];
					edx = n.edx + turndx[0][i];
					edy = n.edy + turndy[0][i];
					if(!isRange(sdx, sdy) || !isRange(mdx, mdy) || !isRange(edx, edy)) {
						check = false;
						break;
					}
					if(map[sdx][sdy] == '1' || map[mdx][mdy] == '1' || map[edx][edy] == '1') {
						check = false;
						break;
					}
				}
				if(check) // 회전 가능 
				{
					int next = (n.type + 1) % 2; 
					if(visit[next][n.mdx][n.mdy] == - 1 || visit[next][n.mdx][n.mdy] > visit[n.type][n.mdx][n.mdy] + 1)
					{
						visit[next][n.mdx][n.mdy] = visit[n.type][n.mdx][n.mdy] + 1;
						que.add(new Node(n.mdx, n.mdy-1, n.mdx, n.mdy, n.mdx, n.mdy+1, next));
					}
				}
			}
			else if(n.type == 1) // 가로 방향 이였을 경우 turn
			{
				check = true;
				for(int i=0; i<2; i++) // 회전 없이 네 방향 확인 
				{
					sdx = n.sdx + turndx[1][i];
					sdy = n.sdy + turndy[1][i];
					mdx = n.mdx + turndx[1][i];
					mdy = n.mdy + turndy[1][i];
					edx = n.edx + turndx[1][i];
					edy = n.edy + turndy[1][i];
					if(!isRange(sdx, sdy) || !isRange(mdx, mdy) || !isRange(edx, edy)) {
						check = false;
						break;
					}
					if(map[sdx][sdy] == '1' || map[mdx][mdy] == '1' || map[edx][edy] == '1') {
						check = false;
						break;
					}
				}
				if(check) // 회전 가능 
				{
					int next = (n.type + 1) % 2; 
					if(visit[next][n.mdx][n.mdy] == - 1 || visit[next][n.mdx][n.mdy] > visit[n.type][n.mdx][n.mdy] + 1)
					{
						visit[next][n.mdx][n.mdy] = visit[n.type][n.mdx][n.mdy] + 1;
						que.add(new Node(n.mdx-1, n.mdy, n.mdx, n.mdy, n.mdx+1, n.mdy, next));
					}
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= N;
	}
	public static void init()
	{
		for(int k=0; k<2; k++)
			for(int i=1; i<= N; i++)
				for(int j=1; j<= N; j++)
					visit[k][i][j] = -1;
	}
	static class Node {
		int sdx, sdy, mdx, mdy, edx, edy, type; // 0 : 세로 , 1 : 가로
		Node(int a, int b, int c, int d, int e, int f, int g) {
			sdx=a; sdy=b; mdx=c; mdy=d; edx=e; edy=f; type =g;
		}
	}
}
