package com.algorithm.week8.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 48644KB 320ms */
public class Solution_1976 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] plan;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N =Integer.parseInt(br.readLine()); // 도시수
		M =Integer.parseInt(br.readLine()); // 계획에 속한 도시수
		adjList = new ArrayList<>();
		// 인접 list입력
		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int from = 0; from < N; from++) {
			st = new StringTokenizer(br.readLine());
			for (int to = 0; to < N; to++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {					
					adjList.get(from).add(to);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		plan = new int[M];
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		String ans = "YES";
		for (int i = 0; i < M-1; i++) {
			int from = plan[i]-1;
			int to = plan[i+1]-1;
			visited = new boolean[N];
			if(!findPath(from, to)) {
				ans = "NO";
				break;
			}
		}
		// 출력
		System.out.println(ans);
	}
	/*
	 * from 부터 to까지 경로가 존재하는지 확인하는 함수
	 * */
	private static boolean findPath(int from, int to) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(from);
		
		while(!queue.isEmpty()) {
			int cFrom = queue.poll();
			// 경로가 존재하는 경우
			if(cFrom==to) {
				return true;
			}
			visited[cFrom] = true;
			
			for (int next : adjList.get(cFrom)) {
				if(!visited[next])
					queue.offer(next);
			}
		}
		return false;
	}

}
