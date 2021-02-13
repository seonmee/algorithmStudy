package com.algorithm.week2.common;

import java.util.Scanner;

public class Baekjoon_4963 {
	static int w, h, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 우 우하 하 좌하 좌 좌상 상 우상
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			ans = 0;
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			// 입력
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 로직
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// Land(섬)이고 방문하지 않았으면
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j); // 섬 방문
						ans++; // 방문한 섬의 갯수 증가
					}
				}
			}
			// 출력
			System.out.println(ans);
		}

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		// 8방 탐색
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 1) 범위 안에 있고 2) 방문하지 않은 3) Land(섬)방문
			if (isInMap(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
	

	private static boolean isInMap(int nr, int nc) {
		return nr >= 0 && nr < h && nc >= 0 && nc < w;
	}

}
