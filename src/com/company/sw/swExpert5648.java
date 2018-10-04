package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 원자 소멸 시뮬레이션 
 */
public class swExpert5648 {

	static int N, ans;
	static int[][][] map = new int[2][2005][2005];
	static ArrayList<Node> cell = new ArrayList<>(); // 세포 배열 
	static int[] dxArr = {-1, 1, 0, 0}, dyArr = {0 ,0, -1, 1};
	static int[] back = {1, 0, 3, 2}; // 반대 방향 인덱스 지정 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k <= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int dx = 0, dy = 0, dir = 0, energy = 0;
			ans = 0;
			cell.clear();
			for(int i=0; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dy = Integer.parseInt(st.nextToken())+ 1000;
				dx = 2000- (Integer.parseInt(st.nextToken()) + 1000); // 2차원 좌표를 배열로 옴기기위해 
				dir = Integer.parseInt(st.nextToken());
				energy = Integer.parseInt(st.nextToken());
				cell.add(new Node(dx,dy, dir, energy));
				map[0][dx][dy] = i+1; // 인덱스로 현재 위치 표시 
			}
			
			solve();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		ArrayList<Node> temp = new ArrayList<>();
		int count, len;
		count = len = cell.size();
		int dx = 0, dy =0, nx =0, ny =0, dir = 0;
		while(count > 0)
		{
			
			for(int i=0; i< len; i++) // 0.5 초 먼저 확인후 제거 
			{
				dx = cell.get(i).dx;
				dy = cell.get(i).dy;
				dir = cell.get(i).dir;
				if(dir < 0) continue; // 소멸한 세포 넘겨
				
				nx = dx + dxArr[dir];
				ny = dy + dyArr[dir];
				
				if(!isRange(nx, ny)) continue;
				
				if(map[0][nx][ny] > 0) // 0.5 초 소멸 가능한지 확인 
				{
					int tIndex = map[0][nx][ny] -1;
					if(back[cell.get(tIndex).dir] == dir)
					{
						cell.get(i).dir = -1;
						cell.get(tIndex).dir = -1; // 소멸 세포로 설정하고 기록 지우기 
						map[0][dx][dy] = 0;
						map[1][dx][dy] = 0;
						dx = cell.get(tIndex).dx;
						dy = cell.get(tIndex).dy;
						map[0][dx][dy] = 0;
						map[1][dx][dy] = 0;
						
						count -= 2; // 두 원자 소멸 
						
						ans += (cell.get(i).energy + cell.get(tIndex).energy); // 에너지 합 
					}
				}
			}
			
			for(int i=0; i< len; i++) // 1초 확인 이전 위치 초기화 하고 다음 갈 위치 정해 놓기  
			{
				dx = cell.get(i).dx;
				dy = cell.get(i).dy;
				dir = cell.get(i).dir;
				if(dir < 0) continue; // 소멸한 세포 넘겨
				
				nx = dx + dxArr[dir];
				ny = dy + dyArr[dir];
				
				if(!isRange(nx, ny)) // 범위 넘기면 아웃 
				{
					cell.get(i).dir = -1;
					count--;
				}
				
				map[0][dx][dy] = 0; // 기록 삭제 
				map[1][dx][dy] = 0;
				
				cell.get(i).dx = nx;
				cell.get(i).dy = ny; // 업데이트 
				
			}
			
			temp.clear();
			for(int i=0; i< len; i++) // 겹치는 세포 소멸   
			{
				dx = cell.get(i).dx;
				dy = cell.get(i).dy;
				dir = cell.get(i).dir;
				if(dir < 0) continue; // 소멸한 세포 넘겨
				
				if(map[0][dx][dy] ==0 )
				{
					map[0][dx][dy] = i+1; // 몇번 세포 인지 체크 
					map[1][dx][dy] = cell.get(i).energy; // 에너지 기록  
				}
				else if(map[0][dx][dy] > 0) // 처음 겹쳤을 때 
				{
					int tIndex = map[0][dx][dy] - 1;
					cell.get(tIndex).dir = -1;
					cell.get(i).dir = -1;
					
					map[0][dx][dy] = -1; // 겹쳤다라는 표시
					map[1][dx][dy] += cell.get(i).energy;
					
					count -=2;
					
					temp.add(new Node(dx, dy, -1, 0)); // 좌표만 가지고 있기 위한 temp 
				}
				else if(map[0][dx][dy] == -1) // 2번이상 겹친 경우 
				{
					cell.get(i).dir = -1;
					map[1][dx][dy] += cell.get(i).energy;
					
					count--;
				}
				
			}
			
			for(int i=0; i< temp.size(); i++) // 겹쳤던 곳 정리 
			{
				dx = temp.get(i).dx;
				dy = temp.get(i).dy;
				ans += map[1][dx][dy];
				
				map[0][dx][dy] = 0;
				map[1][dx][dy] = 0;
			}
			
		}
		
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=0 && dy>=0 && dx<= 2000 && dy<= 2000;
	}
	static class Node{
		int dx, dy, dir, energy;
		Node(int a, int b, int c, int d) {
			 dx = a; dy =b; dir =c; energy=d;
		}
	}
}
