package com.algorithm.week26;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
/*
 * 엄청난 부자2 
 * */
public class Solution_1271 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 1 ≤ m ≤ n ≤ 101000
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		// 오.. 함수가 있다...
		System.out.println(a.divide(b));
		System.out.println(a.mod(b));
	}
	
}
