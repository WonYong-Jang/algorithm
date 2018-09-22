package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [ 모의 sw 역량 테스트 ] 차량 정비소 
 */
public class swExpert2477 {

	static int N, M, K, A, B;
	static int[][] rArr = new int[2][11]; // 접수 창구 / 0 상담 시간 기록 / 1 방 비어있는지 유무 
	static int[][] jArr = new int[2][11]; // 정비 창구
	static Queue<Integer> rQue = new LinkedList<>();
	static Queue<Integer> jQue = new LinkedList<>();
	static ArrayList<Node> person = new ArrayList<>();
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
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			person.clear(); rQue.clear(); jQue.clear();
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++) // 접수 창구 
			{
				rArr[0][i] = Integer.parseInt(st.nextToken());
				rArr[1][i] = 0;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= M; i++) // 정비 창구 
			{
				jArr[0][i] = Integer.parseInt(st.nextToken());
				jArr[1][i] = 0;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< K; i++)
			{
				int temp = Integer.parseInt(st.nextToken());
				person.add(new Node(0,0,0, temp ,i+1)); // 도착 시간 , 고객 번호 
			}
			
			solve();
			int ans = 0;
			for(int i=0; i< person.size(); i++)
			{
				if(person.get(i).r == A && person.get(i).j == B) ans += (i+1);
			}
			if(ans == 0 ) ans = -1;
			bw.write("#"+k+" "+ans+"\n");
			//debug();
		}
		bw.flush();
	}
	public static void solve()
	{
		int time = 0, len =0, target = person.size();
		int num = 0;
		while(target > 0) // 0 이 되면 사람이 모두 이동 완료 
		{
			len = person.size();
			for(int i=0; i< len; i++) // 대기 중이고 도착 시간이 되면 접수창구 갈 준비 
			{
				int arrive = person.get(i).arrive;
				if(arrive == time) rQue.add(person.get(i).num);
			}
			
			len = rQue.size();
			for(int i=0; i< len; i++)
			{
				for(int j=1; j<= N; j++) // 접수 창구 확인 후 배정 
				{
					if(rArr[1][j] == 0)
					{
						if(!rQue.isEmpty()) num = rQue.poll();
						rArr[1][j] = num; // 고객 번호 기록 접수창구 이용 중 
						person.get(num-1).start = time; // 이용 시작 시간
						person.get(num-1).r = j; // 접수창구 번호 기록
						break;
					}
				}
			}
			
			
			
			len = jQue.size();
			for(int i=0; i< len; i++)
			{
				for(int j= 1; j<= M; j++) // 정비 창구 확인 후 배정 
				{
					if(jArr[1][j] == 0)
					{
						if(!jQue.isEmpty()) num = jQue.poll();	
						jArr[1][j] = num;
						person.get(num-1).start = time;
						person.get(num-1).j = j;
						break;
					}
				}
			}
			
			for(int i=1; i<= N; i++) // 접수 창구 끝난 사람 확인 
			{
				if(rArr[1][i] == 0 ) continue;
				num = rArr[1][i];
				int start = person.get(num-1).start;
				if(start + rArr[0][i] - 1 == time)
				{
					rArr[1][i] = 0;
					jQue.add(person.get(num-1).num); // 정비 창구 큐 이동 
				}
			}
			
			for(int i=1; i<= M; i++)
			{
				if(jArr[1][i] == 0) continue;
				num = jArr[1][i];
				int start = person.get(num-1).start;
				if(start + jArr[0][i] - 1 == time)
				{
					jArr[1][i] = 0;
					target--;
				}
			}
			
			time++;
		}
	}
	public static void debug()
	{
		for(int i=0; i< person.size(); i++)
		{
			System.out.println(person.get(i).r +" "+ person.get(i).j);
		}
	}
	static class Node {
		int r, j, start, arrive, num; // r, j : 접수, 정비 창구 번호 , start 시작 시간, 도착 시간, 현재 상태  
		Node(int a, int b, int c, int d, int e) {
			r = a; j = b; start = c; arrive = d; num = e;
		}
	}
}
