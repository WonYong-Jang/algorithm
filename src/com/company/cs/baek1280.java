package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 나무 심기 
 */
public class baek1280 {

	static final int max_value = 200000;
	static int N;
	static final long mod = 1000000007;
	static int[] data = new int[max_value+5];
	static long[] sumTree = new long[4*max_value + 5];
	static long[] cntTree = new long[4*max_value + 5];
	static long result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 1;
		long sum = 0, leftSum = 0, rightSum = 0, leftCnt = 0 , rightCnt = 0, xi = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken())+1;
			if(i != 1)
			{
				xi = (long)data[i];
				leftSum = getSum(1, 1, max_value, 1, data[i]-1);
				rightSum = getSum(1, 1, max_value, data[i]+1, max_value);
				
				leftCnt = getCnt(1, 1, max_value, 1, data[i] - 1);
				rightCnt = getCnt(1, 1, max_value, data[i]+1, max_value);
				
				sum = ((xi*leftCnt) - leftSum) + (rightSum - (rightCnt*xi));
				sum %= mod;
				result = (result * sum) % mod;
			}
			updateSum(1, 1, max_value, data[i], data[i]);
			updateCnt(1, 1, max_value, data[i], 1);
		}
		
		System.out.println(result);
	}
	public static void updateCnt(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index ) return;
		cntTree[node] += num;
		if(start == end) return;
		int mid = (start + end) / 2;
		updateCnt(node*2, start, mid, index, num);
		updateCnt(node*2+1, mid+1, end, index, num);
	}
	public static void updateSum(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index ) return;
		sumTree[node] += num;
		if(start == end) return;
		int mid = (start + end) / 2;
		updateSum(node*2, start, mid, index, num);
		updateSum(node*2+1, mid+1, end, index, num);
	}
	public static long getSum(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j) return sumTree[node];
		else return getSum(node*2, start, mid, i, j) + getSum(node*2+1, mid+1, end, i, j);
	}
	public static long getCnt(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j) return cntTree[node];
		else return getCnt(node*2, start, mid, i, j) + getCnt(node*2+1, mid+1, end, i, j);
	}
}





