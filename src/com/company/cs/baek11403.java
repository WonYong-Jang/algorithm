package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 경로 찾기 
 */
public class baek11403 {

	static int N;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); // 인접 리스트 
	static int[][] ans = new int[101][101]; // 정답 배열 
	static int[] visited= new int[101]; // 전체 노드 범위 1 ~ 100
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<= N; i++) // 인접 리스트 초기화 작업 
		{
			arr.add(new ArrayList<>());
		}
		
		for(int i=1;i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++) // input 
			{
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					arr.get(i).add(j); // 방향 있는 그래프 i -> j 
				}
			}
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				dfs(i, i, j);
				init(); // 방문 기록 초기화 
			}
		}
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int curIndex, int dx, int target) // (dx, target ) == ( dx -> target ) 
	{
		for(int nextNode : arr.get(curIndex)) // 연결 된 다음 노드 검색 
		{
			if(visited[nextNode] == 1) continue; // 무한 루프 방지 
			if(target == nextNode) // 목표 노드 찾게 되면 정답배열에 기록후 리턴  
			{
				ans[dx][target] = 1;
				return;
			}
			visited[nextNode] = 1; // 방문 기록 후 다음 노드 확인 
			dfs(nextNode, dx, target);
		}
	}
	public static void init()
	{
		for(int i=1; i<=N; i++)
			visited[i] =0;
	}
}
