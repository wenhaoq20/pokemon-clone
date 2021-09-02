
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;




public class startScreen{
    JFrame window;
    JPanel title, startGame, starterChoice, choiceScreen, playerParty, simu, map, inbattle;
    JLabel titleText, party, pokemon ,  hp, hpNum;
    Font titleTextFont = new Font("Comic Sans", Font.PLAIN, 60);
    Font startTextFont = new Font("Comic Sans", Font.PLAIN, 30);
    Font battleTextFont = new Font("Comic Sans", Font.PLAIN, 20); //font, font style , font size
    JButton startGameB,loadB, choices[], simB;
    JTextArea choiceTextArea, simBattleArea, showMap;
    JTextArea battleText;

 


     public void createGameScreen(ChoiceHandler c){
        
        //Creating the window
        window = new JFrame(); //initalize the screen object
        window.setSize(800,600); //set the size of the screen. horizontal, vertical
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the screen properly
        window.getContentPane().setBackground(Color.black); //set the background of the screen to be black
        window.setLayout(null); 


        //Title Screen
        title = new JPanel();
        title.setBounds(100,100,600,500);
        title.setBackground(Color.black);
        titleText = new JLabel("Pokemon Maybe");
        titleText.setForeground(Color.white);
        titleText.setFont(titleTextFont);
        title.add(titleText);

        //Start Game
        startGame = new JPanel();
        startGame.setBounds(300,400,200,100);
        startGame.setBackground(Color.black);
        startGame.setLayout(new GridLayout(3,1));
        startGameB = new JButton("Start");
        startGameB.setBackground(Color.black);
        startGameB.setForeground(Color.white);
        startGameB.setFont(startTextFont);
        startGameB.setFocusPainted(false);
        startGameB.addActionListener(c);
        startGameB.setActionCommand("start");
        startGame.add(startGameB);
        loadB = new JButton("Load");
        loadB.setBackground(Color.black);
        loadB.setForeground(Color.white);
        loadB.setFont(startTextFont);
        loadB.setFocusPainted(false);
        loadB.addActionListener(c);
        loadB.setActionCommand("load");
        startGame.add(loadB);

        simB = new JButton("Simulation");
        simB.setBackground(Color.black);
        simB.setForeground(Color.white);
        simB.setFont(startTextFont);
        simB.setFocusPainted(false);
        simB.addActionListener(c);
        simB.setActionCommand("sim");
        startGame.add(simB);
        window.add(title);
        window.add(startGame);

        //Simulation Screen
        simu = new JPanel();
        simu.setBounds(100,100,600,250);
        simu.setBackground(Color.black);

        simBattleArea = new JTextArea();
        simBattleArea.setBounds(100,100,600,250);
        simBattleArea.setBackground(Color.black);
        simBattleArea.setForeground(Color.white);
        simBattleArea.setFont(battleTextFont);
        simBattleArea.setLineWrap(true);
        simu.add(simBattleArea);

        //Choice Screen
        choiceScreen = new JPanel();
        choiceScreen.setBounds(100,100,600,250);
        choiceScreen.setBackground(Color.black);
        window.add(choiceScreen);

        choiceTextArea = new JTextArea();
        choiceTextArea.setBounds(100,100,600,250);
        choiceTextArea.setBackground(Color.black);
        choiceTextArea.setForeground(Color.white);
        choiceTextArea.setFont(battleTextFont);
        choiceTextArea.setLineWrap(true);
        choiceTextArea.setWrapStyleWord(true);
        choiceTextArea.setEditable(false);
        choiceScreen.add(choiceTextArea);

        //Start Choice
        starterChoice = new JPanel();
        starterChoice.setBounds(250,350,300,150);
        starterChoice.setBackground(Color.black);
        starterChoice.setLayout(new GridLayout(5,1));
        window.add(starterChoice);

        choices = new JButton[6];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = new JButton("Choice " + (i + 1));
            choices[i].setOpaque(true);
            choices[i].setBorderPainted(false);
            choices[i].setFocusPainted(false);
            choices[i].setBackground(Color.black);
            choices[i].setForeground(Color.white);
            choices[i].setFont(battleTextFont);
            choices[i].addActionListener(c);
            choices[i].setActionCommand("c" + (i + 1));

            starterChoice.add(choices[i]);
        }

        playerParty = new JPanel(); //Panel for the top stats
        playerParty.setBounds(100,15,600,50);
        playerParty.setBackground(Color.black);
        playerParty.setLayout(new GridLayout(1,4));
        window.add(playerParty);

        party = new JLabel("Party: "); //Text for players party
        party.setFont(battleTextFont);
        party.setForeground(Color.white);
        playerParty.add(party);
        pokemon = new JLabel();
        pokemon.setForeground(Color.white);
        pokemon.setFont(battleTextFont);
        playerParty.add(pokemon);
        hp = new JLabel("Hp: ");
        hp.setForeground(Color.white);
        hp.setFont(battleTextFont);
        playerParty.add(hp);
        hpNum = new JLabel();
        hpNum.setForeground(Color.white);
        hpNum.setFont(battleTextFont);
        playerParty.add(hpNum);

        inbattle = new JPanel();
        inbattle.setBounds(100,100,600,250);
        inbattle.setBackground(Color.black);
        window.add(inbattle);
        
        battleText = new JTextArea();
        battleText.setBounds(100,100,600,250);
        battleText.setBackground(Color.black);
        battleText.setForeground(Color.white);
        battleText.setFont(titleTextFont);
        battleText.setLineWrap(true);
        battleText.setWrapStyleWord(true);
        battleText.setEditable(false);
        inbattle.add(battleText);

        window.setVisible(true);

    } 

    public void updateButton(String c1, String c2, String c3, String c4, String c5, String c6){
        choices[0].setText(c1);
        choices[1].setText(c2);
        choices[2].setText(c3);
        choices[3].setText(c4);
        choices[4].setText(c5);
        choices[5].setText(c6);
    }
}