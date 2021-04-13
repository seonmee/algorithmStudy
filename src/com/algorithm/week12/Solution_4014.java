package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {
	static int T, N, X;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + t + " " + solution());
		}
	}

	private static int solution() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (makeRoadByRow(i))
				count++;
			if (makeRoadByCol(i))
				count++;
		}
		return count;
	}

	private static boolean makeRoadByCol(int c) {
		int preHeight = map[0][c], size = 0;
		int r = 0; // 탐색 행위치
		while (r < N) {
			// pr == 현재 map[i][j]
			if (preHeight == map[r][c]) {
				size++;
				r++;
			} else if (preHeight + 1 == map[r][c]) { // 오름
				if (size < X)
					return false; // 경사로 설치 불가
				preHeight++;
				size = 1;
				r++;
			} else if (preHeight - 1 == map[r][c]) { // 내림
				int count = 0;
				for (int k = r; k < N; k++) {
					if (map[k][c] != preHeight - 1)
						break;
					if (++count == X)
						break;
				}
				if (count < X)
					return false; // 경사로 설치불가
				preHeight--;
				size = 0;
				r = r + X;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean makeRoadByRow(int r) {
		int preHeight = map[r][0], size = 0;
		int c = 0; // 탐색 열위치
		while (c < N) {
			// pr == 현재 map[i][j]
			if (preHeight == map[r][c]) {
				++size;
				c++;
			} else if (preHeight + 1 == map[r][c]) { // 오름
				if (size < X)
					return false; // 경사로 설치 불가
				preHeight++;
				size = 1;
				c++;
			} else if (preHeight - 1 == map[r][c]) { // 내림
				int count = 0;
				for (int k = c; k < N; k++) {
					if (map[r][k] != preHeight - 1)
						break;
					if (++count == X)
						break;
				}
				if (count < X)
					return false; // 경사로 설치불가
				preHeight--;
				size = 0;
				c = c + X;
			} else {
				return false;
			}
		}
		return true;
	}

}
