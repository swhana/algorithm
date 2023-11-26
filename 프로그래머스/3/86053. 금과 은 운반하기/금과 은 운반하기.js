function solution(a, b, g, s, w, t) {
    var answer = -1;
    
    let lp = 0;
    let rp = Number.MAX_SAFE_INTEGER;
    while(lp + 1 < rp) {      
        let total = 0;  
        let gold = 0; //필요한 금의 양
        let silver = 0; //필요한 은의 양
        
        const mid = Math.floor((lp + rp) / 2);
        
        for(let i=0; i<t.length; i++) {
            //옮길 수 있는 횟수 먼저
            let cnt = Math.floor(mid / (2 * t[i]));
            if(mid % (2 * t[i]) >= t[i]) cnt++; //편도로 한 번 더 옮길 수 있을 때
            
            let tmp = Math.min(w[i] * cnt, g[i] + s[i]);
            total += tmp;
            gold += Math.min(tmp, g[i]);
            silver += Math.min(tmp, s[i]);
        }
        
        if(total >= a+b && gold >= a && silver >= b) rp = mid;
        else lp = mid;
    }
    
    return rp;
}