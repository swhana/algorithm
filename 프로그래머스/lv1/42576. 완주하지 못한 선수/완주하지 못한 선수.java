import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> partMap = new HashMap<String, Integer>();
        
        for(String partName : participant){
            partMap.put(partName, partMap.getOrDefault(partName, 0) +1);
        }
        
        for(String compName : completion){
            partMap.put(compName, partMap.getOrDefault(compName, 0) -1);
        }
        
        for(String key : partMap.keySet()) {
            if(partMap.get(key) == 1) answer = key;
        }
        
        return answer;
    }
}