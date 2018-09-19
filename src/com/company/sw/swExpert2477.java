package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [차량 정비소 ]
 */
public class swExpert2477 {

	static int N, M, K, A, B;  // K 고객 수 / 고객이 다녀간 접수창구, 정비 창구 (A, B)
	static int[][] data = new int[10][2]; // 1 ~ 9  접수 창구 걸리는 시간 / 0 : 접수 창구 / 1 : 정비 창구  
	static int[][] limit = new int[10][2]; // 해당 창구 비어 있는지 확인 
	static ArrayList<Node> person = new ArrayList<>(); // 1~ 1000
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase ; k++)
		{
			person.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				data[i][0] = Integer.parseInt(st.nextToken()) - 1; // 접수 창구 
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= M; i++)
			{
				data[i][1] = Integer.parseInt(st.nextToken()) - 1; // 정비 창구 
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= K; i++)
			{
				int min = Integer.parseInt(st.nextToken());
				person.add(new Node(min, -1));
			}
			solve();
		}
	}
	public static void solve()
	{
		int len = person.size();
		
		while(true)
		{
			int curMin =0, next = 0, blank =0;
			boolean flag = false;
			for(int i=0; i<len; i++)
			{
				int curPos = person.get(i).check; // 현재 어느 위치 있는지 확인 
				int min = person.get(i).min;
				if(curPos == 2) continue; // 이미 지나 간 경우 
				if(curMin == min ) // 창구가 비어있으면 갈수 있음 
				{
					next = curPos + 1;
					blank = checkBlank(next);
					if(blank != -1) 
					{
						min += data[blank][next];
						limit[blank][next]++;
					}
					
				}
			}
			
			curMin++; // 시간 증가 
			if(!flag) break;
		}
		
	}
	public static int checkBlank(int index)
	{
		int len = index != 0 ? M : N , target = -1; // 빈곳 없으면 -1 리턴 
		for(int i= 0; i< len; i++)
		{
			if( limit[i][index] == 0 ) {
				target = i; // 빈 곳 인덱스 리턴
				break;
			}
		}
		return target;
	}
	static class Node {
		int min, check; // 도착 시간과 창구를 다 도착한지 확인 check -1: 가기전  0:접수 창구  1 : 정비 창구  2 : 도착
		int[] flag = new int[2];
		Node(int a, int b) {
			min = a; check = b;
		}
	}
}
