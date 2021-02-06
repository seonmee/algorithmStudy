package com.algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1074 {
	static int N, R, C;
	static int size, count = -1;
	static int[] dr = { 0, 0, 1, 0 }; // z자 이동
	static int[] dc = { 0, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		Z(N, 0, 0);
	}

	private static void Z(int n, int r, int c) {
		// 기저조건
		if (n == 1) {
			for (int i = 0; i < 4; i++) {
				count++;
				r = r + dr[i];
				c = c + dc[i]; 
				if(r==R&&c==C) {
					System.out.println(count);
					return;
				}
			}
			return;
		}
		// 1사분면
		Z(n - 1, r, c);
		// 2사분면
		Z(n - 1, r, c + size / 2);
		// 3사분면
		Z(n - 1, r + size / 2, c);
		// 4사분면
		Z(n - 1, r + size / 2, c + size / 2);
		size = size/2;

	}

}
