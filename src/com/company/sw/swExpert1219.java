package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 길 찾기 
 */
public class swExpert1219 {

	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); // 인접 리스트 
	static int[] visited;
	static int N, result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int k=1; k<= 10; k++)
		{
			arr.clear();
			result = 0;
			st = new StringTokenizer(br.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr.clear();
			visited = new int[100]; // 0 ~ 99 
			for(int i=0; i< 100; i++)
			{
				arr.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< N; i++)
			{
				int dx = Integer.parseInt(st.nextToken());
				int dy = Integer.parseInt(st.nextToken());
				
				arr.get(dx).add(dy); // 인접 리스트 연결 
			}
			visited[0] = 1; // 첫번째 점 되돌아 오지 않게 
			for(int nextValue : arr.get(0))
			{
				visited[nextValue] = 1;
				solve(nextValue);
				visited[nextValue] = 0;
			}
			System.out.println("#"+k+" "+result);
		}
	}
	public static void solve(int curValue)
	{
		if(result == 1) return; // 값을 찾은 경우 
		if(curValue == 99) {
			result = 1;
			return;
		}
		for(int nextValue : arr.get(curValue))
		{
			if(visited[nextValue] == 1) continue;
			visited[nextValue] = 1;
			solve(nextValue);
			visited[nextValue] = 0;
		}
	}
}








