import java.util.*;

class Solution {
    
    class Node {
        int idx;
        int dis;
        
        public Node(int idx, int dis){
            this.idx = idx;
            this.dis = dis;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        
        boolean[] visited = new boolean[n+1];
        
        for(int i=0; i<n+1; i++) adjList[i] = new LinkedList<Integer>();
        
        
        for(int i=0; i<edge.length; i++){
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Node> q = new LinkedList<>();
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.dis - o1.dis;
        });
        
        q.add(new Node(1, 0));
        
        visited[1] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i : adjList[node.idx]){
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(new Node(i, node.dis+1));
                    pq.add(new Node(i, node.dis+1));
                }
            }
        }
        
        Node fn = pq.peek();
        int maxDis = fn.dis;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.dis == maxDis) cnt++;
        }
        
        answer = cnt;
        
        return answer;
    }
}