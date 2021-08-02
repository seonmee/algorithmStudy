package com.algorithm.week27;
import java.util.*;
import java.io.*;
/*
 * 동방 프로젝트 
 * 
 * 다시 풀기...
 * */
public class Solution_14594 {
	static int N, M;
	static boolean[] room;
	static int[] P, R;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		room = new boolean[N];
		R = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			R[i] = 1;   // rank 초기화 
		}

		P = new int[N];
		make();
		int ans = 0;
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			if(union(from,to)){
				ans++;
			}
		}
		
		
		System.out.println(ans==0?N:ans);
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

	

}
