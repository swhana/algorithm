function solution(my_string, n) {
    var answer = '';
    
    for(let i=n-1; i>=0; i--){
        answer += my_string.charAt(my_string.length - i - 1);
    }
    
    return answer;
}