package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈주범 검거
// 털주 한시간 후 맨홀뚜껑으로 진입
// 탈주 범이 존재할 수 있는 위치 개수
// 시간당 1 씩 이동
// 터널 1. 상하좌우 2. 상하 3. 좌우 4. 우상 5. 우하  6.좌하 7.좌상
// que에 넣고 엎어버리기
// 개수와 터널개수가 같으면 stop : 가지치기
public class Solution_1953 {
	static int T, N, M, R, C, L, pipeCnt;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 세로크기 r
			M = Integer.parseInt(st.nextToken()); // 지도 가로크기 c
			R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑의 r좌표
			C = Integer.parseInt(st.nextToken()); // 맨홀뚜껑의 c좌표
			L = Integer.parseInt(st.nextToken()); // 탈출 소요시간 
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]!=0) pipeCnt++; // 총 파이프 갯수
				}
			}
			if(L==1)System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + move());
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Integer> d = new ArrayList<>();
	
	private static int move() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {R,C, map[R][C]}); // 맨홀 뚜껑위치에서 시작
		int[] cur;
		int cr, cc, ct, type, nr, nc;
		int time = 1, count =1;
		map[R][C] = 8; // 방문처리
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {				
				cur = que.poll();
				cr = cur[0];
				cc = cur[1];
				ct = cur[2];
				d = chooseDirect(ct); // pipe type에 따른 방향 지정
				for (int d : d) {
					nr = cr + dr[d];
					nc = cc + dc[d];
					if(!isContain(nr,nc)) continue; // 범위를 벗어난경우
					if(map[nr][nc]==8) continue; // 방문한 경우
					if(!isConnect(map[nr][nc], d)) continue; // 길이 없는 경우
					que.offer(new int[] {nr,nc,map[nr][nc]});
					map[nr][nc] = 8; // 방문처리
					count++;
				}
				d.clear();
			}
			if(time++ == L) break;
			if(count == pipeCnt) break;
		}
		return count;
		
	}

	private static boolean isConnect(int pipe, int dir) {
		int con = 0; // 연결되는 방향
		switch(dir) {
		case 0 :
			con = 1;
			break;
		case 1 :
			con = 0;
			break;
		case 2 :
			con = 3;
			break;
		case 3 :
			con = 2;
			break;
		}
		return chooseDirect(pipe).contains(con);
	}

	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M ;
	}

	private static ArrayList<Integer> chooseDirect(int type) {
		ArrayList<Integer> ans = new ArrayList<>();
		switch(type) {
		case 1 : // 상하좌우
			for (int i = 0; i < 4; i++) {
				ans.add(i);
			}
			break;
		case 2 : // 상하
			ans.add(0);
			ans.add(1);
			break;
		case 3 : // 좌우
			ans.add(2);
			ans.add(3);
			break;
		case 4 : // 상우
			ans.add(0);
			ans.add(3);
			break;
		case 5 : // 하우
			ans.add(1);
			ans.add(3);
			break;
		case 6 : // 하좌
			ans.add(1);
			ans.add(2);
			break;
		case 7 : // 상좌
			ans.add(0);
			ans.add(2);
			break;
		}	
		return ans;
	}

}
