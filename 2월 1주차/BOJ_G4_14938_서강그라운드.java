package _2월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/14938
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_14938_서강그라운드 {

	public static class Node implements Comparable<Node>{
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o)
		{
			return cost - o.cost;
		}

		
	}

	static int N, M, R; // 지역의 개수, 수색범위, 길의 개수
	static int[] item;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	static int ans = Integer.MIN_VALUE;
	//static int dist[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		item = new int[N + 1];
		//dist = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
			graph.get(end).add(new Node(start, cost));
		}
		
		for (int i = 1; i < N+1; i++) {
			int result=Dijkstra(new Node(i,0));
			//System.out.println(result);
			ans = Integer.max(ans,result);
		}
		
		System.out.println(ans);
		
	}
	
	public static int Dijkstra (Node node) 
	{
		int result=0;
		int [] dist  = new int[N+1];
		boolean [] visited = new boolean[N+1];

		for (int i = 0; i < N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.offer(node);
		dist[node.index]=0;
		
		
		while(!pq.isEmpty()) 
		{
			Node curNode = pq.poll();
			
			if(dist[curNode.index]<curNode.cost)
				continue;
			
			if(visited[curNode.index])
				continue;
			visited[curNode.index]=true;
			
			int size = graph.get(curNode.index).size();
			
			for (int i = 0; i < size; i++) {
				Node nextNode = graph.get(curNode.index).get(i);
				int cost = curNode.cost + nextNode.cost;
				
				if(visited[nextNode.index])
					continue;
				
				if(dist[nextNode.index]>cost ) 
				{
					dist[nextNode.index]=cost;
					pq.offer(new Node(nextNode.index,cost));
				}
				
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			if(dist[i]<=M) 
			{
				result +=item[i];
			}
		}
		
		
		return result;
	}

}
