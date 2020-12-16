import java.util.Scanner;
import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);

        System.out.println("Menu: \n1. Create New Game\n2. Validate a save file\n3. Randomize an existing character\n4. Quit");
        int option = scan.nextInt();
        scan.nextLine();
        while (option != 4){
            System.out.print("File: ");
            String nameFile = scan.nextLine();
            switch (option){
                case 1:
                    System.out.print("Name of new game: ");
                    String nameGame = scan.nextLine();

                    GameSave newGame = new GameSave(nameFile);
                    newGame.setName(nameGame);

                    for (int i = 0; i < 4; i++){
                        int acceptDecline = 2;
                        Character character = new Character();
                        while (acceptDecline != 1){
                            System.out.print("\n Knight\n Peasant\n Cleric\n Mage \n Courtier");
                            System.out.print("\nType: ");
                            String type = scan.nextLine();
                            Boolean isFull = newGame.isFullType(newGame.typeStrToInt(type));

                            while (isFull){
                                System.out.print("Full type. Choose another");
                                type = scan.nextLine();
                                isFull = newGame.isFullType(newGame.typeStrToInt(type));
                            }

                            character = new Character("", newGame.typeStrToInt(type));
                            System.out.println(character + "\n1: accept 2: decline");
                            acceptDecline = scan.nextInt();
                            scan.nextLine();
                        }

                        System.out.print("Name: ");
                        String name = scan.nextLine();
                        character.setName(name);

                        newGame.addCharacter(character);
                    }

                    newGame.writeFile();
                    break;
                case 2:
                    GameSave validate = new GameSave(nameFile);
                    if (validate.readFile()){
                        System.out.println("Correct");
                    } else {
                        System.out.println("Incorrect");
                    }

                    break;
                case 3:
                    System.out.print("Name to Reroll: ");
                    String characterName = scan.nextLine();

                    GameSave game = new GameSave(nameFile);
                    game.readFile();
                    Character character = game.getCharacterFromName(characterName);
                    character.setSave(game);
                    character.randomize(-1);


                    game.writeFile();
                    break;
            }

            System.out.println("Menu: \n1. Create New Game\n2. Validate a save file\n3. Randomize an existing character\n4. Quit");
            option = scan.nextInt();
            scan.nextLine();
            scan.close();
        }
        
    }

}