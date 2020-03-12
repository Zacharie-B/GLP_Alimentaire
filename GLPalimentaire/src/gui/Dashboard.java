package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import beingManagement.BeingCreator;
import data.Consumer;
import data.Producer;
import ecosystemProcess.SavannaEcosystem;
import gui.images.ImagesPreferences;

public class Dashboard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public Dashboard instance;
	
	private Image desert;
	private Image savanna;
	private Image acaciap;
	private Image buffalop;
	private Image bushp;
	private Image cheetahp;
	private Image gazellep;
	private Image giraffep;
	private Image grassp;
	private Image hyenap;
	private Image lionp;
	private Image warthogp;
	private Image zebrap;
	
	private int heightPanel;
	private int widthPanel;
	private int squareSide;
	private BeingCreator bc= new BeingCreator("Savanna");
	
	

	public void setPicture() throws IOException {
		try {
            this.desert = ImageIO.read(new File(ImagesPreferences.DESERT_IMG_BACKGROUND_PATH));
            this.savanna = ImageIO.read(new File(ImagesPreferences.SAVANNA_IMG_BACKGROUND_PATH));
            this.acaciap= ImageIO.read(new File(ImagesPreferences.ACACIA_IMG_BACKGROUND_PATH));
            this.buffalop = ImageIO.read(new File(ImagesPreferences.BUFFALO_IMG_BACKGROUND_PATH));
            this.bushp = ImageIO.read(new File(ImagesPreferences.BUSH_IMG_BACKGROUND_PATH));
            this.cheetahp = ImageIO.read(new File(ImagesPreferences.CHEETAH_IMG_BACKGROUND_PATH));
            this.gazellep = ImageIO.read(new File(ImagesPreferences.GAZELLE_IMG_BACKGROUND_PATH));
            this.giraffep= ImageIO.read(new File(ImagesPreferences.GIRAFFE_IMG_BACKGROUND_PATH));
            this.grassp= ImageIO.read(new File(ImagesPreferences.GRASS_IMG_BACKGROUND_PATH));
            this.hyenap = ImageIO.read(new File(ImagesPreferences.HYENA_IMG_BACKGROUND_PATH));
            this.lionp = ImageIO.read(new File(ImagesPreferences.LION_IMG_BACKGROUND_PATH));
            this.warthogp = ImageIO.read(new File(ImagesPreferences.WARTHOG_IMG_BACKGROUND_PATH));
            this.zebrap = ImageIO.read(new File(ImagesPreferences.ZEBRA_IMG_BACKGROUND_PATH));
            repaint();
        } 
        catch (IOException e) {
            throw new IOException(" one/some files are not found", e);
        }
	}

	public Dashboard(){
		super();
	}

	
	public Dashboard getInstance() {
		return this;
	}
    
	
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    		//BeingCreator bc= new BeingCreator("Savanna");
        	heightPanel = getHeight();
        	widthPanel = getWidth();
        	squareSide = heightPanel/3;
            Graphics2D g2d = (Graphics2D)g;
            /*g2d.setColor(Color.green);
            g2d.fillRect(0, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(widthPanel/2, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.cyan);
            g2d.fillRect(0, heightPanel/2, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.blue);
            g2d.fillRect(widthPanel/2 - squareSide/2,heightPanel/2 - squareSide/2, squareSide, squareSide);*/
            
            //g2d.drawImage(desert, widthPanel/2, heightPanel/2, widthPanel/2, heightPanel/2, this);
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(0,0, widthPanel, heightPanel);
            
            DisplayPictureProducer1(acaciap, g2d, SavannaEcosystem.acacia);
            DisplayPictureProducer1(bushp, g2d, SavannaEcosystem.bush);
            DisplayPictureProducer1(grassp, g2d, SavannaEcosystem.grass);
            DisplayPictureConsumer1(buffalop,g2d, SavannaEcosystem.buffalo);
            DisplayPictureConsumer1(cheetahp,g2d, SavannaEcosystem.cheetah);
            DisplayPictureConsumer1(gazellep,g2d, SavannaEcosystem.gazelle);
            DisplayPictureConsumer1(giraffep,g2d, SavannaEcosystem.giraffe);
            DisplayPictureConsumer1(hyenap,g2d, SavannaEcosystem.hyena);
            DisplayPictureConsumer1(lionp,g2d, SavannaEcosystem.lion);
            DisplayPictureConsumer1(warthogp,g2d, SavannaEcosystem.warthog);
            DisplayPictureConsumer1(zebrap,g2d, SavannaEcosystem.zebra);

            /*for(i=62;i<67;i++) {
            if (((Consumer) bc.allAnimals[i]).getIsAlive()==true) {
        	g2d.drawImage(lionp,(((Consumer) bc.allAnimals[i]).getCordinates().getX()*widthPanel)/30, 
        			(((Consumer) bc.allAnimals[i]).getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            }*/
            
        			
        }	
    

private void DisplayPictureConsumer1(Image image, Graphics2D g2d, Consumer species) {
	if (image!=null && species.getIsAlive()==true) {
		g2d.drawImage(image,(species.getCordinates().getX()*widthPanel)/30, 
      			(species.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
        }
	}

private void DisplayPictureProducer1(Image image, Graphics2D g2d, Producer species) {
	if (image!=null && species.getIsAlive()==true) {
		g2d.drawImage(image,(species.getCordinates().getX()*widthPanel)/30, 
      			(species.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
        }
	}


    @SuppressWarnings("unused")
	private void DisplayPictureConsumer(Image image, Graphics2D g2d, Consumer[] species, int i) {
    	if (image!=null && species[i].getIsAlive()==true) {
    		g2d.drawImage(image,(species[i].getCordinates().getX()*widthPanel)/30, 
          			(species[i].getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
    	}
    @SuppressWarnings("unused")
	private void DisplayPictureProducer(Image image, Graphics2D g2d, Producer[] species, int i) {
    	if (image!=null && species[i].getIsAlive()==true) {
    		g2d.drawImage(image,(species[i].getCordinates().getX()*widthPanel)/30, 
          			(species[i].getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
    	}
}
    
