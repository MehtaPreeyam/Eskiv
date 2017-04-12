package eskiv; 
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JButton;


public class Eskiv extends JPanel implements KeyListener, ActionListener, Runnable 
	{
		EskivBall ball = new EskivBall(500, 300);
	    BufferedImage image;
	    Thread gameThread; 
	    ArrayList <EnemyBall> balls = new ArrayList<EnemyBall>();
		Food target = new Food(250, 150);
		boolean death = false;
		int score = 0;
		int highScore = 0;
		boolean rand = (int)(Math.random() * 2)==0;
		int height = (int)(Math.random() * 420);
		int width = (int)(Math.random() * 500) + 150;
		EnemyBall ball1 = new EnemyBall (width,height,rand);
		JButton myButton = new JButton("NEW GAME");
		
		public Eskiv() 
		{
			balls.add(ball1);
			setFocusable(true);
			JFrame frame = new JFrame("Eskiv");
			frame.setSize(672, 450);
			frame.add(this);
			frame.setVisible(true);
			addKeyListener(this);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			myButton.setBounds(20, 100, 100, 30);
			add(myButton);
			myButton.addActionListener(this);

		}
    
		public void start()
		{
			gameThread = new Thread(this);
			gameThread.start();
		}

		@SuppressWarnings("deprecation")
		public void stop()
		{
			gameThread.stop();
			gameThread = null;
		}

		public static void main(String args[]) throws IOException
		{
			Eskiv app=new Eskiv();
			app.start();
		}
		
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g.drawImage(image, 0, 0, null);
	        g.setColor(Color.black);
	        ball.paint(g2d);
	        g.setColor(Color.gray);
	        target.paint(g2d);
	        g.setColor(Color.blue);
	        g.fillRect(0, 0, 148,450);
	        g.setColor(Color.white);
	        g2d.drawString("Score: "+score, 43, 200);
	        g2d.drawString("Highscore: "+highScore, 30, 220);
	        
	        if (death)
	        {
	        	g.setColor(Color.black);
	        	g2d.drawString("Game Over", 380, 80);
	        }
	       
	        //Color Colo = new Color(252, 0, 0);
	        for (int x = 0;x<balls.size();x++)
	        {
	        	g.setColor(Color.blue);
	        	balls.get(x).paint(g2d);
	        }
	        
	        
		}
		
		public void keyPressed(KeyEvent e) 
		{
			ball.pKey(e);
		   	 System.out.println("f");
		}	
   
		public void keyReleased(KeyEvent e) 
		{
			ball.rKey(e);
		}
		
    public void keyTyped(KeyEvent e) {}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == myButton){
			death=false;
			balls.clear();
			repaint(); 
			highScore=0;
			score=0;
			Eskiv app = new Eskiv(); 
			app.start();
		}
	}

	@Override
	public void run() {
	     while (!death) 
	    	
	        {
	            ball.move();
	            for (int x = 0;x<balls.size();x++)
	            {
	            	balls.get(x).move();
	            }
	            if (target.getBorder().intersects(ball.getBorder()))
	            {
					rand = (int)(Math.random() * 2) == 0;
					height = (int)(Math.random() * 370) + 13;
					width = (int)(Math.random() * 482) + 150;
					EnemyBall ball1 = new EnemyBall (width,height,rand);
					balls.add(ball1);
					int targetX = (int)(Math.random() * 500) + 150;
					int targetY = (int)(Math.random() * 380);
					target.CxPos(targetX);
					target.CyPos(targetY);
					score = score + 5;
				}
	            
	            for (int x = 0;x<balls.size();x++)
	            {
					if (balls.get(x).getBorder().intersects(ball.getBorder()))
						death = true;
				}
         
	            try {
	                Thread.sleep(3);
	            } catch (Exception e) {}
	            repaint();
	        }
	        
	        if (death)
         {
         	if (highScore<score)
         		highScore=score;
         }
		
	}
}