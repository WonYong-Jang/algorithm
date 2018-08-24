package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 괄호 짝 짓기 
 */
public class swExpert1218 {

	static int N;
	static char[] data;
	static Deque<Character> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int k=1; k<= 10; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			que.clear();
			data = new char[N];
			String str = br.readLine();
			for(int i=0; i< N; i++) // input 
			{
				data[i] = str.charAt(i);
			}
			
			int j=0;
			for(j = 0; j< N; j++)
			{
				char value = data[j];
				if( value == '(' || value == '[' || value == '<' || value == '{') que.addLast(value);
				else 
				{
					if(que.isEmpty()) 
					{
						bw.write("#"+k+" "+0+"\n");
						break;
					}
					else 
					{
						char temp = que.pollLast();
						if(value != match(temp)) {
							bw.write("#"+k+" "+0+"\n");
							break;
						}
					}
				}
			}
			
			if(j == N) bw.write("#"+k+" "+1+"\n");
		}
		bw.flush();
	}
	public static char match(char value)
	{
		char result = 0;
		switch(value)
		{
		case '{': result = '}'; break;
		case '[': result = ']'; break;
		case '<': result = '>'; break;
		case '(': result = ')'; break;
		}
		
		return result;
	}
}
