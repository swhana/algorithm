function solution(num_list, n) { 
    let answer = 0;
    
    num_list.forEach(num => {
        if(num == n) {
            answer = 1;
            return;
        }
    })
    
    return answer;
}