function solution(n)
{
    //숫자에 + ""을 통해 String으로 바꿀수 있고,
    //String에 *1을 통해 숫자로 인식하게 할 수 있다
    return (n+"").split("").reduce((total, e) => total + e*1, 0);
}