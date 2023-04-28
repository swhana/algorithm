import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer>[] team = new ArrayList[201];
		
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			for(int i=0; i<201; i++) team[i] = new ArrayList<Integer>();
			int[] teamCnt = new int[201];
			int N = sc.nextInt();
			int[] t = new int[N];
			
			HashMap<Integer, Boolean> check = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				t[i] = sc.nextInt(); //팀 번호(입력 저장)
				teamCnt[t[i]]++;
//				team[t].add(i); //t팀에 i등으로 들어온 선수 입력(알아서 오름차순 정리)
			}
			
			
			for(int i=0; i<201; i++) {
				if(teamCnt[i] < 6) check.put(i, false);
				else {
					check.put(i, true);
				}
			}
			

			int cnt = 1;
			for(int i=0; i<N; i++) {
				if(check.get(t[i]))	{
					team[t[i]].add(cnt); //t팀에 i등으로 들어온 선수 입력(알아서 오름차순 정리)
					cnt++;
				}
			}
			
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for(int i=0; i<201; i++) {
				if(team[i].size() < 6) continue;
				int sum = team[i].get(0) + team[i].get(1) + team[i].get(2) + team[i].get(3);
				if(min > sum) {
					min = sum;
					minIdx = i;
				}
				else if(min == sum) {
					if(team[i].get(4) < team[minIdx].get(4)) {
						minIdx = i;
					}
				}
			}
			System.out.println(minIdx);
		}
	}

}
