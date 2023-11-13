function solution(n) {
    return Math.sqrt(n) == ~~Math.sqrt(n) ? Math.pow((Math.sqrt(n) + 1), 2): -1;
}