package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 최솟값 찾기 
 */
public class baek11003 {

	static final int max = 5000005;
	static int N, L;
	static int[] ans = new int[max];
	static Deque<Node> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int num =0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			
			while(true) // last 넣는 구간 
			{
				if(que.isEmpty()) 
				{
					que.addLast(new Node(num, i));
					break;
				}
				
				Node last = que.peekLast();
				
				if(last.num < num) 
				{
					que.addLast(new Node(num, i));
					break;
				}
				else que.pollLast();
			}
			int target =0;
			
			while(true)
			{
				Node first = que.peekFirst();
				Node last = que.peekLast();
				
				target = first.num;
				if(last.idx - first.idx < L) break;
				que.pollFirst();
				
			}
			bw.write(target+" ");
		}
		bw.flush();
	}
	static class Node {
		int num, idx;
		Node(int a, int b) {
			num = a; idx = b;
		}
	}
}
