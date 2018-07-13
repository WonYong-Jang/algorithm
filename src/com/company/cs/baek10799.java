package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 쇠막대기 
 */
public class baek10799 {

	static int result =0, len;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		len = str.length();
		for(int i=0; i< len; i++) // solve 
		{
			char target = str.charAt(i);
			if(target == '(') stack.push(target);
			else {
				if(!stack.isEmpty()) {
					stack.pop();
					result += stack.size();
				}
			}
		}
		System.out.println(result);
	}

}
