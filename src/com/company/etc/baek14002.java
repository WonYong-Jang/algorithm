package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분수열 4
 */
public class baek14002 {

	static int N;
	static int[] data = new int[1005];
	static int[] dp = new int[1005];
	static Node[] ans = new Node[1005];
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
		ans[1].dx = 1; // 실제 인덱스 1로 처음 시작 
		ans[1].dy = dp[1]; // 실제 값 
		int size = 1;
		for(int i=2; i<= N; i++)
		{
			if(dp[size] < data[i])
			{
				dp[++size] = data[i];
				ans[i].dx = size;
				ans[i].dy = data[i];
			}
			else {
				int idx = lower_bound(1, size, data[i]);
				dp[idx] = data[i];
				ans[i].dx = idx;
				ans[i].dy = data[i];
			}
		}
		System.out.println(size);
		// 인덱스 i=2 부터 계속 해서 업데이트 해왔으므로
		// 맨뒤 인덱스 부터 찾아 나감 
		int t = size;
		for(int i = N; i > 0; i--)
		{
			if(t == ans[i].dx)
			{
				que.addLast(ans[i].dy);
				t--;
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
			else {
				e = mid - 1;
				result = mid;
			}
		}
		
		return result;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx=a; dy=b;
		}
	}
}
