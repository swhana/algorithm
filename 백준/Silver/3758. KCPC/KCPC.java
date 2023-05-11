/*
 * 문제 수 k개 : 각 문제당 0~100점
 * 추가 데이터 : 팀ID, 문제번호, 점수(기본 0점), 제출 시간
 * 최종점수 = 각 문제의 점수 총합
 * 순위 = 자신보다 높은 팀 수 + 1
 * 점수가 높은 순 -> 제출횟수가 적은 순 -> 제출 시간이 더 빠른 순
 * 
 * */

import java.util.*;
import java.io.*;

public class Main {
	//팀 배열 Team[] teams = new Team[n+1];
	//문제 배열 int[] sol = new int[k+1];
	static class Team {
		int[] sol; //sol[문제번호] = 점수;
		int total; //점수 총합
		int count; //제출횟수
		int time; //마지막 제출시간
		int rank; //순위
		
		public Team(int k) {
			this.sol = new int[k+1];
			this.total = 0;
			this.count = 0;
			this.time = 0;
			this.rank = 1;
		}
		
		public void addRank() {
			this.rank += 1;
		}
		
		//num: 문제 번호, score: 문제 점수, time: 제출시간
		public void solve(int k, int num, int score, int time) {
			if(score > this.sol[num]) this.sol[num] = score;
			this.total = 0;
			for(int i=1; i<k+1; i++) {
				this.total += sol[i];
			}
			this.count++;
			this.time = time;
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //test case
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); //전체 팀 수 n
			int k = Integer.parseInt(st.nextToken()); //문제 수 k
			int t = Integer.parseInt(st.nextToken()); //팀 id
			int m = Integer.parseInt(st.nextToken()); //로그 엔트리 개수 m
			
			Team[] team = new Team[n+1];
			for(int i=0; i<n+1; i++) {
				team[i] = new Team(k);
			}
			
			for(int time=0; time<m; time++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken()); //팀 id
				int j = Integer.parseInt(st.nextToken()); //문제 번호
				int s = Integer.parseInt(st.nextToken()); //점수
				
				team[i].solve(k, j, s, time);
			}
			
			for(int i=1; i<n+1; i++) {
				if(i == t) continue;
				if(team[i].total > team[t].total) {
					team[t].addRank();
				} else if(team[i].total == team[t].total) {
					if(team[i].count < team[t].count) team[t].addRank();
					else if(team[i].count == team[t].count) {
						if(team[i].time < team[t].time) team[t].addRank();
					}
				} else continue;
			}	
			System.out.println(team[t].rank);
		}
	}
}
