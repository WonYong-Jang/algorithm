package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한윤정이 이탈리아에 ( 백트래킹 )
 */
public class baek2422 {

	static int N, M, ans;
	static int[] output = new int[205];
	static int[][] data = new int[205][205]; // 안되는 조합 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int dx =0, dy =0;
		ans =0;
		for(int i=0; i< M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			data[dx][dy] = 1;
			data[dy][dx] = 1;
		}
		
		for(int i=1; i<= N; i++)
		{
			solve(i, 1);
		}
		System.out.println(ans);
	}
	public static void solve(int index, int depth)
	{
		output[depth] = index;
		if(depth == 3)
		{
			ans++;
			return;
		}
		else 
		{
			for(int i=index+1; i<= N; i++)
			{
				if(isPromising(depth, i)) // i 가 depth 에 가능한지 검사 
				{
					solve(i, depth+1);
				}
			}
		}
	}
	public static boolean isPromising(int depth, int target) // target이 가능한지 확인 
	{
		boolean result = true;
		
		for(int i=1; i<= depth; i++)
		{
			int num = output[i];
			if(data[num][target] == 1) return false;
		}
		
		return result;
	}
}







