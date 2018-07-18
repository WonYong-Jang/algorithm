package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 톱니바퀴 
 */
public class baek14891 {

	static int[][] map = new int[5][8];
	static int[] visited;// 4개 톱니 바퀴 
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num =0, dir =0;
		for(int i=1; i<=4; i++) // 톱니 바퀴 셋팅 
		{
			String str = br.readLine();
			for(int j=0; j< str.length(); j++)
			{
				map[i][j] = str.charAt(j) - '0'; // 숫자로 저장 
			}
		}
		N = Integer.parseInt(br.readLine());
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			visited = new int[5]; // 사용 배열 1 ~ 4 톱니바퀴 갯수 만큼 
			num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			visited[num] = 1;
			solve(num, dir);
			visited[num] = 0;
			
			turn(num, dir);
		}
		printFun(); // 계산 후 출력 
		
	}
	// 2번 인덱스와 5번 인덱스 비교
	public static void solve(int num, int dir) // dir   1 시계 방향 /  -1 반시계 방향  
	{
		if( num > 4 || num < 1 ) return;
		
		if(num+1 <= 4 && visited[num+1] ==0 ) { // 해당 인덱스에서 오른쪽 톱니 바퀴 확인 //  
			if(map[num][2] != map[num+1][6]) // 같지 않으면 해당 방향의 반대 방향으로 회전 
			{   
				 // 현재 톱니 바퀴가 시계방향일때 다음 확인할 톱니바퀴 반시계방향
				visited[num+1] = 1;
				solve(num+1, dir * -1 ); // 반대방향 넣어 주기 
				visited[num+1] = 0;
				
				turn(num+1, dir * -1 );
			}
		}
		if(num-1 > 0 && visited[num-1] ==0 ) { // 해당 인덱스에서 왼쪽 톱니 바퀴 확인 
			if(map[num][6] != map[num-1][2]) // 같지 않으면 해당 방향의 반대 방향으로 회전 
			{
				visited[num-1] = 1;
				solve(num-1, dir * -1 );
				visited[num-1] = 0;
				
				turn(num-1, dir * -1);
			}
		}
		
	}
	public static void turn(int num, int dir) // 반시계 방향 회전  
	{
		int[] temp = new int[8];
		for(int i=0; i< 8; i++)
			temp[i] = map[num][i];
		if(dir == -1) // 반시계 방향 
		{   
			for(int i=0; i<8; i++)
			{
				map[num][i] = temp[(i+1) %8 ]; // 왼쪽으로 shift
			}
		}
		else { // 시계 방향 
			for(int i=0; i<8; i++)
			{
				map[num][ (i+1) % 8 ] = temp[i]; // 으론쪽 으로 shift
			}
		}
	}
	public static void printFun()
	{
		int result =0;
		if(map[1][0] == 1) result +=1;
		if(map[2][0] ==1) result +=2;
		if(map[3][0] == 1) result+=4;
		if(map[4][0] ==1) result +=8;
		System.out.println(result);
	}
}




