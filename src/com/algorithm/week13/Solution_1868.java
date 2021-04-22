package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.IsoChronology;
import java.util.LinkedList;
import java.util.Queue;

// 파핑파핑 지뢰찾기
public class Solution_1868 {
	static int T, N;
	static char[][] map;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = line.charAt(c);
				}
			}
			// click
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '.') {
						if (findStPoint(r, c)) {
							click(r, c);
							ans++;
						}
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '.') {
						click(r, c);
						ans++;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static boolean findStPoint(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isContain(nr, nc))
				continue;
			if (map[nr][nc] == '*')
				return false;
		}

		return true;
	}

	private static void click(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		map[r][c] = '0';
		while (!queue.isEmpty()) {
			int cntBomb = 0;
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!isContain(nr, nc))
					continue;
				if (map[nr][nc] == '*') // 폭탄인경우
					cntBomb++;
			}
			if (cntBomb == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (!isContain(nr, nc))
						continue;
					if (map[nr][nc] == '.') {
						map[nr][nc] = '0';
						queue.offer(new int[] { nr, nc });
					}
				}
			} else {
				map[r][c] = (char) cntBomb;
			}
		}
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
