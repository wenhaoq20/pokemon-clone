
public class Steel extends Character{
    public Steel(){
        super("Riolu", 6, 22, 6,5,5,4,4);   
    }

    public Steel(String name, int atk, int hp, int def, int sped, int spatk, int sdef, int lvl, int exp, int fHp, int type){
        super(name, atk, hp, def, sped, spatk, sdef, lvl, exp, fHp, type);
    }


    public void addStat(){
        addDefense(1);
        addHealth(1);
        addAttack(1);
        super.addStat();
    }

    public void attack(Character opp){
        int dmg = 0;
        int critChance = (int)(Math.random() * 5) + 1;
        if(opp.getDef() >= this.getAtk()){
            int halfD = this.getAtk()/2;
            dmg = (int)(Math.random() * halfD) + 3;
        }else{
            int fullD = this.getAtk() - opp.getDef();
            dmg = (int)(Math.random() * fullD) + 5;
        }
        if(critChance == 1){
            dmg *= 4;
            System.out.println("Crit");
        }
        opp.hpCal(dmg);
    }
}
