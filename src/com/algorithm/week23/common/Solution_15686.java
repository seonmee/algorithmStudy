package com.algorithm.week23.common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15686 {
	static int N, M, ans=Integer.MAX_VALUE;
	static ArrayList<int[]> stores;
	static ArrayList<int[]> houses;
	static int[][] distance;
	static int[] nearStore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stores = new ArrayList<>();
		houses = new ArrayList<>();
		nearStore = new int[M];
		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				n = Integer.parseInt(st.nextToken());
				if (n == 2) {
					stores.add(new int[] { i, j });
				} else if (n == 1) {
					houses.add(new int[] { i, j });
				}
				;
			}
		}
		// 치킨 거리 저장
		distance = new int[stores.size()][houses.size()];
		for (int i = 0; i < stores.size(); i++) {
			for (int j = 0; j < houses.size(); j++) {
				distance[i][j] = Math.abs(stores.get(i)[0] - houses.get(j)[0])
						+ Math.abs(stores.get(i)[1] - houses.get(j)[1]);
			}
		}
		// 순열
		nCr(0, 0);
		System.out.println(ans);
	}

	private static void nCr(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < houses.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < nearStore.length; j++) {
					min = Math.min(distance[nearStore[j]][i], min);
				}
				sum += min;
			}
			ans = Math.min(ans,sum);
			return;
		}
		for (int i = start; i < stores.size(); i++) {
			nearStore[cnt] = i;
			nCr(cnt + 1, i + 1);
		}
	}

}
