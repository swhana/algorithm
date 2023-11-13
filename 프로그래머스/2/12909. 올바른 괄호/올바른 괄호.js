function solution(s){
    var answer = true;

    let total = 0;
    for(let i=0; i<s.length; i++) {
        if(s[i] === '(') total++;
        else {
            if(total === 0) return false;
            total--;
        }
    }
    
    if(total !== 0) return false;
    
    return answer;
}