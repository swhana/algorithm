function solution(x, n) {
    var answer = [];

    let a = 0;
    
    for(let i=0; i<n; i++) {
        a += x;
        answer.push(a);
    }
    
    return answer;
}