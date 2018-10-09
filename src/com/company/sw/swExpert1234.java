package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 비밀번호 
 */
public class swExpert1234 {

	static int N;
	static Deque<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int k=1; k<= 10; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			String str = st.nextToken();
			
			for(int i=0; i< str.length(); i++)
			{
				int num = str.charAt(i) - '0';
				
				if(!que.isEmpty())
				{
					if(num == que.peekLast())
					{
						que.pollLast();
					}
					else que.addLast(num);
				}
				else if(que.isEmpty()) que.addLast(num);
			}
			
			System.out.print("#"+k+" ");
			while(!que.isEmpty())
			{
				System.out.print(que.pollFirst());
			}
			System.out.println();
		}
	}

}
