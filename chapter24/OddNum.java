import java.util.*;

public class OddNum {

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter N: ");
        int n = scanner.nextInt();
        scanner.close();

		int sum = 0;
		for(int i = 1; i <= n; i += 2){
			sum += i;
		}

		System.out.println("Sum: " + sum + "\tN^2: " + (n*n));
	}

}