package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testttt extends JFrame implements ActionListener {
	
	private JFrame frame;
    private JPanel gameView, loginView;
    private JTextField tfield;
	private JButton nextButton,backButton;
	
	public Testttt() {
		frame = new JFrame("BLAAAAA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginView = new JPanel();
		gameView = new JPanel();
		JTextField tfield = new JTextField(10);

		JButton nextButton = new JButton("NEXT");
		JButton backButton = new JButton("BACK");
        nextButton.addActionListener(this);
        nextButton.setActionCommand("NEXT");
        backButton.addActionListener(this);
        backButton.setActionCommand("BACK");

        loginView.add(tfield);
        loginView.add(nextButton);
        gameView.add(backButton);

        setContentPane(loginView);
        setSize(220, 220);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
    {
            if (ae.getActionCommand().equals("NEXT"))
            {   
                /*
                 * this will remove the first panel 
                 * and add the new panel to the frame.
                 */
                frame.remove(loginView);
                frame.setContentPane(gameView);
            }
            else if (ae.getActionCommand().equals("BACK"))
            {
                frame.remove(gameView);
                frame.setContentPane(loginView);
            }
            frame.validate();
            frame.repaint(); // prefer to write this always.
    } 
	
	public static void main(String[] args)
    {   
        
        Testttt t = new Testttt();
    }
	
}
