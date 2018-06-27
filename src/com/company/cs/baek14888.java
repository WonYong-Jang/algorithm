package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek14888 {

	static int N, minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[] opCnt = new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			opCnt[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<4; i++)
		{
			if(opCnt[i] == 0 ) continue;
			opCnt[i]--;
			dfs(0,i, arr.get(0));
			opCnt[i]++;
		}
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	public static void dfs(int cnt ,int op, int sum)
	{
		int rSum = sum;
		int nextCnt = cnt+1;
		switch(op)
		{
		case 0: rSum += arr.get(nextCnt); break;
		case 1: rSum -= arr.get(nextCnt); break;
		case 2: rSum *= arr.get(nextCnt); break;
		case 3: rSum /= arr.get(nextCnt); break;
		}
		
		if(nextCnt == N-1) {
			minValue = Integer.min(minValue, rSum);
			maxValue = Integer.max(maxValue, rSum);
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			if(opCnt[i] == 0 ) continue;
			opCnt[i]--;
			dfs(nextCnt,i, rSum);
			opCnt[i]++;
		}
	}
}