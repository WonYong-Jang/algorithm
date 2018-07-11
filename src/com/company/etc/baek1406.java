package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
/**
 * 에디터  (링크드 리스트도 집접 구현해 보기 !!!, )
 */
public class baek1406 {
	
	static LinkedList<Character> vec = new LinkedList<>();
	static Stack<Character> left = new Stack<>();
	static Stack<Character> right = new Stack<>();
	static char[][] cmdArr = new char[500001][2];
	static int len, cmd; // 문자 길이 ,  커서 , 명령  
	static String str;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		len = str.length();
		for(int i=0; i<len; i++) // input 
		{
			left.push(str.charAt(i));
		}
		
		cmd = Integer.parseInt(br.readLine());
		for(int i=0; i< cmd; i++) // cmd input 
		{
			st = new StringTokenizer(br.readLine());
			char temp = st.nextToken().charAt(0);
			cmdArr[i][0] = temp;
			if(temp == 'P') cmdArr[i][1] = st.nextToken().charAt(0);
			
			command(cmdArr[i][0], i);
		}
		setting();
		while(!right.isEmpty())
		{
			sb.append(right.pop());
		}
		System.out.println(sb);
	}
	public static void setting() {
		while(!left.isEmpty())
		{
			right.push(left.pop());
		}
	}
	public static void command(char cmd, int index)
	{
		char temp;
		if(cmd == 'L')
		{
			if(!left.isEmpty()) 
			{
				temp = left.pop();
				right.push(temp);
			}
		}
		else if(cmd == 'D')
		{
			if(!right.isEmpty())
			{
				temp = right.pop();
				left.push(temp);
			}
		}
		else if(cmd == 'B')
		{
			if(!left.isEmpty())
			{
				left.pop();
			}
		}
		else if(cmd =='P')
		{
			left.push(cmdArr[index][1]);
		}
	}
	
}








