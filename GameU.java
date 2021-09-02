//test player dead
//need to check if the coord are dupes

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameU {
    static Character[] pT = new Character[2]; // player's team
    static int currentSlot = -1;
    static int numberP = 0;
    static Team pTeam = new Team();
    static Character player = null; // creating the holder for pokemon
    static Character player2 = null;
    static Character player3 = null;
    static Character player4 = null;
    static ArrayList<Character> allEnemy = new ArrayList<Character>();
    static Map room = new Map();
    static MediaFile file = null;
    static int level = 1;
    static int bossLvl = 0;
    static Person mainC = new Person("O", 2, 1);
    static int start = -3;
    static int killCount = 5;
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Character ch1 = new Character("Me"); // use for testing
        Character ch2 = new Character("You"); // use for testing
       

        // Character ch1 = new Fire();
        // Character ch2 = new Water();

        System.out.println("Simulation or Start or Load");
       
        String userIn = "";
        String userCh = "";
        // String name = "";

        while (!(userIn.equals("simulation") || userIn.equals("start") || userIn.equals("load"))) { // checks the
            // reponse so that
            // the reponse must
            // be one of the
            // choice to
            // continue the game
            userIn = input.next().toLowerCase(); // turns the reponse into lower case
            startMenu(userIn);
        }
        if (start == 1) {
            while (!(userCh.equals("chimchar") || userCh.equals("riolu") || userCh.equals("froakie")
                    || userCh.equals("treecko"))) { // the user must select a pokemon to continue
                userCh = input.next().toLowerCase();// turns the reponse into lower case

                starterPick(userCh);
            }
            start = 2;
        }

        while (start == 2) {
            
            System.out.println("Use WASD to move around and type save if you want to save the game");
            room.printMap();
            String mapD = input.next();
            while (!mapD.equalsIgnoreCase("n") && pTeam.teamAlive()) {
                if (killCount == 5 && bossLvl == 0) {
                    enemySpawn(level);
                    level++;
                    killCount = 0;
                }else if(killCount > 5 && bossLvl == 1){
                    enemySpawn(level);
                    level++;
                    bossLvl = 0;
                    killCount = 0;
                }
                mainC.move(mapD, room);
                if (mapD.equals("save")) {
                    gameSave();
                    // mapSave(room);
                    System.out.println("Save Successful!");
                }
                if(mapD.equals("st")){
                    System.out.println(pT[currentSlot].toString());
                }
                for (int i = 0; i < allEnemy.size(); i++) {
                    if (room.enemyInRange(mainC, allEnemy.get(i).getLocation())) {
                        System.out.println("You encountered an enemy!!!");
                        pTeam.startB(); 
                        while (pTeam.teamBattle()) { // if the player's status is ready for battl
                            if(pT[currentSlot].cAlive()){
                                battle(pT[currentSlot], allEnemy.get(i)); // start the battle
                            }else{
                                for(int p = 0; p < pT.length; p++){
                                    switchParty(i);
                                }
                            }

                        }
                    }
                }
                System.out.println("Use WASD to move around and type save if you want to save the game");
                mapD = input.next();
                System.out.println('\u000C');
            }
            start = -1;
        }


        if (start == 0) {
            int ch1W = 0;
            int ch2W = 0;
            double amtBat = 0.0;
            double round = 0.0;
            while (amtBat != 100) { // simulate 100 battles
                if (ch2.getHp() > 0 && ch1.getHp() > 0) {
                    simBattle(ch1, ch2);
                    round++;
                    if (ch2.getHp() <= 0) { // character one wins if character two's health is lower or equal to zero
                        ch1W++;
                        ch1.setHp(100); // revive each character
                        ch2.setHp(100);
                        amtBat++;
                    } else if (ch1.getHp() <= 0) { // character two wins if character one's health is lower or equal to
                                                   // zero
                        ch2W++;
                        ch1.setHp(100);
                        ch2.setHp(100);
                        amtBat++;
                    }
                }
            }
            System.out.println("I won " + ch1W + " times.");
            System.out.println("You won " + ch2W + " times.");
            System.out.println("Average round per battle: " + round / amtBat);
            System.out.println(ch1.toString());
            System.out.println(ch2.toString());
            start = -1; // end the game
        }
    }

    public static void startMenu(String u) {
        if (u.equals("simulation")) { // go to the simulation method
            start = 0;
        } else if (u.equals("start")) { // starts the game
            start = 1;
            System.out.println("\n" + "You can choose between four pokemon");
            System.out.println("Chimchar, Riolu, Froakie and Treecko");
            System.out.println("Which one do you want");

        } else if (u.equals("load")) { // load the save file
            MediaFile.setFileName("save");
            String load = MediaFile.readString();
            System.out.println(load + "TEST");
            System.out.println("TEST!");
            currentSlot = 0;
            loadGame(load); // load the previous game save
            start = 2; // move to the battle stage
        } else {
            System.out.println("Wrong command, try again");
        }
    }

    public static void starterPick(String u){
                if (u.equals("chimchar")) {
                    player = new Fire(); // create player's main character
                    player2 = new Steel();
                    mainC = new Person("O", 2, 1);
                    room.placeObject(mainC);
                    // player3 = new Water();
                    // player4 = new Grass();
                    System.out.println("You choose Chimchar!");
                    pTeam.addTeam(player); // add the characters into the player's team
                    pTeam.addTeam(player2);
                    pT[0] = player;// put each pokemon in the team
                    pT[1] = player2;
                    currentSlot = 0; // current pokemon chosen
                    numberP = 2; // number of pokemon in the team

                } else if (u.equals("riolu")) {
                    player = new Steel();
                    player2 = new Fire();
                    mainC = new Person("LUL", 2, 1);
                    room.placeObject(mainC);
                    // player3 = new Water();
                    // player4 = new Grass();
                    System.out.println("You choose Riolu!");
                    pTeam.addTeam(player);
                    pTeam.addTeam(player2);
                    pT[0] = player;
                    pT[1] = player2;
                    currentSlot = 0;
                    numberP = 2;

                } else if (u.equals("froakie")) {
                    player = new Water();
                    player2 = new Fire();
                    mainC = new Person("LUL", 2, 1);
                    room.placeObject(mainC);
                    // player3 = new Steel();
                    // player4 = new Grass();
                    System.out.println("You choose Froakie!");
                    pTeam.addTeam(player);
                    pTeam.addTeam(player2);
                    pT[0] = player;
                    pT[1] = player2;
                    currentSlot = 0;
                    numberP = 2;

                } else if (u.equals("treecko")) {
                    player = new Grass();
                    player2 = new Fire();
                    mainC = new Person("LUL", 2, 1);
                    room.placeObject(mainC);
                    // player3 = new Water();
                    // player4 = new Steel();
                    System.out.println("You choose Treecko!");
                    pTeam.addTeam(player);
                    pTeam.addTeam(player2);
                    pT[0] = player;
                    pT[1] = player2;
                    currentSlot = 0;
                    numberP = 2;

                } else {
                    System.out.println("Not an actual Pokemon name");
                }
            }



    public static void battle(Character player, Character enemy) { // method for battling
        String battleC = "";
        Scanner in = new Scanner(System.in);
        if (pTeam.teamAlive() && enemy.cAlive()) {
            System.out.println("\n" + "type a do normal attack" + "\n" + "type sa to do special attack" + "\n"
                + "type stat to view your stats" + "\n" + "type r to run" + "\n"
                + "type switch to switch to another pokemon in your party");
            battleC = in.next().toLowerCase();
            if (battleC.equals("a")) {
                if (player.getSped() > enemy.getSped()) { // if the player is faster, player will attack first
                    player.attack(enemy);
                    enemy.attack(player);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                } else if (enemy.getSped() > player.getSped()) { // if the enemy is faster, the enemy will
                    // attack first
                    enemy.attack(player);
                    player.attack(enemy);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                } else { // else the player will attack first
                    player.attack(enemy);
                    enemy.attack(player);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                }
            } else if (battleC.equals("sa")) {
                if (player.getSped() > enemy.getSped()) { // if the player is faster, player will attack first
                    player.specialAttack(enemy);
                    enemy.specialAttack(player);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                } else if (enemy.getSped() > player.getSped()) { // if the enemy is faster, the enemy will
                    // attack first
                    enemy.specialAttack(player);
                    player.specialAttack(enemy);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                } else { // else the player will attack first
                    player.specialAttack(enemy);
                    enemy.specialAttack(player);
                    System.out.println(
                        "You lost " + (player.getFullHealth() - player.getHp()) + "health");
                    System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
                }

            } else if (battleC.equals("r")) {
                player.endBattle(); // end the battle
                System.out.println("Are you going to continue?");
                // in.close();
            } else if (battleC.equals("stat")) { // print out the stats between the characters on the battlefield
                System.out.println(player.toString());
                System.out.println(enemy.toString());
            } else if (battleC.equals("switch")) {
                System.out.println("Which Pokemon?"); // the player can switch their pokemon in battle
                int order = 1;
                for (int i = 0; i < pT.length; i++) {
                    System.out.println(order + ". " + pT[i]);
                    order++;
                }
                int pN = in.nextInt();
                switchParty(pN); // the number in parameter will be the
            }

            if (!pTeam.teamAlive()) { // check if anyone in the team is alive
                System.out.println("You Die!"); // end the game if everyone in the team is dead
                System.out.println("Game Over!");
                pTeam.stopB();
                // in.close();
            }
            if (!enemy.cAlive()) { // check if the enemy is alive
                System.out.println("\n" + "You defeated " + enemy + "!" + "\n");
                player.expGain(20); // the player gains 20 exp
                room.removeEnemy(allEnemy);
                killCount++;
                System.out.println(killCount);
                pTeam.stopB(); // stop the battle while and ask if the player wants to continue the game
            }
        }
    }


    public static void loadGame(String load) { // load method
        int partySlot = 0;
        while (load != null) {
            int info = 0;
            int count = 0;
            String pName = "";
            int atk = 0;
            int hp = 0;
            int def = 0;
            int sped = 0;
            int spatk = 0;
            int sdef = 0;
            int lvl = 0;
            int exp = 0;
            int fullHealth = 0;
            int type = 0;
            while (load.length() > 0) {
                int pipe = load.indexOf("|"); // find location of the pipe
                String num = load.substring(0, pipe); // remove the pipe
                String num1 = "";
                if (count == 0) {
                    pName = num;
                    System.out.println(pName);
                } else if (count == 1) { // sort out all of a character's info
                    num1 = num;
                    info = Integer.valueOf(num1);
                    atk = info;
                    System.out.println(atk);
                } else if (count == 2) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    hp = info;
                    System.out.println(hp);
                } else if (count == 3) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    def = info;
                    System.out.println(def);
                } else if (count == 4) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    sped = info;
                    System.out.println(sped);
                } else if (count == 5) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    spatk = info;
                    System.out.println(spatk);
                } else if (count == 6) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    sdef = info;
                    System.out.println(sdef);
                } else if (count == 7) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    lvl = info;
                    System.out.println(lvl);
                } else if (count == 8) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    exp = info;
                    System.out.println(exp);
                } else if (count == 9) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    fullHealth = info;
                    System.out.println(fullHealth);
                } else if (count == 10) {
                    num1 = num;
                    info = Integer.valueOf(num1);
                    type = info;
                    System.out.println(type);
                    partySlot++;

                }
                if (partySlot == 1 && count == 10) { // loading info for character one
                    System.out.println(partySlot);
                    if (type == 1) {// check what child class the character was from
                        player = new Fire(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player;
                        pTeam.addTeam(player);
                    } else if (type == 2) {
                        player = new Water(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player;
                        pTeam.addTeam(player);

                    } else if (type == 3) {
                        player = new Grass(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player;
                        pTeam.addTeam(player);

                    } else if (type == 4) {
                        player = new Steel(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player;
                        pTeam.addTeam(player);
                    }
                    System.out.println(pName + " loaded");
                    pT[partySlot - 1].startBattle();
                }
                if (partySlot == 2 && count == 10) { // loading info for character two
                    if (type == 1) { // check what child class the character was from
                        player2 = new Fire(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player2;
                        pTeam.addTeam(player2);
                    } else if (type == 2) {
                        player2 = new Water(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player2;
                        pTeam.addTeam(player2);
                    } else if (type == 3) {
                        player2 = new Grass(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player2;
                        pTeam.addTeam(player2);
                    } else if (type == 4) {
                        player2 = new Steel(pName, atk, hp, def, sped, spatk, sdef, lvl, exp, fullHealth, type);
                        pT[partySlot - 1] = player2;
                        pTeam.addTeam(player2);
                    }
                    System.out.println(pName + " loaded");
                    pT[partySlot - 1].startBattle();

                }
                count++;
                load = load.substring(pipe + 1);
            }
            load = MediaFile.readString();
        }
    }

    public static void switchParty(int n) { // switch the character in battle
        currentSlot = n - 1;
    }
    
    public static void simBattle(Character player, Character enemy) { // method for simulation battle
        if (player.getSped() > enemy.getSped()) { // if the player is faster, player will attack first
            player.attack(enemy);
            enemy.attack(player);
            System.out.println("You lost " + (player.getFullHealth() - player.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else if (enemy.getSped() > player.getSped()) { // if the enemy is faster, the enemy will attack first
            enemy.attack(player);
            player.attack(enemy);
            System.out.println("You lost " + (player.getFullHealth() - player.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else { // else the player will attack first
            player.attack(enemy);
            enemy.attack(player);
            System.out.println("You lost " + (player.getFullHealth() - player.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        }
    }


    public static void gameSave(){
        file = new MediaFile();
        file.setFileName("save"); //create a save file called save
        for (int i = 0; i < pT.length; i++) {
            if (i == 0) {
                file.writeString(pT[i].saveData()); //save the character info in the text file
            } else {
                file.writeString("\n" + pT[i].saveData());  //move to the next line
            }
        }
        file.saveAndClose();
    }

    public static void enemySpawn(int lvl) { 
        ArrayList<Integer> ranrow = new ArrayList<Integer>();
        ArrayList<Integer> rancol = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            ranrow.add(Integer.valueOf(i));
            rancol.add(Integer.valueOf(i));
        }
        Collections.shuffle(ranrow);
        Collections.shuffle(rancol);
        for (int i = 0; i <5; i++) {
            Person enemy12 = new Person(ranrow.get(i),rancol.get(i));
            Character b1 = new Character("Bob",2*lvl,2*lvl,2*lvl,2*lvl,2*lvl,2*lvl,2*lvl,enemy12);
            System.out.println(b1);
            allEnemy.add(b1);
            System.out.println(allEnemy.get(i));
            room.placeObject(allEnemy.get(i).getLocation());
        }
        if(lvl % 5 == 0){
            Person enemy13 = new Person("Luke",ranrow.get(7), rancol.get(7));
            Character e1 = new Character("Luke",5*lvl,5*lvl,5*lvl,5*lvl,5*lvl,5*lvl,5*lvl,enemy13);
            allEnemy.add(e1);
            room.placeObject(e1.getLocation());
            bossLvl = 1;
        }
    }

}
