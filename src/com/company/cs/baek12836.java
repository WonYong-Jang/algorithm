package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가계부 
 */
public class baek12836 {

	static int N, Q;
	static final int max = 10000;
	static int[] tree = new int[4 * max];
	static int sIdx, eIdx;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		sIdx = 1;
		while(sIdx < N) sIdx *=2;
		eIdx = sIdx + N - 1;
		
		int cmd = 0, dx = 0, dy =0 , value =0;
		for(int i=1; i<= Q; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				dx = Integer.parseInt(st.nextToken());
				value = Integer.parseInt(st.nextToken());
				insert(dx, value);
			}
			else if(cmd == 2)
			{
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				solve(dx, dy);
			}
		}
	}
	public static void solve(int dx, int dy)
	{
		int sdx = sIdx + dx -1;
		int edx = sIdx + dy -1;
		long sum =0;
		while(sdx <= edx)
		{
			if(sdx % 2 != 0) sum +=tree[sdx];
			sdx = (sdx+1)/2;
			
			if(edx % 2 ==0) sum +=tree[edx];
			edx = (edx-1)/2;
		}
		System.out.println(sum);
	}
	public static void insert(int dx, int value)
	{
		int curIdx = sIdx + dx -1; // 현재 시작점 잡기 
		tree[curIdx] += value;
		
		while(curIdx > 1) // 갱신 
		{
			curIdx /=2 ;
			tree[curIdx] = tree[curIdx*2] + tree[curIdx*2 + 1];
		}
	}
}
