function solution(n)
{
    var answer = 0;
    
    const nn = String(n);
    
    
    for(let i=0; i<nn.length; i++) {
        answer += parseInt(nn[i]);
    }

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    console.log('Hello Javascript')

    return answer;
}