function solution(s) {
    var answer = [];
    
    let ch = 0; //이진변환 횟수
    let zero = 0; //지운 0의 갯수
    
    while(true){
        let cnt = 0;
        for(let i=0; i<s.length; i++) {
            if(s[i] === '0') cnt++;
        }
        s = s.replace(/[0]/g, '').length.toString(2);
        ch++;
        zero += cnt;
        if(s === '1') break;
    }
    
    
    return [ch, zero];
}