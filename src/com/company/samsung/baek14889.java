package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek14889 {

	static int N, mid, ans;
	static int[][] data = new int[25][25]; // 1 ~ 20
	static int[] visit = new int[25];
	static ArrayList<Integer> start = new ArrayList<>();
	static ArrayList<Integer> link = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		mid = N /2; ans = 4000 * 100; // 큰 값 넣어 두기 
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<= mid + 1; i++) 
		{
			visit[i] = 1; // N/2 될때까지 찾아 나가기 
			solve(i, 1);
			visit[i] = 0;
		}
		System.out.println(ans);
	}
	public static void solve(int index, int cnt) // 몇번째 선수 인지, N/2 나누기 위한 cnt 
	{
		if(cnt == mid)
		{
			calculate(); // 두 팀의 능력치 계산 후 최소 구하기 
			return;
		}
		for(int i=index + 1; i<= N ; i++) 
		{
			if(visit[i] == 1) continue;
			visit[i] = 1; // N/2 될때까지 찾아 나가기 
			solve(i, cnt+1);
			visit[i] = 0;
		}
	}
	public static void calculate()
	{
		int startNum =0, linkNum =0;
		for(int i=1; i<= N; i++) // start , link 팀 나누기 
		{
			if(visit[i] == 1) start.add(i);
			else link.add(i);
		}
		
		for(int i = 0; i < mid -1; i++) // 각각 합 구하기 
		{
			for(int j = i+1; j < mid; j++)
			{
				startNum += (data[start.get(i)][start.get(j)] + data[start.get(j)][start.get(i)] );
				linkNum += (data[link.get(i)][link.get(j)] + data[link.get(j)][link.get(i)] );
			}
		}
	
		int result = startNum > linkNum ? (startNum - linkNum) : (linkNum - startNum) ;
		ans = min(ans, result);
		
		start.clear(); // 다음 검사를 위해 초기화 
		link.clear();
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}







