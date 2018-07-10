package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호 ( 스택 ) 
 *
 */
public class baek9012 {

	static int N, len; 
	static boolean flag;
	static char[] map = new char[51];
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int k=1; k<=N; k++)
		{
			String str = br.readLine();
			len = str.length();
			
			flag = true;
			
			for(int m=0; m< len; m++)
				map[m] = str.charAt(m);
			
			solve();
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	public static void solve() {
		stack.clear();
		for(int i =0; i< len; i++)
		{
			if(map[i] == '(') stack.push('(');
			else {
				if(!stack.isEmpty()) stack.pop();
				else 
				{
					flag = false;
					return;
				}
			}
		}
		if(!stack.isEmpty()) flag = false;
	}
}
