import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<String>();
        
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                set.add(phone_book[i].substring(0, j));
            }
        }
        
        for(int i=0; i<phone_book.length; i++){
            if(set.contains(phone_book[i])) return false;
        }
        
        return answer;
    }
}