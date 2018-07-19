package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 보물 찾기 ( 390927 ) 
 *
 */
public class sds_Treasure {

	static int[] visited = new int[10001]; // 방문 확인 배열
	static ArrayList<ArrayList<Integer>> arr;
	static int N, M, K; // 유적의 수, 단서의 수 , 화산 폭발 까지 남은 시간
	static int flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= testCase; k++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= N ; i++) {
				arr.add(new ArrayList<>());
				visited[i] = 0;
			}
			flag = 20000;

			for (int i = 0; i < M; i++) // 단서 수 입력 받기
			{
				st = new StringTokenizer(br.readLine());
				int dx = Integer.parseInt(st.nextToken());
				int dy = Integer.parseInt(st.nextToken());
				arr.get(dx).add(dy); // dx -> dy
			}
			visited[1] = 1;
			for (int nextValue : arr.get(1)) 
			{
				visited[nextValue] = 1;
				dfs(nextValue, 1);
				visited[nextValue] = 0;
			}
			if(flag == 20000) System.out.println("#" + k + " " + -1);
			else System.out.println("#" + k + " " + flag);
		}
	}
	public static void dfs(int curNode, int cnt) {
		if(flag < cnt) return;
		
		if (cnt > K ) {
			return; // 화산 폭발 했을 경우
		}
		if (curNode == N) { // 보물을 찾은경우
			flag = Math.min(flag, cnt);
			return;
		}
		
		for(int nextValue : arr.get(curNode)) 
		{
			if(visited[nextValue] == 1) continue;
			visited[nextValue] = 1;
			dfs(nextValue, cnt+1);
			visited[nextValue] = 0;
		}
	}
}
