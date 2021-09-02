
import java.util.Scanner;
import java.util.ArrayList;


public class Game {

    
    startScreen startG = new startScreen();
    ChoiceHandler cHandler = new ChoiceHandler(this);
    Scene ts = new Scene(startG);
    static int stage = 0;
    MainG story = new MainG(this, startG, ts);
    public Game(){
     
        startG.createGameScreen(cHandler);
        ts.showTitle();
        //showTop(startG);

    }

    public static void main(String[] args) {
        new Game();

    }

    /* public static void battle(Character player, Character enemy) { // method for battling
        String battleC = "";
        Scanner in = new Scanner(System.in);
        if (story.pTeam.teamAlive() && enemy.cAlive()) {
            System.out.println("\n" + "type a do normal attack" + "\n" + "type sa to do special attack" + "\n"
                + "type stat to view your stats" + "\n" + "type r to run" + "\n"
                + "type switch to switch to another pokemon in your party");
            battleC = in.next().toLowerCase();
        }
    } */
}
