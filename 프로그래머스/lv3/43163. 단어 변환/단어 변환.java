import java.util.*;

class Solution {
    
    class Node {
        String word;
        int idx;
        int cnt;
        
        public Node(String word, int idx, int cnt){
            this.word = word;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    int answer = 0;
    int count = 0;
    public void bfs(String st, String target, String[] words, boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(st, words.length, 0)); //begin이 맨처음 들어갈 예정
        
        while(!q.isEmpty()){
            Node n = q.poll();
            visited[n.idx] = true;

            count++;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && compareStr(words[i], n.word) == 1){
                    q.add(new Node(words[i], i, count)); 
                    
                    if(words[i].equals(target)) {
                        answer = n.cnt + 1;
                        return;
                    }
                }
                
            }
        }
    }
    
    
    //문자열 다른 갯수 비교
    public int compareStr(String a, String b){
        int len = a.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        
        return cnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length+1];
        
        boolean check = false;
        for(String word : words) {
            if(word.equals(target)) {
                check = true;
                break;
            }
        }
        
        for(int i=0; i<words.length; i++){
            
        }
        
        if(!check) return 0;
        
        bfs(begin, target, words, visited);
        
        return answer;
    }
}