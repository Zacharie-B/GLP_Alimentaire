package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationZone extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 18);
	
	private OperationZone instance = this;
	public static boolean stop = true;
	
	private JButton buttonLeave = new JButton("Leave");
	private JButton stopButton = new JButton("Stop");
	private JButton buttonDisaster = new JButton("Disaster");
	
	public OperationZone(){
		add(buttonDisaster);
		stopButton.setFont(font);
		stopButton.addActionListener(new StartStopAction());
		add(stopButton);
		add(buttonLeave);
	}
	
	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				stopButton.setText("Stop");
			} else {
				stop = false;
				stopButton.setText("Restart");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
