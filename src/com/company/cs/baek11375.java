package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 열혈 강호 ( 이분 매칭 ) 
 */
public class baek11375 {

	static int N, M, result;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int[] visit = new int[1005];
	static int[] match = new int[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++) {
			adj.add(new ArrayList<>());
		}
		result = 0;
		int cnt =0, num = 0;
		for(int i=1; i<= N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for(int j=1; j<= cnt; j++) 
			{
				num = Integer.parseInt(st.nextToken());
				adj.get(i).add(num);
			}
		}
		
		int result = bmatch();
		System.out.println(result);
	}
	
	public static int bmatch()
	{
		int ret = 0;
		for(int i=1; i<= N; i++) // 모든 직원들에 대해서 매칭 시도 
		{
			for(int j=1; j<= N; j++) visit[j] = 0;
			if(dfs(i) == 1) ret++; // 직원과 일이 매칭 된다면 카운트 
		}
		return ret;
	}
	public static int dfs(int cur)
	{
		if(visit[cur] == 1) return 0; // 방문한 직원 매칭 불가 
		visit[cur] = 1;
		
		for(int next : adj.get(cur))
		{
			// 매칭한 적이 없거나 매칭 되어 있다면 매칭 된 직원에게 되돌아 가서 다른 일이 가능한지 확인 작업 
			if(match[next] == 0 || dfs(match[next]) == 1)
			{
				match[next] = cur; // 매칭이 된다면 1 리턴 
				return 1;
			}
		}
		
		return 0;
	}
}


/**
5 5
2 1 2
4 1 2 3 4
3 1 2 3
5 1 2 3 4 5
1 2
 */





