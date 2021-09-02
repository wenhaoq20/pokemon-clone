import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Currency;

public class ChoiceHandler implements ActionListener {
    Game game;
    int enemyNum = 0;
    public ChoiceHandler(Game g) {
        game = g;
    }

    public void actionPerformed(ActionEvent event) {

        String pChoice = event.getActionCommand();

        switch (game.story.getStage()) {
            case 0:
                switch (pChoice) {
                    case "start":
                        game.ts.showStaterScreen();
                        game.story.showMap();
                        game.story.setStage(1);
                        break;

                    case "load":
                        game.story.loadGame();
                        game.ts.afterStarterScreen();
                        game.story.showTop();
                        game.story.setStage(2);
                        break;

                    case "sim":
                        game.story.simSetUp();
                        game.story.simTest();
                        game.ts.showSim();
                        break;
                }
                break;

            case 1:
                switch (pChoice) {
                    case "c1":
                        game.story.starter1();
                        game.ts.afterStarterScreen();
                        game.story.showTop();
                        game.story.setStage(2);
                        break;

                    case "c2":
                        game.story.starter2();
                        game.ts.afterStarterScreen();
                        game.story.showTop();
                        game.story.setStage(2);
                        break;

                    case "c3":
                        game.story.starter3();
                        game.ts.afterStarterScreen();
                        game.story.showTop();
                        game.story.setStage(2);
                        break;

                    case "c4":
                        game.story.starter4();
                        game.ts.afterStarterScreen();
                        game.story.showTop();
                        game.story.setStage(2);
                        break;
                }
                break;

            case 2:
                game.story.showMap();
                game.story.room.removeEnemy(game.story.allEnemy);
                if (game.story.killCount == 5 && game.story.bossLvl == 0) {
                    game.story.enemySpawn(game.story.level);
                    game.story.level++;
                    game.story.killCount = 0;
                } else if (game.story.killCount > 5 && game.story.bossLvl == 1) {
                    game.story.enemySpawn(game.story.level);
                    game.story.level++;
                    game.story.bossLvl = 0;
                    game.story.killCount = 0;
                }
                switch (pChoice) {
                    case "c1":
                        game.story.movePlayerUp();
                        for(int i = 0; i < game.story.allEnemy.size(); i++){
                            if(game.story.room.enemyInRange(game.story.mainC, game.story.allEnemy.get(i).getLocation())){
                                enemyNum = i;
                                game.ts.battleScreen();
                                game.story.setStage(3);
                            }
                        }
                        break;

                    case "c2":
                        game.story.movePlayerRight();
                        for(int i = 0; i < game.story.allEnemy.size(); i++){
                            if(game.story.room.enemyInRange(game.story.mainC, game.story.allEnemy.get(i).getLocation())){
                                enemyNum = i;
                                game.ts.battleScreen();
                                game.story.setStage(3);
                            }
                        }
                        break;

                    case "c3":
                        game.story.movePlayerDown();
                        for(int i = 0; i < game.story.allEnemy.size(); i++){
                            if(game.story.room.enemyInRange(game.story.mainC, game.story.allEnemy.get(i).getLocation())){
                                enemyNum = i;
                                game.ts.battleScreen();
                                game.story.setStage(3);
                            }
                        }
                        break;

                    case "c4":
                        game.story.movePlayerLeft();
                        for(int i = 0; i < game.story.allEnemy.size(); i++){
                            if(game.story.room.enemyInRange(game.story.mainC, game.story.allEnemy.get(i).getLocation())){
                                enemyNum = i;
                                game.ts.battleScreen();
                                game.story.setStage(3);
                            }
                        }
                        break;

                    case "c5":
                        game.story.saveGame();
                        break;

                    case "c6":
                        game.startG.window.dispose();
                        break;
                }
                break;
            case 3:
                System.out.println("You encounter an enemy");
                game.story.pTeam.startB();
                switch (pChoice) {
                    case "c1":
                        if(game.story.pT[game.story.currentSlot].cAlive() && game.story.allEnemy.get(enemyNum).cAlive()){
                            game.story.normalAtk(game.story.pT[game.story.currentSlot], game.story.allEnemy.get(enemyNum));
                        }
                        game.story.killCount++;
                        game.story.room.removeEnemy(game.story.allEnemy);
                        game.ts.afterStarterScreen();
                        game.story.setStage(2);
                        break;

                    case "c2":
                        if(game.story.pT[game.story.currentSlot].cAlive() && game.story.allEnemy.get(enemyNum).cAlive()){
                            game.story.specialAtk(game.story.pT[game.story.currentSlot], game.story.allEnemy.get(enemyNum));
                        }
                        game.story.killCount++;
                        game.story.room.removeEnemy(game.story.allEnemy);
                        game.ts.afterStarterScreen();
                        game.story.setStage(2);
                        break;

                    case "c3":
                        if(game.story.pT[game.story.currentSlot].cAlive() && game.story.allEnemy.get(enemyNum).cAlive()){
                            game.story.checkStat(game.story.pT[game.story.currentSlot], game.story.allEnemy.get(enemyNum));
                        }
                
                        game.story.setStage(3);
                        break;

                    case "c4":
                        game.ts.partyScreen();
                        game.story.setStage(4);
                        break;

                    case "c5":
                    
                        break;

                    case "c6":
                        break;
                }
                break;
            case 4:
                System.out.println("Which Pokemon do you want to switch to?");
                switch(pChoice){
                    case "c1":
                        game.story.switchParty(1);
                        game.ts.battleScreen();
                        game.story.setStage(3);
                        break;
                    case "c2":
                        game.story.switchParty(2);
                        game.ts.battleScreen();
                        game.story.setStage(3);
                        break;
                    case "c3":
                        game.ts.battleScreen();
                        game.story.setStage(3);
                        break;
                    case "c4":
                        break;
                    case "c5":
                        break;
                    case "c6":
                        break;
                }
                break;
        }       
    }
}
