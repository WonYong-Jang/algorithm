package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 히스토그램에서 가장 큰 정사각형 
 */
public class baek6549 {

	static final int max_node = 100005;
	static int N, s, e;
	static long result;
	static int[] tree = new int[4*max_node];
	static int[] data = new int[4*max_node]; // height
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break; // 종료 
			
			s = 1; result = -1;
			while(N > s) s *= 2;
			e = N + s -1;
			
			for(int i= 1; i <= N*4; i++) {
				tree[i] = -1;
			}
			
			for(int i = s; i<= e; i++)
			{
				data[i] = Integer.parseInt(st.nextToken());
				tree[i] = i;
			}
			
			int left =0, right =0;
			for(int i=e/2; i>=1; i--) // init
			{
				left = tree[i*2];
				right = tree[(i*2) + 1];
				if(left == -1 && right == -1) tree[i] = -1;
				else if(left == -1 && right > 0) tree[i] = right;
				else if(left > 0 && right == -1) tree[i] = left;
				else {
					if(data[left] > data[right]) tree[i] = right;
					else tree[i] = left;
				}
			}
			
			/*
			for(int i=1; i<= e; i++)
			{
				System.out.print(tree[i]+" ");
			}
			System.out.println();
			*/
			
			solve(s, e);
			System.out.println(result);
		}
		
	}
	public static void solve(int sdx, int edx)
	{
		int index =0, len =0;
		if(sdx <= edx)
		{
			index = query(sdx, edx);
			
			len = edx - sdx +1;
			result = max(result, (long) len*data[index]);
			//System.out.println(len+" "+result);
			//System.out.println(result);
			if(index > s) solve(sdx, index-1);
			
			if(index < e) solve (index+1, edx);
		}
	}
	public static int query(int sdx, int edx) // 가장 작은 값의 인덱스 리턴 
	{
		int idx = 0, value = Integer.MAX_VALUE;
		while(sdx <= edx)
		{
			if(sdx % 2 != 0) 
			{
				if(data[tree[sdx]] < value) {
					value = data[tree[sdx]];
					idx = tree[sdx];
				}
			}
			if(edx % 2 == 0)
			{
				if(data[tree[edx]] < value) {
					value = data[tree[edx]];
					idx = tree[edx];
				}
			}
			
			sdx = (sdx + 1) / 2;
			edx = (edx - 1) / 2;
		}
		return idx;
	}
	
	public static long max(long a, long b) { return a > b ? a : b; }
}



