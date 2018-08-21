package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2210 {

	static final int N = 5;
	static String[][] map = new String[5][5];
	static Queue<Character> que = new LinkedList<>();
	static HashSet<String> hs = new HashSet<>();
	static int[] visit = new int[6];
	static int[] dxArr = {0, 0, 1, -1} , dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< N; j++) 
			{
				map[i][j] = st.nextToken();
			}
		}
		for(int i =0; i< N; i++)
		{
			for(int j=0; j< N; j++)
			{
				String str = map[i][j];
				solve(i, j, 1, str);
			}
		}
		
		System.out.println(hs.size());
		
	}
	public static void solve(int dx, int dy, int cnt, String value)
	{
		if(cnt == 6)
		{
			hs.add(value);
			return;
		}
		for(int i=0; i<4; i++)
		{
			int nx = dx + dxArr[i];
			int ny = dy + dyArr[i];
			if(!isRange(nx, ny)) continue;
			solve(nx, ny, cnt+1, value+map[nx][ny]);
		}
	}
	
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 0 && dy >= 0 && dx < N && dy < N;
	}
}







