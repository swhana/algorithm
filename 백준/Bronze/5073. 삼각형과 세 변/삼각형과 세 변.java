import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[3];
		
		while(true) {
			for(int i=0; i<3; i++) arr[i] = sc.nextInt();
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			Arrays.sort(arr);
			
			if(arr[0] + arr[1] <= arr[2]) {
				sb.append("Invalid").append("\n");
				continue;
			}
			
			if(arr[0] == arr[1] && arr[1] == arr[2]) {
				sb.append("Equilateral").append("\n");
				continue;
			}
			
			if(arr[0] == arr[1] && arr[1] != arr[2]) {
				sb.append("Isosceles").append("\n");
				continue;
			}
			if(arr[0] == arr[2] && arr[1] != arr[2]) {
				sb.append("Isosceles").append("\n");
				continue;
			}			
			if(arr[1] == arr[2] && arr[0] != arr[1]) {
				sb.append("Isosceles").append("\n");
				continue;
			}
			
			if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
				sb.append("Scalene").append("\n");
				continue;
			}
		}
		
		System.out.println(sb);
		
	}

}
