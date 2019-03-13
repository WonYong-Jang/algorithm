package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek2336 {
	
	static final int INF = 50000000;
	static final int max_node = 500000;
	static int[] tree = new int[(4 * max_node )+ 2];
	static int[] first = new int[max_node+2];
	static int[] second = new int[max_node+2];
	static int[] third = new int[max_node+2];
	static int N, ans, start, end;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = 1;
		while(N > start) start *= 2;
		end = start + N - 1;
		
		for(int i= 0; i<= 4 * max_node; i++) tree[i] = INF;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++) first[i] = Integer.parseInt(st.nextToken());
		ans = 1;
		int num =0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++) 
		{
			num = Integer.parseInt(st.nextToken());
			second[num] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++) 
		{
			num = Integer.parseInt(st.nextToken());
			third[num] = i;
		}
		
		int curIdx = 0, prevIdx =0, prevNode =0, prevNum =0;
		for(int i=2; i<= 2; i++)
		{
			curIdx = first[i]; // 검사 진행할 타겟 
			prevIdx = first[i-1]; // 그 이전 노드를 이용하여 확인 
			prevNode = second[prevIdx];
			prevNum = third[prevIdx];
			update(prevNode, prevNum);
			int result = query(1, second[curIdx]);
			//System.out.println("쿼리 : "+ 1+" ~ "+ second[curIdx]);
			//System.out.println(curIdx +" "+  prevIdx + " "+prevNode+" "+prevNum);
			System.out.println("결과 : " +result + " "+ second[curIdx]);
			if(result > second[curIdx]) {
				//System.out.println("성공 : "+i);
				ans++;
			}
			
		}
		
		System.out.println(ans);
	}
	public static int query(int dx, int dy)
	{
		int s = dx + start - 1;
		int e = dy + start - 1;
		int value = INF;
		while(s <= e)
		{
			if(s % 2 != 0) value = min(value, tree[s]);
			if(e % 2 == 0) value = min(value, tree[e]);
			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}
		return value;
	}
	public static void update(int idx, int num)
	{
		int dx = idx + start - 1;
		tree[dx] = num;
		while(dx > 1)
		{
			dx /= 2;
			tree[dx] = min(tree[dx*2], tree[dx*2 + 1]);
		}
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}

/**
6
1 5 3 4 2 6
1 2 6 4 3 5
5 2 3 4 1 6 
 */


