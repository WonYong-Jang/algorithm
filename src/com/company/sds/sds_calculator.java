package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 오래된 계산기 
 */
public class sds_calculator {

	static PriorityQueue<Long> que = new PriorityQueue<>(); //  우선순위 큐 이용 
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			que.clear();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) // input 
				que.add(Long.parseLong(st.nextToken()));
			
			long result = solve();
			System.out.println("#"+k+" "+ result);
		}
	}
	public static long solve()
	{
		long result =0, temp =0;
		int count = 1;
		while(!que.isEmpty()) // 우선순위 큐를 이용해서 작은 값부터 출력 해서 두개씩 더해나간 값이 최소 !
		{
			long target = que.poll();
			if(count % 2 == 0)
			{
				temp += target;
				que.add(temp);
				result += temp;
			}
			else temp = target;
			count++;
		}
		
		return result;
	}
}
/**
3        
3        
5 4 3
8
2 2 2 2 2 2 2 4
5
4 1 3 3 1
 */





