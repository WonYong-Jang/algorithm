package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 찾기  
 */
public class baek10809 {

	static int[] map = new int[26];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		setting();
		
		for(int i=0; i<len; i++)
		{
			int index = str.charAt(i) - 'a';
			if(map[index] == -1 ) map[index] = i;
		}
		for(int i=0; i<26; i++)
		{
			System.out.print(map[i]+" ");
		}
	}
	public static void setting()
	{
		for(int i=0; i<26; i++)
		{
			map[i] = -1;
		}
	}
}
