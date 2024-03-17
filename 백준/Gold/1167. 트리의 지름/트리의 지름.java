import java.io.*;
import java.util.*;
public class Main{

    static void DFS(int start, int cost){
        if(cost > maxCost){
            maxCost = cost;
            longDest = start;
        }
        visited[start] = true;
        for(Node node : adjList[start]){
            if(visited[node.dest])
                continue;
            DFS(node.dest, cost + node.cost);
        }
    }
    static ArrayList<Node>[] adjList;
    static boolean[] visited;
    static int longDest;
    static int maxCost = 0;
    static class Node{
        int dest;
        int cost;

        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());

        adjList =  new ArrayList[vertex+1];

        for(int i = 1;i <= vertex; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 1;i <= vertex ; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int dest = Integer.parseInt(st.nextToken());
                if(dest == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                adjList[node].add(new Node(dest, cost));
            }
        }

        visited =  new boolean[vertex+1];
        DFS(1, 0);

        visited =  new boolean[vertex+1];
        DFS(longDest, 0);

        System.out.println(maxCost);
    }
}