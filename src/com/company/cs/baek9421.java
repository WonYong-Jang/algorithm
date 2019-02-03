package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 상근 수 
 */
public class baek9421 {

	static final int max_node = 1000005;
	static int N, index;
	static int[] prime = new int[max_node];
	static int[] data = new int[max_node];
	static boolean[] visit = new boolean[max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		index = 0;
	
		for(int i=1; i<= N; i++) data[i] = i;
		
		for(int i=2; i<= N; i++)
		{
			if(data[i] == 0) continue;
			prime[++index] = i;
			for(int j = i+i; j<= N; j += i)
			{
				if(data[j] == 0) continue;
				data[j] = 0;
			}
		}
		
		int target = 0;
		for(int i=1; i<= index; i++)
		{
			target = prime[i];
			visit[target] = fun(target);
			if(!visit[target]) System.out.println(target);
		}
		
	}
	public static boolean fun(int target)
	{
		if(visit[target]) return true; // 상근수가 아닌 수 
		
		int value = target, sum = 0;
		while(value > 0)
		{
			sum += (value % 10) * (value % 10);
			value /= 10;
		}
		if(sum == 1) {
			return visit[target] = false;
		}
		else 
		{
			visit[target] = true;
			return visit[target] = fun(sum);
		}
	}
}











