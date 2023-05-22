function solution(a, b) {
    var answer = 0;
    let sum1 = parseInt(a.toString() + b.toString());
    let sum2 = parseInt(b.toString() + a.toString());
    
    answer = sum1 > sum2 ? sum1 : sum2;
    return answer;
}