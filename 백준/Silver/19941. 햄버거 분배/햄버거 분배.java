import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //길이 N
		int K = sc.nextInt(); 
		
		String str = sc.next();
		String[] arr = str.split("");
		
		int cnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(arr[i].equals("P")) {
				for(int j=i-K; j<=i+K; j++) {
					if(j < N && j >= 0 && arr[j].equals("H")) {
						arr[j] = "E";
						cnt++;
						break;
					}
				}
			}
		}
	
		System.out.println(cnt);
	}

}
