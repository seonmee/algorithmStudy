package com.algorithm.week27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 경로 찾기 
 * */
public class Solution_11403 {
	static int n;
	static int[][] adjMatrix;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[n][n];
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n ; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 워샬
		for(int k = 0; k < n; k ++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j< n; j++) {
					if(adjMatrix[i][k] == 1 && adjMatrix[k][j]==1)
						adjMatrix[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				System.out.print(adjMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
