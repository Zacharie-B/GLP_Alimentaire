package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import data.Consumer;
import data.Position;
import data.tertiaryConsumerdata.Lion;
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
            throw new IOException(ImagesPreferences.DESERT_IMG_BACKGROUND_PATH +" introuvable", e);
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
    	if(desert!=null && savanna!=null && acaciap!=null && buffalop!=null && bushp!=null && cheetahp!=null && gazellep!=null
    			&& giraffep!=null && grassp!=null && hyenap!=null && lionp!=null && warthogp!=null && zebrap!=null){
        	heightPanel = getHeight();
        	widthPanel = getWidth();
        	squareSide = heightPanel/3;
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.green);
            g2d.fillRect(0, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(widthPanel/2, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.cyan);
            g2d.fillRect(0, heightPanel/2, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.blue);
            g2d.fillRect(widthPanel/2 - squareSide/2,heightPanel/2 - squareSide/2, squareSide, squareSide);
            
            
            g2d.drawImage(desert, widthPanel/2, heightPanel/2, widthPanel/2, heightPanel/2, this);
            g2d.drawImage(savanna,0,0, widthPanel/2, heightPanel/2, this);
            if (SavannaEcosystem.acacia.getIsAlive()==true) {
        	g2d.drawImage(acaciap,(SavannaEcosystem.acacia.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.acacia.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.buffalo.getIsAlive()==true) {
        	g2d.drawImage(buffalop,(SavannaEcosystem.buffalo.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.buffalo.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.bush.getIsAlive()==true) {
        	g2d.drawImage(bushp,(SavannaEcosystem.bush.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.bush.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.cheetah.getIsAlive()==true) {
        	g2d.drawImage(cheetahp,(SavannaEcosystem.cheetah.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.cheetah.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.gazelle.getIsAlive()==true) {
        	g2d.drawImage(gazellep,(SavannaEcosystem.gazelle.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.gazelle.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.giraffe.getIsAlive()==true) {
        	g2d.drawImage(giraffep,(SavannaEcosystem.giraffe.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.giraffe.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.grass.getIsAlive()==true) {
        	g2d.drawImage(grassp,(SavannaEcosystem.grass.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.grass.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.hyena.getIsAlive()==true) {
        	g2d.drawImage(hyenap,(SavannaEcosystem.hyena.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.hyena.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.lion.getIsAlive()==true) {
        	g2d.drawImage(lionp,(SavannaEcosystem.lion.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.lion.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.warthog.getIsAlive()==true) {
        	g2d.drawImage(warthogp,(SavannaEcosystem.warthog.getCordinates().getX()*widthPanel)/30, 
          			(SavannaEcosystem.warthog.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
            if (SavannaEcosystem.zebra.getIsAlive()==true) {
        	g2d.drawImage(zebrap,(SavannaEcosystem.zebra.getCordinates().getX()*widthPanel)/30, 
        			(SavannaEcosystem.zebra.getCordinates().getY()*heightPanel)/20, widthPanel/30, heightPanel/20, this);
            }
        	repaint();		
        }	
    }
}
