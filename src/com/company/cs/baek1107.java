package com.company.cs;
/**
 * 리모컨 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek1107 {

	static final int MAX = 1000000; // N 이 오십만인데 채널이 넘어 갈수 있으므로 일단 2배 확인 
	static int N, M, ans;
	static boolean[] visit = new boolean[12]; // 0 ~ 9 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		init(); // 전부 리모콘 true 초기화 
		if(M > 0 ) st = new StringTokenizer(br.readLine());
		for(int i=0; i< M; i++)
		{
			int temp = Integer.parseInt(st.nextToken());
			visit[temp] = false; //  고장난 채널 체크 
		}
		
		ans = abs(N, 100); // 시작점 100 이랑 먼저 목표점 확인 해보기
		// 목표점이 100 일땐 그냥 0이 최소기 때문 
		
		// max 보다 2배 정도로 잡아서 최악의경우 두배의 수에서 -- 할수도 ? 
		for(int i=0; i<= MAX; i++)
		{
			solve(i);
		}
		
		System.out.println(ans);
	}
	public static void solve(int num)
	{ 
		
		int target = num; 
		int digit =0;
		do  // 시작점 0이고 목표점 0일땐 버튼 하나면 끝나기 때문 do while 
		{
			int temp = target % 10;
			if( visit[temp] == false ) return;
			target /= 10;
			digit++;
		}
		while(target > 0 );
		
		
		int result = abs(num, N); // 숫자 버튼으로 누른 숫자차이
		ans = min(ans, result + digit);
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static void init()
	{
		for(int i=0; i <= 9; i++) visit[i] = true;
	}
}

/**
반례
101
0
=> 1

0
0
=> 1


 * */

