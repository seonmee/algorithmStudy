package com.algorithm.week4.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1377_v2 {
	static int N;
	static Map A;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new HashMap<Integer, Integer>();
		temp = new int[N];
		for (int n = 0; n < N; n++) {
			temp[n] = Integer.parseInt(br.readLine());
			A.put(temp[n], n);
		}
		// 로직
		Arrays.sort(temp);
		int[] idx = new int[N];
		int max = Integer.MIN_VALUE;
		int ans = 0;
		for (int n = 0; n < N; n++) {
			idx[n] = (int) A.get(temp[n]) - n;
			if (idx[n] >= 0) {
				if (idx[n] >= max) {
					max = idx[n];
					ans = temp[n];
				}
			}
		}
		System.out.println(ans);

	}

}
