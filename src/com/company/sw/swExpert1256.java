package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * k번째 접미어 
 */
public class swExpert1256 {

	static int N;
	static ArrayList<String> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int len = str.length();
			arr.clear();
			
			for(int i=0; i< len; i++)
			{
				arr.add(str.substring(i, len));
			}
			
			Collections.sort(arr, String.CASE_INSENSITIVE_ORDER);
			
			bw.write("#"+k+" "+arr.get(N-1)+"\n");
		}
		bw.flush();
	}
	
}
