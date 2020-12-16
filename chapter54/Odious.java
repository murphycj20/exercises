import java.util.Scanner;

public class Odious {

	public static boolean isOdious(int num){
		int ones = 0;

		if(num % 2 == 1){
			ones++;
		}

		num /= 2;

		while (num != 0){
			if(num % 2 == 1){
				ones++;
			}

			num /= 2;
		}

		return ones % 2 == 1;

	}

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number: ");
		int currentNum = scanner.nextInt();

		while(currentNum >= 0){
			if(isOdious(currentNum)){
				System.out.println("Odious");
			} else {
				System.out.println("Evil");
			}

			System.out.print("Enter number: ");
            currentNum = scanner.nextInt();
            scanner.close();
		}

	}

}