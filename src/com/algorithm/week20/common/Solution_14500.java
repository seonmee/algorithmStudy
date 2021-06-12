package com.algorithm.week20.common;
import java.util.*;
import java.io.*;

/*
 * 테트로미노 
 * */
public class Solution_14500 {
	static int N, M, ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] print;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int r = 0; r< N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c<M ;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		print = new int[4];
		visited = new boolean[N][M];
		for(int r = 0; r<N ; r++) {
			for(int c = 0; c<M ; c++) {
				makeTermino(r,c,0,map[r][c]);
				visited[r][c] = false;
				makeO(r,c);
				
			}
		}
		
		System.out.print(ans);
		
		
	}
	
	// ㅗ : 만들기 (dfs로 ㅗ 모양을 만들 수 x) 
	private static void makeO(int r, int c) {
		int sum = map[r][c];
		int min = Integer.MAX_VALUE;
		int flag = 4;
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc)) {
				flag--; // + 에서 빼기  
				continue; 
			}
			if(flag==2) return;  // ㅡ 는 ㅗ 모양이 될 수 x
			sum += map[nr][nc];
			min = Math.min(min, map[nr][nc]);
		}
		if(flag==4) sum -= min;  // + 모양이면 최솟 값을 하나 제외
		ans = Math.max(ans, sum);
	}

	// 테트로미노 만들기 
	// tot :  테르미노 위치 값의 합  
	private static void makeTermino(int r, int c, int cnt, int tot) {
		visited[r][c] = true;
		if(cnt == 3) {
			ans = Math.max(ans, tot);
			return;
		}
		
		for(int d = 0; d< 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc))continue;   
			if(visited[nr][nc]) continue;
			makeTermino(nr, nc, cnt+1, tot + map[nr][nc]);
			visited[nr][nc] = false;
		}
		
		
	}

	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
