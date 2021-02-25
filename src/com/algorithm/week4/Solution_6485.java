package com.algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485 {
	static int T, N, A, B, P, C;
	static int[][] bus;
	static int[] stops, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			bus = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				bus[i][0] = Integer.parseInt(st.nextToken());
				bus[i][1] = Integer.parseInt(st.nextToken());
			}
			P = Integer.parseInt(br.readLine());
			stops = new int[P];
			ans = new int[P];
			for (int i = 0; i < P; i++) {
				stops[i] = Integer.parseInt(br.readLine());
			}
			// 로직
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					if(bus[i][0]<=stops[j] && stops[j]<=bus[i][1])
						ans[j]++;
				}
			}
			// 출력
			System.out.print("#" + t +" ");
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}

	}

}
