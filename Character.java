
public class Character {
    private int atk;
    private int hp;
    private int def;
    private int sped;
    private int satk;
    private int sdef;
    private int lvl;
    private int exp;
    private boolean inBattle;
    private int fullHealth;
    private int type; // 1 = fire, 2 = water , 3 = grass , 4 = steel
    private String characterNames;
    private Person location;

    public Character(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int type, Person loc) {
        characterNames = name;
        inBattle = false;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.sped = sped;
        this.satk = spatk;
        this.sdef = sdef;
        lvl = 5;
        this.type = type;
        exp = 0;
        fullHealth = hp;
        location = loc;
    }

    public Character(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int type) {
        characterNames = name;
        inBattle = false;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.sped = sped;
        this.satk = spatk;
        this.sdef = sdef;
        lvl = 5;
        this.type = type;
        exp = 0;
        fullHealth = hp;
    }


    public Character(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int lvl, int exp,
            int fullHealth, int type) {
        characterNames = name;
        inBattle = false;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.sped = sped;
        this.satk = spatk;
        this.sdef = sdef;
        this.lvl = lvl;
        this.exp = exp;
        this.fullHealth = fullHealth;
        this.type = type;
    }

    public Character(String character) {
        characterNames = character;
        atk = (int) (Math.random() * 101);
        hp = 100;
        def = 100 - atk;
        sped = (int) (Math.random() * 10);
        lvl = 10;
    }

    public String getName() {
        return characterNames;
    }

    public boolean getBattle() {
        return inBattle;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }

    public int getSped() {
        return sped;
    }

    public int getSatk() {
        return satk;
    }

    public int getSdef() {
        return sdef;
    }

    public int getType() {
        return type;
    }

    public int getLvl() {
        return lvl;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public Person getLocation(){
        return location;
    }

    public void startBattle() {
        inBattle = true;
    }

    public void endBattle() {
        inBattle = false;
    }

    public void addAttack(int a) {
        atk += a;
    }

    public void addHealth(int h) {
        hp += h;
    }

    public void addDefense(int d) {
        def += d;
    }

    public void addSpeed(int s) {
        sped += s;
    }

    public void addSpecialAttack(int sa) {
        satk += sa;
    }

    public void addSpecialDefense(int sd) {
        sdef += sd;
    }

    public void addStat() {
        atk++;
        def++;
        hp += 3;
        sped++;
        satk++;
        sdef++;
        fullHealth += 3;
    }

    public void expGain(int n) {
        exp += n;
        if (exp >= 100) {
            lvl++;
            addStat();
            exp = 0;
        }
    }

    public void lifeSteal(int d) {
        hp += d;
    }

    public void hpCal(int lostHp) {
        hp -= lostHp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.characterNames = name;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSdef(int sdef) {
        this.sdef = sdef;
    }

    public void setSped(int sped) {
        this.sped = sped;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public void setSatk(int satk) {
        this.satk = satk;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void revive() {
        hp = fullHealth;
    }

    public boolean cAlive() {
        if (hp > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void attack(Character opp) {
        int dmg = 0;
        int critChance = (int) (Math.random() * 10) + 1;
        if (opp.getDef() >= this.atk) {
            int halfD = this.atk / 2;
            dmg = (int) (Math.random() * halfD) + 1;
        } else {
            int fullD = this.atk - opp.getDef();
            dmg = (int) (Math.random() * fullD) + 2;
        }
        if (critChance == 1) {
            dmg *= 2;
            System.out.println("Crit");
        }
        opp.hpCal(dmg);
    }

    public void specialAttack(Character opp) {
        int dmg = 0;
        int critChance = (int) (Math.random() * 10) + 1;
        if (opp.getSdef() >= this.satk) {
            int halfD = this.satk / 2;
            dmg = (int) (Math.random() * halfD) + 1;
        } else {
            int fullD = this.satk - opp.getSdef();
            dmg = (int) (Math.random() * fullD) + 2;
        }
        if (critChance == 1) {
            dmg *= 2;
            System.out.println("Crit");
        }
        opp.hpCal(dmg);
    }

    public String toString() {
        return ("\n" + characterNames + "\n" + "Level: " + lvl + "\n" + "Health: " + hp + "\n" + "Attack: " + atk + "\n"
                + "Defense: " + def + "\n" + "Special Attack: " + satk + "\n" + "Special Defense: " + sdef + "\n"
                + "Speed :" + sped);
    }

    public String saveData() {
        return (characterNames + "|" + atk + "|" + hp + "|" + def + "|" + sped + "|" + satk + "|" + sdef + "|" + lvl
                + "|" + exp + "|" + fullHealth + "|" + type);
        
    }
}
