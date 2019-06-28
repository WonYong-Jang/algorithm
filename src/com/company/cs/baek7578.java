package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 공장 
 */
public class baek7578 {

	static long result;
	static final int max_value = 500001;
	static int N, start, end;
	static int[] tree = new int[max_value*4];
	static int[] map = new int[max_value];
	static HashMap<Integer, Integer> set = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		start = 1;
		while(N > start) start *= 2;
		end = start + N -1;
		
		result = 0;
		int num = 0, index = start;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			set.put(num, i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			map[i] = set.get(num);
			tree[index++] = 1;
		}
		
		for(int i=end/2; i>=1; i--)
		{
			tree[i] = tree[i*2] + tree[i*2+1];
		}
		
		long tmp = 0;
		for(int i=1; i<= N; i++)
		{
			tmp = get(1,map[i]-1);
			set(0, map[i]);
			result += tmp;
		}
		System.out.println(result);
	}
	public static void set(int num, int sdx)
	{
		int idx = sdx + start - 1;
		tree[idx] = num;
		while(idx > 1)
		{
			idx/=2;
			tree[idx] = tree[idx*2] + tree[idx*2+1];
		}
	}
	public static long get(int sx, int ex)
	{
		long sum = 0;
		int sdx = start + sx - 1;
		int edx = start + ex - 1;
		
		while(sdx <= edx)
		{
			if(sdx % 2 != 0) sum += tree[sdx];
			if(edx % 2 == 0) sum += tree[edx];
			
			sdx = (sdx + 1) / 2;
			edx = (edx - 1) / 2;
		}
		
		return sum;
	}
}
