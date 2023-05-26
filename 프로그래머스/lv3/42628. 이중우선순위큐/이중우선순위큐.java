import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        int addCnt = 0;
        int minDeleteCnt = 0; //최솟값 삭제 명령어 갯수
        int maxDeleteCnt = 0; //최댓값 삭제 명령어 갯수
        
        for(String op : operations) {
            String command = op.split(" ")[0];
            
            switch(command){
                case "I": 
                    pq_max.add(Integer.parseInt(op.split(" ")[1]));
                    pq_min.add(Integer.parseInt(op.split(" ")[1]));
                    addCnt++;
                    break;
                case "D":
                    if(minDeleteCnt+maxDeleteCnt >= addCnt) break;
                    if(!pq_max.isEmpty() && Integer.parseInt(op.split(" ")[1]) == 1) {
                        int num = pq_max.poll();
                        pq_min.remove(num);
                        maxDeleteCnt++;
                    }
                    else {
                        if(!pq_min.isEmpty()){
                            int num = pq_min.poll();
                            pq_max.remove(num);
                            minDeleteCnt++;                    
                        }
                    }       
                    break;
            }
        }
        
        if(pq_max.isEmpty() || pq_min.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pq_max.poll();
            answer[1] = pq_min.poll();            
        }
       

        return answer;
    }
}