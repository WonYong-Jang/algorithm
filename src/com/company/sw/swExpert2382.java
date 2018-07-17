package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 미생물 격리 
 */
public class swExpert2382 {
	
	static ArrayList<Node> arr;
	static int N, M, K;
	static int[] dxArr = {0,-1,1,0,0}, dyArr = {0,0,0,-1,1}; //  상 하 좌 우 / 1 2 3 4
	static int[] reverse = {0,2,1,4,3};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k<= testCase; k++)
		{
			int dx, dy, sum, dir;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			for(int i=0; i< K; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				sum = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				arr.add(new Node(dx,dy,sum,dir));
				
			}
			solve();
			int result=0;
			for(int i=0; i< arr.size(); i++)
			{
				if(arr.get(i).sum ==0) continue;
				result += arr.get(i).sum;
			}
			
			System.out.println("#"+k+" "+result);
		}
	}
	public static void solve()
	{
		for(int k=0; k< M; k++) // 해당 시간 만큼 
		{
			int[][] dirMap = new int[N][N]; // 방향 저장 
			int[][] sumMap = new int[N][N]; // 전체 합 
			int[][] maxMap = new int[N][N]; // 가장 큰 값 찾는 
			
			for(int i=0; i< arr.size(); i++)
			{
				if(arr.get(i).sum == 0) continue;
				
				int dir = arr.get(i).dir;
				int sum = arr.get(i).sum;
				
				int rDx = arr.get(i).dx + dxArr[dir];
				int rDy = arr.get(i).dy + dyArr[dir];
				
				if(isBoundary(rDx, rDy)) { // 경계선
					dirMap[rDx][rDy] = reverse[dir]; // 반대 방향 
					sumMap[rDx][rDy] = sum/2 ;
				}
				else if(sumMap[rDx][rDy] != 0) { // 겹쳤을 때 
					sumMap[rDx][rDy] += sum;
					if(maxMap[rDx][rDy] < sum) {
						maxMap[rDx][rDy] = sum;
						dirMap[rDx][rDy] = dir;
					}
				}
				else {
					sumMap[rDx][rDy] = sum;
					maxMap[rDx][rDy] = sum;
					dirMap[rDx][rDy] = dir;
				}
			}
			arr.clear();
			for(int i=0; i< N; i++)
			{
				for(int j=0; j< N; j++)
				{
					if(sumMap[i][j] > 0)
						arr.add(new Node(i,j,sumMap[i][j],dirMap[i][j]));
				}
			}
		}
	}
	public static boolean isBoundary(int dx, int dy) {
		return dx ==0 || dy ==0 || dx == N-1 || dy == N-1;
	}
	static class Node {
		int dx,dy, sum, dir;
		Node(int a, int b, int c, int d) {
			dx =a; dy =b; sum =c; dir=d;
		}
	}
}
