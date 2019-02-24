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
 * 크게 만들기 
 */
public class baek16496 {

	static int N, K, M;
	static Deque<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = N - K; // 출력해야 할 숫자 갯수  
		String str = br.readLine();
		int num =0, last = 0;
		for(int i=1; i<= N; i++)
		{
			num = str.charAt(i-1) - '0';
			
			while(!que.isEmpty()) // 뒷 자리 빼는 부분 
			{
				if(K == 0) break;
				
				last = que.peekLast();
				if(last < num) {
					que.pollLast();
					K--;
				}
				else break;
			}
			
			que.addLast(num);
		}
		
		for(int i=0; i< M; i++)
		{
			System.out.print(que.pollFirst());
		}
		System.out.println();
	}
}
