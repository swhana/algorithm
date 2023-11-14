function solution(a, b) {
    const ret = a.reduce((total, e, idx) => {
        total += e * b[idx];
        
        return total;
    }, 0);
    
    return ret;
}