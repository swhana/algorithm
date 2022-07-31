package Baekjoon.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] age_name = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            age_name[i][0] = st.nextToken();
            age_name[i][1] = st.nextToken();
        }

        Arrays.sort(age_name, new Comparator<String[]>() {

            @Override
            public int compare(String[] age1, String[] age2) {
                return Integer.parseInt(age1[0]) - Integer.parseInt(age2[0]);

            }
        });

        for (int i = 0; i < N; i++)
            System.out.println(age_name[i][0] + " " + age_name[i][1]);
    }
}