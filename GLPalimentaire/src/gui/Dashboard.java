package gui;

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
	
	private JPanel panneau = new JPanel();
	
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
        if(image!=null){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
