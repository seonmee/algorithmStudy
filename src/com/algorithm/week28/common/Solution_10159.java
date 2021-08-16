package com.algorithm.week28.common;

import java.util.*;
import java.io.*;

/*
 * 저울 
 * 
 * 5 ≤ N ≤ 100 이고, 0 ≤ M ≤ 2,000
 * */
public class Solution_10159 {
	static int N, M;
	static int[][] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		weight = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int hav = Integer.parseInt(st.nextToken()); // 무거운 물건
			int lig = Integer.parseInt(st.nextToken()); // 가벼운 물건
			weight[hav][lig] = 1; // 처음 물건이 더 무거운 경우
			weight[lig][hav] = -1; // 반대의 경우
		}

		// 플로이드 워샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (weight[i][k] == weight[k][j] && weight[i][k] != 0) { // 서로 비교할 수 있는 경우
						// e.g. 1 2  (1)   2 3  (1)      
						weight[i][j] = weight[i][k]; // 1 3 (1)
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
            int cnt = -1; // 자기 자신 제외  
            for (int j = 1; j <= N; j++) {
                if (weight[i][j] == 0) { //대소관계 모르는 경우
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

	}

}
