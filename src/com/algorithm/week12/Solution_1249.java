package com.algorithm.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249 {
	static int N, INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] -'0';
				}
			}
			
			System.out.println("#" + t+ " "+ dijkstra(0,0));
		}
		
	}
	private static int dijkstra(int startR, int startc) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], INF);
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		}); // 정점 r [0], c [1], 출발지부터 복구시간 [2]
		
		minTime[startR][startc] = 0;
		queue.offer(new int[] {startR, startc, minTime[startR][startc]});
		int r = 0, c = 0, cost = 0, nr, nc;
		int[] current;
		while(true) {
			cost = INF;
			// 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점
			current = queue.poll();
			r = current[0];
			c = current[1];
			cost = current[2];
			
			if(visited[r][c])continue;// 삭제하지 않고 계속 offer 해서
			
			visited[r][c] = true;
			if(r==N-1 && c ==N-1) return cost;
			
			// 선택된 정점 기준으로 아직 방문하지 않은 나머지 정점들  자신과의 경윳 비용과 기존
			// 최소 비용 비교하여 최솟값 업데이트
			// 현재 정점위치 기준으로 4방의 인접 정점을 처리
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if(isContain(nr,nc)&&!visited[nr][nc]
						&&minTime[nr][nc]>cost+map[nr][nc]) {
					minTime[nr][nc] = cost+ map[nr][nc];
					queue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
			
		}
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
