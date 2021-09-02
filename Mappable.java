
public abstract class Mappable{
    private int currRow;
    private int currCol;

    public Mappable(int r, int c) {
        currRow = r;
        currCol = c;
    }
    
    public int getRow(){
        return currRow;
    }
    
    public int getCol(){
        return currCol;
    }
   
    public void setRow(int r){
        currRow = r;
    }
    
    public void setCol(int c){
        currCol = c;
    }
    
    public abstract String getSymbol();
    public abstract boolean isAttackable();
}