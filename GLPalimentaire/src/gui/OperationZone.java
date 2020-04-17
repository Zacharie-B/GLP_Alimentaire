package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import naturalNeedsManagement.ActionUser;


public class OperationZone extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);
	
	private OperationZone instance = this;
	private ActionUser au = new ActionUser();
	
	public static boolean stop = true;
	public static String ecosystem;
	
	private JButton buttonBackMenu = new JButton("Back");
	private JButton stopButton = new JButton("Stop");
	private JButton buttonFire = new JButton("forest in fire");	
	private JButton fastReproductButton = new JButton("FastReproduct");
	private JButton sicknessButton = new JButton("virulent diseases");
	

	public JButton getSicknessButton() {
		return sicknessButton;
	}

	public OperationZone() {
		stopButton.setFont(font);
		stopButton.addActionListener(new StartStopAction());
		buttonBackMenu.setFont(font);
		buttonFire.setFont(font);
		buttonFire.addActionListener(new ActionForestFire());
		sicknessButton.setFont(font);
		sicknessButton.addActionListener(new ActionDiseases());
		fastReproductButton.setFont(font);
		
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
	
	private class ActionForestFire implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			au.ForestFire();
		}
	}
	
	private class ActionDiseases implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			au.Sickness();
		}
	}

	public JButton getButtonBackMenu() {
		return buttonBackMenu;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public JButton getButtonDisaster() {
		return buttonFire;
	}

	public JButton getFastReproductButton() {
		return fastReproductButton;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
