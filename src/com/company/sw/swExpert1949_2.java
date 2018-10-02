package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 등산로 조정 
 */
public class swExpert1949_2 {

	static int N, K, maxLen;
	static int[][] map = new int[10][10];
	static int[][] visit = new int[10][10];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static ArrayList<Node> peak = new ArrayList<>(); // 가장 높은 봉우리 저장 배열 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxLen = 1;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					for(int f = 0; f <= K; f++)
					{
						map[i][j] -= f;
						selectMaxValue(); // 최고 봉우리 다시 설정 
						solve();
						map[i][j] += f;
					}
				}
			}
			
			
			
			bw.write("#"+k+" "+maxLen+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		for(int i=0; i< peak.size(); i++)
		{
			int dx = peak.get(i).dx;
			int dy = peak.get(i).dy;
			visit[dx][dy] = 1;
			dfs(dx,dy,1);
			visit[dx][dy] = 0;
		}
	}
	public static void dfs(int dx, int dy, int len)
	{
		maxLen = max(maxLen, len);
		
		for(int i=0; i< 4; i++)
		{
			int nx = dx + dxArr[i];
			int ny = dy + dyArr[i];
			if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
			if(map[nx][ny] < map[dx][dy])
			{
				visit[nx][ny] = 1;
				dfs(nx, ny, len+1);
				visit[nx][ny] = 0;
			}
		}
	}
	public static void selectMaxValue() // 가장 큰 봉우리 찾기 
	{
		int tmp = -1;
		peak.clear();
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(tmp < map[i][j])
				{
					peak.clear();
					tmp = map[i][j];
					peak.add(new Node(i, j));
				}
				else if(tmp == map[i][j])
				{
					peak.add(new Node(i, j));
				}
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy>=1 && dx <= N && dy <= N;
	}
	static class Node{
		int dx, dy;
		Node(int a, int b) {
			dx = a; dy = b;
		}
	}
}
