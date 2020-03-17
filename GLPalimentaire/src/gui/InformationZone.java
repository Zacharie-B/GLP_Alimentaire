package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import beingManagement.BeingCreator;
import data.Consumer;
import ecosystemProcess.SavannaEcosystem;

public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextArea areatopleft = new JTextArea(2,1);
	private JTextArea areatopright = new JTextArea(2,1);
	private JTextArea areabottomleft = new JTextArea(2,1);
	private JTextArea areabottomright = new JTextArea(2,1);
	//debut:test
	private JLabel labelInformation = new JLabel("Information");
	public JTextArea getAreatopright() {
		return areatopright;
	}

	public void setAreatopright(JTextArea areatopright) {
		this.areatopright = areatopright;
	}

	public JTextArea getAreabottomleft() {
		return areabottomleft;
	}

	public void setAreabottomleft(JTextArea areabottomleft) {
		this.areabottomleft = areabottomleft;
	}

	public JTextArea getAreabottomright() {
		return areabottomright;
	}

	public void setAreabottomright(JTextArea areabottomright) {
		this.areabottomright = areabottomright;
	}

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

	

	public InformationZone(){
		labelInformation.setFont(font);
		areatopleft.setFont(font);
		areatopright.setFont(font);
		areabottomleft.setFont(font);
		areabottomright.setFont(font);
	}
	
	public void CounterSpecies() {
		CounterInLife("hyena");
		//CounterInLife("giraffe");
	}
	
	public JTextArea getAreatopleft() {
		return areatopleft;
	}

	public void setAreatopleft(JTextArea areatopleft) {
		this.areatopleft = areatopleft;
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
		int hpcounttl=0;
		int hpcounttr=0;
		int hpcountbl=0;
		int hpcountbr=0;
		for(int i=0;i<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			if(consumer[i].getPopulationDensity()!=0){
				if(consumer[i].getCordinates().getX()<9&&consumer[i].getCordinates().getY()<6) {
					countertl+=consumer[i].getPopulationDensity();
					String.valueOf(countertl);
					hpcounttl+=consumer[i].getHp();
					String.valueOf(hpcounttl);
					
				}
				else if (consumer[i].getCordinates().getX()>9&&consumer[i].getCordinates().getY()<6) {
					countertr+=consumer[i].getPopulationDensity();
					String.valueOf(countertr);
					hpcounttr+=consumer[i].getHp();
					String.valueOf(hpcounttr);
				}
				else if (consumer[i].getCordinates().getX()<9&&consumer[i].getCordinates().getY()>6) {
					counterbl+=consumer[i].getPopulationDensity();
					String.valueOf(counterbl);
					hpcountbl+=consumer[i].getHp();
					String.valueOf(hpcountbl);
				}
				else {
					counterbr+=consumer[i].getPopulationDensity();
					String.valueOf(counterbr);
					hpcountbr+=consumer[i].getHp();
					String.valueOf(hpcountbr);
				}
			}
			
		}
		displayonlabeltl+=countertl+"\n";
		displayonlabeltl+=" hp :"+hpcounttl;
		displayonlabeltr+=countertr+"\n";
		displayonlabeltr+=" hp :"+hpcounttr;
		displayonlabelbl+=counterbl+"\n";
		displayonlabelbl+=" hp :"+hpcountbl;
		displayonlabelbr+=counterbr+"\n";
		displayonlabelbr+=" hp :"+hpcountbr;
		
		areatopleft.setText(displayonlabeltl);
		areatopright.setText(displayonlabeltr);
		areabottomleft.setText(displayonlabelbl);
		areabottomright.setText(displayonlabelbr);
	}
	
}
