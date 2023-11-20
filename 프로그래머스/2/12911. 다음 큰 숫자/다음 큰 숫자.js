function getBinaryNum(num) {
    return num.toString(2).split("0").join("").length;
}

function solution(n) {
    let num = n+1;
    const std = getBinaryNum(n);
    
    while(num < 1000000) {
        const ret = getBinaryNum(num);
        if(ret === std) return num;
        num++;
    }
}