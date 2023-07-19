function solution(strArr) {
    var answer = [];
    
    for(let i of strArr){
        if(i.includes("ad")) continue;
        answer.push(i);
    }
    
    return answer;
}