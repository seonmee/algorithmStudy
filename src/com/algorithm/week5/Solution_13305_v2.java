package com.algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_주요소
public class Solution_13305_v2 {
	static int N;
	static long[] oil, length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		length = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		oil = new long[N];
		for (int i = 0; i < N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}

		// 로직
		long ans = 0;
		for (int i = 0; i < N-1; i++) {
			if(oil[i] < oil[i+1]) oil[i+1] = oil[i];
			ans += oil[i] * length[i]; 
		}
		System.out.println(ans);
	}

}
