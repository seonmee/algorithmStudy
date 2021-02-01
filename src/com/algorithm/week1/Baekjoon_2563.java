package com.algorithm.week1;

import java.util.Scanner;

public class Baekjoon_2563 {

	private static int P;
	private static boolean[][] map;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		P = scn.nextInt();
		map = new boolean[100][100];
		int area = 0;
		for (int i = 0; i < P; i++) {
			int r = scn.nextInt();
			int c = scn.nextInt();
			// 시작지점부터
			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					// 겹치지 않는 부분
					if (!map[j][k]) {
						map[j][k] = true;
						// 넓이 ++
						area++;
					}
				}
			}
		}
		scn.close();
		System.out.print(area);
	}

}
