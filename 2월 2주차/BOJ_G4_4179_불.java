package _2월2주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/4179
 * 
 * @author Zizon_Yonni
 * 
 * 푼 방법
 * 개꿀큐로 불이랑 지훈이가 동시에 이동하게.. 설계했음
 * 
 */
public class BOJ_G4_4179_불 {

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int cnt;
		char state;

		public Point(int x, int y, int cnt, char state) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.state =state;
		}

		@Override
		public int compareTo(Point p) {
			return this.cnt - p.cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

	static int R, C;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static char matrix[][];
	static boolean visited[][], visitedF[][];
	static ArrayList<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		matrix = new char[R + 2][C + 2];
		visited = new boolean[R + 2][C + 2];
		visitedF = new boolean[R + 2][C + 2];

		for (int r = 1; r < R + 1; r++) {
			String input = br.readLine();
			for (int c = 1; c < C + 1; c++) {
				char ch = input.charAt(c - 1);
				matrix[r][c] = ch;

				if (ch != '.')
					list.add(new Point(r, c, 1,matrix[r][c]));

			}
		}


		int ans = BFS();

		if (ans == -1) {
			System.out.println("IMPOSSIBLE");
		} else
			System.out.println(ans);

	}

	public static int BFS() {

		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		for (Point p : list) {
			pq.offer(p);
		}

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			char state = p.state;
			if (matrix[x][y] == '\u0000')
				return cnt;
			
//			System.out.println(state+" : "+x+" / "+y+" state : "+cnt);
			if (state == 'F') {
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (!(nx >= 1 && ny >= 1 && nx < R + 1 && ny < C + 1))
						continue;
					if (matrix[nx][ny] == '#')
						continue;

					if (matrix[nx][ny] == 'F')
						continue;

					matrix[nx][ny]='F';
					pq.offer(new Point(nx, ny, cnt + 1,'F'));
				}

			} else if (state == 'J') {
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (matrix[nx][ny] == '\u0000')
						return cnt;
					

					if (!(nx >= 0 && ny >= 0 && nx < R + 2 && ny < C + 2))
						continue;
					if (visited[nx][ny])
						continue;
					// 벽
					if (matrix[nx][ny] == '#')
						continue;
					if (matrix[nx][ny] == 'F')
						continue;
					if (matrix[nx][ny] == 'J')
						continue;
					
					matrix[nx][ny]='J';
					visited[nx][ny]=true;
					pq.offer(new Point(nx, ny, cnt + 1,'J'));
//					System.out.println(nx+" "+ny+"넣기");
//					for (int r = 0; r < R + 2; r++) {
//						System.out.println(Arrays.toString(matrix[r]));
//					}

				}
			}
		}

		return -1;
	}

}
