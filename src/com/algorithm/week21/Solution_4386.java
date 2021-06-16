package com.algorithm.week21;
import java.util.*;
/*
 * 별자리 만들기 
 * */
public class Solution_4386 {
	static class Star {
		double r;
		double c;
		public Star(double r, double c) {
			this.r = r;
			this.c = c;
		}
	} 
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double w;
		public Edge(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.w, e.w);
		}
		
	}
	static int N;
	static int[] P,R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Star[] stars = new Star[N];
		R = new int[N];
		for(int i = 0 ; i < N ; i++) {
			double r = sc.nextDouble();
			double c = sc.nextDouble();
			stars[i] = new Star(r,c);  
			R[i] = 1;   // rank 초기화 
		}
		// 간선 정보 
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i = 0; i < N ; i++) {
			for(int j = i+1; j < N ; j++) {
				double d = calcDistance(stars[i],stars[j]);
				edges.add(new Edge(i,j,d));
			}
		}
		// 정렬
		Collections.sort(edges);
		
		// 크루스칼 
		P = new int[N];
		make();
		double ans = 0.00;
		int cnt = 0;
		for(Edge e : edges) {
			if(cnt==N-1) break;
			if(union(e.from,e.to)) {
				ans += e.w;
				cnt++;
			}
		}
		System.out.println(String.format("%.2f", ans));
	}
	
	private static boolean union(int from, int to) {
		int pFrom = findSet(from);
		int pTo = findSet(to);
		if(pFrom == pTo) return false;
		if(R[pFrom] >= R[pTo]) { 
			P[pTo] = pFrom;
			R[pFrom] += R[pTo];
		}else {
			P[pFrom] = pTo;
			R[pTo] += R[pFrom];
		}
		return true;
	}

	private static int findSet(int num) {
		if(num==P[num]) return num;
		return P[num] = findSet(P[num]);
	}

	private static void make() {
		for(int i = 0;i < N; i++) {
			P[i] = i;
		}
	}

	// 거리 구하는 함수 
	private static double calcDistance(Star from, Star to) {
		return Math.sqrt(Math.pow(from.r - to.r, 2) + Math.pow(from.c - to.c, 2));
	}

}
