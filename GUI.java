import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class implementing a graphical based user interface.
 */
public class GUI extends JFrame
{
	private JTextField challenge;
	private JTextField response;

	public GUI(){
	}
	/** handles user input and updates JFrame as needed.
	 * 
	 * @param game is the Studymethod.
	 * could be Leitner, drill, or simple
	 */
	public void display(StudyMethod game){
		JFrame frame = new JFrame();
		GridLayout gbl_panel = new GridLayout(3,1);
		JPanel panel = new JPanel();

		response = new JTextField("");
		challenge = new JTextField("");
		double n = Math.random();
		if (n < 0.5) {
			challenge.setText(game.getFront());
		}
		else{
			challenge.setText(game.getBack());
		}
		JButton dont = new JButton("I Don't Know");
		JButton flip = new JButton("Flip Card");
		JButton know = new JButton("I Know");
		JButton exit = new JButton("Exit");
		panel.add(dont);
		panel.add(flip);
		panel.add(know);
		panel.add(exit);

		frame.setLayout(gbl_panel);
		frame.add(challenge);
		frame.add(response);
		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600,600);
		/**
		 * 
		 * Inner class implements ActionListener
		 *	Checks to see if a button is pressed
		 *	and handles user input appropriately.
		 */
		class ButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == flip){
					challenge.setText(game.getAnswer());
					System.out.println("Cheater");
				}
				if(e.getSource() == dont){
					boolean wrong = false;
					game.moveCard(wrong);
					System.out.println("Wrong!");
					double n = Math.random();
					if (n < 0.5) {
						challenge.setText(game.getFront());
					}
					else{
						challenge.setText(game.getBack());
					}
				}
				if(e.getSource()==know){
					String input = response.getText();
					boolean correct = game.testAnswer(input);
					game.moveCard(correct);
					double n = Math.random();
					if (n < 0.5) {
						challenge.setText(game.getFront());
						response.setText("");
					}
					else{
						challenge.setText(game.getBack());
						response.setText("");
					}
				}
				if(e.getSource()==exit){
					frame.dispose();
				}
			}
		}
		ActionListener listen = new ButtonListener();
		dont.addActionListener(listen);
		flip.addActionListener(listen);
		know.addActionListener(listen);
		exit.addActionListener(listen);
	}
}