import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        //심사시간
        long lo = 0;
        long hi = (long)Math.pow(10, 18);
        while(lo <= hi) {

            long mid = (lo + hi) / 2;
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += mid / times[i];   
            }
            
            //모든 사람이 다 심사를 받았을 때
            if(cnt >= n) {
                hi = mid - 1;
                answer = mid;
            } else {
                lo = mid + 1;
            }
        }
   
        
        return answer;
    }
}