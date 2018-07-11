package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약   
 */
public class baek10026 {
	
	static int N, result1=0,result2=0;
	static char[][] map = new char[101][101];
	static int[][] visited = new int[101][101];
	static int[] dxArr= {0,1,0,-1}, dyArr= {1,0,-1,0}; // 방향 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i< N; i++)
		{
			String str = br.readLine();
			for(int j=0; j< N ;j++)
			{
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<N; i++)
		{
			for(int j=0; j< N; j++)
			{
				if(visited[i][j] == 1) continue;
				general(i,j);
				result1++;
			}
		}
		init(); // 방문 배열 초기화
		for(int i=0; i<N; i++)
		{
			for(int j=0; j< N; j++)
			{
				if(visited[i][j] == 1) continue;
				exception(i,j);
				result2++;
			}
		}
		
		System.out.println(result1+" "+ result2);
	}
	public static void general(int dx, int dy) // 일반사람 
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(dx,dy));
		visited[dx][dy] =1; // 방문 수 
		while(!que.isEmpty())
		{
			Node node = que.poll();
			char curType = map[node.dx][node.dy];
			for(int i=0; i<4; i++)
			{
				int rDx = node.dx + dxArr[i];
				int rDy = node.dy + dyArr[i];
				if(!isRange(rDx,rDy) || visited[rDx][rDy] == 1) continue; // 범위에 맞지 않으면 pass
				if(curType != map[rDx][rDy]) continue;
				que.add(new Node(rDx,rDy));
				visited[rDx][rDy] = 1;
			}
		}
		
	}
	public static void exception(int dx, int dy) // 적록 색약  
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(dx,dy));
		visited[dx][dy] =1; // 방문 수 
		while(!que.isEmpty())
		{
			Node node = que.poll();
			char curType = map[node.dx][node.dy];
			for(int i=0; i<4; i++)
			{
				int rDx = node.dx + dxArr[i];
				int rDy = node.dy + dyArr[i];
				if(!isRange(rDx,rDy) || visited[rDx][rDy] == 1) continue; // 범위에 맞지 않으면 pass
				if(!isCheck(curType, map[rDx][rDy])) continue;
				que.add(new Node(rDx,rDy));
				visited[rDx][rDy] = 1;
			}
		}
	}
	public static boolean isCheck(char a, char b) // 적록색약 확인 ! 
	{
		if(a == b || a == 'R' && b=='G' || a == 'G' && b=='R') return true;
		else return false;
	}
	public static boolean isRange(int dx, int dy) // 범위 확인 
	{
		return dx >=0 && dy >=0 && dx < N && dy < N;
	}
	public static void init()
	{
		for(int i=0; i< N; i++)
		{
			for(int j=0; j< N ;j++)
			{
				visited[i][j] = 0;
			}
		}
	}
	static class Node {
		int dx,dy;
		Node(int x, int y) {
			dx =x; dy=y;
		}
	}
}
