package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
/***
 * 일곱난쟁이 ( Brute Force ) 
 */
public class baek2309 {

	static int[] map = new int[9];
	static Deque<Integer> que = new ArrayDeque<>();
	static ArrayList<Integer> arr= new ArrayList<>();
	static int height;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++)
		{
			int temp = Integer.parseInt(br.readLine());
			map[i] = temp;
		}
		for(int i=0; i< 9; i++)
		{
			que.addLast(map[i]);
			dfs(i,1);
			que.pollLast();
		}
	}
	public static void dfs(int index ,int cnt)
	{
		if(flag) return;
		if(cnt == 7)
		{
			if(que.size()==7) {
				int temp = calculate();
				if(temp == 100) {
					arr.addAll(que);
					Collections.sort(arr);
					for(int i=0; i<7; i++)
						System.out.println(arr.get(i));
					flag = true;
				}
			}
			return;
		}
		for(int i=index+1;i < 9; i++)
		{
			que.addLast(map[i]);
			dfs(i,cnt+1);
			que.pollLast();
		}
	}
	public static int calculate()
	{
		int result =0;
		arr.addAll(que);
		for(int i=0; i<arr.size(); i++)
		{
			result += arr.get(i);
		}
		arr.clear();
		return result;
	}
}
