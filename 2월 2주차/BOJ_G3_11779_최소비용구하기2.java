package _2월2주차;

import java.util.*;
import java.io.*;;


/**
 * https://www.acmicpc.net/problem/11779
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_11779_최소비용구하기2 {

	static int N, M;
	static int dist[], route[];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static class Node implements Comparable<Node> {
		int node;
		int cost;

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		route = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int ans=dijkstra(start,end);
		Stack<Integer> s = new Stack<Integer>();
		
		while(true) 
		{
			s.push(end);
			end = route[end];
			
			if(end==start) 
			{
				s.push(end);
				break;
			}
				
		}
		
		sb.append(ans).append("\n").append(s.size()).append("\n");
		
		while(!s.isEmpty()) 
		{
			sb.append(s.pop()).append(" ");
		}
		
		System.out.println(sb);

	}

	public static int dijkstra(int start,int end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[start]=0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node n = pq.poll();

			int curNode = n.node;
			int curCost = n.cost;
			if(curNode==end)
				break;
			if (dist[curNode] < curCost)
				continue;

			ArrayList<Node> nodeList = graph.get(curNode);

			int size = nodeList.size();

			for (int i = 0; i < size; i++) {
				int nextNode = nodeList.get(i).node;
				int nextCost = nodeList.get(i).cost;

				int newCost = curCost + nextCost;

				if (dist[nextNode] > newCost) {
					dist[nextNode] = newCost;
					route[nextNode] = curNode;
					pq.offer(new Node(nextNode, newCost));
				}

			}
		}
		return dist[end];
	}

}
