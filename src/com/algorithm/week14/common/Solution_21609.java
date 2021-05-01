package com.algorithm.week14.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상어 중학교
public class Solution_21609 {
	static class Group implements Comparable<Group> {
		int r; // 기준 블록 행
		int c; // 기준 블록 열
		int rainbow; // 무지개 블록수
		
		public Group(int r, int c, int rainbow) {
			super();
			this.r = r;
			this.c = c;
			this.rainbow = rainbow;
		}

		@Override
		public int compareTo(Group g) {
			int dif1 = Integer.compare(g.rainbow, this.rainbow); // 우선순위 1. 무지개 블록 내림차순
			int dif2 = Integer.compare(g.r, this.r); // 우선순위 2. 기준 블록 행 내림차순
			return dif1 == 0 ? (dif2 == 0 ? Integer.compare(g.c, this.c) : dif2) : dif1;
		}

	}

	static int N, M, max,groupSize, rainbowCnt, totScore;
	static int[][] map, tmp;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 인접한 칸 : 4방
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Group> groups;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 한변의 크기
		M = Integer.parseInt(st.nextToken()); // 색상의 수
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		autoPlay();
		// 출력
		System.out.println(totScore);
	}

	private static void autoPlay() {
		
		while(true) {
			// 1. 크가가 가장 큰 블록 그룹을 찾는다. (그룹이 존재하지 않으면 종료)
			Group group = findGroup();
			if (group==null)return;
			
			// 2. 블럭 제거 & score 획득
			int r = group.r;
			int c = group.c;
			bfs(r, c, map[r][c]);
			
			totScore += max*max;
			
			// 3. 중력
			gravity();
			
			// 4. 반시계 방향
			ccw();
			
			// 5. 중력
			gravity();
		}
		
	}
	
	/* 네번째 : 반시계 */
	private static void ccw() {
		tmp = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				tmp[r][c] = map[c][N-1-r];
			}
		}
		
		for (int r = 0; r < N; r++) {
			map[r] = Arrays.copyOf(tmp[r], N);
		}
	}

	/* 세번째 : 중력 함수 : 빈칸(-2) 채우기, 검정 블록(-1)은 이동x */
	private static void gravity() {
		for (int c = 0; c < N; c++) {
			int r = N-1; // 아래부터
			while(r>0) {
				if(map[r][c]==-2) {// 빈 공간이면
					int nr = r-1;
					// 떠있는 벽돌 찾기
					while(nr>0 && map[nr][c]==-2) nr--;
					if(map[nr][c]!=-1) {  // 검정 블록이 아니면 이동
						map[r][c] = map[nr][c];
						map[nr][c] = -2; 
					}
				}
				r--;
			}
		}
	}

	/* 두번째 : 블럭 제거 */
	private static void bfs(int r, int c, int num) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		map[r][c]=-2;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0]; 
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!isContain(nr, nc))continue;
				if (map[nr][nc] == num || map[nr][nc] == 0) {
					que.offer(new int[] {nr,nc});
					map[nr][nc] = -2;      // 제거할 블럭 표시
				}
			}
		}
		
	}
	/* 첫번째 : 크기가 가장 큰 그룹을 구하는 함수 */
	private static Group findGroup() {
		groups = new ArrayList<>();
		max = Integer.MIN_VALUE;
		int flag = 0;		
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > 0 && map[r][c] <= M && !visited[r][c]) { // 일반 블록 & 방문x
					groupSize = rainbowCnt = 0;
					unvisited();
					// 1) group size 구하기 : dfs
					dfs(r, c, map[r][c]);
					
					if(groupSize>1)flag=1;
					
					// 2) groupSize가 가장 큰 group list에 add
					if (max < groupSize) {
						max = groupSize; // 최댓 값 갱신
						groups.clear();
						groups.add(new Group(r, c, rainbowCnt));
					}else if(max == groupSize) {
						groups.add(new Group(r, c, rainbowCnt));
					}
				}
			}
		}
		if(flag==0) return null;   // groupSize가 모두 2보다 작은 경우 = 그룹이 존재하지 않는 경우
		else { // group이 존재하는 경우 : 가장 첫번째 group return
			// 3) 우선순위 순으로 정렬
			Collections.sort(groups);
			return groups.get(0);
		}
	}

	private static void unvisited() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==0) visited[r][c]=false;
			}
		}
	}

	/* group을 탐색하며 group의 크기를 구하는 함수 */
	private static void dfs(int r, int c, int num) {
		groupSize++;
		visited[r][c] = true;
		if(map[r][c]==0) rainbowCnt++;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isContain(nr, nc))
				continue;
			if ((map[nr][nc] == num || map[nr][nc] == 0) && !visited[nr][nc]) {
				dfs(nr, nc, num);
			}
		}
	}

	private static boolean isContain(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
