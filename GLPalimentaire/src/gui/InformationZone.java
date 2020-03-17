package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beingManagement.BeingCreator;
import data.Consumer;
import ecosystemProcess.SavannaEcosystem;

public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//debut:test
	private JLabel labelInformation = new JLabel("Information");
	private JLabel labeltopleft  = new JLabel("");
	private JLabel labeltopright  = new JLabel("");
	private JLabel labelbottomleft  = new JLabel("");
	private JLabel labelbottomright  = new JLabel("");
	@SuppressWarnings("unused")
	private SavannaEcosystem se= new SavannaEcosystem();
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);
	
	private BeingCreator animals = BeingCreator.getInstance();
	//fin:test
	
	@SuppressWarnings("unused")
	private JTextField textFieldInformation = new JTextField();
	
	public JLabel getLabelInformation() {
		return labelInformation;
	}

	public void setLabelInformation(JLabel labelInformation) {
		this.labelInformation = labelInformation;
	}

	public JLabel getLabeltopleft() {
		return labeltopleft;
	}

	public void setLabeltopleft(JLabel labeltopleft) {
		this.labeltopleft = labeltopleft;
	}

	public JLabel getLabeltopright() {
		return labeltopright;
	}

	public void setLabeltopright(JLabel labeltopright) {
		this.labeltopright = labeltopright;
	}

	public JLabel getLabelbottomleft() {
		return labelbottomleft;
	}

	public void setLabelbottomleft(JLabel labelbottomleft) {
		this.labelbottomleft = labelbottomleft;
	}

	public JLabel getLabelbottomright() {
		return labelbottomright;
	}

	public void setLabelbottomright(JLabel labelbottomright) {
		this.labelbottomright = labelbottomright;
	}

	public InformationZone(){
		labelInformation.setFont(font);
		labeltopleft.setFont(font);
		labeltopright.setFont(font);
		labelbottomleft.setFont(font);
		labelbottomright.setFont(font);
	}
	
	public void CounterSpecies() {
		CounterInLife("lion");
		CounterInLife("zebra");
		CounterInLife("hyena");
		CounterInLife("giraffe");
	}
	
	public void CounterInLife(String name) {
		Consumer[] consumer = new Consumer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animals.getTable(name);
		String displayonlabeltl = name+" : ";
		String displayonlabeltr = name+" : ";
		String displayonlabelbl = name+" : ";
		String displayonlabelbr = name+" : ";
		int countertl=0;
		int countertr=0;
		int counterbl=0;
		int counterbr=0;
		for(int i=0;i<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			if(consumer[i].getPopulationDensity()!=0){
				if(consumer[i].getCordinates().getX()<9&&consumer[i].getCordinates().getY()<6) {
					countertl+=consumer[i].getPopulationDensity();
				}
				else if (consumer[i].getCordinates().getX()>9&&consumer[i].getCordinates().getY()<6) {
					countertr+=consumer[i].getPopulationDensity();
				}
				else if (consumer[i].getCordinates().getX()<9&&consumer[i].getCordinates().getY()>6) {
					counterbl+=consumer[i].getPopulationDensity();
				}
				else {
					counterbr+=consumer[i].getPopulationDensity();
				}
			}
		}
		String.valueOf(countertl);
		displayonlabeltl+=countertl;
		labeltopleft.setText(displayonlabeltl);
		
		String.valueOf(countertr);
		displayonlabeltr+=countertr;
		labeltopright.setText(displayonlabeltr);
		
		String.valueOf(counterbl);
		displayonlabelbl+=counterbl;
		labelbottomleft.setText(displayonlabelbl);
		
		String.valueOf(counterbr);
		displayonlabelbr+=counterbr;
		labelbottomright.setText(displayonlabelbr);
	}
	
}
