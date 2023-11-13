function solution(s) {
    var answer = '';
    
    const arr = s.split(" ").map(e => e * 1).sort((a, b) => a-b); //배열로 분리하고 숫자로 변환 후 정렬
    
    answer += arr[0] + " " + arr[arr.length-1];
    
    
    return answer;
}