package com.algorithm.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

// 블록 껍질 
public class Solution_1708 {
	static class Point  {
		// 중간에 곱하기가 있으서?
		long x; 
		long y;
		
		public Point() {}

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class LC implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			int result =Long.compare(o1.x,o2.x);
			return result == 0 ? Long.compare(o1.y,o2.y) : result;
		}
		
	}
	// P를 중심으로 정렬
	static class LCT implements Comparator<Point>{
		Point point;
		public LCT(Point p) {
			super();
			point = p;
		}
		@Override
		public int compare(Point p1, Point p2) {
			long angle = ccw(point, p1, p2);
			if(angle == 0) {
				// 거리를 구한다
				long d1= distance(point,p1);
				long d2= distance(point,p2);
				return d1>d2? 1:-1;
			}else {
				return angle>0 ? -1:1;
			}
		}
		
	}
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> points = new ArrayList<>();
		Stack<Point> hull = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			points.add(new Point(x, y));
		}
		// 1. 왼쪽 아래로 정렬
		points.sort(new LC());
		Point P = points.remove(0);
		hull.push(P); // 기준점 저장
		// 2. P점을 기준으로 각도 정렬, 거리정렬
		points.sort(new LCT(P));
		Point tw = points.remove(0);
		hull.push(tw); // 두번째 점 넣기
		
		// 3. 그라함 스캔
		for (int i = 0; i < N-2; i++) {
			Point b = points.get(i);
			// 2개이상이면 
			while(hull.size() >= 2) {
				// cw 뺀다
				Point a = hull.pop(); 
				Point p = hull.peek();
				long ang = ccw(p, a, b);
				// 문제 없으면 a 다시 넣어주기 
				if(ang>0) {
					hull.push(a);
					break;
				}
			}
			hull.push(b);
		}
		
		System.out.println(hull.size());
		
	}
	// x1,x2에서 x2,y2 거리
	static long distance(Point p1, Point p2) {
		return (p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y)  ;
	}
	static Point vector(Point p1, Point p2) {
		// vector AB = OB - OA
		long x = p2.x - p1.x;
		long y = p2.y - p1.y;
		return new Point(x, y);
	}
	// 외적 
	static long cross(Point p1, Point p2) {
		return p1.x * p2.y- p2.x * p1.y;
	}
	// 각도
	static long ccw(Point P, Point A, Point B) {
		return cross(vector(P,A), vector(A,B));
	}

}
