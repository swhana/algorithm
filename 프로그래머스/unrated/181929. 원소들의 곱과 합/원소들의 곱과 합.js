function solution(num_list) {
    var answer = 0;
    
    let multi_sum = 1;
    let sum_square = 0;
    
    for(let i of num_list){
        multi_sum *= i;
        sum_square += i;
    }
    
    if(multi_sum < sum_square*sum_square) answer = 1;
    
    return answer;
}