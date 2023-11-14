function solution(price, money, count) {
    var answer = -1;
    
    answer = money - price * count * (count + 1) / 2;
    

    return answer < 0 ? answer * -1 : 0;
}