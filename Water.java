
public class Water extends Character{
    public Water(){
        super("Froakie", 7, 20,4,6,4,4,2);
    }

    public Water(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int lvl, int exp, int fHp, int type){
        super(name, atk, hp, def, sped, spatk, sdef, lvl, exp, fHp, type);
    }

    public void addStat(){
        addAttack(2);
        addSpeed(1);
        super.addStat();
    }

    public void attack(Character opp){
        int dmg = 0;
        int critChance = (int)(Math.random() * 10) + 1;
        if(opp.getDef() >= getAtk() ){
            int fullD2 = (this.getAtk() + this.getSatk())/2;
            dmg = (int)(Math.random() * fullD2) + 2;
        }else{
            int fullD = (getAtk() - opp.getDef())*2;
            dmg = (int)(Math.random() * fullD) + 5;
        }
        if(critChance == 1){
            dmg *= 2;
            System.out.println("Crit");
        }
        opp.hpCal(dmg);
    }
}