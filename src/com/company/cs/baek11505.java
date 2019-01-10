package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek11505 {

	static final int mod = 1000000007;
	static final int max_node = 1000001;
	static long[] tree = new long[4*max_node];
	static int N, M, K, s, e;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		s=1;
		while(N > s) s *= 2;
		e = s + N - 1;
		
		for(int i=1; i<= N*4; i++) tree[i] = 1;
		
		for(int i=s; i<= e; i++)
		{
			st = new StringTokenizer(br.readLine());
			tree[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i=e/2; i>=1 ;i--)
		{
			tree[i] = (tree[i*2] * tree[i*2+1]) % mod;
		}
		
		int cmd =0, dx=0, dy=0;
		long value =0;
		for(int i=1; i<= M + K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				value = Long.parseLong(st.nextToken());
				update(dx, value);
			}
			else {
				dy = Integer.parseInt(st.nextToken());
				query(dx, dy);
			}
		}
	}
	public static void query(int sdx, int edx)
	{
		int sx = sdx + s - 1;
		int ex = edx + s - 1;
		long result = 1;
		while(sx <= ex)
		{
			if(sx % 2 != 0) result = (result * tree[sx]) % mod;
			if(ex % 2 ==0 ) result = (result * tree[ex]) % mod;
			
			sx = (sx + 1) / 2;
			ex = (ex - 1) / 2;
		}
		System.out.println(result);
	}
	public static void update(int idx, long num)
	{
		int sdx = idx + s - 1;
		tree[sdx] = num;
		while(sdx > 1)
		{
			sdx /=2;
			tree[sdx] = (tree[sdx*2] * tree[sdx*2+1]) % mod;
		}
	}
}








