import java.util.*;

public class SnakeEyes {
    static int playerScore, y, x, n, dOne, dTwo, totalScore, rollCount, totalRolls;
    static double averageScore,fourRolls, averageRolls;
    public static void main(String[] args){
        findAmount();
        addScores();
        System.out.println("Average number of rolls: " + averageRolls);
        System.out.println("Average score: " + averageScore);
        System.out.println("Precent of players that have more than 4 rolls: " + fourRolls);

    }
    public static void findAmount(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter amount of times to run the Simulation: ");
        n = scan.nextInt();
        scan.close();
    }
    public static int throwDie(){
        Random random = new Random();
        
        return random.nextInt(6) + 1;
    } 
    public static void rollDice(){
        dOne = throwDie();
        dTwo = throwDie();
    }

    public static void addScores(){
        while (x < n){
            rollDice();
            while(dOne + dTwo != 2){
                playerScore = dOne + dTwo;
                totalScore = totalScore + playerScore; 
                rollDice();
                rollCount++;
            }
                rollCount++;
                totalRolls = totalRolls + rollCount;
                playerScore = 0;
                
                x++;
                if(rollCount > 4){
                    y++;
                }
                rollCount = 0;
        }
        averageScore = totalScore / (double) n;
        averageRolls = totalRolls / (double) n;
        fourRolls = y / (double) n * 100;
    }
}