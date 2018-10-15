package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 불 !
 */
public class baek4179 {

	static int N, M, ans;
	static char[][] map = new char[1005][1005];
	static int[][][] visit = new int[2][1005][1005]; // 상근, 불의 방문
	static int[] dxArr = { -1, 0, 1, 0 }, dyArr = { 0, 1, 0, -1 };
	static Queue<Node> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(); // 초기화

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				char temp = str.charAt(j - 1);
				if (temp == 'F') {
					que.add(new Node(i, j, 1));
					visit[1][i][j] = 0;
				} else if (temp == 'J') {
					que.add(new Node(i, j, 0));
					visit[0][i][j] = 0;
				}
				map[i][j] = temp;
			}
		}
		solve();
		if (ans == -1)
			bw.write("IMPOSSIBLE\n");
		else
			bw.write(ans + "\n");
		bw.flush();
	}

	public static void solve() {
		int min = 0, len = 0;
		while (!que.isEmpty()) {
			len = que.size();
			min++;
			for (int i = 0; i < len; i++) {
				Node n = que.poll();
				if (n.type == 0 && map[n.dx][n.dy] == 'F') { // 같은 시간에서는 피할수 있지만 이전에 번진 불은 못피함
					if (min > visit[1][n.dx][n.dy])
						continue; // 불이 번진 시간 확인
				}

				for (int k = 0; k < 4; k++) {
					int nx = n.dx + dxArr[k];
					int ny = n.dy + dyArr[k];
					if (!isRange(nx, ny) && n.type == 0) { // 탈출
						ans = min;
						return;
					}
					if (map[nx][ny] == 'F' || map[nx][ny] == '#' || visit[n.type][nx][ny] >= 0)
						continue;

					if (n.type == 0 && map[nx][ny] == '.') { // 상근
						visit[n.type][nx][ny] = min;
						que.add(new Node(nx, ny, n.type));
					} else if (n.type == 1 && map[nx][ny] == '.') { // 불
						visit[n.type][nx][ny] = min;
						que.add(new Node(nx, ny, n.type));
						map[nx][ny] = 'F';
					}
				}
			}
		}
	}

	public static boolean isRange(int dx, int dy) {
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}

	public static void init() {
		ans = -1;
		que.clear();
		for (int k = 0; k < 2; k++)
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++)
					visit[k][i][j] = -1;
	}

	static class Node {
		int dx, dy, type;

		Node(int a, int b, int c) {
			dx = a;
			dy = b;
			type = c;
		}
	}
}
