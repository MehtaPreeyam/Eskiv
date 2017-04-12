package eskiv;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class EnemyBall 
{
    private int xPos;
    private int yPos;
    private int right, left, up, down = 0;
    boolean horizontal;
    boolean l=false;
    boolean d=false;
   
    public EnemyBall(int x, int y, boolean horizontal) 
    {
        xPos = x;
        yPos = y;
        this.horizontal=horizontal;
    }
    public void paint(Graphics g) 
    {
        g.fillOval(xPos, yPos, 20, 20);
    }
    public void move() 
    {
        if (horizontal)
        {
        	if (xPos<150)
        	{
        		xPos=150;
        		l=false;
			}
        	if (xPos>632)
       		{
       		  	xPos=632;
       		  	l=true;
			}
         	if (l==true)
         		xPos--;
         	else
         		xPos++;
		}
		else
		{
			if (yPos<13)
			{
				yPos=13;
				d=true;
			}
			if (yPos>383)
			{
				yPos=383;
				d=false;
			}
			
			if (d==true)
				yPos++;
			else
         		yPos--;
		}
    }
    public Rectangle getBorder() 
    {
        return new Rectangle(xPos, yPos, 20, 20);
    }
}
