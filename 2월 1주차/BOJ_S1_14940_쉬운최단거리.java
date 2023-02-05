package _2월1주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14940
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_S1_14940_쉬운최단거리 {

	public static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

	static int N, M; // 세로 , 가로
	static int matrix[][];
	static int result[][];
	static boolean visited[][];

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];

		Point target = null;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {

				int input = Integer.parseInt(st.nextToken());

				matrix[r][c] = input;

				if (input == 2) {
					target = new Point(r, c, 0);
				}
			}
		}

		BFS(target);

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if ((visited[r][c]==false) && result[r][c] == 0 && matrix[r][c]!=0)
					result[r][c]=-1;

					sb.append(result[r][c]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void BFS(Point target) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.offer(target);
		visited[target.x][target.y] = true;

		while (!queue.isEmpty()) {
			Point curPoint = queue.poll();
			int x = curPoint.x;
			int y = curPoint.y;
			int cnt = curPoint.cnt;

			for (int d = 0; d < 4; d++) {

				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visited[nx][ny])
					continue;

				if (matrix[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				result[nx][ny] = cnt + 1;

				queue.offer(new Point(nx, ny, cnt + 1));

			}
		}

	}

}
