package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * 스타트와 링크  
 */
public class baek14889 {

	static int[][] map = new int[22][22];
	static int[] visited = new int[22]; // start 표시하기 위한 배열   
	static Deque<Integer> start = new ArrayDeque<>(); 
	static Deque<Integer> link = new ArrayDeque<>();
	static int N, minValue = Integer.MAX_VALUE;
	static int mid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		mid = N /2; // 중간 값 start 와 link 분리 하기 위한 값  
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
		if(cnt == mid) // start 를 절반 값 채우면  
		{
			for(int i =1; i<=N; i++)
			{
				if(visited[i] == 1) continue; // start 인경우 제외하고 link 로 선택 
				link.add(i);
			}
			if(start.size() == mid && link.size() == mid)
			{
				int temp = calculate(); // 계산  
				minValue = Math.min(temp, minValue);
			}
			return;
		}
		
		for(int i= index+1; i<= N; i++)
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
		int startValue = 0, linkValue = 0;
		for(int i=0; i< mid-1; i++) // 선택 정렬 형태로 계산 ! 
		{
			for(int j= i+1; j< mid; j++)
			{
				startValue += ( map[startTemp.get(i)][startTemp.get(j)] + map[startTemp.get(j)][startTemp.get(i)] );
				linkValue += ( map[linkTemp.get(i)][linkTemp.get(j)] + map[linkTemp.get(j)][linkTemp.get(i)] );
			}
		}
		result = Math.abs(startValue - linkValue);
		link.clear();
		return result;
	}
}






