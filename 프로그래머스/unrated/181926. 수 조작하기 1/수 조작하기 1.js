function solution(n, control) {
    let input = [...control];
    
    input.forEach(word => {
        switch(word){
            case "w":
                n++;
                break;
            case "s":
                n--;
                break;
            case "d":
                n += 10;
                break;
            case "a":
                n -= 10;
                break;
        }
    })
    
    answer = n;
    
    return answer;
}