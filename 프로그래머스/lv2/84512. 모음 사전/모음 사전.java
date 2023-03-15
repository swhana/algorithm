import java.util.*;
import java.io.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] plusDigit = { 781, 156, 31, 6, 1 };
        int digit = word.length(); //자릿수에 따라
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(c == 'A') answer += 1;
            else if (c == 'E') answer += plusDigit[i] * 1 + 1;
            else if (c == 'I') answer += plusDigit[i] * 2 + 1;
            else if (c == 'O') answer += plusDigit[i] * 3 + 1;
            else answer += plusDigit[i] * 4 + 1;
        }
                
        
        return answer;
    }
}