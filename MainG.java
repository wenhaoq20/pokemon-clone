
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

   
public class MainG{
    Game game;
    startScreen sc;
    Scene s;
    Team pTeam = new Team();

    static Character[] pT = new Character[2]; // player's team
    static int currentSlot = -1;
    static int numberP = 0;
    static Character player = null; // creating the holder for pokemon
    static Character player2 = null;
    static Character player3 = null;
    static Character player4 = null;
    static ArrayList<Character> allEnemy = new ArrayList<Character>();
    static Map room = new Map();
    static MediaFile mapFile = null;
    static MediaFile file = null;
    static int level = 1;
    static Person mainC = new Person("LUL", 2, 1);
    static int start = -1;
    static int killCount = 5;
    Character ch1 = null;
    Character ch2 = null;
    static int bossLvl = 0;
    private int stage = 0;

    public MainG(Game g, startScreen screen, Scene vis) {
        game = g;
        sc = screen;
        s = vis;
    }

    public void starter1() { // chimchar
        player = new Fire(); // create player's main character
        player2 = new Steel();
        mainC = new Person("LUL", 2, 1);
        room.placeObject(mainC);
        // player3 = new Water();
        // player4 = new Grks();
        System.out.println("You choose Chimchar!");
        pTeam.addTeam(player); // add the characters into the player's team
        pTeam.addTeam(player2);
        pT[0] = player;// put each pokemon in the team
        pT[1] = player2;
        currentSlot = 0; // current pokemon chosen
        numberP = 2; // number of pokemon in the team
    }

    public void starter2() { // riolu
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
    }

    public void starter3() { // froakie
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
    }

    public void starter4() { // treecko
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
    }

    public void showMap() {
        System.out.println('\u000C');    
        room.printMap();
    }


    public void showTop() {
        String allPoke = "";
        for (int i = 0; i < pT.length; i++) {
            if (i != pT.length - 1) {
                allPoke += pT[i].getName() + ",";
            } else {
                allPoke += pT[i].getName();
            }
        }
        sc.hpNum.setText("" + pT[currentSlot].getHp());
        sc.pokemon.setText("" + allPoke);
    }

    public void normalAtk(Character u, Character enemy) {
        if (u.getSped() > enemy.getSped()) { // if the player is faster, player will attack first
            u.attack(enemy);
            enemy.attack(u);
            System.out.println("You lost " + (u.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else if (enemy.getSped() > u.getSped()) { // if the enemy is faster, the enemy will
            // attack first
            enemy.attack(u);
            u.attack(enemy);
            System.out.println("You lost " + (u.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else { // else the player will attack first
            u.attack(enemy);
            enemy.attack(u);
            System.out.println("You lost " + (player.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enmy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        }
        if (!pTeam.teamAlive()) { // check if anyone in the team is alive
            System.out.println("You Die!"); // end the game if everyone in the team is dead
            System.out.println("Game Over!");
            pTeam.stopB();
            // in.close();
        }
        if (!enemy.cAlive()) { // check if the enemy is alive
            System.out.println("\n" + "You defeated " + enemy + "!" + "\n");
            u.expGain(20); // the player gains 20 exp
            pTeam.stopB();
            ; // stop the battle while and ask if the player wants to continue the game
        }
    }

    public void specialAtk(Character u, Character enemy) {
        if (u.getSped() > enemy.getSped()) { // if the player is faster, player will attack first
            u.specialAttack(enemy);
            enemy.specialAttack(u);
            System.out.println("You lost " + (u.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else if (enemy.getSped() > u.getSped()) { // if the enemy is faster, the enemy will
            // attack first
            enemy.specialAttack(u);
            u.specialAttack(enemy);
            System.out.println("You lost " + (u.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        } else { // else the player will attack first
            u.specialAttack(enemy);
            enemy.specialAttack(u);
            System.out.println("You lost " + (u.getFullHealth() - u.getHp()) + "health");
            System.out.println("The enemy lost " + (enemy.getFullHealth() - enemy.getHp()) + "health");
        }
        if (!pTeam.teamAlive()) { // check if anyone in the team is alive
            System.out.println("You Die!"); // end the game if everyone in the team is dead
            System.out.println("Game Over!");
            pTeam.stopB();
            // in.close();
        }
        if (!enemy.cAlive()) { // check if the enemy is alive
            System.out.println("\n" + "You defeated " + enemy + "!" + "\n");
            u.expGain(20); // the player gains 20 exp
            pTeam.stopB();
            ; // stop the battle while and ask if the player wants to continue the game
        }
    }

    public void checkStat(Character u, Character enemy) {
        System.out.println(u.toString());
        System.out.println(enemy.toString());
    }

    public void switchPoke() {
        int order = 1;
        int slot = 0;
        for (int i = 0; i < pT.length; i++) {
            System.out.println(order + ". " + pT[i]);
            order++;
        }

        switchParty(slot); // the number in parameter will be the
    }

    public void saveGame() {
        file = new MediaFile();
        file.setFileName("save"); // create a save file called save
        for (int i = 0; i < pT.length; i++) {
            if (i == 0) {
                file.writeString(pT[i].saveData()); // save the character info in the text file
            } else {
                file.writeString("\n" + pT[i].saveData()); // move to the next line
            }
        }
        System.out.println("Save Sucessfully");
        file.saveAndClose();
    }

    public void battle(Character player) {

    }

    public void movePlayerUp() {
        mainC.move("w", room);
    }

    public void movePlayerDown() {
        mainC.move("s", room);
    }

    public void movePlayerRight() {
        mainC.move("d", room);
    }

    public void movePlayerLeft() {
        mainC.move("a", room);
    }

    public void loadGame() {
        MediaFile.setFileName("save");
        String load = MediaFile.readString();
        currentSlot = 0;
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

    public void simBattle(Character player, Character enemy) { // method for simulation battle
        System.out.println("test");
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

    public void simTest() {
        sc.simBattleArea.setText("Test");
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
        sc.simBattleArea.setText("Average round per battle: " + round / amtBat);
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        start = -1; // end the game
    }

    public void simSetUp() {
        ch1 = new Character("Me");
        ch2 = new Character("You");
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int n) {
        stage = n;
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
        for (int i = 0; i < 5; i++) {
            Person enemy12 = new Person(ranrow.get(i), rancol.get(i));
            Character b1 = new Character("Bob", 2 * lvl, 2 * lvl, 2 * lvl, 2 * lvl, 2 * lvl, 2 * lvl, 2 * lvl, enemy12);
            System.out.println(b1);
            allEnemy.add(b1);
            System.out.println(allEnemy.get(i));
            room.placeObject(allEnemy.get(i).getLocation());
        }
        if (lvl % 5 == 0) {
            Person enemy13 = new Person("Luke", ranrow.get(7), rancol.get(7));
            Character e1 = new Character("Luke", 5 * lvl, 5 * lvl, 5 * lvl, 5 * lvl, 5 * lvl, 5 * lvl, 5 * lvl,
                    enemy13);
            allEnemy.add(e1);
            room.placeObject(e1.getLocation());
            bossLvl = 1;
        }
    }
}