function solution(survey, choices) {
    var answer = '';
    
    const perType = {
        'R': 0,
        'T': 0,
        'C': 0,
        'F': 0,
        'J': 0,
        'M': 0,
        'A': 0,
        'N': 0,
    }
    
    for(let i=0; i<survey.length; i++) {
        if(choices[i] < 4) {
            perType[survey[i][0]] += 4 - choices[i];
        } else if(choices[i] > 4) {
            perType[survey[i][1]] += choices[i] - 4;
        }
    }
    
    if(perType['R'] >= perType['T']) answer += 'R';
    else answer += 'T';
    
    if(perType['C'] >= perType['F']) answer += 'C';
    else answer += 'F';
    
    if(perType['J'] >= perType['M']) answer += 'J';
    else answer += 'M';
    
    if(perType['A'] >= perType['N']) answer += 'A';
    else answer += 'N';
    
    return answer;
}