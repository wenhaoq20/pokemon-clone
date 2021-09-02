
public class Grass extends Character{
    public Grass(){
        super("Treecko", 6, 20, 5,6,6,5,3);
    }

    public Grass(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int lvl, int exp, int fHp, int type){
        super(name, atk, hp, def, sped, spatk, sdef, lvl, exp, fHp, type);
    }

    public void addStat(){
        addSpecialAttack(1);
        addSpeed(1);
        addAttack(1);
        super.addStat();
    }

    public void attack(Character opp){
        int dmg = 0;
        int hpBack = 0;
        int critChance = (int)(Math.random() * 10) + 1;
        if(opp.getDef() >= getAtk()){
            int halfD = getAtk()/2;
            dmg = (int)(Math.random() * halfD) + 1;
        }else{
            int fullD = getAtk() - opp.getDef();
            dmg = (int)(Math.random() * fullD) + 5;
        }
        if(critChance == 1){
            dmg *= 2;
            System.out.println("Crit");
        }
        hpBack = dmg;
        if(hpBack == 1){
            lifeSteal(1);
        }else{
            hpBack = (int)(Math.random() * dmg) + 2;
            lifeSteal(hpBack);
        }
        System.out.println("Heal " + hpBack );
        opp.hpCal(dmg);
    }
}
