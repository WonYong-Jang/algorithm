package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 5
 */
public class baek14003 {

	static int N, size;
	static final int max_node = 1000005;
	static int[] data = new int[max_node];
	static int[] dp = new int[max_node];
	static Node[] ans = new Node[max_node];
	static Deque<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			ans[i] = new Node(-1,-1);
		}
		dp[1] = data[1];
		ans[1].idx = 1;
		ans[1].num = data[1];
		size = 1;
		for(int i=2; i<= N; i++)
		{
			if(dp[size] < data[i]) {
				dp[++size] = data[i];
				ans[i].idx = size;
				ans[i].num = data[i];
			}
			else {
				int idx = lower_bound(1,size, data[i]);
				dp[idx] = data[i];
				ans[i].idx = idx;
				ans[i].num = data[i];
			}
		}
		System.out.println(size);
		for(int i = N; i > 0; i--)
		{
			if(size == ans[i].idx)
			{
				que.addLast(ans[i].num);
				size--;
			}
		}
		while(!que.isEmpty())
		{
			int num = que.pollLast();
			System.out.print(num+" ");
		}
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid=0, result =0;
		
		while(s <= e)
		{
			mid = (s + e) / 2;
			if(dp[mid] < target)
			{
				s = mid + 1;
			}
			else 
			{
				e = mid - 1;
				result = mid;
			}
		}
		return result;
	}
	static class Node {
		int idx,num;
		Node(int a, int b){
			idx=a;num=b;
		}
	}
}
