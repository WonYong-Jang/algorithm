package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 열쇠 
 */
public class baek9328 {

	static int H, W, ans, keys;
	static char[][] map = new char[105][105];
	static int[][] visit = new int[105][105];
	static Queue<Node> que = new LinkedList<>();
	static ArrayList<Door> doors = new ArrayList<>();
	static int[] dxArr = {-1, 0 ,1, 0}, dyArr = {0 ,1, 0 , -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()) + 1; // 한칸 늘리기 
			W = Integer.parseInt(st.nextToken()) + 1;
			String str = "";
			init(); // 전체 초기화 
			for(int i=1; i< H; i++)
			{
				str = br.readLine();
				for(int j=1; j< W; j++)
				{
					map[i][j] = str.charAt(j-1);
				}
			}
			str = br.readLine();
			keys = 0;
			if(!str.equals("0")) 
			{
				for(int i=0; i< str.length(); i++)
				{
					keys += (1 << str.charAt(i) - 'a');
				}
			}
			que.add(new Node(0,0));
			visit[0][0] = 1;
			solve();
			boolean flag = true;
			while(true)
			{
				if(flag == false ) break;
				flag = false;
				for(int i=0; i< doors.size(); i++)
				{
					if(doors.get(i).type == -1) continue;
					int nx = doors.get(i).dx;
					int ny = doors.get(i).dy;
					if((keys & (1 << map[nx][ny] -'A' )) > 0 )
					{
						flag = true;
						doors.get(i).type = -1;
						que.add(new Node(nx, ny));
					}
				}
				solve();
			}
			//debug();
			
			bw.write(ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] == '*') continue;
				
				if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') 
				{ // 벽일때 
					if((keys & (1 << map[nx][ny] - 'A')) ==0 )
					{
						doors.add(new Door(nx, ny, 1));
						visit[nx][ny] = 1; // 방문 체크만하고 일단 continue 
						continue;
					}
				}
				else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z')
				{
					if((keys & (1 << map[nx][ny] - 'a')) == 0 )
					{
						keys += (1 << map[nx][ny] - 'a');
					}
				}
				else if(map[nx][ny] == '$')
				{
					ans++;
				}
				que.add(new Node(nx,ny));
				visit[nx][ny] = 1;
			}
		}
	}
	public static boolean isRange(int dx, int dy) // 상하좌우 한칸 늘린 범위 
	{
		return dx>=0 && dy>=0 && dx<= H && dy <= W;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static void init()
	{
		doors.clear();
		ans = 0;
		for(int i=0; i<= H; i++)
		{
			for(int j=0; j<= W; j++)
			{
				visit[i][j] = 0;
				map[i][j] = '.';
			}
		}
	}
	public static void debug()
	{
		for(int i=0; i<= H; i++)
		{
			for(int j=0; j<= W; j++)
			{
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx =a; dy =b;
		}
	}
	static class Door {
		int dx, dy, type; // -1 이면 종료 
		Door(int a, int b, int c) {
			dx =a; dy =b; type =c;
		}
	}
}
