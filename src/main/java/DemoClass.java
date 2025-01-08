import java.util.Scanner;

public class DemoClass {
	public static void main(String[] args) {
		System.out.println("Enter a Numbers: ");
		int marks[] = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i< marks.length; i ++) {
			marks[i] = sc.nextInt();
		}
		display(marks);
		
	}
	public static void display(int m[]) {
		for(int k:m) {
			System.out.println(k);
		}
	}

}
