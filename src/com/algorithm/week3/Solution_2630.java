package com.algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2630 {
	static int N, blue, white;
	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0, size = st.countTokens(); j < size; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		cutPaper(0, 0, N);
		// 출력
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cutPaper(int r, int c, int len) {
		// 색이 같은지 check
		int cnt = 0;
		out: for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (paper[i][j] != paper[r][c])
					break out;
				else
					cnt++;
			}
		}
		// 기저조건 : 모두 같은 색
		if (cnt == len * len) {
			if (paper[r][c]== 1)
				blue++;
			else
				white++;
			return;
		}
		// 분할
		cutPaper(r, c, len / 2);
		cutPaper(r, c + len / 2, len / 2);
		cutPaper(r + len / 2, c, len / 2);
		cutPaper(r + len / 2, c + len / 2, len / 2);

	}

}
