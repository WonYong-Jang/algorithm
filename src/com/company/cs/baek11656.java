package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 접미사 배열  
 */
public class baek11656 {

	static Queue<Character> input = new LinkedList<>();
	static ArrayList<String> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		for(int i=0; i< len; i++)
		{
			result.add(str.substring(i, len));
		}
		Collections.sort(result);
		for(int i=0; i< len; i++)
		{
			System.out.println(result.get(i));
		}
	}

}
