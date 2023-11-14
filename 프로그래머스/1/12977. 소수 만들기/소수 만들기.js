function solution(nums) {
    var answer = 0;
    
    const isPrime = (num) => {
        if(num === 1 || num === 2) return true;
        
        for(let i=2; i<num; i++) {
           if(num % i === 0) return false; 
        }
        
        return true;
    }
    
    for(let i=0; i<nums.length - 2; i++) {
        for(let j=i+1; j<nums.length - 1; j++) {
            for(let k=j+1; k<nums.length; k++) {
                if(isPrime(nums[i] + nums[j] + nums[k])) answer++;
            }
        }
    }
    
    
    return answer;
}