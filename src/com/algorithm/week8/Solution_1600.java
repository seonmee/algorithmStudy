package com.algorithm.week8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1600 {

	// 동서남북 좌우상하(말)
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] hr = { -2, -2, 2, 2, 1, -1, 1, -1 };
	static int[] hc = { 1, -1, 1, -1, 2, 2, -2, -2 };

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	static class Monkey {
		int r;
		int c;
		int cnt;
		int k;

		Monkey(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		visit = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visit[0][0][0] = true;
		System.out.println(solve());
	}

	private static int solve() {
		Queue<Monkey> queue = new LinkedList<Monkey>();
		queue.add(new Monkey(0, 0, 0, K));
		while (!queue.isEmpty()) {
			Monkey mon = queue.poll();
			int cr = mon.r;
			int cc = mon.c;
			int cnt = mon.cnt;
			int k = mon.k;
			if (cr == H - 1 && cc == W - 1)
				return cnt;
			// 8방탐색
			if (k > 0) {
				for (int d = 0; d < 8; d++) {
					int nr = cr + hr[d];
					int nc = cc + hc[d];
					if (!isContain(nr, nc))
						continue;
					if (map[nr][nc] == 1)
						continue;
					if (visit[nr][nc][k - 1])
						continue;
					visit[nr][nc][k - 1] = true;
					queue.add(new Monkey(nr, nc, cnt + 1, k - 1));
				}
			} // 4방탐색
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!isContain(nr, nc))
					continue;
				if (map[nr][nc] == 1)
					continue;
				if (visit[nr][nc][k])
					continue;
				visit[nr][nc][k] = true;
				queue.add(new Monkey(nr, nc, cnt + 1, k));
			}

		}
		return -1;
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}

}

/*
 * 
1
5 5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 0
 * 
 */
