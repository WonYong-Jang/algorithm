package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 히스토그램  
 */
public class baek1725 {

	static int N, start, end, result;
	static int[] tree = new int[100005 * 4];
	static int[] data = new int[100005];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = 1; result = 0;
		
		while(N > start) start *= 2;
		end = start + N -1;
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
			tree[i+start-1] = i;
		}
		
		int left =0, right =0;
		for(int i= end/2; i>=1; i--)
		{
			left = tree[i*2];
			right = tree[i*2 + 1];
			if(left == 0 && right == 0) continue;
			if(left != 0 && right != 0)
			{
				if(data[left] < data[right]) tree[i] = left;
				else tree[i] = right;
			}
			else if(left == 0) tree[i] = right;
			else tree[i] = left;
		}
		
		solve(1, N);
		System.out.println(result);
	}
	public static void solve(int sdx, int edx)
	{
		if(sdx > edx) return;
		if(sdx < 0 || edx > N) return;
		
		int index = query(sdx, edx);
		
		result = max(result, data[index]*(edx-sdx+1));
		
		solve(sdx, index-1);
		solve(index+1, edx);
	}
	public static int query(int dx, int dy)
	{
		int index = 0, value = 987654321;
		int sdx = dx + start - 1;
		int edx = dy + start - 1;
		
		while(sdx <= edx)
		{
			if(sdx % 2 !=0)
			{
				if(data[tree[sdx]] < value) 
				{
					value = data[tree[sdx]];
					index = tree[sdx];
				}
			}
			if(edx % 2 == 0)
			{
				if(data[tree[edx]] < value)
				{
					value = data[tree[edx]];
					index = tree[edx]; 
				}
			}
			
			sdx = (sdx + 1) / 2;
			edx = (edx - 1) / 2;
		}
		
		return index;
	}
	public static int min(int a, int b) { return a > b ? b : a; }
	public static int max(int a, int b) { return a > b ? a : b; }
}
