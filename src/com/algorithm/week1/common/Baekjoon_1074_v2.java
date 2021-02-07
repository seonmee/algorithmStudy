package com.algorithm.week1.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1074_v2 {
	static int N, R, C;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		Z((int) Math.pow(2, N), 0, 0);
	}

	private static void Z(int size, int r, int c) {
		// 기저조건
		if (r == R && c == C) {
			System.out.println(count);
			return;
		}
		// 사분면에 속하는지 check
		if (R < r + size && R >= r && C < c + size && C >= c) {
			int s = size / 2;
			Z(s, r, c);
			Z(s, r, c + s);
			Z(s, r + s, c);
			Z(s, r + s, c + s);
		} else {
			// 앞의 사분면 값을 그냥 더해주기
			count += size * size;
		}

	}
}
