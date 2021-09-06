package com.algorithm.week31.common;

import java.io.*;
import java.util.*;
/*
 * 중량제한 
 * 
 * 중량의 최댓값
 * */
public class Solution_1939 {
	static int N, M, start, end;
	static boolean[] visited;
	static class Node {
		int to; // 도착지
		int limit; // 중량 제한

		public Node(int to, int limit) {
			super();
			this.to = to;
			this.limit = limit;
		}
	}

	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  // 섬 개수 
		M = Integer.parseInt(st.nextToken());  // 다리 정보 개수 
		
		adjList = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 다리정보 입력 
		int max = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to,limit));
			adjList[to].add(new Node(from,limit));
			
			min = Math.min(min, limit);
			max = Math.max(max, limit);
			
		}
		
		// 공장이 위치한 섬이 있는 번호 
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while(min<=max) {
			int mid = (min + max)/2;
			visited = new boolean[N+1];
			if(check(mid)) {  // mid의 중량으로 건널 수 있으면 
				min = mid + 1;
				ans = mid;
			}else {
				max = mid - 1;
			}
		}
		System.out.print(ans);
	}

	/* 중량으로 건널 수 있는지 확인 */
	private static boolean check(int mid) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작위치부터 
		queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == end) return true; // 도착 
            
            for(int i = 0; i < adjList[cur].size(); i++) { // 인접한 섬중 
                if(adjList[cur].get(i).limit >= mid && visited[adjList[cur].get(i).to] == false) {
                	// 제한된 중량보다 작고 방문하지 않았으면 
                    visited[adjList[cur].get(i).to] = true;
                    queue.offer(adjList[cur].get(i).to);
                }
            }
        }
        return false;
	}
}
