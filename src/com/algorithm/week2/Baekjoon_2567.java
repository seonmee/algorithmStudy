package com.algorithm.week2;

import java.util.Scanner;

public class Baekjoon_2567 {
	static int N;
	static boolean[][] check;
	static int[] dr = { 0, 1, 0,-1 }; // 우하좌상
	static int[] dc = { 1, 0, -1 ,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new boolean[101][101];
		int length = 0;
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			length += go(r, c, 0);
		}
		System.out.println(length);
		sc.close();
	}

	private static int go(int r, int c, int ans) {
		int flag = 0;// 안겹침 +
		int sr = r, sc = c;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				r = r + dr[i];
				c = c + dc[i];
				if (flag == 0)
					ans++;
				else
					ans--;
		
				// + -를 바꿈
				if (check[r][c]) {
					if (flag == 0) {
						flag = 1;
					} else {
						flag = 0;
					}
				}else {
					check[r][c] = true;
				}
			}
		}
		return ans;
	}

}
