function solution(absolutes, signs) {
    const ret = absolutes.reduce((total, e, idx) => {
        if(signs[idx]) return total + e;
        else return total - e;
    }, 0);
    
    
    return ret;
}