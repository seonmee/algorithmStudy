package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486 {
// 장훈이의 높은 선반
	static int T, N, B, ans;
	static int[] height;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 수 
			B = Integer.parseInt(st.nextToken()); // 높이
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			subset(0, 0);
			System.out.println("#" + t +" "+ (ans-B));
			
		}
	}

	private static void subset(int cnt, int h) {
		if(cnt==N) {
			if(h>=B) {
				ans = Math.min(ans, h);
			}
			return;
		}
		subset(cnt+1, h);
		subset(cnt+1, h + height[cnt]);
	}

}
