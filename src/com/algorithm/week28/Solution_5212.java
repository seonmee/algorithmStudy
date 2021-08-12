package com.algorithm.week28;

import java.io.*;
import java.util.*;

/*
 * 지구 온난화 
 * X는 땅 . 는 바다 
 * */
public class Solution_5212 {
	static int R, C;
	static char[][] map;
	static boolean[][] checked;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int minR = 10; 
	static int minC =  10;
	static int maxR = 0;
	static int maxC = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		checked = new boolean[R][C];
		// 입력
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		solve();
		
		for(int r =  minR; r <= maxR ; r++) {
			for(int c =  minC; c <= maxC ; c++) {
				if(checked[r][c])System.out.print('X');
				else System.out.print('.');
			}
			System.out.println();
		}

	}

	private static void solve() {
		// 땅만 확인 
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'X') {
					check(r, c);
				}
			}
		}
		
	}

	// 주변에 땅이 2개 이상 있는지 확인
	private static void check(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isContain(nr, nc))
				continue;
			if(map[nr][nc] ==  'X')cnt++;
		}
		if(cnt>=2) {
			checked[r][c] = true; // 가라앉지 않음 
			minR = Math.min(r, minR);
			minC = Math.min(c, minC);
			maxR = Math.max(r, maxR);
			maxC = Math.max(c, maxC);
		}
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
