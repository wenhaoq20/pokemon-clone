
public class Person extends Mappable{
    private String name;

    public Person(int r, int c){
        super(r,c);
        name = "N";
    }

    public Person(String n, int r, int c){
        super(r,c);
        name = n;
    }

    public void move(String direction, Map room){
        if(direction.equalsIgnoreCase("w")){
            if(room.canMove(this.getRow() - 1, this.getCol())){
                System.out.println("1w");
                Map.removeObject(this);
                this.setRow(this.getRow() - 1);
            }
        }else if(direction.equalsIgnoreCase("a")){
            if(room.canMove(this.getRow(), this.getCol() - 1)){
                System.out.println("1a");
                Map.removeObject(this);
                this.setCol(this.getCol() - 1);
            }
        }else if(direction.equalsIgnoreCase("d")){
            if(room.canMove(this.getRow(), this.getCol() + 1)){
                System.out.println("1d");
                Map.removeObject(this);
                this.setCol(this.getCol() + 1);
            }
        }else if(direction.equalsIgnoreCase("s")){
            if(room.canMove(this.getRow() + 1, this.getCol())){
                System.out.println("1s");
                Map.removeObject(this);
                this.setRow(this.getRow() + 1);
            }
        }
        room.placeObject(this);
        room.printMap();
    }

    public String getSymbol(){
        return name.substring(0,1).toUpperCase();
    }

    public boolean isAttackable(){
        return true;
    }
}