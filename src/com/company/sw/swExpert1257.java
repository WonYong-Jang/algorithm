package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swExpert1257 {

	static int K, len;
	static String str;
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			set.clear();
			str = br.readLine();
			len = str.length();
			
			for(int i=0; i< len; i++)
			{
				for(int j=i; j< len; j++ )
				{
					set.add(str.substring(i, j+1));
				}
			}
			
			ArrayList<String> arr = new ArrayList<>(set);
			Collections.sort(arr);
			String result = "none";
			if(arr.size() >= K)
			{
				result = arr.get(K-1);
			}
			
			bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}

}
