package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 원자 소멸 시물레이션 ( 맵 2배 )
 */
public class swExpert5648_2 {

	static int N, ans;
	static int[][] map = new int[4005][4005];
	static int[][][] visit = new int[2][4005][4005];
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] dxArr = {-1, 1, 0, 0}, dyArr = {0, 0, -1, 1}; // 상 하 좌 우 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr.clear();
			ans = 0;
			int dx=0, dy=0, dir =0, energy =0;
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dy = (Integer.parseInt(st.nextToken()) + 1000 ) * 2;
				dx = (2000 - (Integer.parseInt(st.nextToken()) + 1000) ) * 2;
				dir = Integer.parseInt(st.nextToken());
				energy = Integer.parseInt(st.nextToken());
				arr.add(new Node(dx, dy, dir, 1 ,energy));
			}
			solve();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		int len = arr.size(), count = arr.size(), min =0;
		while(count > 0)
		{
			if(min > 4000) break;
			min++;
			
			int dx=0, dy =0, nx =0, ny =0, dir =0;
			for(int i=0; i< len; i++)
			{
				if(arr.get(i).state == 0) continue;
				dx = arr.get(i).dx;
				dy = arr.get(i).dy;
				dir = arr.get(i).dir;
				nx = dx + dxArr[dir];
				ny = dy + dyArr[dir];
				if(!isRange(nx, ny)) {
					arr.get(i).state = 0; // 소멸 
					count--;  
					continue;
				}
				visit[0][nx][ny]++;
				visit[1][nx][ny] += arr.get(i).energy;
				arr.get(i).dx = nx;
				arr.get(i).dy = ny;
			}
			
			for(int i=0; i< len; i++)
			{
				if(arr.get(i).state == 0) continue;
				dx = arr.get(i).dx;
				dy = arr.get(i).dy;
				dir = arr.get(i).dir;
				
				if(visit[0][dx][dy] >= 2) { // 겹친 
					ans += visit[1][dx][dy];
					count -= visit[0][dx][dy];
					arr.get(i).state = 0;
				}
				else if(visit[0][dx][dy] == 0) {
					arr.get(i).state = 0;
				}
				
				visit[0][dx][dy] = 0;
				visit[1][dx][dy] = 0;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>= 0 && dy >= 0 && dx <= 4000 && dy <= 4000;
	}
	static class Node {
		int dx, dy, dir, state, energy;
		Node(int a, int b, int c, int d, int e) {
			dx=a; dy=b; dir=c; state=d; energy=e;
		}
	}
}
