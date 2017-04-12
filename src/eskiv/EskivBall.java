package eskiv;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class EskivBall 
	{
	    private int xPos;
	    private int yPos;
	    private int right, left, up, down = 0;
	    
	    public EskivBall(int x, int y) 
	    {
	        xPos = x;
	        yPos = y;
	    }
    
	    public void paint(Graphics g) 
	    {
	        g.fillOval(xPos, yPos, 25, 25);
	    }
	    
	    public void move() 
	    {
	    	if (xPos < 150)
	    		xPos = 150;
			if (xPos > 632)
				xPos = 632;
	        
			xPos += left + right;
	        
			if (yPos > 383)
				yPos = 383;
	        if (yPos < 13)
	        	yPos = 13;
	        
	        yPos += up + down;
	    }
    
	    public void pKey(KeyEvent e) 
	    {
	        if (e.getKeyCode() == KeyEvent.VK_DOWN)
	            down = 1;
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	            right = 1;
	        if (e.getKeyCode() == KeyEvent.VK_UP)
	            up = -1;
	        if (e.getKeyCode() == KeyEvent.VK_LEFT)
	            left = -1;
	    }
	    
	    public void rKey(KeyEvent e) 
	    {
	        if (e.getKeyCode() == KeyEvent.VK_DOWN)
	            down = 0;
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	            right = 0;
	        if (e.getKeyCode() == KeyEvent.VK_UP)
	            up = 0;
	        if (e.getKeyCode() == KeyEvent.VK_LEFT)
	            left = 0;
	    }
	    
	    public Rectangle getBorder() 
	    {
	        return new Rectangle(xPos, yPos, 25, 25);
	    }
}