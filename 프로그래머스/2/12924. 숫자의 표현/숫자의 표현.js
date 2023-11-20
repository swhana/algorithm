function solution(n) {
    var answer = 0;
    
    //연속된 숫자의 개수 i
    for(let i=1; i<=n; i++) {
        let a = i * (i - 1) / 2;
        if(n > a && (n - a) % i === 0) answer++;
    }
    
    return answer;
}