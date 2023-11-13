function solution(arr) {
    var answer = 0;
    
    answer = arr.reduce((total, e) => total + e);
    answer /= arr.length;
    
    return answer;
}