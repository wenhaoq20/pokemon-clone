
public class Wall extends Mappable{
    
    public Wall(int r, int c) {
        super(r,c);
    }
    
    public String getSymbol(){
        return "X";
    }

    @Override
    public boolean isAttackable(){
        return false;
    }
}