package com.company.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swExpert1210 {

	public static final int N = 100;
	public static int[][] map = new int[100][100];
	public static int[][] visited = new int[100][100];
	public static int dxArr[] = { 0, 0, 1 }; // first, horizontal then down
	public static int dyArr[] = { 1, -1, 0 };
	public static int result;

	public static void dfs(int dx, int dy, int check) {
		int cnt = check;
		if (check == 1)
			return;
		if (map[dx][dy] == 2) {
			result = dy;
			// System.out.println(dx + " " + dy);
			cnt = 1;
			return;
		} else {
			visited[dx][dy] = 1; // confirm visited
			int rDx = 0, rDy = 0, flag = 0;
			for (int i = 0; i < 3; i++) {
				rDx = dx + dxArr[i];
				rDy = dy + dyArr[i];
				if (rDx >= 0 && rDy >= 0 && rDx < N && rDy < N && visited[rDx][rDy] == 0 && map[rDx][rDy] != 0) {
					flag = 1;
					break;
				}
			}
			// System.out.println("progress" + dx + " " + dy);
			if (flag == 1)
				dfs(rDx, rDy, cnt);
			visited[dx][dy] = 0;
		}
	}

	public static void init() {
		result = -1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				visited[i][j] = 0;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 1; k <= 10; k++) {
			init(); // initialize
			int n = Integer.parseInt(reader.readLine());
			String[] input;
			for (int i = 0; i < N; i++) // input
			{
				input = reader.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			for (int i = 0; i < N; i++) {
				if (map[0][i] == 1) {
					dfs(0, i, 0); // ladder start
					if (result != -1) {
						result = i;
						break;
					}
					// init();
				}
			}
			System.out.println("#" + k + " " + result);
		}
	}
}