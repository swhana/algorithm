function solution(num_list) {
    var answer = [];
    
    let a = num_list[num_list.length - 1];
    let b = num_list[num_list.length - 2];
    
    answer = [...num_list, a > b ? a - b : a * 2 ];
    
    return answer;
}