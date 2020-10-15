import java.util.*;

public class HailStone {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter N: ");
        int n = scanner.nextInt();
        scanner.close();

		while(n != 1){
			if(n % 2 == 0){
				n /= 2;
			} else {
				n = 3 * n + 1;
			}

			System.out.println(n);
		}
	}	
}