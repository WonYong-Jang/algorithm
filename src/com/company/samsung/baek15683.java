package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 감시 
 */
public class baek15683 {

	static int N, M, ans, area;
	static int[][] cctv = {
			{1,2,4,8}, // 1번 cctv
			{5,10}, // 2
			{3,6,9,12}, // 3
			{7,11,13,14}, // 4
			{15} // 5
	};
	static int[][][] originMap = new int[10][11][11]; // cctv 최대 갯수 8개 
	static int[][] tempMap = new int[11][11];
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1}; // 북 동 남 서 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int wallCnt = 0; // 벽 갯수 카운트 변
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				originMap[0][i][j] = tempMap[i][j] = temp;
				if(temp == 6) wallCnt++;
				else if(temp >= 1 && temp <= 5) { // cctv 일 경우 
					arr.add(new Node(i, j, temp));
				}
			}
		}
		area = ans = N * M - (arr.size() + wallCnt); // 처음 사각지대 영역 계산 해놓고 시작
		
		if(arr.size() == 0) System.out.println(ans); // 사각지대 없는 경우 그냥 출력 
		else {
			solve(0, arr.size(), 0); // 현재 cctv 인덱스, 전체 cctv 사이즈, 사각지대 영역 갯수
			System.out.println(ans);
		}
	}
	public static void solve(int curSize, int size, int cnt)
	{
		if(curSize == size)
		{
			ans = min(ans, area - cnt); // ans = cctv 없는 사각지대(area) - cctv 돌렸을때 감시 영역
			return;
		}
		else 
		{
			for(int i=1; i<= N; i++)
				for(int j=1; j<= M; j++)
					originMap[curSize][i][j] = tempMap[i][j]; // 검사 전 원본 맵 복사해두고 시작
			
			int num = arr.get(curSize).num - 1; // 몇번 cctv 인지 
			int len = cctv[num].length; // 해당 cctv 몇번 회전 할수 있는지 
			int dx = arr.get(curSize).dx;
			int dy = arr.get(curSize).dy;
			
			for(int i=0; i< len; i++)
			{
				int target = cctv[num][i];
				int sum =0 ;
				for(int j=0; j< 4; j++)
				{
					if( (target & (1 << j)) > 0 )
					{
						int nx = dx + dxArr[j];
						int ny = dy + dyArr[j];
						sum += go(nx, ny, j); // 해당 방향으로 검사 진행 
					}
				}
				solve(curSize+1, size, cnt + sum);
				init(curSize); // 원본 맵으로 다시 초기화 
			}
		}
	}
	public static int go(int dx, int dy, int dir)
	{
		int nx = 0, ny =0;
		if(!isRange(dx, dy)) return 0;
		else if(tempMap[dx][dy] == 0)
		{
			nx = dx + dxArr[dir];
			ny = dy + dyArr[dir];
			tempMap[dx][dy] = 9;
			return go(nx, ny, dir) + 1; // 카운트 
		}
		else if(tempMap[dx][dy] == 9 || (tempMap[dx][dy] >= 1 && tempMap[dx][dy] <= 5 ) ) { 
			// 9 지난 점이거나 1 ~ 5 이면 그냥 지나가
			nx = dx + dxArr[dir];
			ny = dy + dyArr[dir];
			return go(nx, ny, dir);
		}
		return 0; // 6 벽 
	}
	public static void init(int index)
	{
		for(int i=1; i<= N; i++)
			for(int j=1; j<= M; j++)
				tempMap[i][j] = originMap[index][i][j];
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, num;
		Node(int x, int y, int z) {
			dx = x; dy = y; num = z;
		}
	}
}
