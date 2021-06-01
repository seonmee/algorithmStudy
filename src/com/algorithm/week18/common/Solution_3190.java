package com.algorithm.week18.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 뱀
 *  
 * 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝
 * 
 * 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
 * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
 * 
 * */
public class Solution_3190 {
	static int N, K, L;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Map<Integer, Character> turn;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());  // 보드 크기
		map = new int[N][N];
		
		K = Integer.parseInt(br.readLine());  // 사과 개수
	
		for(int i = 0; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1; // 사과 
		}
		L = Integer.parseInt(br.readLine());  // 방향 전환 횟수
		turn = new HashMap<>();
		for(int i = 0 ; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			turn.put(time, dir);// 뱀 방향 전환 
		}
		
		// 로직
		System.out.println(bfs(0));
		
	}

	private static int bfs(int d) {
		Queue<int[]> snake = new LinkedList<>();
		snake.offer(new int[] {0,0,0}); // 시작점
		int cr =  0;
		int cc = 0;
		int ct = 0;
		map[0][0] = 2; // 뱀이다~  
		while(true) {
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			int nt = ct + 1;
			// 벽에 부딫히면 종료 몸에 부딫히면 종료 
			if(!isContian(nr,nc) || map[nr][nc]==2) {
				return nt;
			}
			if(map[nr][nc]==0) {         // 사과가 없으면 
				int[] tail = snake.poll();
				map[tail[0]][tail[1]] = 0;
			}
			map[nr][nc] = 2;
			snake.offer(new int[] {nr,nc,nt});
			if(turn.containsKey(nt)) {
				if(turn.get(nt)=='L') d = (d+3)%4;
				if(turn.get(nt)=='D') d = (d+1)%4;
			}
			cr = nr;
			cc = nc;
			ct = nt;
			
		}
	}

	private static boolean isContian(int nr, int nc) {
		return nr>=0 && nr <N && nc >= 0 && nc<N;
	}
}
