package eskiv;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Food {
    
	private int xPos;
    private int yPos;
    
    public Food(int x, int y) 
    {
        xPos = x;
        yPos = y;
    }
    
    public void CxPos(int x)
    {
		xPos = x;
	}
    
    public void CyPos(int x)
    {
		yPos = x;
	}
    
    public void paint(Graphics g) 
    {
	        g.fillRect(xPos, yPos, 20, 20);
    }
    
    public Rectangle getBorder() 
    {
        return new Rectangle(xPos, yPos, 20, 20);
    }
}