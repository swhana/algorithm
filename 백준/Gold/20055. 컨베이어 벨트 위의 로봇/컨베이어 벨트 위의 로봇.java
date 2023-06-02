import java.util.*;

public class Main {

	static int[] belt; //벨트의 내구도
	static boolean[] robot; //로봇의 위치
	static int N, K;
	static int count = 0;
	
	
	//과정을 진행할 수 있는지 여부 판단
	static boolean isContinue() {
		int cnt = 0;
		
		for(int dur : belt) {
			if(dur == 0) cnt++;
		}
		
		if(cnt < K) return true;
		return false;
	}
	
	static void Simulation() {
		while(isContinue()) {
			count++;
			//회전(내구도 옮기기)
			int temp = belt[2*N-1];
			for(int i=2*N-1; i>0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = temp;

			//회전(로봇)
			for(int i=N-1; i>0; i--) {
				robot[i] = robot[i-1];
			}
			robot[N-1] = false; //로봇 내리기
			robot[0] = false; //밑의 컨베이어 벨트에서 올라올테니 로봇이 없음
			
			for(int i=N-2; i>0; i--) {
				if(robot[i] && !robot[i+1] && belt[i+1] > 0) {
					robot[i+1] = true;
					robot[i] = false;
					belt[i+1]--;
				}
			}
			
			//올리는 위치에 로봇 올리기
			if(belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		belt = new int[2*N];
		robot = new boolean[N];
		
		for(int i=0; i<2*N; i++) belt[i] = sc.nextInt();
		
		Simulation();
		
		System.out.println(count);
	}

}
