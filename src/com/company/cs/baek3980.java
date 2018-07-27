package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선발 명단 
 */
public class baek3980 {

	static int[][] map = new int[12][12]; // 1 ~ 11 
	static int[] visited; // 각 포지션 선택 되었는지 확인 배열
	static int N =11, result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			result = 0;
			for(int i=1; i<= N; i++) // input 
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new int[12]; // 1 ~ 11 인덱스 사용 
			for(int i=1; i<= N; i++)
			{
				if(map[1][i] == 0) continue; // 능력치가 0이라면 
				visited[i] = 1;
				dfs(1, map[1][i]); // 첫번째 사람의 11개 포지션을 모두 검사 
				visited[i] = 0;
			}
			System.out.println(result);
		}
	}
	public static void dfs(int curPerson, int sum)
	{
		if(curPerson == N) { // 11개 포지션 모두 찬 경우
			result = Math.max(result, sum);
			return;
		}
		for(int i=1; i<= N; i++)
		{
			if(map[curPerson+1][i] == 0 || visited[i] == 1) continue; // 능력치가 0 이거나 이미 포지션이 차있는 경우  
			visited[i] = 1;
			dfs(curPerson + 1, map[curPerson+1][i] + sum); // 다음 사람의 11개 포지션을 모두 검사 
			visited[i] = 0;
		}
	}
}
