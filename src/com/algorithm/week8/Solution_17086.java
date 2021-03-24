package com.algorithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 아기상어 2
public class Solution_17086 {
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> sharks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sharks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					sharks.add(new int[] {i,j});
			}
		}
		//
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					int safe = Integer.MAX_VALUE;
					for (int[] shark : sharks) {
						// 안전거리 
						safe = Math.min(safe,Math.max(Math.abs(i-shark[0]), Math.abs(j-shark[1])));
					}
					map[i][j] = safe;
				}
				ans = Math.max(ans, map[i][j]);
			}
		}
		//
		System.out.println(ans);
	}

}
