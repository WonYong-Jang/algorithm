package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nhn_test1 {

	static int[] data = new int[105];
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int index = 0;
		boolean check = false;
		while(st.hasMoreTokens()) 
		{
			int num = Integer.parseInt(st.nextToken());
			int limit = arr.size() - 1 - index;
			if(limit < 2) {
				arr.add(num);
			}
			else
			{
				boolean flag = false;
				for(int i= index; i< arr.size(); i++)
				{
					if(arr.get(i) == num) 
					{
						flag = true;
						break;
					}
				}
				if(!flag) {
					System.out.println(arr.get(index));
					check = true;
				}
				arr.add(num);
				index++;
			}
		}
		if(!check) System.out.println(0);
	}

}
