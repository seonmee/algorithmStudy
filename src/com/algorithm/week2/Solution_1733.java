package com.algorithm.week2;

import java.util.Scanner;

public class Solution_1733 {
	static int[][] map = new int[21][21];
	static int[] dr = { 1, 0, 1, -1 };// 우 하 우하 우상
	static int[] dc = { 0, 1, 1, 1 };// 우 하 우하 우상

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				int curVal = map[i][j];
				if (curVal == 0)
					continue;
				// 흰돌, 검은돌
				for (int k = 0; k < 4; k++) {
					int cnt = 1;
					int nr = dr[k];
					int nc = dc[k];
					// 진행하려는 방향과 이전의
					if (curVal == map[i + dr[k] * -1][j + dc[k] * -1]) {
						continue;
					}
					while (curVal == map[i + nr][j + nc]) {
						cnt++;
						nr = dr[k] * cnt;
						nc = dc[k] * cnt;
					}
					// count 가 같은갑
					if (cnt == 5) {
						System.out.println(curVal);
						System.out.println(i + " " + j);
						System.exit(0);// 종료
					}
				}
			}
		}
		System.out.println(0);
	}

}
