function solution(s){
    var answer = true;

    const a = s.toUpperCase();
    
    let numP = 0;
    let numY = 0;
    
    for(let i=0; i<a.length; i++) {
        if(a[i] == 'P') numP++;
        else if(a[i] == 'Y') numY++;
    }
    
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    console.log('Hello Javascript')

    if(numP != numY) answer = false;
    
    return answer;
}