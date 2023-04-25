import java.util.*;

public class Main {
	
	static boolean isVowel(char ch) {
		if(ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u') return true;
		else return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = sc.nextLine();
			if(str.equals("end")) break;
			
			//1. 모음 하나를 반드시 포함하여야 한다
			if(str.contains("a") || str.contains("e")|| str.contains("i")|| str.contains("o")|| str.contains("u")) {
				boolean check = false;
				//3. 같은 문자가 2개이상 연속으로 오면 안된다
				label: for(int i=0; i<str.length()-1; i++) {
					//3. ee나 oo는 가능
					if(str.charAt(i) == str.charAt(i+1) && str.charAt(i) != 'e' && str.charAt(i) != 'o') {
						check = true;
						break label;
					}
				}
				//2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
				label2: for(int i=0; i<str.length()-2; i++) {
					if(isVowel(str.charAt(i)) && isVowel(str.charAt(i+1)) && isVowel(str.charAt(i+2))) {
						check = true;
						break label2;
					}
					if(!isVowel(str.charAt(i)) && !isVowel(str.charAt(i+1)) && !isVowel(str.charAt(i+2))) {
						check = true;
						break label2;
					}
				}
				
				if(!check) sb.append("<" + str + "> is acceptable.").append("\n");
				else sb.append("<" + str + "> is not acceptable.").append("\n");
			} else {
				sb.append("<" + str + "> is not acceptable.").append("\n");
			}
		}
		System.out.println(sb);
	}
}
