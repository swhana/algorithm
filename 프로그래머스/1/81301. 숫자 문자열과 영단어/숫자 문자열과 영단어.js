function solution(s) {
    var answer = 0;
    
    const nums = [
        'zero', 
        'one', 
        'two', 
        'three', 
        'four', 
        'five', 
        'six', 
        'seven',
        'eight',
        'nine',
    ]
    
    for(let i=0; i<nums.length; i++) {
        const arr = s.split(nums[i]);
        s = arr.join(i);
    }
    
    return parseInt(s);
}