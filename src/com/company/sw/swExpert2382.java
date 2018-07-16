package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미생물 격리 ( 모의 SW 역량 테스트 ) 
 */
public class swExpert2382 {

	static int N, M, K; // 셀의 갯수, 격리 시간, 미생물 군집의 수
	static Queue<Node> que = new LinkedList<>();
	static int[][] map = new int[101][101]; // 처음 input 
	static int[][] visited = new int[101][101]; // 방문 표시 ( 시간으로 중복인지 확인 할수 있음) 
	static int[][] checkMax = new int[101][101]; //가장 큰 미생물 수 찾기 위한 배열 
	static int[][] axisArr = new int[101][101]; // 가장 큰 미생물수 배열 에 방향 정보 
	static int[][] sumArr = new int[101][101]; 
	static int[] dxArr = {0, -1, 1, 0, 0}, dyArr = {0 , 0, 0, -1, 1}; // 상 하 좌 우 
	static int[] reverse = {0,2,1,4,3}; // 반대 방향 인덱스 ! 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		int dx, dy, cnt, dir;
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			init();
			for(int i=0; i<K ;i++) // input 
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				que.add(new Node(dx, dy, cnt, dir, 0));
				sumArr[dx][dy] = cnt;
				checkMax[dx][dy] = cnt;
				axisArr[dx][dy] = dir;
			}
			
			solve();
			printSum();
			//System.out.println("#"+k+" "+printSum());
		}
	}
	public static void solve()
	{
		
		while(!que.isEmpty())  
		{
			if(que.peek().min == M) {
				break;
			}
			Node node = que.poll();
			int sum = node.sum;
			int dir = node.dir;
			int min = node.min;
			
			System.out.println("( " +node.dx+", "+node.dy+" ) "+ sum +" "+dir+" "+min);
			System.out.println(sumArr[node.dx][node.dy]+" // "+ axisArr[node.dx][node.dy]);
			
			if(axisArr[node.dx][node.dy] != dir) 
			{
				//System.out.println("continue : "+node.dx+" "+node.dy);
				continue;
			}
			int rDx = node.dx + dxArr[dir];
			int rDy = node.dy + dyArr[dir];
			min++; // 시간 증가 
			if(isBoundary(rDx, rDy)) { // 약품 처리 공간에 접근 할 경우 
				dir = reverse[dir]; // 반대 방향 바꾸기
				sum /= 2;
				sumArr[rDx][rDy] = sum;
				axisArr[rDx][rDy] = dir;
				visited[rDx][rDy] = min;
				
			}
			else if(visited[rDx][rDy] == min && min > 0) { // 중복 
				if(checkMax[rDx][rDy] < sum) {
					checkMax[rDx][rDy] = sum;
					axisArr[rDx][rDy] = dir;
				}
				sumArr[rDx][rDy] += sum;
			}
			else {
				
				visited[rDx][rDy] = min;
				checkMax[rDx][rDy] = sum;
				axisArr[rDx][rDy] = dir;
				sumArr[rDx][rDy] = sum;
			}
			que.add(new Node(rDx,rDy,sumArr[rDx][rDy],axisArr[rDx][rDy],min));
		}
	}
	public static int printSum()
	{
		int sum=0;
		System.out.println(que.size());
		while(!que.isEmpty())
		{
			Node node = que.poll();
			
			System.out.println(node.dx+" "+node.dy+" // "+node.sum);
		}
		for(int i=0; i<N; i++)
		{
			for(int j=0; j< N; j++)
			{
				//System.out.print(sumArr[i][j]+" ");
			}
			System.out.println();
		}
		return sum;
	}

	public static boolean isBoundary(int dx, int dy) { // 군집이 약품 처리 공간에 들어 왔는지 확인 
		return dx ==0 || dy == 0 || dx == N-1 || dy == N-1;
	}
	public static void init()
	{
		que.clear();
		for(int i=0; i< N; i++)
		{
			for(int j=0; j<N; j++)
			{
				visited[i][j] = 0;
				checkMax[i][j] = 0;
				sumArr[i][j] = 0;
				axisArr[i][j] = 0;
			}
		}
	}
	static class Node{
		int dx, dy, sum, dir, min; // x,y좌표, 미생물 합, 방향, 시간  
		Node(int a, int b, int c, int d, int e){
			dx= a; dy=b; sum =c; dir =d; min =e;
		}
	}
}
