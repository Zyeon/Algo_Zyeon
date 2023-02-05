package _2월2주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2589
 * 
 * @author Zizon_Yonni L: 육지 W : 바다
 */
public class BOJ_G5_2589_보물섬 {

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int dist;
		boolean[][] visited;

		public Point(int x, int y, int dist, boolean visited[][]) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.visited = visited;
		}
		public Point(int x, int y,int dist) {
			this.x = x;
			this.y = y;
			this.dist= dist;
		}
		
		@Override
		public int compareTo(Point p) 
		{
			return this.dist - p.dist;
		}
		
		

	}

	public static class Treasure {
		int startX;
		int startY;
		int endX;
		int endY;

		public Treasure(int startX, int startY, int endX, int endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
		

		@Override
		public String toString() {
			return "Treasure [startX=" + startX + ", startY=" + startY + ", endX=" + endX + ", endY=" + endY + "]";
		}
		
		

	}

	static int L, W;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static char matrix[][];
	static boolean isCheck[][];
	static int max;
	static Treasure t;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		matrix = new char[L][W];
		isCheck = new boolean[L][W];

		for (int r = 0; r < L; r++) {
			String input = br.readLine();
			for (int c = 0; c < W; c++) {
				matrix[r][c] = input.charAt(c);
			}
		}

		for (int r = 0; r < L; r++) {
			for (int c = 0; c < W; c++) {
				if (!isCheck[r][c] && matrix[r][c] == 'L') {
					isCheck[r][c] = true;

					int [ ]result = BFS(r,c);
					
					if (max < result[2]) {
						max=result[2];
						t= new Treasure(r, c, result[0], result[1]);
						
					}
				}
			}
		}

		System.out.println(BFSResult(t)-1);
	}

	public static int[] BFS(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		boolean visited[][] = new boolean[L][W];
		int max = 0;

		int result[] = new int[3];

		visited[x][y] = true;

		q.offer(new Point(x, y, 1, visited));

		while (!q.isEmpty()) {
			Point curPoint = q.poll();

			int curX = curPoint.x;
			int curY = curPoint.y;
			int dist = curPoint.dist;
			
			if (max <= dist) {
				result[0] = curX;
				result[1] = curY;
				result[2] = dist;
			}

			for (int d = 0; d < 4; d++) {

				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (!(nx >= 0 && ny >= 0 && nx < L && ny < W))
					continue;
				if (visited[nx][ny])
					continue;

				if (matrix[nx][ny] == 'W')
					continue;

				visited[nx][ny] = true;

				q.offer(new Point(nx, ny, dist + 1, visited));

			}

		}

		return result;
	}
	
	public static int BFSResult(Treasure t) 
	{
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		boolean visited[][] = new boolean[L][W];
		q.offer(new Point(t.startX,t.startY,1));
		visited[t.startX][t.startY]=true;
		
		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			int x = curPoint.x;
			int y = curPoint.y;
			int dist = curPoint.dist;
			
			
			if(x==t.endX &&y==t.endY) 
			{
				return dist;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!(nx >= 0 && ny >= 0 && nx < L && ny < W))
					continue;
				if (visited[nx][ny])
					continue;

				if (matrix[nx][ny] == 'W')
					continue;

				visited[nx][ny] = true;
				q.offer(new Point(nx, ny, dist + 1));
			}
			
		}
		return -1;
	}

}
