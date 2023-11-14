function solution(s) {
    const stack = []; // JS에선 Array가 stack과 같은 동작도 가능
    
    for(let i=0; i<s.length; i++) {
        if(stack[stack.length-1] === s[i]) stack.pop();
        else stack.push(s[i]);
    }
    
    return stack.length === 0 ? 1 : 0;
}