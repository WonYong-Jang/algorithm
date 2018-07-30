package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무 자르기 
 */
public class baek2805 {

	static int[] tree = new int[1000005];
	static int N, M, start, end;
	static long ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start =1; end =0; ans =0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			tree[i] = Integer.parseInt(st.nextToken());
			end = max(end,tree[i]); // 가장 큰 값 찾기 
		}
		while(end >= start) // O(logN) 이분 탐색으로 시간 줄이기 
		{
			int mid = (start + end) / 2;
			long tmp = calculate(mid);
			
			if(tmp < M) { // 적어도 M 미터 이상은 가져 가야하니깐  
				end = mid-1;  
			}
			else { // M 보다 클때는 일단 답 가능성 있으면서 최소를 찾아감  
				ans = mid;
				start = mid+1;
			}
		}
		System.out.println(ans);
	}
	public static long calculate(int target) // 나무 절단 후 남는 크기 더하기 O(n)
	{
		long sum =0;
		for(int i=1; i<= N; i++)
		{
			int tmp = tree[i] - target; // 남는 나무 
			if( tmp > 0) sum += tmp;
		}
		return sum;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
