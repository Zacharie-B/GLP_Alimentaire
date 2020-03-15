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
import gui.images.ImagesPreferences;

public class Dashboard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public Dashboard instance;
	
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
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	

	public void setPicture() throws IOException {
		try {
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
        try {
			setPicture();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		//BeingCreator bc= new BeingCreator("Savanna");
        	heightPanel = getHeight();
        	widthPanel = getWidth();
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
            
                    	
            DisplayPictureProducer(grassp, g2d,"grass");
            DisplayPictureProducer(bushp, g2d,"bush");
           	DisplayPictureProducer(acaciap, g2d,"acacia");
      		DisplayPictureConsumer(gazellep, g2d,"gazelle");
            DisplayPictureConsumer(giraffep, g2d,"giraffe");
            DisplayPictureConsumer(hyenap, g2d,"hyena");
            DisplayPictureConsumer(warthogp, g2d,"warthog");
            DisplayPictureConsumer(lionp, g2d,"lion");
            DisplayPictureConsumer(cheetahp, g2d,"cheetah");
            DisplayPictureConsumer(buffalop, g2d,"buffalo");
            DisplayPictureConsumer(zebrap, g2d,"zebra");
            
            g.setColor(Color.BLACK);
            g.drawLine(widthPanel/2, 0, widthPanel/2, heightPanel);
            g.drawLine(0, heightPanel/2, widthPanel, heightPanel/2);   
        			
        }	
    

	private void DisplayPictureConsumer(Image image, Graphics2D g2d, String name) {
		Consumer[] consumer = new Consumer[10];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		for(int i=0;i<10;i++) {
    	if (image!=null && consumer[i].getIsAlive()==true) {
    		g2d.drawImage(image,(consumer[i].getCordinates().getX()*widthPanel)/18, 
          			(consumer[i].getCordinates().getY()*heightPanel)/12, widthPanel/27, heightPanel/18, this);
            }
		}
    	}
	private void DisplayPictureProducer(Image image, Graphics2D g2d, String name) {
		Producer[] producer = new Producer[10];
		producer=(Producer[]) animalsInSavana.getTable(name);
		for(int i=0; i<10;i++) {
    	if (image!=null && producer[i].getIsAlive()==true) {
    		g2d.drawImage(image,(producer[i].getCordinates().getX()*widthPanel)/18, 
          			(producer[i].getCordinates().getY()*heightPanel)/12, widthPanel/27, heightPanel/18, this);
            }
		};
    	}
}
    
