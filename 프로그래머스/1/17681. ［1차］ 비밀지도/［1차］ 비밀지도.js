function solution(n, arr1, arr2) {
    var answer = [];
    
    for(let i=0; i<n; i++) {
        const bin1 = arr1[i].toString(2).split(""); //첫번째 비밀지도 한줄 2진수 변환
        const bin2 = arr2[i].toString(2).split(""); //두번쨰 비밀지도 한줄 2진수 변환
        
        while(bin1.length < n) {
            bin1.unshift('0');
        }
        
        while(bin2.length < n) {
            bin2.unshift('0');
        }
        
        let ret = '';
        for(let j=0; j<n; j++) {
            if(bin1[j] === '1' || bin2[j] === '1') ret += '#';
            else ret += ' ';
        }
        answer.push(ret);
    }
    
    return answer;
}