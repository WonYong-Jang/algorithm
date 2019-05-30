package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2104 {

	static long result = 0;
	static int N, start, end, rStart, rEnd;
	static long[] sumTree = new long[100001*4];
	static int[] minTree = new int[100001*4];
	static int[] data = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start=1;
		while(N > start) start *= 2;
		end = start + N - 1;
		rStart = 1; rEnd = N;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			sumTree[start+i-1] = data[i];
			minTree[start+i-1] = i;
		}
		int left = 0, right = 0;
		for(int i=end/2; i>=1; i--)
		{
			sumTree[i] = sumTree[i*2] + sumTree[i*2+1];
			left = minTree[i*2];
			right = minTree[i*2+1];
			if(left == 0 && right ==0) continue;
			else if(left != 0 && right != 0)
			{
				if(data[left] < data[right]) minTree[i] = left;
				else minTree[i] = right;
			}
			else if(left == 0) minTree[i] = right;
			else minTree[i] = left;
		}
		
		solve(1, N);
		System.out.println(result);
		System.out.println(rStart + " " + rEnd);
	}
	public static void solve(int sdx, int edx)
	{
		if(sdx > edx) return;
		if(sdx < 0 || edx > N ) return;
		
		long sum = sumQuery(sdx,edx);
		int index = query(sdx, edx);
		long tmp = sum*(long)data[index];
		if(result < tmp)
		{
			result = tmp;
			rStart = sdx;
			rEnd = edx;
		}
		
		
		solve(sdx, index-1);
		solve(index+1, edx);
	}
	public static int query(int dx, int dy)
	{
		int index = 0;
		long value = Long.MAX_VALUE;
		int sdx = dx + start - 1;
		int edx = dy + start - 1;
		
		while(sdx <= edx)
		{
			if(sdx % 2 != 0)
			{
				if(value > data[minTree[sdx]])
				{
					value = data[minTree[sdx]];
					index = minTree[sdx];
				}
			}
			if(edx % 2 == 0)
			{
				if(value > data[minTree[edx]])
				{
					value = data[minTree[edx]];
					index = minTree[edx];
				}
			}
			sdx = (sdx+1)/2;
			edx = (edx-1)/2;
		}
		
		return index;
	}
	public static long sumQuery(int dx, int dy)
	{
		long sum = 0;
		
		int sdx = dx + start - 1;
		int edx = dy + start - 1;
		
		while(sdx <= edx)
		{
			if(sdx % 2 != 0) sum += sumTree[sdx];
			if(edx % 2 == 0) sum += sumTree[edx];
			
			sdx = (sdx+1)/2;
			edx = (edx-1)/2;
		}
		
		return sum;
	}
	public static long max(long a, long b) { return a > b ? a : b; }
}










