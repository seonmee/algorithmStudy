package com.algorithm.week24.common;

import java.io.*;
import java.util.*;
/*
 * 벽 부수고 이동하기 
 * */
public class Solution_2206 {
	static int N, M;
	static int[][] map; 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node {
		int r;
		int c;
		int breakCnt;
		int mvCnt;
		public Node(int r, int c, int breakCnt, int mvCnt) {
			this.r = r;
			this.c = c;
			this.breakCnt = breakCnt;
			this.mvCnt = mvCnt;
		} 
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int r = 0; r < N ; r++) {
			String line = br.readLine();
			for(int c =0; c < M ; c++) {
				map[r][c] = line.charAt(c) -'0';
			}
		}
		
		System.out.println(solution());
		
	}
	// 최단 경로 탐색 : bfs 
	private static int solution() {
		Queue<Node> pos = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2];  // 0 : 안부순 경우   1 : 부순경우   
		pos.offer(new Node(0,0,0,1));  // (1,1) 에서 출발
		visited[0][0][0] = true;   
		visited[0][0][1] = true;
		
		while(!pos.isEmpty()) {
			Node cur = pos.poll();
			int cr = cur.r;
			int cc = cur.c;
			int bCnt = cur.breakCnt;
			int mCnt = cur.mvCnt;
			if(cr == N-1 && cc == M-1) {
				return mCnt;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!isContian(nr,nc))continue;       // 범위가 벗어난 경우
				// 1. 벽일 때 
				if(map[nr][nc]==1) {
					// 1-1) 이전에 부수지 않았으면 부수고 이동
					if(bCnt == 0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						pos.offer(new Node(nr, nc, 1, mCnt+1));
					}
					// 1-2) 부쉈으면 이동 못함
				}else {
					// 2. 벽이 아닐 때  그냥 이동
					if(visited[nr][nc][bCnt])continue;
					visited[nr][nc][bCnt] = true;
					pos.offer(new Node(nr, nc, bCnt, mCnt+1));
				}
			}
		}
		
		return -1;
	}
	private static boolean isContian(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M ;
	}

}