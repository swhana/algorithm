function solution(str1, str2) {
    var answer = '';
    
    for(let i=0; i<str1.length; i++){
        answer += str1.split("")[i] + str2.split("")[i];
    }
    
    return answer;
}