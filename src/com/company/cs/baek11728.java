package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 배열 합치기 
 */
public class baek11728 {

	static int N, M;
	static ArrayList<Integer> arr1 = new ArrayList<>();
	static ArrayList<Integer> arr2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int num = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			arr1.add(num);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= M; i++)
		{
			num = Integer.parseInt(st.nextToken());
			arr2.add(num);
		}
		
		arr1.addAll(arr2);
		Collections.sort(arr1);
		for(int next : arr1)
		{
			bw.write(next+" ");
		}
		bw.write("\n");
		bw.flush();
	}

}
