package com.company.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 벌꿀 채취  (모의 테스트 )  
 */
public class swExpert2115 {
	
	public static int[][] map = new int[11][11];
	public static int[][] visited = new int[11][11];
	public static ArrayList<Integer> arr1 = new ArrayList<>();
	public static ArrayList<Integer> arr2 = new ArrayList<>();
	public static int maxValue1 = 0, maxValue2 = 0, result=0;
	public static int N, M ,C; // 벌통의 크기, 선택할수 있는 벌통 갯수, 꿀 채취할수 있는 최대 양 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k<=testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			init();
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N-M+1; j++)
				{
					visited[i][j] = 1;
					dfs(i, j, 1, 1);
					visited[i][j] = 0;
					
				}
			}
			
			System.out.println("#"+k+" "+result);
		}
	}
	public static void dfs(int dx, int dy, int cnt, int flag) 
	{
		if(flag == 1) // 처음 벌통 영역  
		{
			if(cnt == M) 
			{
				dfs(dx,dy, 0, 2); // 두번째 벌통 검사하러 가기  
			}
			else {
				int rDy = dy + 1;
				if(rDy > N || visited[dx][rDy] > 0 ) return; 
				visited[dx][rDy] = 1;
				dfs(dx, rDy, cnt+1, flag);
				visited[dx][rDy] = 0;
			}
		}
		else // 두번째 벌통 영역 flag == 2
		{
			if(cnt == 0) 
			{
				for(int i=dx; i<=N; i++)
				{
					for(int j=1; j<= N-M+1; j++)
					{
						if(visited[i][j] > 0) continue;
						visited[i][j] = 2;
						dfs(i, j, 1, 2);
						visited[i][j] = 0;
					}
				}
			}
			else 
			{
				if(cnt == M) { // 검사 후 리턴  
					
					int temp = solution(); // arr1 , arr2 각 visited 배열 이용하여 셋팅 후 검
					
					result = Integer.max(result, temp);
					
					return;
				}
				else {
					int rDy = dy + 1;
					if(rDy > N || visited[dx][rDy] > 0) return; 
					visited[dx][rDy] = 2;
					dfs(dx, rDy, cnt+1, flag);
					visited[dx][rDy] = 0;
				}
			}
		}
	}
	public static int solution() {
		arr1.clear();
		arr2.clear();
		maxValue1=0; maxValue2=0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(visited[i][j] == 1) arr1.add(map[i][j]);
				else if(visited[i][j] == 2) arr2.add(map[i][j]);
			}
		}
		int sum =0, temp=0;
		for(int i=1; i< (1<<M) ; i++)
		{
			sum=0; temp=0;
			for(int j=0; j<M; j++)
			{
				if( (i & (1<<j)) >0)
				{
					sum += arr1.get(j);
					temp += (arr1.get(j)*arr1.get(j));
				}
			}
			if(sum <= C) {
				maxValue1 = Integer.max(maxValue1, temp);
			}
		}
		
		for(int i=1; i< (1<<M) ; i++)
		{
			sum=0; temp=0;
			for(int j=0; j<M; j++)
			{
				if( (i & (1<<j)) >0)
				{
					sum += arr2.get(j);
					temp += (arr2.get(j)*arr2.get(j));
				}
			}
			if(sum <= C) {
				maxValue2 = Integer.max(maxValue2, temp);
			}
		}
		return maxValue1 + maxValue2;
	}
	public static void init()
	{
		result=0;
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++)
				visited[i][j] =0;
	}
}





