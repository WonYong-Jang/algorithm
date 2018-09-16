package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 드래곤 커브  
 */
public class baek15685 {
	
	static int dx, dy, D ,G; // x, y 좌표 / 방향 / 세대 
	static int[][] map = new int[105][105]; // 그릴 맵 
	static int[] dxArr = {0, -1, 0, 1}, dyArr = {1, 0, -1, 0}; // 동 북 서 남 
	static ArrayList<Integer> dirArr = new ArrayList<>(); // 10세대 일때 최대 나올수 있는 방향 배열 갯수 1024
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int curve = Integer.parseInt(st.nextToken()); // 드래곤 커브 갯수 
		
		for(int i=0; i< curve; i++)
		{
			st = new StringTokenizer(br.readLine());
			dy = Integer.parseInt(st.nextToken()); // x, y 반대로 입력 받기 
			dx = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			
			dirArr.clear();
			map[dx][dy] = 1;
			for(int k=0; k<= G; k++) // 조건 세대 까지 
			{
				draw(k);
			}
		}
		checkMap(); // 4꼭지점 확인 
	}
	public static void checkMap()
	{
		int cnt =0;
		
		for(int i=0; i < 100; i++)
		{
			for(int j=0; j < 100; j++)
			{
				if(map[i][j] == 0) continue;
				if(map[i][j+1] == 1 && map[i+1][j+1] == 1 && map[i+1][j] == 1) cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void draw(int generation)
	{
		int len = dirArr.size();
		
		if(len == 0) { // 0 세대 일때 
			dirArr.add(D);
			dx += dxArr[D];
			dy += dyArr[D];
			map[dx][dy] = 1;
		}
		else 
		{
			for(int i=len-1; i >= 0; i--)
			{
				int curDir = dirArr.get(i);
				int nextDir = (curDir+1) % 4;
				dirArr.add(nextDir);
				dx += dxArr[nextDir];
				dy += dyArr[nextDir];
				map[dx][dy] = 1;
			}
		}
		
	}
}







