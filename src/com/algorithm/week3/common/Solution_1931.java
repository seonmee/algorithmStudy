package com.algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1931 {
	static int N, ans=1;
	static ArrayList<int[]> meetings;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		meetings = new ArrayList<>();
		// 입력
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		// 정렬
		meetings.sort((int[] o1, int[] o2) -> {
			int dif = o1[1] - o2[1]; // 회의 종료시간 (빠른시간 순 : 오름차순)
			return dif != 0 ? dif : o1[0] - o2[0]; // 종료시간이 같으면 시작시간
			// {1, 2} {2, 3} {3, 3} => 1 2 & 2 3 & 3 3 => 3회 
			// {1, 2} {3, 3} {2, 3} => 1 2 & 3 3 => 2회
		});
		// 탐색
		int cur = meetings.get(0)[1];
		for (int i = 1; i < meetings.size(); i++) {
			if(cur<=meetings.get(i)[0]) {
				cur = meetings.get(i)[1];
				ans++;
			}
		}
		// 출력
		System.out.printf("%d", ans);

	}

}
