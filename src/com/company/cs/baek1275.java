package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 커피숍 2
 */
public class baek1275 {

	static final int max_node = 100005;
	static int N, M, start, end;
	static long[] tree = new long[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int size = 1;
		while(N > size) size *= 2;
		start = size;
		end = size + N - 1;
		
		int dx=0, dy=0, to=0, from=0;
		st = new StringTokenizer(br.readLine());
		for(int i=start; i< start + N; i++)
		{
			tree[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i= end/2; i > 0; i--) // init;
		{
			tree[i] = tree[i*2] + tree[(i*2) + 1];
		}
		
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(dx > dy) 
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			long num = query(dx, dy);
			update(from, to);
			bw.write(num+"\n");
		}
		bw.flush();
	}
	public static long query(int sdx, int edx)
	{
		long ret = 0;
		int s = sdx + start - 1;
		int e = edx + start - 1;
		
		while(s <= e)
		{
			if(s % 2 == 1)
			{
				ret += tree[s];
			}
			if(e % 2 ==0 )
			{
				ret += tree[e];
			}
			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}
		
		return ret;
	}
	public static void update(int idx, int num)
	{
		int s = idx + start - 1;
		tree[s] = num;
		while(s > 1)
		{
			s /= 2;
			tree[s] = tree[s*2] + tree[(s*2) + 1];
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
