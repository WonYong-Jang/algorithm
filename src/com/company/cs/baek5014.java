package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스타트 링크 
 */
public class baek5014 {

	static int F, S, G, U, D;
	static int[] data = new int[1000005];
	static int[] dir = new int[2];
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 전체 층수 
		S = Integer.parseInt(st.nextToken()); // 현재 층 수 
		G = Integer.parseInt(st.nextToken()); // 목표 층 수 
		U = Integer.parseInt(st.nextToken()); 
		D = Integer.parseInt(st.nextToken());
		dir[0] = U; dir[1] = -D;
		solve(S);
		if(data[G] ==0) System.out.println("use the stairs");
		else System.out.println(data[G]-1);
	}
	public static void solve(int start)
	{
		que.add(start);
		data[start] = 1;
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			if(n == G) {
				return;
			}
			for(int i=0; i<2; i++)
			{
				int next  = n + dir[i];
				if(next < 1 || next > F) continue;
				if(data[next] == 0 || data[next] > data[n] + 1)
				{
					data[next] = data[n] + 1;
					que.add(next);
				}
			}
		}
	}
}
