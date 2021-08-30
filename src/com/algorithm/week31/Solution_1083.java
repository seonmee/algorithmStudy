package com.algorithm.week31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1083 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int max = arr[i];
			int maxi = i;
			for (int j = i + 1; j < N; j++) {
				if (M - (j - i) >= 0) {
					if (max < arr[j]) {
						max = arr[j];
						maxi = j;
					}
				}
			}
			for (int j = maxi; j > i; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
			M -= (maxi - i);
			if (M <= 0)
				break;
		}
		
		for(int i = 0; i < N; i++)
			System.out.print(arr[i]+" ");

	}

}
