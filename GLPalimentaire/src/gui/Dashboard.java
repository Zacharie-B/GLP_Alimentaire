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

public class Dashboard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	
	private Image image;
	
	public Dashboard(){
		super();
	}
	
	public Dashboard(Image image){
		super();
		setImage(image);
	}
	
	public Dashboard(String path) throws IOException {
        super();
        setImage(path);
    }
	
	public void setImage(Image image) {
        this.image = image;
        repaint();
    }
	
	public void setImage(String path) throws IOException {
        try {
            this.image = ImageIO.read(new File(path));
            repaint();
        } 
        catch (IOException e) {
            throw new IOException(path+" introuvable", e);
        }
    }
	
	public Image getImage() {
        return image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	if(image!=null){
        	int heightPanel = getHeight();
        	int widthPanel = getWidth();
        	int squareSide = heightPanel/3;
        	System.out.println(widthPanel + "and" + heightPanel);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.green);
            g2d.fillRect(0, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(widthPanel/2, 0, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.cyan);
            g2d.fillRect(0, heightPanel/2, widthPanel/2, heightPanel/2);
            g2d.setColor(Color.orange);
            g2d.drawImage(image, widthPanel/2, heightPanel/2, widthPanel/2, heightPanel/2, this);
            g2d.setColor(Color.blue);
            g2d.fillRect(widthPanel/2 - squareSide/2,heightPanel/2 - squareSide/2, squareSide, squareSide);
        }	
    }
}
