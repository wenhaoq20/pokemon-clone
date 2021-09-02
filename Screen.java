
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class Screen{
    JFrame window;
    Container con;
    JPanel gamePanel, startPanel, battleScreen;
    JLabel gamePanelText; 
    Font titleTextFont = new Font("Comic Sans", Font.PLAIN, 60);
    Font startTextFont = new Font("Comic Sans", Font.PLAIN, 30);
    Font battleTextFont = new Font("Comic Sans", Font.PLAIN, 20); //font, font style , font size
    JButton startGame, loadGame;
    JTextArea battleText;

    startScreenHandler ssHandler = new startScreenHandler();

    public static void main(String[] args){
        new Screen();
    }

    public Screen(){
        
        //Creating the window
        window = new JFrame(); //initalize the screen object
        window.setSize(800,600); //set the size of the screen. horizontal, vertical
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the screen properly
        window.getContentPane().setBackground(Color.black); //set the background of the screen to be black
        window.setLayout(null); 
        con = window.getContentPane();


        //Creating the title/panel
        gamePanel = new JPanel();
        gamePanel.setBounds(100,100,600,150); //set the panel location to x,y,width,height
        gamePanel.setBackground(Color.white);

        startPanel = new JPanel();
        startPanel.setBounds(300,350,200,100);
        startPanel.setBackground(Color.white);

        //Button
        startGame = new JButton("START");
        startGame.setBackground(Color.black); //color of the button
        startGame.setForeground(Color.white); //color of the text
        startGame.setFont(startTextFont);
        startGame.addActionListener(ssHandler);

        //Create the text
        gamePanelText = new JLabel("POKEMON MAYBE"); 
        gamePanelText.setBackground(Color.black); //set the text color
        gamePanelText.setFont(titleTextFont);
        

        gamePanel.add(gamePanelText); //add text to the background
        startPanel.add(startGame);
        con.add(gamePanel); //add title background to the container 
                            //text,panel,container
        con.add(startPanel);
        window.setVisible(true);
    }

    public void createGameScreen(){
        gamePanel.setVisible(false);
        startPanel.setVisible(false);
        battleScreen = new JPanel();
        battleScreen.setBounds(100,100,600,250);
        battleScreen.setBackground(Color.white);
        con.add(battleScreen);

        battleText = new JTextArea("\n" + "type a do normal attack" + "\n" + "type sa to do special attack" + "\n"
        + "type stat to view your stats" + "\n" + "type r to run" + "\n"
        + "type switch to switch to another pokemon in your party");
        battleText.setBounds(100,100,600,250);
        battleText.setBackground(Color.black);
        battleText.setForeground(Color.white);
        battleText.setFont(battleTextFont);
        battleText.setLineWrap(true); //text will automatically cut off
        battleScreen.add(battleText);
    }

    public class startScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
}