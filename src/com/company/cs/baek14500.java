package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 테트리미노 
 */
public class baek14500 {

	static int[][] map = new int[505][505];
	static int[][] visit = new int[505][505];
	static int ans = -1; // 최대 값 
	static int N, M;
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] dxArr = {-1, 0, 1, 0 }; // 북 동 남 서 
	static int[] dyArr = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 1;
				arr.add(new Node(i,j));
				solve(map[i][j]);
				visit[i][j] = 0;
				arr.remove(arr.size()-1); // 
			}
		}
		System.out.println(ans);
	}
	public static void solve(int sum)
	{
		if(arr.size() == 4)
		{
			ans = max(ans, sum);
			return;
		}
		
		int nx, ny;
		for(int i=0; i<arr.size(); i++)
		{
			for(int j=0; j<4; j++)
			{
				nx = arr.get(i).dx + dxArr[j];
				ny = arr.get(i).dy + dyArr[j];
				
				if(!isRange(nx,ny) || visit[nx][ny] == 1) continue;
				
				visit[nx][ny] = 1;
				arr.add(new Node(nx,ny));
				solve(sum+ map[nx][ny]);
				arr.remove(arr.size()-1);
				visit[nx][ny] = 0;
			}
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx<= N && dy <= M;
	}
	public static int max(int a,int b)
	{
		return a > b ? a : b;
	}
	static class Node{
		int dx,dy;
		Node(int x, int y) {
			dx =x; dy =y;
		}
	}
}
