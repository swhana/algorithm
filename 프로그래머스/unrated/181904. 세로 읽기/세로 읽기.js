function solution(my_string, m, c) {
    var answer = '';
    
    for(let i=0; i<my_string.length; i++){
        if((i - c + 1) % m == 0) answer += my_string[i];
    }
    
    return answer;
}