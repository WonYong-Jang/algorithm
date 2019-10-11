package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, number, cnt;
	static ArrayList<Integer>[] adj = new ArrayList[10005];
	static int[] ans = new int[10005];
	static int[] order = new int[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		number = 0; cnt = 0;
		for(int i=1; i<= V; i++)
		{
		    adj[i] = new ArrayList<>();
		}
		
		int dx = 0, dy = 0;
		for(int i=1; i<= E; i++)
		{
		    st = new StringTokenizer(br.readLine());
		    dx = Integer.parseInt(st.nextToken());
		    dy = Integer.parseInt(st.nextToken());
		    adj[dx].add(dy);
		    adj[dy].add(dx);
		}
		
		for(int i=1; i<= V; i++)
		{
		    if(order[i] != 0) continue;
		    dfs(i, 0);
		}
		System.out.println(cnt);
		for(int i=1; i<= V;i ++)
		{
		    if(ans[i] == 1) System.out.print(i+" ");
		}
		System.out.println();
		
	}
	public static int dfs(int cur, int p)
	{
	    order[cur] = ++number;
	    int ret = order[cur], child = 0;
	    
	    for(int next : adj[cur])
	    {
	        if(next == p) continue;
	        if(order[next] != 0 )
	        {
	            ret = min(ret, order[next]);
	            continue;
	        }
	        child++;
	        
	        int prev = dfs(next, cur);
	        
	        if(p != 0 && order[cur] <= prev && ans[cur] == 0)
	        {
	            ans[cur] = 1;
	            cnt++;
	        }
	        ret = min(ret, prev);
	    }
	    
	    if(p == 0 && child >= 2 && ans[cur] == 0 )
	    {
	        ans[cur] = 1;
	        cnt++;
	    }
	    
	    return ret;
	}
	public static int min(int a, int b) { return a > b ? b: a; }
}






