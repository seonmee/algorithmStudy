package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 회전 초밥
public class Solution_2577 {
	static int N, d, k, c;
	static int[] table;
	static Set<Integer> line;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 벨트 위 접시
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // event 1. 연속해서 먹는 수
		c = Integer.parseInt(st.nextToken()); // event 2. 쿠폰번호
		table = new int[N];
		for (int i = 0; i < N; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		line = new HashSet<>();
		int ans = 0, size = 0;
		for (int i = 0; i < N; i++) {
			line.clear();
			for (int j = 0; j < k; j++) {
				int idx = (i+j)%N;
				line.add(table[idx]);
			}
			size = line.size();
			if(!line.contains(c)) ++size; // line에 쿠폰이 포함되지 않으면 쿠폰사용
			ans = Math.max(ans, size);
		}
		System.out.println(ans);
		
	}
}
