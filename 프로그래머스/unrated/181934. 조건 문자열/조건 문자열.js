function solution(ineq, eq, n, m) {
    var answer = 0;
    
    if(ineq == ">" && eq == "=") return n >= m ? 1 : 0;
    else if(ineq == "<" && eq == "=") return n <= m ? 1 : 0;
    else if(ineq == ">" && eq == "!") return n > m ? 1 : 0;
    else return n < m ? 1 : 0;
    
    return answer;
}