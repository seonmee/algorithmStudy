package com.algorithm.week1;

import java.util.Scanner;

public class SWEA_D4_1210 {
	private static final int T = 10;
	private static int N, stC;
	private static int[] dr = { -1, 0, 0 }; // 상 좌 우
	private static int[] dc = { 0, -1, 1 };
	private static int[][] map = new int[100][100];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			N = scn.nextInt();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = scn.nextInt();
					if (map[i][j] == 2)
						stC = j;

				}
			}

			int d = 0; // 상
			int stR = 99;
			while (stR != 0) {
				// 좌로 전환
				if (d != 2 && stC - 1 > 0 && map[stR][stC - 1] == 1)
					d = 1;
				// 우로 전환
				if (d != 1 && stC + 1 <= 99 && map[stR][stC + 1] == 1)
					d = 2;
				stR = stR + dr[d];
				stC = stC + dc[d];
				// 이동한게 범위를 벗어나면
				if ( stC <= 0 || stC > 99||map[stR][stC] == 0 ) {
					stR = stR - dr[d];
					stC = stC - dc[d];
					d = 0;
					stR = stR + dr[d];
					stC = stC + dc[d];
				}
			}

			System.out.printf("#%d %d%n", N, stC);
		}
	}

}
