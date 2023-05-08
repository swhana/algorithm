import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		long cntZero = 0;
		long cntOne = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '0') cntZero++;
			else cntOne++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cntZero/2; i++) sb.append("0");
		for(int i=0; i<cntOne/2; i++) sb.append("1");
		
		System.out.println(sb);
	}

}
