package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 음주 코딩 
 */
public class baek5676 {

	static final int max_node = 100005;
	static long[] tree = new long[4*max_node];
	static int N, M, start, end;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String str = "";
		while( (str = br.readLine()) != null )
		{
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			start = 1;
			while(N > start) start *= 2;
			end = start + N - 1;
			
			for(int i=1; i<= N*4; i++) tree[i] = 1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = start; i< start + N; i++)
			{
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = end / 2; i > 0; i--)
			{
				tree[i] = ( tree[i*2] * tree[(i*2) + 1] ) % 1000000007;
			}
			
			char ch = ' ';
			int dx = 0, dy = 0;
			
			for(int i=1; i<= M; i++)
			{
				st = new StringTokenizer(br.readLine());
				ch = st.nextToken().charAt(0);
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				if(ch == 'P')
				{
					if(dx > dy) {
						int tmp = dx;
						dx = dy;
						dy = tmp;
					}
					long mul = query(dx, dy);
					if(mul == 0) bw.write('0');
					else if(mul > 0) bw.write('+');
					else if(mul < 0) bw.write('-');
				}
				else if(ch == 'C')
				{
					update(dx,dy);
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
	public static void update(int idx, int num)
	{
		int s = idx + start - 1;
		tree[s] = num;
		while(s > 1)
		{
			s /= 2;
			tree[s] = ( tree[s*2] * tree[(s*2) + 1] ) % 1000000007;
		}
	}
	public static long query(int sdx, int edx)
	{
		int s = sdx + start - 1;
		int e = edx + start - 1;
		long ret = 1;
		while(s <= e)
		{
			if(s % 2 == 1)
			{
				ret *= tree[s];
				ret %= 1000000007;
			}
			if(e % 2 == 0)
			{
				ret *= tree[e];
				ret %= 1000000007;
			}
			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}
		
		return ret;
	}
}








