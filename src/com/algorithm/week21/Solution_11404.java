package com.algorithm.week21;
import java.util.*;
import java.io.*;

/* 
 * 플로이드 
 * */
public class Solution_11404 {
	static int n, m;
	static final int INF = 9999999;
	static int[][] adjMatrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[n][n];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j<n ; j++) {
				if(i!=j && adjMatrix[i][j]==0)
					adjMatrix[i][j] = INF;
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = Math.min(w, adjMatrix[from][to]);
		}
		// 플로이드 워샬 : 경유지를 지나 도착한 w와 지나지 않은 w비교 
		for(int k = 0; k < n; k ++) {
			for(int i = 0; i < n; i++) {
				if(k==i)continue;
				for(int j = 0; j< n; j++) {
					if(k==j || j==i) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						
				}
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				System.out.print((adjMatrix[i][j]==INF? 0 : adjMatrix[i][j]) + " ");
			}
			System.out.println();
		}

	}
	

}
