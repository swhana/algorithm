function solution(myString, pat) {
    let answer = 0;
    answer = myString.toLowerCase().includes(pat.toLowerCase()) ? 1 : 0;
    
    return answer;
}