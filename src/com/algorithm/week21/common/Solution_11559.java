package com.algorithm.week21.common;

import java.io.*;
import java.util.*;
/*
 * Puyo Puyo
 * */
public class Solution_11559 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Puyo{
		int r;
		int c;
		public Puyo(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static ArrayList<Puyo> puyos;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for(int r = 0; r < 12; r++) {
			map[r] = br.readLine().toCharArray();
		}
		puyos = new ArrayList<>();
		
		System.out.println(solution());

	}
	
	private static int solution() {
		int ans = 0;
		while(true) {
			visited = new boolean[12][6];
			int flag = 0;
			for(int r = 0; r < 12; r++) {
				for(int c = 0; c <6; c++) {
					if(!visited[r][c] && map[r][c] != '.') {
						puyos.clear();
						// 1. 연속 된 블럭 수 cnt : dfs
						countLinkedBlock(r,c);
						// 연속된게 4개 이상이면 터트리기!!!
						if(puyos.size()>=4) {
							flag ++;
							for(Puyo puyo : puyos) {
								int pr = puyo.r;
								int pc = puyo.c;
								map[pr][pc] = '.';
							}
						}
					} 
				}
			}
			if(flag == 0) return ans; 
			// 중력
			gravity();
			// 연쇄 추가 
			ans++;
		}
		
	}

	private static void gravity() {
		for (int c = 0; c < 6; c++) {
			int r = 11; // 아래부터
			while(r>0) {
				if(map[r][c]=='.') {// 빈 공간이면
					int nr = r-1;
					// 떠있는 벽돌 찾기
					while(nr>0 && map[nr][c]=='.') nr--;
						map[r][c] = map[nr][c];
						map[nr][c] = '.'; 
				}
				r--;
			}
		}
		
	}

	private static void countLinkedBlock(int r, int c) {
		visited[r][c] = true;
		puyos.add(new Puyo(r,c));
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc)|| visited[nr][nc])continue;
			if(map[r][c] == map[nr][nc]) {
				countLinkedBlock(nr,nc);
			}
		}
	}

	private static boolean isContain(int r, int c) {
		return 0 <= r && r < 12 && 0<=c && c<6;
	}

}
