package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 로또 ( 백 트래킹 )
 */
public class baek6603 {

	static final int K = 6;
	static int[] data = new int[14];
	static ArrayList<Integer> arr = new ArrayList<>();
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			arr.clear();
			for(int i=1; i<= N; i++)
			{
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<= N - K + 1; i++)
			{
				arr.add(data[i]);
				solve(i, 1);
				arr.remove(arr.size()-1);
			}
			bw.write("\n");
		}
		bw.flush();
	}
	public static void solve(int index, int cnt) throws IOException
	{
		
		if( cnt == K )
		{
			for(int i=0; i< K; i++)
			{
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=index+1; i<= N ; i++)
		{
			arr.add(data[i]);
			solve(i, 1 + cnt);
			arr.remove(arr.size()-1);
		}
			
	}
	
}
