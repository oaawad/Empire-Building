package view;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import engine.Game;
public class StartGame extends JFrame implements ActionListener
{

	 private JTextField name;
	 private JPanel buttonPanel;
	 private GameView gameView;	
	 private final JComboBox<String> cb;
	
	
    public static void main(String[] args)
    { StartGame buttonGUI = new StartGame();
	buttonGUI.setVisible(true);
    }
   
    public StartGame()
{
    super();
    setTitle("The Conqueror"); 
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setVisible(true);
    GameView gameView = new GameView();
    buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.WHITE); 
    
    JLabel lbl = new JLabel("Enter player name.");
    lbl.setBounds(10, 20, 80, 25);
    buttonPanel.add(lbl);
    
    name = new JTextField(16);
    buttonPanel.add(name);
    
    JLabel lbl2 = new JLabel("Select one of the possible cities");
    buttonPanel.add(lbl2);
    
    String[] choices = { "Cairo","Roma", "Sparta"};
    cb = new JComboBox<String>(choices);
    buttonPanel.add(cb);   
    
    JButton button1 = new JButton("Continue");
    button1.addActionListener(this);
    buttonPanel.add(button1);
    
    
    this.setContentPane(buttonPanel);
    
}

    public void actionPerformed(ActionEvent e)
    {
    	String nameStr = name.getText();
    	String cityStr = (String) cb.getSelectedItem();
    	try {
			Game g = new Game(nameStr,cityStr);
			System.out.println(cityStr);
		} catch (IOException e1) {
			System.out.println("BLABLA");
		}
    	
    }
}
