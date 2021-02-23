package com.algorithm.week4;

import java.util.Scanner;
// Baeckjoon 참외밭
public class Solution_2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int[] map = new int[6];
		int K = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			map[i] = sc.nextInt();
		}
		// 전체 사각형
		int w = 0, h = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0)
				w = Math.max(w, map[i]);
			else
				h = Math.max(h, map[i]);
		}
		int ww = 0, hh = 0;
		// 잘린 사각형
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				// x % y => k
				// (x + y) % y => k
				// 자바는 -3%6 => -3
				if (h == (map[(i - 1 + 6) % 6] + map[(i + 1) % 6])) {
					ww = map[i];
				}
			} else {
				if (w == (map[(i - 1 + 6) % 6] + map[(i + 1) % 6])) {
					hh = map[i];
				}
			}
		}
		// 출력
		System.out.println((w * h - ww * hh) * K);

	}

}
