import java.util.Scanner;
import java.io.*;

public class GameSave {

    String fileName, name;
    Character[] party = {new Character(),new Character(),new Character(),new Character()};
    int partyIndex = 0;
    public GameSave(String fileName) throws IOException{
        this.fileName = fileName;
    }

    public int typeStrToInt(String type){
        for(int i = 0; i < 5; i++){
            if(type.equals(Character.types[i])){
                return i;
            }
        }

        return -1;
    }

    public boolean isFullType(int type){
        if(type < 0 || type > 4){
            return true;
        }

        int[] num = new int[5];

        for (Character c : party){
            if(c.getType() >= 0){
                num[c.getType()]++;
            }
        }

        if(num[type] >= 2){
            return true;
        }

        return false;
    }

    public Character getCharacterFromName(String charName){
        for (Character c : party){
            if (c.getName().equals(charName)){
                return c;
            }
        }
        return null;
    }

    public boolean addCharacter(Character c){
        if(partyIndex >= 4){
            return false;
        }

        party[partyIndex] = c;
        partyIndex++;
        return true;
    }

    public boolean readFile() throws IOException{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int index = 0;
        while(scanner.hasNextLine() && index <= 4){
            if(index > 0){
                if(!party[index-1].createFromLine(scanner.nextLine())){
                    return false;
                }
            } else {
                name = scanner.nextLine();
            }
            scanner.close();

            index++;
        }

        return true;
    }
    

    public void writeFile() throws IOException{
        PrintWriter out = new PrintWriter(fileName);
        
        out.print(toString());

        out.close();
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        String ret = "";

        ret += name + "\n";
        for(Character p : party){
            ret += p + "\n";
        }
        return ret;
    }
}