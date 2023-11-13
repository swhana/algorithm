function solution(x) { 
    const hashad = (x + "").split("").reduce((total, e) => total + e * 1, 0);
    return x % hashad == 0 ? true : false;
}