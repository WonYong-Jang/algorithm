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
 * 홍준이와 울타리 
 */
public class baek2905 {

	static int N, X, ansCnt;
	static long ansWidth;
	static int[] data = new int[1000005];
	static int[] window = new int[1000005];
	static int[] result = new int[1000005];
	static Deque<Node> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		que.clear();
		st = new StringTokenizer(br.readLine());
		int num =0, index = 0;
		ansWidth =0; ansCnt =0;
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			data[i] = num; window[i] = 0; result[i] =0;
			
			Node first = null, last = null;
			while(!que.isEmpty()) // 조건 만족할때 가지 데크 뒤 빼기 
			{
				last = que.peekLast();
				
				if(last.num >= num) que.pollLast();
				else break;
			}
			que.addLast(new Node(num, i));
			
			int target = 0;
			while(!que.isEmpty())
			{
				first = que.peekFirst();
				last = que.peekLast();
				
				target = first.num;
				if(last.idx - first.idx < X)
				{
					break;
				}
				que.pollFirst();
			}
			if(i >= X)
			{
				window[++index] = target;
			}
		}
		// index = 1 ~ 3 
		int cnt = 0, idx =0, chk =1;
		que.clear();
		for(int i=1; i<= N; i++)
		{
			if(index == cnt) num = window[index];
			else num = window[++cnt];
			
			Node first = null, last = null;
			while(!que.isEmpty()) // 뒤로 넣는 구간 
			{
				last = que.peekLast();
				if(last.num <= num) que.pollLast();
				else break;
			}
			
			que.addLast(new Node(num,i));
			
			int target =0;
			while(!que.isEmpty()) // 빼는 구간 
			{
				first = que.peekFirst();
				last = que.peekLast();
				
				target = first.num;
				if(last.idx - first.idx < X)
				{
					break;
				}
				que.pollFirst();
			}
			
			if(idx == 0) {
				ansCnt++;
				chk = 1;
				result[idx++] = target;
			}
			else if(result[idx-1] == target)
			{
				if(chk == X) {
					ansCnt++;
					chk = 1;
					result[idx++] = target;
				}
				else {
					chk++;
					result[idx++] = target;
				}
			}
			else if(result[idx-1] != target) {
				chk = 1;
				ansCnt++;
				result[idx++] = target;
			}
			
			//System.out.print(target+" ");
			//System.out.println();
			
			
			ansWidth += (long)(data[i] - target);
		}
		
		System.out.println(ansWidth);
		System.out.println(ansCnt);
	}
	static class Node {
		int num, idx;
		Node(int a, int b){
			num=a; idx =b;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b;}
}

/**

5 3
1 2 2 2 1

 */
