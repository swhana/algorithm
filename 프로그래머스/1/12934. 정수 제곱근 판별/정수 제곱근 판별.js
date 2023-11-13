function solution(n) {
    var answer = 0;
    return Math.sqrt(n) == ~~Math.sqrt(n) ? Math.pow((Math.sqrt(n) + 1), 2): -1;
}