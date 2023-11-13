function solution(numbers) {
    var answer = 0;
    
    const ret = numbers.reduce((total, e) => total + e);
    
    answer = ret / numbers.length;
    
    return answer;
}