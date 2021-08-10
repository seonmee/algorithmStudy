package com.algorithm.week28;

import java.io.*;
import java.util.*;

/*
 * 끝나지 않는 파티 
 * */
public class Solution_11265 {
	static int N, M, A, B, C;
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 파티장의 크기 N(5 ≤ N ≤ 500)
		M = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님의 수 M(1 ≤ M ≤ 10,000)

		adjMatrix = new int[501][501];
		// 인접 행렬 
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				adjMatrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 플로이드 워샬 
		for (int k = 1; k <= N; k++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (adjMatrix[r][k] + adjMatrix[k][c] < adjMatrix[r][c]) {
						adjMatrix[r][c] = adjMatrix[r][k] + adjMatrix[k][c];
					}
				}
			}
		}
		// 출력 
		for( int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(adjMatrix[A][B] <= C) System.out.println("Enjoy other party");
			else System.out.println("Stay here");
		}
		
	}

}
