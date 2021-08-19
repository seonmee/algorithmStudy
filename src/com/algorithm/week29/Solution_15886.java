package com.algorithm.week29;

import java.io.*;
import java.util.*;

/*
 * 내 선물을 받아줘 2 
 * 
 * 2 ≤ N ≤ 1,000
 * 
 * 6
 * EEWWEW 
 * */
public class Solution_15886 {
	static int N;
	static HashSet<Integer> ans = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        String move = br.readLine();

        for(int i=0; i<N; i++) {
            boolean[] visited = new boolean[N];
            dfs(i, move, visited);
        }

        System.out.println(ans.size());
    }

    public static void dfs(int idx, String mv, boolean[] visited) {
        
    	if(ans.contains(idx)) return;
        
        if(visited[idx]) {
            ans.add(idx);
            return;
        }

        visited[idx] = true;
        if(mv.charAt(idx)=='E')
            dfs(idx+1, mv, visited);
        else
            dfs(idx-1, mv, visited);
    }

}
