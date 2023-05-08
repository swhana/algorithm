import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int cntZero = 0;
		int cntOne = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '0') cntZero++;
			else cntOne++;
		}
		
		String answer = "";
		for(int i=0; i<cntZero/2; i++) answer += "0";
		for(int i=0; i<cntOne/2; i++) answer += "1";
		
		System.out.println(answer);
	}

}
