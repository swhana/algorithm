function solution(myString) {
 
    const strArr = myString.split('');
    
    let answer = '';
    strArr.map(e => {
        if(e < 'l') answer += 'l';
        else answer += e;
    })
    
    return answer;
}