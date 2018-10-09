package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Contact
 */
public class swExpert1238 {

	static int N, start, ans;
	static int[] visit = new int[105];
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int k=1; k<= 10 ; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			adj.clear(); que.clear();
			
			for(int i=0; i<= 100; i++)
			{
				adj.add(new ArrayList<>());
			}
			
			for(int i=0; i<= 100; i++) visit[i] = 0;
			
			st = new StringTokenizer(br.readLine());
			int dx = 0, dy = 0;
			for(int i=0; i< N/2; i++)
			{
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy); // 인접 리스트 연결 
			}
			
			int result = solve();
			bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}
	public static int solve()
	{
		que.add(start);
		visit[start] = 1;
		
		while(!que.isEmpty())
		{
			int len = que.size();
			if(len > 0 ) 
			{
				ans = -1;
				for(int i=0; i< len; i++)
				{
					int n = que.poll();
					
					if(ans < n) ans = n;
					
					for(int next : adj.get(n))
					{
						if(visit[next] == 1) continue;
						visit[next] = 1;
						que.add(next);
					}
				}
			}
			
		}
		return ans;
	}
}





