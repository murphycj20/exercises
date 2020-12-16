import java.util.Random;

public class Character {

    private int[] stats = new int[5];
    private String name = "";
    private GameSave save;

    public static String[] types = {"Knight", "Peasant", "Cleric", "Mage", "Courtier"};

    public Character(String name, int type){
        this.name = name;
        randomize(type);
    }

    public Character(){}

    public boolean createFromLine(String line){
        String[] values = line.split(",");

        if(values.length < 7){
            return false;
        }

        try {
            this.name = values[0];
            
            for(int i = 2; i < 7; i++){
                this.stats[i-2] = Integer.parseInt(values[i]);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    //type should be -1 if you don't want to decide a type
    public void randomize(int type){
        Random rand = new Random();

        int main = type;
        
        if(type == -1 && save.isFullType(main)){
            main = rand.nextInt(5);
        }
        
        for (int i = 0; i < 5; i++){
            if (i == main){
                this.stats[i] = rand.nextInt(4) + 7;
            } else {
                this.stats[i] = rand.nextInt(7);
            }
        }

        while (totalScore() > 28 || totalScore() < 8){
            int selected = rand.nextInt(5);
            while (selected == main || stats[selected] >= 6){
                selected = rand.nextInt(5);
            }

            if(totalScore() > 28){
                stats[selected]--;
            } else {
                stats[selected]++;
            }
        }
    }

    public String getTypeStr(){
        return types[getType()];
    }

    public int getType(){
        for(int i = 0; i < 5; i++){
            if (stats[i] >= 7){
                return i;
            }
        }

        return -1;
    }

    private int totalScore(){
        int sum = 0;

        for(int i : stats){
            sum += i;
        }

        return sum;
    }

    public void setSave(GameSave save){
        this.save = save;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        String str = name + "," + getTypeStr() + "," + stats[0] + "," + stats[1] + "," + stats[2] + "," + stats[3] + "," + stats[4];
        return str;
    }

}
