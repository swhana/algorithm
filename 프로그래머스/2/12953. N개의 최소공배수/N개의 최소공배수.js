function solution(arr) {
    var answer = 1;
    
    let mcd = 1; //최대공약수 찾기
    
    arr = arr.sort((a, b) => b - a);
    
    let flag = false;
    let current = arr[0];
    
    while(!flag) {
        flag = arr.every(num => current % num === 0);
        if(flag) {
            answer = current;
            break;
        }
        current++;
    }
    
    return answer;
}