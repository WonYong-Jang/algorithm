package com.company.cs;

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
 *
 */
public class baek1946 {

	static int N;
	static ArrayList<Node> arr = new ArrayList<>();
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
			arr.clear();
			int dx =0, dy=0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				arr.add(new Node(dx,dy));
			}
			Collections.sort(arr, new mySort());
			
			int min = arr.get(0).dy;
			int result = 1;
			for(int i= 1; i< N; i++)
			{
				if(min > arr.get(i).dy)
				{
					min = arr.get(i).dy;
					result++;
				}
				
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else return 0;
		}
		
	}
	static class Node {
		int dx, dy;
		Node(int a, int b){
			dx=a; dy=b;
		}
	}
}
