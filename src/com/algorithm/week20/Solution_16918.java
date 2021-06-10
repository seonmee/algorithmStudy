package com.algorithm.week20;

import java.util.*;
import java.io.*;

public class Solution_16918 {
	static int R, C, N;
	static char[][] map;
	static int[][] exTime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 초후
		map = new char[R][C];
		exTime = new int[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'O')
					exTime[r][c] = 3;
			}
		}
		// 홀수이면
		for (int n = 1; n <= N; n++) {
			if (n % 2 == 0) {
				fillBomb(n);
			} else {
				explosion(n);
			}
		}

		print();

	}

	private static void fillBomb(int time) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '.') {
					exTime[r][c] = time + 3;
					map[r][c] = 'O';
				}
			}
		}
	}

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	private static void explosion(int time) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (exTime[r][c] == time) {
					for (int d = 0; d < 5; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (!isContain(nr, nc))
							continue;
						map[nr][nc] = '.';
					}
				}
			}
		}

	}

	private static boolean isContain(int nr, int nc) {
		return 0 <= nr && nr < R && 0 <= nc && nc < C;
	}

	private static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

}
