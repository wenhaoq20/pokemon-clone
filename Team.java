
public class Team {
    private Character[] playerTeam = new Character[4];
    private int i = 0;
    private boolean bstat = false;
    private int playerPos = 0;

    public void addTeam(Character p) {
        if (i < playerTeam.length) {
            playerTeam[i] = p;
            System.out.println(i + ". " + p + "\n" + " had added to your team!" + "\n");
            i++;
        }
    }

    public boolean teamBattle(){
        return bstat;
    }

    public int getPlayerPos(){
        return playerPos;
    }

    public void setPlayerPos(int n){
        playerPos += n;
    }

    public void startB(){
        if(teamAlive()){
            bstat = true;
        }
    }
    
    public void stopB(){
        bstat = false;
    }

    public boolean teamAlive() {
        int numDead = 0;
        for (int x = 0; x < i; x++) {
            if (playerTeam[x].getHp() <= 0) {
                numDead++;
            }
        }
        if (numDead == playerTeam.length) {
            return false;
        } else {
            return true;
        }
    }
}
