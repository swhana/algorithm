/*
    작업시간이 오래걸리는 작업을 먼저 처리하게 되면 그만큼 대기하는 시간도 길어지므로
    다른 작업들의 평균 작업 완료 시간도 길어지게 된다
    즉 작업의 소요시간이 가장 짧은 작업부터 순서대로 처리하면 된다
    
    평균시간을 처리할때는 입력받았던 요청시간을 완료시간에서 빼주면 된다
*/
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //요청시간 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        //우선순위 큐는 소요시간이 적은 순으로 정렬 
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int cnt = 0;
        int end = 0; //작업이 끝나는 시간
        int idx = 0;
        
        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                q.add(jobs[idx++]);
            }
            
            if(q.isEmpty()){
                end = jobs[idx][0];
            } else {
                int[] temp = q.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                cnt++;
            }
        }
    
        answer /= jobs.length;
        
        return answer;
    }
}