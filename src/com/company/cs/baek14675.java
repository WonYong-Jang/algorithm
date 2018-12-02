package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 단절점과 단절선 
 */
public class baek14675 {

	static int N, K;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int dx =0, dy =0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(dx == 1) // 단절점  
			{
				int child =0;
				for(int next : adj.get(dy))
				{
					child++;
				}
				if(child >=2) bw.write("yes\n");
				else bw.write("no\n");
			}
			else if(dx == 2) // 단절선 
			{
				bw.write("yes\n");
			}
		}
		bw.flush();
	}
}






