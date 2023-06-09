function solution(arr, idx) {
    for(let i=0; i<arr.length; i++){
        if(i >= idx && arr[i] == 1) return i; 
    }
    
    return -1;
}