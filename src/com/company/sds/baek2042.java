package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 ( 익덱스 트리 ! )
 * 
 *  1. 처음 값부터 인덱스 잡는 법 x2 씩 해 나가다가 N을 넘는 인덱스 ! 
 *  2. 전체 N * 4 ( 배열 전체로 잡으면 안전 ) ==> 리프 노드 갯수 n 과  internal 노드는 n-1 정도 되고 남는 리프노드 갯수 까 
 *  3. 구간 합이기 때문에 전체 배열 초기화는 0 !!!!
 *  4. 최소 구간을 구할때는 타입별 최대값을 넣어 놓고 최대구간을 구할때는 최소 구간을 넣어둠 
 */
public class baek2042 {

	static long[] tree;
	static int N, M, K, index, start;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		index = 1; start =1;
		tree = new long[N*4];
		while(N > index) index *= 2;
		start = index; // 첫번째 저장 
		index--;
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine());
			tree[++index] = Long.parseLong(st.nextToken());
		}
		init();
		
		int a,b,c;
		for(int i=1; i<= M+K; i++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a == 1) // b번째 수를 c로 바꾸기 
			{
				change(b,c);
			}
			else if(a == 2) // b ~ c 까지 구간 합 구하기 
			{
				internalSum(b, c);
			}
		}
		
	}
	public static void init()
	{
		for(int i=start-1; i > 0; i--) // 부모 노드 구간 합으로 초기화 
		{
			tree[i] = tree[i*2] + tree[i*2 + 1];
		}
	}
	public static void change(int idx, int num) // 인덱스 교체 및 구간 합 트리 업데이트 
	{
		int targetIdx = start + idx-1;
		tree[targetIdx] = num;
		while(targetIdx > 1) // 부모 노드 전부 업데이트  
		{
			targetIdx/=2; // 부모 노드로 이동
			tree[targetIdx] = tree[targetIdx*2]+ tree[targetIdx*2 + 1];
		}
	}
	public static void internalSum(int b, int c) // 구간 합 구하기 ! 
	{
		int startIdx = start + b -1; // 실제 인덱스로 변환 
		int endIdx = start + c -1;
		long sum =0;
		while(endIdx >= startIdx)
		{
			if(startIdx % 2 !=0) sum += tree[startIdx]; // 시작점과 끝점 확인 하면서 구간합 구하기 (트리)!!
			startIdx = (startIdx +1) / 2;
			
			if(endIdx % 2 ==0) sum += tree[endIdx];
			endIdx = (endIdx -1) / 2;
		}
		System.out.println(sum);
	}
}





