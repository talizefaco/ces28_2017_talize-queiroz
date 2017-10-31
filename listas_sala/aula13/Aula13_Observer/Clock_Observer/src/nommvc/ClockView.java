package nommvc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * ClockView is a GUI for Clock
 * Is the concrete observer
 */
public class ClockView implements Observer {
	
	public ClockView() {
		this.mountDisplay();
		clock.addObserver(this); // Each object is an observer of the observable (clock)
		
		Thread clockT = new Thread(clock);
		clockT.start();
	}
	
	public void mountDisplay() {
		JPanel panel = new JPanel();

		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Arial", Font.ITALIC, 25));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);

		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		label.setText(clock.getTime());
	}
	
	public void update(Observable o, Object arg) {
			System.out.println("Hora: " + arg);
			label.setText((String) arg);
	}
	
	private Clock clock = new Clock();
	private JLabel label = new JLabel();
	private static JFrame frame = new JFrame("Clock :D");
}