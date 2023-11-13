function solution(numbers) {
    const sum = 45 - numbers.reduce((total, e) => total + e);

    return sum;
}