

function solution(n) {
    
    const memo = [];
    memo[0] = 0;
    memo[1] = 1;
    
    for(let i=2; i<=100000; i++) {
        memo[i] = (memo[i-1] + memo[i-2]) % 1234567;
    }

    return memo[n];
}