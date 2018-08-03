package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합 2 ( 투 포인터 ) 
 */
public class baek2003 {

	static int[] data = new int[10001];
	static int N, M, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		int s=0, e=0, sum=0;
		while(true)
		{
			while( sum < M &&  e < N) // 목표치 M 보다 작고 범위를 넘어가지 않으면 더해나감 
			{
				sum += data[e++];
			}
			if(sum < M) break; // 목표지에 도달하거나 커질때까지 돌리는데 작다는건 범위를 넘어가서 더이상 더할 값이 없다는 것!
			
			if(sum == M) { // 목표치 만난 경우 
				ans++; sum -= data[s++];
			}
			
			while(sum > M && s < e) // 목표치 넘어간경우 시작점에서부터 빼줌 
			{
				sum -=data[s++];
			}
		}
	}
}







