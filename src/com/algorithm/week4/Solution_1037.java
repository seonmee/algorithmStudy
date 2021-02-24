package com.algorithm.week4;

import java.util.Scanner;

public class Solution_1037 {
// 정올
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];

		// 읽기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 로직 : 가로합 세로합
		int cnt1 = 0, cnt2 = 0;
		int x = 0, y = 0;
		for (int i = 1; i <= N; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = 1; j <= N; j++) {
				sum1 += map[i][j]; // 가로의 합
				sum2 += map[j][i]; // 세로의 합
			}
			if (sum1 % 2 != 0) {
				y = i;
				cnt1++;
			}
			if (sum2 % 2 != 0) {
				x = i;
				cnt2++;
			}
		}
		// 출력
		if (cnt1 + cnt2 == 0) {
			System.out.println("OK");
		} else if (cnt1 == 1 && cnt2 == 0) {
			System.out.println("Change bit (" + x + "," + y + ")");
		} else {
			System.out.println("Corrupt");
		}
	}

}
