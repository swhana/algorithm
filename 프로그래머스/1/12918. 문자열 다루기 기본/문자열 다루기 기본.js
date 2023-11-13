function solution(s) {
    var answer = false;
    
    if(s.replace(/[0-9]/g, '').length === 0 && (s.length === 4 || s.length === 6)) answer = true;
    
    return answer;
}