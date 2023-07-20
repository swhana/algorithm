function solution(n_str) {
    let answer = '';
    
    let idx;
    
    for(let i=0; i<n_str.length; i++){
        if(n_str.charAt(i) == 0) continue;
        else {
            idx = i;
            break;
        }
    }
    
    for(let i=idx; i<n_str.length; i++){
        answer += n_str.charAt(i);
    }
    
    return answer;
}