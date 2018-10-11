package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/** 
 * 수영장 
 */
public class swExpert1952_2 {

	static int ans;
	static int[] dates = new int[13]; // 12	개월 
	static int[][] cost = new int[2][4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		cost[0][0] = 1; cost[0][1] = 1; cost[0][2] = 3; cost[0][3] = 12; // 개월수 
		
		for(int k=1; k<= testCase; k++)
		{
			ans = 100000;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++)
			{
				cost[1][i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= 12; i++)
			{
				dates[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum =0;
			for(int i=0; i<4; i++)
			{
				if(i == 0 ) sum = dates[1] * cost[1][i];
				else sum = cost[1][i];
				solve(1 + cost[0][i], sum);
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int curDate, int sum)
	{
		if(curDate > 12) 
		{
			ans = min(ans, sum);
			return;
		}
		if(sum > ans) return; // 가지 치기 
		
		int temp = 0;
		for(int k=0; k<4; k++)
		{
			if(k == 0) temp = dates[curDate] * cost[1][k];
			else temp = cost[1][k];
			solve(curDate + cost[0][k] , sum + temp);
		}
		
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
