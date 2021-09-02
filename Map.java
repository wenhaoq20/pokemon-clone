
import java.util.ArrayList;

public class Map {
    private static Mappable[][] grid;
    private static String[][] map2;
    private static startScreen map = new startScreen();
    public Map() {
        MediaFile.setFileName("level");
        int r = Integer.valueOf(MediaFile.readString());
        int c = Integer.valueOf(MediaFile.readString());
        grid = new Mappable[r][c];

        for (int i = 0; i < grid.length; i++) {
            String info = MediaFile.readString();
            String[] line = info.split(" ");
            for (int j = 0; j < grid[i].length; j++) {
                if (Integer.valueOf(line[j]) == 1) {
                    grid[i][j] = new Wall(i, j);
                } else if (Integer.valueOf(line[j]) == 2) {
                    grid[i][j] = new Person(i, j);
                }
            }
        }
    }

    public Map(String name) {
        MediaFile.setFileName(name);
        int r = Integer.valueOf(MediaFile.readString());
        int c = Integer.valueOf(MediaFile.readString());
        grid = new Mappable[r][c];

        for (int i = 0; i < grid.length; i++) {
            String info = MediaFile.readString();
            String[] line = info.split(" ");
            for (int j = 0; j < grid[i].length; j++) {
                if (Integer.valueOf(line[j]) == 1) {
                    grid[i][j] = new Wall(i, j);
                } else if (Integer.valueOf(line[j]) == 2) {
                    grid[i][j] = new Person(i, j);
                }
            }
        }
    }

    public void placeObject(Mappable toPlace) {
        grid[toPlace.getRow()][toPlace.getCol()] = toPlace;
    }

    public static void removeObject(Mappable toRemove) {
        grid[toRemove.getRow()][toRemove.getCol()] = null;
    }

    public boolean canMove(int r, int c) {
        if (r > 0 && r < grid.length - 1 && c > 0 && c < grid[r].length - 1){
            return true;
        }
        return false;
    }

    public boolean enemyInRange(Person character, Person opp) {
        int r = character.getRow();
        int c = character.getCol();
        int r1 = opp.getRow();
        int c1 = opp.getCol();
        if(grid[r][c] != null && grid[r][c].isAttackable() && r == r1 && c == c1 ){
            return true;
        }
        return false;
    }

    public int gridValue(int r, int c){
        if(grid[r][c].getSymbol().equals("X")){
            return 1;
        }
        return 0;
    }

    public Mappable[][] returnGrid(){
        return grid;
    }

    public int returnGridRow(){
        return grid.length;
    }

    public int returnGridCol(){
        return grid[0].length;
    }

    public void printMap() { 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    System.out.print(" " + grid[i][j].getSymbol());
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void printMapToText(startScreen s) { 
        String mapText = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    mapText += grid[i][j].getSymbol();
                } else {
                    //s.choiceTextArea.append("  ");
                }
            }
            mapText += "\n";
        }
        s.choiceTextArea.setText(mapText);
    }

    
    


    public void removeEnemy(ArrayList<Character> allEnemy) {
        for (int i = 0; i < allEnemy.size(); i++) {
            if (!allEnemy.get(i).cAlive()) {
                removeObject(allEnemy.get(i).getLocation());
                allEnemy.remove(i);
            }
        }
    
    }

    public static void main(String[] args) {
        Map room = new Map();
        room.printMap();
    }
}