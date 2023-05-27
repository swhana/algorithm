function solution(num_list) {
    let oddsum = "";
    let evensum = "";
    
    for(let i=0; i<num_list.length; i++) {
        if(num_list[i] %2 === 0) evensum += num_list[i];
        else oddsum += num_list[i];
    }
    
    answer = parseInt(evensum) + parseInt(oddsum);
    return answer;
}