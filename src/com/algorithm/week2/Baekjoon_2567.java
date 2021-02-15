package com.algorithm.week2;

import java.util.Scanner;

public class Baekjoon_2567 {
	static int T, flag;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[102][102];
		T = sc.nextInt();
		int ans = 0;
		for (int t = 0; t < T; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			// 색종이 영역 표시
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				// 색종이영역의
				if(map[i][j] == 1) {
					// 상하좌우 확인
					if(map[i-1][j]==0) ans++;
					if(map[i+1][j]==0) ans++;
					if(map[i][j-1]==0) ans++;
					if(map[i][j+1]==0) ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
