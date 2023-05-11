const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    //여기부터가 코드 작성부분인듯
    str = input[0];
    
    //결과값은 console.log에?
    for(let i=0; i<str.length; i++){
        console.log(str.split("")[i]);
    }
});