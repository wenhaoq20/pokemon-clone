

public class Fire extends Character{
    public Fire() {
        super("Chimchar", 6,21,5,6,5,5,1);
    }

    public Fire(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int lvl, int exp, int fHp, int type){
        super(name, atk, hp, def, sped, spatk, sdef, lvl, exp, fHp, type);
    }

    public void addStat(){
        addAttack(1);
        addSpeed(1);
        addHealth(1);
        super.addStat();
    }

    public void attack(Character opp){
        int dmg = 0;
        int critChance = (int)(Math.random() * 10) + 1;
        int fullDmgChance = (int)(Math.random() * 20) + 1;
        if(opp.getDef() >= this.getAtk() && fullDmgChance != 1){
            int fullD2 = (opp.getDef() - this.getAtk())*2;
            dmg = (int)(Math.random() * fullD2) + 2;
        }else if(this.getAtk() > opp.getDef() && fullDmgChance != 1){
            int fullD = (this.getAtk() - opp.getDef())*2;
            dmg = (int)(Math.random() * fullD) + 2;
        }
        if(fullDmgChance == 1){
            dmg = (int)(Math.random() * this.getAtk()) + 3;
            System.out.println("RNGesus is on your side!");
        }
        if(critChance == 1){
            dmg *= 2;
            System.out.println("Crit");
        }
        opp.hpCal(dmg);
    }
}