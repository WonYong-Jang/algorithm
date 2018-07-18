package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.company.cs.baek12100.Point;

/**
 * 톱니바퀴 
 */
public class baek14891 {

	static LinkedList<Character> arr1 = new LinkedList<>(); // 12시 방향 부터 시계방향 순으로 
	static LinkedList<Character> arr2 = new LinkedList<>();
	static LinkedList<Character> arr3 = new LinkedList<>();
	static LinkedList<Character> arr4 = new LinkedList<>();
	static LinkedList<LinkedList<Character>> list = new LinkedList<>();
	static Character[][] map = new Character[4][8];
	static int[] visited = new int[4];
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num =0, dir =0;
		for(int i=0; i<4; i++) // 톱니 바퀴 셋팅 
		{
			String str = br.readLine();
			for(int j=0; j< str.length(); j++)
			{
				map[i][j] = str.charAt(j);
				if(i==0) arr1.add(str.charAt(j));
				else if(i==1) arr2.add(str.charAt(j));
				else if(i==2) arr3.add(str.charAt(j));
				else if(i==3) arr4.add(str.charAt(j));
			}
		}
		N = Integer.parseInt(br.readLine());
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			visited[num]= num;
			solve(num,dir);
			visited[num]= 0;
		}
	}
	public static void solve(int num, int dir)
	{
		
		if(num+1 <= 4) { // 해당 인덱스에서 오른쪽 톱니 바퀴 //  
			if(map[num][2] != map[num+1][5]) { // 같지 않으면 반시계 방향 회전 
				
			}
		}
		// 2번 인덱스와 5번 인덱스 비교 
		
	}
	public static void leftTurn(int num) // 왼쪽 회전 
	{
		int[] temp = new int[8];
		for(int i=0; i< 8; i++)
		{
			temp[i] = map[num][i];
		}
	}
}




