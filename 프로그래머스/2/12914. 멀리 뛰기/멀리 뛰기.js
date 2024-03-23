function solution(n) {
    let answer = 0;
    
    let dp = [];
    
    dp[0] = 0;
    dp[1] = 1; // 1칸
    dp[2] = 2; // 1칸+1칸, 2칸
    
    if(n > 2) {
        for(let i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 1234567;
        }
    }
    answer = dp[n] % 1234567;
    
    return answer;
}