package com.algorithm.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오르막길
public class Solution_2846 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int pre = Integer.parseInt(st.nextToken());
		int start = pre;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (pre < cur) {
				if(i==N-1) max = Math.max(cur - start,max);
			}else {
				max = Math.max(pre - start,max);
				start = cur;
			}
			pre = cur;
		}
		System.out.println(max);
	}

}
