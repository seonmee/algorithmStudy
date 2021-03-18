package com.algorithm.week6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 백준 친구비
public class Solution_16562 {
	static int N, M, k;
	static int[] P, R, cost;
	static Set<Integer> unions;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계
		k = Integer.parseInt(st.nextToken()); // 돈
		st = new StringTokenizer(br.readLine());
		cost = new int[N+1];
		// 친구비
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken()); 
		}
		P = new int[N+1];
		R = new int[N+1];
		for (int i = 1; i <= N; i++) {
			R[i]=1;
		}
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		unions = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			unions.add(findSet(i));
		}
		int needs = 0;
		for (int union : unions) {
			needs += cost[union];
		}
		System.out.println(k>=needs?needs:"Oh no");
		
		// 출력
		System.out.println();
	}
	private static void make() {
		for (int i = 1; i <= N; i++) {
			P[i]=i;
		}
	}
	private static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa==pb)return;
		if(cost[pa]<cost[pb]) {
			P[pb] = pa;
		}else {
			P[pa] = pb;
		}
	}

	private static int findSet(int a) {
		if(P[a]==a) return a;
		return P[a]= findSet(P[a]);
	}

}
