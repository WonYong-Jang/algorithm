package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek14888 {

	public static int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
	public static int N;
	public static ArrayList<Integer> num = new ArrayList<>();
	public static int[] map = new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++)
			num.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<4; i++)
		{
			if(map[i]==0) continue;
			map[i]--;
			dfs(num.get(0), 0, i);
			map[i]++;
		}
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	public static void dfs(int sum, int cnt, int op) 
	{
		int rSum = sum, nextCnt = cnt;
		nextCnt++;
		switch(op) 
		{
		case 0:rSum+=num.get(nextCnt); break;
		case 1:rSum-=num.get(nextCnt); break;
		case 2:rSum*=num.get(nextCnt); break;
		case 3:rSum/=num.get(nextCnt); break;
		}
		
		if(nextCnt == N-1) {
			maxValue = Integer.max(maxValue, rSum);
			minValue = Integer.min(minValue, rSum);
		}
		for(int i=0; i<4; i++)
		{
			if(map[i]==0) continue;
			map[i]--;
			dfs(rSum, nextCnt, i);
			map[i]++;
		}
	}
}











