/*
    옷의 종류를 key, 옷의 이름을 value로 저장하는 HashMap을 생각해본다
*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
        
        // 종류 : 이름
        for(String[] cloth : clothes){
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        int total = 1;
        for(String key : clothMap.keySet()){
            total *= (clothMap.get(key) +1);
        }
        
        answer = total - 1;
    
        return answer;
    }
}