package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import naturalNeedsManagement.ActionUser;


public class OperationZone extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private OperationZone instance = this;
	private ActionUser au = new ActionUser();
	
	public static boolean stop = true;
	public static String ecosystem="";
	
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
		stopButton.setBackground(Color.black);
		stopButton.setForeground(Color.white);
		stopButton.addActionListener(new StartStopAction());
		buttonBackMenu.setFont(font);
		buttonBackMenu.setBackground(Color.black);
		buttonBackMenu.setForeground(Color.white);
		buttonBackMenu.addActionListener(new StartMenu());
		buttonFire.setFont(font);
		buttonFire.setBackground(Color.black);
		buttonFire.setForeground(Color.white);
		buttonFire.addActionListener(new ActionForestFire());
		sicknessButton.setFont(font);
		sicknessButton.setBackground(Color.black);
		sicknessButton.setForeground(Color.white);
		sicknessButton.addActionListener(new ActionDiseases());
		fastReproductButton.setFont(font);
		fastReproductButton.setBackground(Color.black);
		fastReproductButton.setForeground(Color.white);
		
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
	
	private class StartMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new StartWindow();
			StartStopAction startstop = new StartStopAction();
			startstop.actionPerformed(e);
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
