package _2월2주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1753
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_1753_최단경로 {

	public static class Node implements Comparable<Node>
	{
		int index;
		int cost;
		
		public Node(int index, int cost) 
		{
			this.index=index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) 
		{
			return Integer.compare(this.cost,n.cost);
		}
		
	}
	
	static int V,E;	// 정점, 간선
	static int start;
	static int dist[], route[];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		route = new int[V+1];
		
		for (int i = 1; i < V+1; i++) {
			dist[i]= Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end,cost));
			//graph.get(end).add(new Node(start,cost));
		}
		
		dijkstra();
		
		for (int i = 1; i < V+1; i++) {
			if(i==start)
				sb.append(0).append("\n");
			else 
			{
				if(dist[i]==Integer.MAX_VALUE)
					sb.append("INF").append("\n");
				else
					sb.append(dist[i]).append("\n");
			}
				
		}
		System.out.println(sb);
		
		
	}
	public static void dijkstra() 
	{
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) 
		{
			Node n = pq.poll();
			int curNode = n.index;
			int curCost = n.cost;
			
			if(dist[curNode]<curCost)
				continue;
			
			ArrayList<Node> list = graph.get(curNode);
			int size = list.size();
			
			for (int i = 0; i < size; i++) {
				Node next = list.get(i);
				int nextNode = next.index;
				int nextCost = next.cost;
				int newCost = curCost+nextCost;
				
				if(dist[nextNode]>newCost) 
				{
					route[nextNode]=curNode;
					dist[nextNode]=newCost;
					pq.offer(new Node(nextNode,newCost));
				}
				
			}
			
		}
		
	}

}
