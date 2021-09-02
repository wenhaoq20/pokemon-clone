public class Scene{
    startScreen startT;

    public Scene(startScreen t){
        startT = t;
    }

    public void showTitle(){
        
        //show title screen
        startT.title.setVisible(true);
        startT.startGame.setVisible(true);

        //hide everything
        startT.choiceScreen.setVisible(false);
        startT.starterChoice.setVisible(false);
        startT.playerParty.setVisible(false);
        startT.simu.setVisible(false);

    }

    public void showSim(){
         //show title screen
         startT.title.setVisible(false);
         startT.startGame.setVisible(false);
 
         //hide everything
         startT.choiceScreen.setVisible(false);
         startT.starterChoice.setVisible(false);
         startT.playerParty.setVisible(false);
         startT.simu.setVisible(true);
         startT.inbattle.setVisible(false);
    }

    public void showStaterScreen(){
        startT.choiceScreen.setVisible(true);
        startT.starterChoice.setVisible(true);
        //startT.choiceTextArea.setText("Choose your Pokemon!!!");
        startT.title.setVisible(false);
        startT.startGame.setVisible(false);
        startT.simu.setVisible(false);
        startT.updateButton("Chimchar", "Riolu", "Froakie", "Teecko", "", "");
        startT.choiceTextArea.setText("Choose your Pokemon!!");
        startT.inbattle.setVisible(false);
    }

    public void afterStarterScreen(){
        startT.playerParty.setVisible(true);
        startT.updateButton("Up", "Right", "Down", "Left", "Save", "Quit");        
        startT.title.setVisible(false);
        startT.startGame.setVisible(false);
        startT.simu.setVisible(false);
        startT.choiceScreen.setVisible(false);
        startT.starterChoice.setVisible(true);
        startT.simu.setVisible(false);
        startT.inbattle.setVisible(false);
    }

    public void battleScreen(){
        startT.playerParty.setVisible(true);
        startT.updateButton("Attack", "Special Attack", "Stats", "Switch", "Save", "Quit");
        startT.title.setVisible(false);
        startT.startGame.setVisible(false);
        startT.simu.setVisible(false);
        startT.choiceScreen.setVisible(false);
        startT.starterChoice.setVisible(true);
        startT.simu.setVisible(false);
        startT.inbattle.setVisible(true);
        startT.battleText.setText("You encounter an enemy!!!");
    }

    public void partyScreen(){
        startT.playerParty.setVisible(true);
        startT.updateButton("Pokemon 1", "Pokemon 2", "Back", "", "", "");
        
        startT.title.setVisible(false);
        startT.startGame.setVisible(false);
        startT.simu.setVisible(false);
        startT.choiceScreen.setVisible(false);
        startT.starterChoice.setVisible(true);
        startT.simu.setVisible(false);
        startT.inbattle.setVisible(false);
    }
}