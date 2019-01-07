package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 듣보잡 
 */
public class baek1764 {

	static final int max_node = 500005;
	static int N, M;
	static String[] sc = new String[max_node];
	static String[] tc = new String[max_node];
	static PriorityQueue<String> que = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String str = "";
		for(int i=1; i<= N; i++)
		{
			str = br.readLine();
			sc[i] = str;
		}
		for(int i=1; i<= M; i++)
		{
			str = br.readLine();
			tc[i] = str;
		}
		
		Arrays.sort(tc, 1, M+1);
		
		for(int i=1; i<= N; i++)
		{
			str = sc[i];
			if(search(1, M, str))
			{
				que.add(str);
			}
		}
		
		if(!que.isEmpty()) bw.write(que.size()+"\n");
		else bw.write(0+"\n");
		
		while(!que.isEmpty())
		{
			bw.write(que.poll()+"\n");
		}
		bw.flush();
	}
	public static boolean search(int s, int e, String target)
	{
		int mid =0;
		while(s <= e)
		{
			mid = ( s + e ) / 2;
			
			if(tc[mid].compareTo(target) == 0) return true;
			else if(tc[mid].compareTo(target) < 0) {
				s = mid +1;
			}
			else if(tc[mid].compareTo(target) > 0) {
				e = mid - 1;
			}
		}
		return false;
	}
}





