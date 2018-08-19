package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Puyo Puyo 
 */
public class baek11559 {
	
	static final int N = 12, M = 6;
	static int ans = 0;
	static char[][] map = new char[N+1][M+1];
	static int[][] visit = new int[N+1][M+1];
	static int[] dxArr= {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<= N; i++) // input 
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1);
			}
		}
		int checkNum =0;
		while(true)
		{
			checkNum = ans;
			
			start(); // 전체 맵 4연결 확인 후 제거 
			clear(); // 방문 기록 다시 제거 
			update();

			if(checkNum == ans) break; // 더이상 변화가 없으면 게임 종료 
		}
		
		System.out.println(ans);
		
	}
	public static void start()
	{
		int bump =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(visit[i][j] == 1) continue;
				bump += check(i,j);
			}
		}
		if(bump > 0) ans++;
	}
	public static int check(int dx, int dy) // 4개 이상 연결 되있는지 확인 
	{
		Queue<Node> temp = new LinkedList<>();
		
		que.clear();
		que.add(new Node(dx, dy));
		temp.add(new Node(dx, dy));
		visit[dx][dy] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			char target = map[n.dx][n.dy];
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx,ny) || target != map[nx][ny] || visit[nx][ny] == 1 || map[nx][ny]== '.') continue;
				temp.add(new Node(nx,ny));
				que.add(new Node(nx, ny));
				visit[nx][ny] = 1;
			}
		}
		if(temp.size() >= 4) // 4연결 이상 
		{
			while(!temp.isEmpty())
			{
				Node n = temp.poll();
				map[n.dx][n.dy] = '.'; // 제거 
			}
			return 1;
		}
		return 0;
	}
	public static void clear() // 방문기록 제거 
	{
		for(int i=1; i<= N ; i++)
		{
			for(int j=1; j<= M ; j++)
			{
				visit[i][j] = 0;
			}
		}
	}
	public static void update() // 뿌요 제거 후 중력으로 인해 바닥으로 땡겨 오기 
	{
		Deque<Character> deque = new ArrayDeque<>();
		for(int i=1; i<= M; i++)
		{
			for(int j= N; j > 0; j--)
			{
				if(map[j][i] != '.') {
					deque.add(map[j][i]);
					map[j][i] = '.';
				}
			}
			if(deque.size() > 0)
			{
				int index = N;
				while(!deque.isEmpty())
				{
					char puyo = deque.pop();
					map[index--][i] = puyo;
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
