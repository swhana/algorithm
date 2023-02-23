import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                map.put(phone_book[i].substring(0, j), 0);
            }
        }
        
        for(int i=0; i<phone_book.length; i++){
            if(map.containsKey(phone_book[i])) return false;
        }
        
        return answer;
    }
}