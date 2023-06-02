function solution(l, r) {
    var answer = [];
    
    
    let nums = ['1', '2', '3', '4', '6', '7', '8', '9'];

    for(let i=l; i<=r; i++){    
        if(i.toString().includes('1')) continue;
        if(i.toString().includes('2')) continue;
        if(i.toString().includes('3')) continue;
        if(i.toString().includes('4')) continue;
        if(i.toString().includes('6')) continue;
        if(i.toString().includes('7')) continue;
        if(i.toString().includes('8')) continue;
        if(i.toString().includes('9')) continue;
        answer.push(i);
    }
    
    if(answer.length == 0) answer = [...answer, -1];
    
    return answer;
}