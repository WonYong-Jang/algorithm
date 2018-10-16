package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에너지 모으기 
 */
public class baek16198 {

	static int N, result;
	static int[] ans = new int[15];
	static int[] visit = new int[15];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result =0;
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++)
		{
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i< N-1; i++)
		{
			visit[i] = 1;
			solve(i, ans[i-1]*ans[i+1],1);
			visit[i] = 0;
		}
		System.out.println(result);
	}
	public static void solve(int index, int sum, int depth)
	{
		if(depth == N-2)
		{
			result = max(result, sum);
		}
		else 
		{
			int left =0, right=0; // 좌우 값 찾기 
			for(int i=1; i< N-1; i++)
			{
				if(visit[i] == 1) continue;
				visit[i] = 1;
				left = i;
				while(true) // 현재 좌표에서 왼쪽 
				{
					left--;
					if(visit[left] == 0) break;
				}
				
				right = i;
				while(true) // 현재 좌표에서 왼쪽 
				{
					right++;
					if(visit[right] == 0) break;
				}
				
				solve(i, (ans[left] * ans[right]) + sum , depth+1);
				visit[i] = 0;
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}




