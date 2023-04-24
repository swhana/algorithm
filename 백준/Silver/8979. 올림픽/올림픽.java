import java.util.*;

public class Main {
	
	static class Node {
		int nation; //국가
		int gold; //금메달
		int silver; //은메달
		int bronze; //동메달
		
		public Node(int nation, int gold, int silver, int bronze) {
			this.nation = nation;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Node[] list = new Node[N];
		
		for(int i=0; i<N; i++) {
			int n = sc.nextInt();
			int g = sc.nextInt();
			int s = sc.nextInt();
			int b = sc.nextInt();
				
			list[i] = new Node(n, g, s, b);
		}
		
		Arrays.sort(list, (o1, o2) -> {
			if(o1.gold == o2.gold) {
				if(o1.silver == o2.silver) {
					if(o1.bronze == o2.bronze) return 0;
					else return o2.bronze - o1.bronze;
				} else return o2.silver - o1.silver;
			} else return o2.gold - o1.gold;
		});

		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(list[i].nation == K) {
				cnt = i+1;
				for(Node n : list) {
					if(n.gold == list[i].gold && n.silver == list[i].silver && n.bronze == list[i].bronze && n.nation != K) {
						cnt--;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
