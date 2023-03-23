import java.util.*;

class Solution {    
    public int solution(int storey) {        
        Queue<Integer> digit = new LinkedList<>();
        
        int num = storey;
        while(num / 10 > 0){
            digit.add(num%10);
            num /= 10;
        }
        int last = num;
        digit.add(last);
        
        int cnt = 0;
        int temp = 0;
        boolean five = false;
        while(!digit.isEmpty()){
            int d = digit.poll();
            
            if(d < 5 && five) temp = 0;
            if(d >= 5 && five) temp = 1;
            
            d += temp;
            if(d < 5) {
                cnt += d;
                temp = 0;
                five = false;
            }
            else if(d > 5){ 
                cnt += 10-d;
                temp = 1;
                five = false;
            }
            //d == 5
            else {
                cnt += 5;
                five = true;              
            }
        }
    
        if(last + temp >= 6) cnt++;
        return cnt;
    }
}