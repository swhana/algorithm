function solution(number) {
    let answer = 0;
    for(let i=0; i<number.length; i++){
       answer += parseInt(number.charAt(i));  
    }
    
    return answer % 9;
}