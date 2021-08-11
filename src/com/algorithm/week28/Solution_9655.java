package com.algorithm.week28;
import java.util.*;
/*
 * 돌게임
 * 
 * 탁자 위에 돌 N개가 있다. 
 * 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 
 * 돌은 1개 또는 3개 가져갈 수 있다. 
 * 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
 * 
 * 1 > 상근
 * 2 > 창영
 * 3 > 1 1 1 상근 
 * 4 > 3 1 창영 
 * 
 * 홀수 상근 
 * 짝수 창영
 * 
 * 엥?
 * 
 * */

public class Solution_9655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N%2==0) System.out.println("CY");
		else System.out.println("SK");
	}

}
