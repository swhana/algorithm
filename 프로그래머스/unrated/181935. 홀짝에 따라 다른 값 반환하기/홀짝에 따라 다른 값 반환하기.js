function solution(n) {
    let oddsum = 0;
    let evensum = 0;
    
    for(let i=1; i<=n; i++){
        if(i%2 == 0) evensum += i*i;
        else oddsum += i;
    }
    
    return n%2 == 0 ? evensum : oddsum;
}