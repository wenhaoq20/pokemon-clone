
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        Map room = new Map();
        Person Player = new Person("LUL", 2 ,1);
        Person Enemy = new Person("4Head",3, 1);
        room.placeObject(Player);
        room.placeObject(Enemy);
        room.printMap();

        System.out.println("What direction?");
        String input = read.next();
        while(!input.equalsIgnoreCase("n")){
            Player.move(input, room);
            if(room.enemyInRange(Player, Enemy)){
                System.out.println("Do you want to attack?"); 
            }
            System.out.println("What direction?");
            input = read.next();
        }
         read.close();
    }
}