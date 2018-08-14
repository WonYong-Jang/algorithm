package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 점프 점프 
 */
public class baek11060 {

	static int[] data = new int[1005];
	static int[] visit = new int[1005];
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		solve();
		if(visit[N] == 0) System.out.println(-1);
		else System.out.println(visit[N]);
	}
	public static void solve()
	{
		Queue<Integer> que = new LinkedList<>();
		que.add(1); // 1번에서 시작 
		while(!que.isEmpty())
		{
			int n = que.poll(); // 현재 인덱스 
			
			for(int i = data[n]; i > 0; i--)
			{
				if( n + i > N) continue;
				if(visit[n +i] != 0 && visit[n +i] < visit[n] + 1) continue;
				if(visit[ n + i ] == 0 )
				{
					visit[ n + i ] = visit[n] + 1;
					que.add(n+i);
				}
			}
		}
	}
}








