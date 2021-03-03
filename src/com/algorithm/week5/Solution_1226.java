package com.algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1226 {
	static int ans, sr, sc;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		for (int t = 1; t <= 10; t++) {
			// 입력
			map = new int[16][16];
			br.readLine();
			for (int i = 0; i < 16; i++) {
				st = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = st.charAt(j) - '0';
					if (map[i][j] == 2) {
						sr = i;
						sc = j;
					}
				}
			}
			// 로직
			ans = 0;
			dfs(sr, sc);
			// 출력
			System.out.println("#" + t + " " +ans);
		}
	}
	// dfs
	private static void dfs(int r, int c) {
		int nr = 0, nc = 0, cnt = 0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			cnt++;
			if (map[nr][nc] == 0) {
				map[nr][nc] = 2;
				dfs(nr, nc);
				map[nr][nc] = 0;
			} else if (map[nr][nc] == 3) {
				ans = 1;
				return;
			}
		}
		if (cnt == 4) {
			return;
		}

	}
	// bfs
	private static int bfs() {
		Queue<int []> que = new LinkedList<int []>();
		que.offer(new int[] {sr,sc});
		int nr = 0, nc = 0;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				if ( map[nr][nc]==0) {
					map[nr][nc]=2;
					que.offer(new int[] {nr,nc});
				}else if(map[nr][nc]==3) {
					return 1;
				}
			}
		}
		return 0;
	}
}
