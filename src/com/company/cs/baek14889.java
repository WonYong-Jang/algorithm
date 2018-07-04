package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class baek14889 {

	static int[][] map = new int[22][22];
	static int[] visited = new int[22]; // 
	static Deque<Integer> start = new ArrayDeque<>(); 
	static Deque<Integer> link = new ArrayDeque<>();
	static int N, minValue = Integer.MAX_VALUE;
	static int mid = N /2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
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
			visited[i] = 1;
			start.addLast(i);
			dfs(i, 1);
			start.pollLast();
			visited[i] = 0;
		}
		System.out.println(minValue);
	}
	public static void dfs(int index, int cnt)
	{
		System.out.println(index+" "+ cnt);
		
		if(cnt == mid)
		{
			for(int i =1; i<=N; i++)
			{
				if(visited[i] ==0) // 나머지 선택 안된 link 선택 
				{
					link.add(i);
				}
			}
			if(start.size() == mid && link.size() == mid)
			{
				System.out.println(start);
				System.out.println(link);
				int temp = calculate();
				minValue = Math.min(temp, minValue);
			}
			return;
		}
		
		for(int i=index+1; i<= N; i++)
		{
			if(visited[i] ==1) continue;
			visited[i] = 1;
			start.addLast(i);
			dfs(i, cnt+1);
			start.pollLast();
			visited[i] = 0;
		}
	}
	public static int calculate() // start 와 link 능력치 계산   
	{
		int result =0;
		ArrayList<Integer> startTemp = new ArrayList<>();
		ArrayList<Integer> linkTemp = new ArrayList<>();
		startTemp.addAll(start);
		linkTemp.addAll(link);
		int startValue = 0;
		int linkValue = 0;
		for(int i=0; i< startTemp.size()-1; i++)
		{
			for(int j=1; j< startTemp.size(); j++)
			{
				startValue += ( map[startTemp.get(i)][startTemp.get(j)] + map[startTemp.get(j)][startTemp.get(i)] );
				linkValue += ( map[linkTemp.get(i)][linkTemp.get(j)] + map[linkTemp.get(j)][linkTemp.get(i)] );
			}
		}
		result = Math.abs(startValue - linkValue);
		System.out.println(startValue + " "+ linkValue+" "+ result);
		link.clear();
		return result;
	}
}






