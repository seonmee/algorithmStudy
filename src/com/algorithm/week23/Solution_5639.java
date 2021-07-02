package com.algorithm.week23;
import java.util.*;
import java.io.*;
/*
 * 이진 검색 트리 
 * */
public class Solution_5639 {
	static ArrayList<Integer> input;
	static class Node {
		int num;
		Node left;
		Node right;
		public Node(int num) {
			this.num = num;
		}
		public void makeTree(int n) {
			if(this.num < n) { // 오른쪽 
				if(right==null) right = new Node(n);
				else right.makeTree(n);
			}else {
				if(left==null) left = new Node(n);
				else left.makeTree(n);
			}
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1) tree 생성 
		Node root = new Node(Integer.parseInt(br.readLine()));
		String num;
		while(true) {
			if((num = br.readLine()) == null) break;
			root.makeTree(Integer.parseInt(num));
			
		}
		// 2. 후위 순회 
		postOrder(root);
		
	}
	private static void postOrder(Node root) {
		if(root==null)return;
		// 왼
		postOrder(root.left);
		// 오
		postOrder(root.right);
		// 중 
		System.out.println(root.num);
	}

}
