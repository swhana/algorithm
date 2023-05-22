function solution(a, b) {
    var answer = 0;
    
    
    answer = parseInt(`${a}${b}`) > 2*a*b ? parseInt(`${a}${b}`) : 2*a*b;
    return answer;
}