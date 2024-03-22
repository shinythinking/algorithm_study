import java.io.*;
import java.util.*;
public class Main{

    static class Node implements Comparable<Node>{
        int vertex;
        int cost;
        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int[] dijkstra(int start, ArrayList<Node>[] adjList){
        int vertex = adjList.length - 1;
        int[] distance = new int[vertex + 1];
        boolean[] visited = new boolean[vertex + 1];

        for(int i = 1 ; i <= vertex ; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int currentV = current.vertex;
           /* if(currentV == end)
                return;*/
            if(visited[currentV])
                continue;
            if(current.cost > distance[currentV])
                continue;
            visited[currentV] = true;
            for (Node next : adjList[currentV]){
                if(distance[next.vertex] > distance[currentV]+ next.cost){
                    distance[next.vertex] = distance[currentV]+ next.cost;
                    pq.offer(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
        return distance;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] adjList = new ArrayList[vertex + 1];
        ArrayList<Node>[] adjListReversed = new ArrayList[vertex + 1];

        for(int i = 1 ; i <= vertex ; i++) {
            adjList[i] = new ArrayList<>();
            adjListReversed[i] = new ArrayList<>();
        }
        while (edge --> 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, cost));
            adjListReversed[end].add(new Node(start, cost));
        }

        int max = 0;
        int res = 0;

        int[] go = dijkstra(target, adjList);
        int[] from = dijkstra(target, adjListReversed);
        for(int i = 1 ; i <= vertex ; i++) {
            res = go[i] + from[i];
            if(max < res)
                max = res;
        }

        System.out.println(max);
    }
}