import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();	//첫번째 눈
		int b = sc.nextInt();	//두번째 눈
		int c = sc.nextInt();	//세번째 눈
		
		if(a==b && b==c)
			System.out.println(10000+a*1000);
		else if(a==b && b!=c)
			System.out.println(1000+a*100);
		else if(b==c && a!=c)
			System.out.println(1000+b*100);
		else if(c==a && c!=b)
			System.out.println(1000+c*100);
		else
			System.out.println(Math.max((Math.max(a, b)), c)*100);
		
		sc.close();
	}

}