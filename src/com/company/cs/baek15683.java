package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 감시  
 */
public class baek15683 {

	public static int[][] map = new int[10][10]; // 전체 맵 
	public static int[][][] originMap = new int[10][10][10]; // 최대 cctv 갯수 8개 넘지 않는다. 
	public static int N,M, minValue = 100000, len=0; // len : 전체 cctv 갯수  
	public static ArrayList<Point> cctv = new ArrayList<>(); // cctv 배열로 저장  
	public static ArrayList<ArrayList<Integer>> info = new ArrayList<ArrayList<Integer>>();
	public static int[] dxArr= {0, 1, 0, -1}, dyArr = {1, 0, -1, 0}; // 4방향  
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				int type = Integer.parseInt(st.nextToken());
				originMap[0][i][j] = map[i][j] = type; // input
				if(type >=1 && type <=5) cctv.add(new Point(i,j, type)); // cctv info  
			}
		}
		init(); 
		len = cctv.size(); // 전체 cctv 갯수 
		if(len != 0)
		{
			int type = cctv.get(0).type; // 검사할 첫번째 몇번 cctv 인지 확인 
			int curLen = info.get(type).size();
			
			for(int i=0; i<curLen; i++) // cctv 마다 검사할 방향이 다르므로 
			{
				dfs(0,type, info.get(type).get(i) );
				initMap(0);
			}
		}
		else { // cctv가 없을 경우도 있나? 
			calZero();
		}
		System.out.println(minValue);
	}
	public static void dfs(int curIndex, int type, int target)
	{
		for(int i=0; i< 4; i++) // 4방향중 비트마스크를 이용하여 해당 방향 move 
		{
			if( ( target & (1<<i)) > 0 ) 
			{
				move(cctv.get(curIndex).dx,cctv.get(curIndex).dy, i, curIndex +1);
			}
		}
		
		if(len-1 == curIndex) {
			// 전체 검사하면서 0의 갯수 검사 후 전 단계 map 으로 초기화 해주는 작업  
			calZero();
			return;
		}

		for(int i=1; i<= N; i++) // 작업 단계 별로 저장  
			for(int j=1; j<= M; j++)
				originMap[curIndex+1][i][j] = map[i][j];
		
		int nextType = cctv.get(curIndex+1).type; // 검사할 첫번째 몇번 cctv 인지 확인 
		int curLen = info.get(nextType).size(); // 몇번 회전을 검사 해야 하는지   
		
		for(int i=0; i<curLen; i++) // cctv 마다 검사할 방향이 다르므로 
		{
			dfs(curIndex+1, nextType, info.get(nextType).get(i) );
			initMap(curIndex+1); // 맵 초기화 
		}
		
	}
	public static void move(int dx,int dy, int dir, int index) //해당 방향으로 이동  
	{
		int rDx = dx +dxArr[dir];
		int rDy = dy +dyArr[dir];

		if(rDx > 0 && rDy >0 && rDx <= N && rDy <= M && map[rDx][rDy] == 0 ) {
			map[rDx][rDy]= 7;
			move(rDx,rDy,dir,index);
		}
		else if(map[rDx][rDy] >=1 && map[rDx][rDy] <=5 || map[rDx][rDy] == 7) move(rDx,rDy,dir,index); //cctv 통과 
		else return;
	}
	public static void initMap(int depth) {
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(!(map[i][j] >= 1 && map[i][j] <=6)) {
					map[i][j] = originMap[depth][i][j];
				}
			}
		}
		
	}
	public static void calZero()  // 사각지대 계산  
	{
		int cnt =0;
		for(int i=1; i<= N; i++)
			for(int j=1; j<= M; j++)
				if(map[i][j]==0) cnt++;
		minValue = Integer.min(minValue, cnt);
	}
	public static void init() {
		for(int i=0; i<=5;i++)
		{
			info.add(new ArrayList<>());
		}
		info.get(1).addAll(Arrays.asList(1,2,4,8)); // 1번 cctv
		info.get(2).addAll(Arrays.asList(5, 10)); // 2번 cctv
		info.get(3).addAll(Arrays.asList(9,3,6,12)); // 3번 cctv
		info.get(4).addAll(Arrays.asList(13,11,7,14)); // 4번 cctv
		info.get(5).addAll(Arrays.asList(15)); // 5번 cctv
		
	}
	public static class Point{
		int dx,dy, type;
		Point(int x, int y, int z) {
			dx =x; dy = y; type = z;
		}
	}
}


