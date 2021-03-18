package com.algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 정올 종교
public class Solution_1863 {
	static int n,m;
	static int[] P,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생
		m = Integer.parseInt(st.nextToken()); // 관계수
		P = new int[n+1];
		R = new int[n+1];
		make();
		for (int c = 0; c < m; c++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			union(i,j);
		}
		// union 갯수 check
		Set<Integer> ans = new HashSet<>();
		for (int i = 1; i < n+1; i++) {
			ans.add(P[i]);
		}
		System.out.println(ans.size());
	}
	private static void make() {
		for (int i = 1; i <= n; i++) {
			P[i] = i;
		}
	}
	private static void union(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		if(pi==pj)return;
		if(R[pi]>=R[pj]) {
			P[pj] = pi;
			R[pi]+=R[pj];
		}else {
			P[pi] = pj;
			R[pj]+=R[pi];
		}
		return;
	}
	private static int findSet(int i) {
		if(P[i]==i) return i;
		return P[i] = findSet(P[i]);
	}

}
