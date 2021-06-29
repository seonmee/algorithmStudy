package com.algorithm.week23;
import java.util.*;
/*
 * 완전 이진 트리
 * 
 * input : 중위순회 결과
 * output : 완전 이진 트리 
 * 1<= K <=10
 * */
public class Solution_9934 {
	static int K;  
	static int[] nodes;
	static Queue<int[]> centers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		int cnt = (int)Math.pow(2, K)-1;
		nodes = new int[cnt];
		centers = new LinkedList<>();
		
		for(int i = 0; i < cnt ; i++) {
			nodes[i] = sc.nextInt();
		}
		
		centers.offer(new int[] {0,cnt-1});
		int depth = 0;
		while(!centers.isEmpty()) {
			int size = centers.size();
			while(--size>=0) {
				int[] current = centers.poll();
				int start = current[0];
				int end = current[1];
				int mid = (start + end)/2;
				System.out.print(nodes[mid] + " ");
				int lEnd = mid - 1;
				int rStart= mid + 1;
				if(lEnd>=0) 
					centers.offer(new int[] {start,lEnd});
				if(rStart<cnt)
					centers.offer(new int[] {rStart,end});
			}
			System.out.println();
			if(++depth==K) break;
		}		
		
		
	}

}
