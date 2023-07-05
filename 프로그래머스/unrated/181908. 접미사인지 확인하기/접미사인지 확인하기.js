function solution(my_string, is_suffix) {
    for(let i=0; i<is_suffix.length; i++){
        if(is_suffix.charAt(is_suffix.length-i-1) !== my_string.charAt(my_string.length-i-1)) return 0;
    }
    
    return 1;
}