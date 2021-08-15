package com.algorithm.week28.common;
import java.io.*;
import java.util.*;
/*
 * 로봇 시뮬레이션 
 * 가로 A(1≤A≤100), 세로 B(1≤B≤100) 
 * 로봇 N(1≤N≤100)개 
 * 명령 M(1≤M≤100)개
 * */
public class Solution_2174 {
	static int A, B, N , M;
	static int[]dr = {-1 ,0, 1, 0};
	static int[]dc = {0, 1, 0, -1};
	static int[][] map;
	static class robot {
		int r;
		int c;
		int d;
		public robot(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	static ArrayList<robot> robots;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B][A];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		robots = new ArrayList<robot>();
		
		for(int i = 0; i < N ; i++) {
			int dir = 0;
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken())-1;
			int r = B-Integer.parseInt(st.nextToken());
			map[r][c] = i+1;
			char d = st.nextToken().charAt(0);
			if(d=='N') dir = 0;
			if(d=='E') dir = 1;
			if(d=='S') dir = 2;
			if(d=='W') dir = 3;
			
			robots.add(new robot(r,c,dir));
		}
		
		boolean isOK = true;
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			int rep = Integer.parseInt(st.nextToken());
			if(move(num, dir, rep)) {
				isOK = false;
				break;
			}
		}
		if(isOK) System.out.println("OK");
		
	}
	private static boolean move(int num, char dir, int rep) {
		robot cur = robots.get(num-1);
		int cr = cur.r;
		int cc = cur.c;
		int cd = cur.d;
		int nr = cr;
		int nc = cc;
		for(int i = 0; i < rep; i++) {
			if(dir=='L') {
				cd = (4 + cd - 1) %4;
			}else if(dir =='R') {
				cd = (cd + 1) % 4;
			}else if(dir =='F') {
				nr = cr + dr[cd];
				nc = cc + dc[cd];
				if(!isContain(nr,nc)) {
					System.out.println("Robot "+num+" crashes into the wall");
					return true;
				}
				if(map[nr][nc]!=0) { // 다른 로봇과 충돌하면 
					System.out.println("Robot "+num+" crashes into robot "+map[nr][nc]);
					return true;
				}
				cr = nr;
				cc = nc;
			}
			cur.d = cd;
		}
		map[cur.r][cur.c] = 0;
		map[nr][nc] = num;
		cur.r = nr;
		cur.c = nc;
		return false;
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr < B && nc >=0 && nc <A;
	}

}
