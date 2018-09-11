package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** 
 * 개미 
 */
public class baek3048 {

	static final int max = 26;
	static int N, M, T, index;
	static Deque<Character> que = new ArrayDeque<>();
	static char[] data = new char[26];
	static int[] check = new int[26];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		char temp;
		index =0;
		for(int i=1; i<= N; i++)
		{
			temp = str.charAt(i-1);
			que.addLast(temp);
		}
		while(!que.isEmpty())
		{
			char target = que.pollLast();
			data[index] = target;
			check[index] = 1;
			index++;
		}
		str = br.readLine();
		for(int i=1; i<= M; i++)
		{
			temp = str.charAt(i-1);
			que.add(temp);
		}
		while(!que.isEmpty())
		{
			char target = que.pollFirst();
			data[index] = target;
			check[index] = 2;
			index++;
		}
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		solve();
		for(int i=0; i<index; i++)
		{
			System.out.print(data[i]);
		}
		System.out.println();
	}
	public static void solve()
	{
		for(int k=1; k<= T; k++)
		{
			for(int i=0; i< index-1; i++)
			{
				int next = i + 1;
				if(check[i] == 1 && check[next] == 2)
				{
					swap(i, next);
					i++;
				}
			}
		}
	}
	public static void swap(int i, int j)
	{
		char temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		int tmp = check[i];
		check[i] = check[j];
		check[j] = tmp;
	}
}
