package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15683 {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map, dir;
	static ArrayList<Camera> cctvs;
	static class Camera{
		public int r;
		public int c;
		public int num;
		public Camera(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]!=6&&map[r][c]>0) cctvs.add(new Camera(r, c, map[r][c])); // 카메라 정보 저장 
			}
		}
		
		go(0);
		System.out.println(ans);
	}
	private static void go(int idx) {
		// cctv를 모두 선택했으면
		if(idx==cctvs.size()) {
			// 사각지대 cnt  && min값 찾기
			ans = Math.min(ans, cntBlind());
			return;
		}
		int[][] dir = findDirect(cctvs.get(idx).num);
		// 1. 방향 선택
		for (int[] d : dir) {
			// 2. 방향대로 뻗기
			check(idx, d);
			go(idx+1);
			// 되돌리기
			cancelCheck(idx, d);
		}
		
	}
	private static int cntBlind() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]==0)cnt++;
			}
		}
		return cnt;
	}
	private static void cancelCheck(int idx, int[] dir) {
		Camera cam = cctvs.get(idx);
		for (int d : dir) {
			int r = cam.r;
			int c = cam.c;
			while(true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!isContain(nr,nc)) break; // 영역을 벗어난 경우
				if(map[nr][nc]==6) break;  // 벽을 만난경우
				if(map[nr][nc]==9) {
					map[nr][nc]=0;  // 감시취소
				}
				if(map[nr][nc]>9) {
					map[nr][nc]--;
				}
				r = nr; // 이동 (다른 카메라인 경우 포함)
				c = nc; 
			}
		}
	}
	private static void check(int idx, int[] dir) {
		Camera cam = cctvs.get(idx);
		for (int d : dir) {
			int r = cam.r;
			int c = cam.c;
			while(true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!isContain(nr,nc)) break; // 영역을 벗어난 경우
				if(map[nr][nc]==6) break;  // 벽을 만난경우
				if(map[nr][nc]>=9) { // 겹치는 경우
					map[nr][nc]++;
				}
				if(map[nr][nc]==0) {
					map[nr][nc]=9;  // 감시표시
				}
				r = nr; // 이동 (다른 카메라인 경우 포함)
				c = nc; 
			}
		}
		
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
	private static int[][] findDirect(int start) {
		int[][] dir = null;
		switch (start) {
		case 1:
			dir = new int[][]{{0},{1},{2},{3}};
			break;
		case 2:
			dir = new int[][]{{0, 1},{2, 3}}; 
			break;
		case 3:
			dir = new int[][]{{0,2},{0,3},{1,2},{1,3}};
			break;
		case 4:
			dir = new int[][]{{0,1,2},{1,2,3},{0,2,3},{0,1,3}};
			break;
		case 5:
			dir = new int[][]{{0,1,2,3}};
			break;
		default:
			break;
		}
		return dir;
	}

}
