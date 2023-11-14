function solution(s) {
    const ret = s.split(" ").map(e => e.replace(/\w/g, (t, idx) => {
        return idx === 0 ? t.toUpperCase() : t.toLowerCase();
    })).join(" ");
    
    return ret;
}