package Baekjoon.Silver;

public class BOJ_4673_셀프넘버 {

    static int self_number(int n){  //n은 res의 생성자가 된다, d(n) = res
        int res = n;

        while(n != 0){         //n이 0이 될때까지 반복
            res += n%10;       //10으로 나눈 나머지를 더하기 = 1의 자리
            n /= 10;           //10으로 나누고 나머지를 버려서 제일 우측 한자리를 줄임
        }

        return res;
    }

    public static void main(String[] args){

        boolean[] check = new boolean[10001];

        for(int i=0; i<10001; i++){
            int n = self_number(i);

            if(n<10001)
                check[n] = true;    //셀프넘버가 아닌 경우 True로 바꿈
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<10001; i++){
            if(!check[i])       //false인 경우(셀프넘버인 경우)만 문자열에 추가
                sb.append(i).append('\n');
        }

        System.out.println(sb);


    }
}
