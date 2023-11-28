function solution(sizes) {
    var answer = 0;
    
    sizes.forEach(size => {
        if(size[0] < size[1]) {
            let temp = size[1];
            size[1] = size[0];
            size[0] = temp;
        }
    })
    
    let maxW = 0;
    let maxH = 0;
    
    sizes.forEach(([w, h]) => {
        maxW = Math.max(w, maxW);
        maxH = Math.max(h, maxH);
    })
    
    return maxW * maxH;
}