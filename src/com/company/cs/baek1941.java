package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 소문난 칠공주 ( 백트래킹 ) 25명중에 7명을 뽑는데 모두 연결되어 있고 1(S) 가 4개 이상 있는 경우의 수 ! 
 */
public class baek1941 {

	static final int N = 5; // S == 1     Y == 0 
	static int[][] map = new int[6][6];
	static int[] visit = new int[26];
	static int[] check = new int[7]; // 0 ~ 6 연결성 확인 !
	static int[] dxArr = {0, 0, 1, -1}, dyArr= {1, -1, 0, 0};
	static ArrayList<Integer> arr = new ArrayList<>();  
	static int ans =0; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for(int j = 0; j < N; j++)
			{
				char temp = str.charAt(j);
				if(temp == 'Y') map[i][j] = 0; // Y == 0 
				else map[i][j] = 1; // S == 1
			}
		}
		
		for(int i=0; i< N * N; i++)
		{
			arr.add(i);
			visit[i] = 1;
			solve(i);
			visit[i] = 0;
			arr.remove(arr.size()-1);
		}
		System.out.println(ans);
	}
	public static void solve(int n)
	{
		if(!isPromise()) return;
		
		if(arr.size() == 7)
		{
			if(isConnect()) {
				ans++;
			}
			return;
		}
		
		for(int i=n+1; i< N * N; i++)
		{
			if(visit[i] == 1) continue;
			visit[i] = 1;
			arr.add(i);
			solve(i);
			visit[i] = 0;
			arr.remove(arr.size()-1);
		}
	}
	public static boolean isConnect() // 7개 노드가 다 연결되어 있는지 확인 
	{
		for(int i=0; i<7; i++) check[i] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(arr.get(0));
		check[0] = 1;
		while(!que.isEmpty())
		{
			int n = que.poll();
			int dx = n/5;
			int dy = n%5;
			for(int i=0; i<4; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(!isRange(nx,ny)) continue;
				for(int j=0; j<7; j++)
				{
					if(check[j] == 1) continue;
					int tx = arr.get(j) / 5;
					int ty = arr.get(j) % 5;
					if(nx == tx && ny == ty)
					{
						check[j] = 1;
						que.add(arr.get(j));
					}
				}
			}
		}
		for(int i=0; i<7; i++)
		{
			if(check[i] == 0) return false;
		}
		return true;
	}
	public static boolean isPromise() // Y 4개 이상 있다면 그 이후 볼 필요 없음 
	{
		int cnt =0; // Y 갯수 0의 갯수 
		for(int i=0; i< arr.size(); i++)  
		{
			if(map[arr.get(i)/5 ][arr.get(i)%5 ] == 0) cnt++;
		}
		
		if(cnt >=4) return false;
		return true;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 0 && dy >= 0 && dx < N && dy < N;
	}
}


