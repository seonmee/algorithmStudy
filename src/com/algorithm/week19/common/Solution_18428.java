package com.algorithm.week19.common;

import java.util.*;
import java.io.*;
/*
 * 감시 피하기 */ 
public class Solution_18428 {
//상, 하, 좌, 우
	static int N;
	static String ans = "NO";
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Teacher{
		int r;
		int c;
		public Teacher(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static ArrayList<Teacher> teachers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		teachers = new ArrayList<>();
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c <N ;c++) {
				map[r][c] = st.nextToken().charAt(0);
				// 선생님의 위치
				if(map[r][c] == 'T') {
					teachers.add(new Teacher(r,c));
				}
			}
		}
		
		choose(0,0);
		System.out.println(ans);
		
	}
	// 벽 위치 선정  
	private static void choose(int cnt, int start) {
		// 1) 완탐 nC3
		if(cnt == 3) {
			boolean flag = true;
			// 2) 선생님 기준으로 확인 
			for(Teacher t : teachers) {
				if(!check(t)) {
					flag = false;
				}
			}
			if(flag)ans = "YES";
			return;
		}
		// 후보 중 선택 후보가 n(r,c) 
		for(int i = start; i < N*N ; i++) {
			int r = i / N;
			int c = i % N;
			// 비어 있을 경우에 만 선택 
			if(map[r][c]=='X') {
				map[r][c] = 'O';
				choose(cnt+1, i+1);
				map[r][c] = 'X';
			}
			
		}
		
	}
	// 선생님 기준으로 사방 탐색 
	private static boolean check(Teacher t) {
		boolean flag = true;
		for(int d = 0 ; d<4 ; d++) {
			// 학생이 발견되면 
			if(!straight(t.r,t.c,d)) {
				flag = false;
			}
		}
		return flag;
	}
	// 직진! 
	private static boolean straight(int r, int c, int d) {
		while(true) {
			r = r + dr[d];
			c = c + dc[d];
			if(!isContian(r, c)) return true;
			if(map[r][c] == 'S') return false;    // 학생이 보이면 x
			if(map[r][c] == 'O') return true;
		}
	}
	
	private static boolean isContian(int r, int c) {
		return r>=0 && r<N && c >=0 && c<N;
	}

}
