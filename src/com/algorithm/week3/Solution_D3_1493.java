package com.algorithm.week3;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1493 {
	// 좌표 구하기
	static int[] getCoor(int target) {
		int cnt = 1;
		for (int i = 1;; i++) {
			for (int r = 1, c = i; r <= i; r++, c--) {
				if (target == cnt) {
					return new int[] { r, c };
				}
				cnt++;
			}
		}
	}
	// 좌표의 값 구하기
	static int getValue(int nr, int nc) {
		int cnt = 1;
		for (int i = 1;; i++) {
			for (int r = 1, c = i; r <= i; r++, c--) {
				if (nr == r && nc == c) {
					return cnt;
				}
				cnt++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[] p = getCoor(sc.nextInt());
			int[] q = getCoor(sc.nextInt());
				
			System.out.println("#" + t + " " + getValue(p[0] + q[0], p[1] + q[1]));
		}
	}

}
