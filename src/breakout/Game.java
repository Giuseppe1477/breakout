package breakout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.Scanner;

import javax.swing.JPanel;
public class Game extends JPanel implements KeyListener,ActionListener 
{
	Random rn = new Random();
	int delay = 8;
	Timer timer;
	ArrayList <Brick> bricks = new ArrayList <> ();
	Scanner scan = new Scanner(System.in);
	Main main = new Main();
	
	public Game()
	{
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		for(int i = 60; i <= 580; i = i + 90)
		{
			for(int j = 60; j <= 160; j = j + 50)
			{
				bricks.add(new Brick(i, j));
			}
		}
		
		ballX = 120;
		ballY = 230;
	}
	
	int score = 0;
	int paddleX = 310;
	int paddleY = 550;
	int ballX = 120;
	int ballY = 150;
	int ballR = 16;
	int ballXDirection = 1;
	int ballYDirection = 2;
	boolean go = true;
	boolean brix = true;
	
	public void paint(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 3, 600);
		g.fillRect(0, 0, 700, 3);
		g.fillRect(691, 0, 3, 600);
		
		g.setColor(Color.GREEN);
		g.fillRect(paddleX, paddleY, 80, 2);
		
		g.setColor(Color.RED);
		g.fillOval(ballX, ballY, ballR, ballR);	
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString(String.valueOf(score),620,40);
		
		g.setColor(Color.RED);
		if(ballY > paddleY + 20)
		{
			g.setFont(new Font("TimesRoman", Font.BOLD, 45));
			go = false;
			g.drawString("Sorry Player, You Lost",75,250);
			Ending(g);
		}
	
		
		g.setColor(Color.WHITE);
		if(score == 450)
		{
			g.setFont(new Font("TimesRoman", Font.BOLD, 45)); 
			go = false;
			g.drawString("Congratulations You Won",75,250);
			Ending(g);
		}
		
		g.setColor(Color.WHITE);
		for(int i = 0; i < bricks.size(); i++)
		{
			Brick b = bricks.get(i);
			int collisionData = b.intersects(ballX, ballY, ballR);
			//check if hit
			if(Math.abs(collisionData) == 1)
			{
				score = score + 25;
				bricks.remove(b);
				i--;
				ballYDirection = ballYDirection * -1;
			}else if(Math.abs(collisionData) == 2){
				score = score + 25;
				bricks.remove(b);
				i--;
				ballXDirection = ballXDirection * -1;
			}
			
			if(!b.beenHit)
				g.setColor(Color.WHITE);
				b.draw(g);
		}
		
	}

	
	
	
//ALL METHODS ECLIPSE IMPORTED: START
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if(go)//Brett taught me this for booleans
		{
			timer.start();
			repaint();
		
		
			//Ball Movement
			ballX = ballX + ballXDirection;
			ballY = ballY + ballYDirection;
			if(ballX < 0)
				ballXDirection = -1 * ballXDirection;
			if(ballY < 0)
				ballYDirection = ballYDirection * -1;
			if(ballX > 675)
				ballXDirection = -1 * ballXDirection;
			if(ballY == paddleY - 16 && ballX >= paddleX - 10 && ballX <= paddleX + 80)
				{
				if(ballXDirection > 0)
					ballXDirection = (int) (((Math.random() * 3) + 1));
				if(ballXDirection < 0)
					ballXDirection = (int) (((Math.random() * (-3)) - 1));
				
				ballYDirection = ballYDirection * -1;
				
				}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(paddleX >= 608)
			{
				paddleX = 608;
			}
			else
			{
				moveRight();
			}
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(paddleX <= 8)
			{
				paddleX = 8;
			}
			else
			{
				moveLeft();
			}
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_R)
		{
			Main.restartGame();
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_E)
		{
			System.exit(0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
//METHODS IMPORTED: END
	
	
	public void moveRight()
	{
		paddleX = paddleX + 16;
		
	}
	
	public void moveLeft()
	{
		paddleX = paddleX - 16;
		
	}
	
	public void RepaintIt() 
	{
		repaint();
	}
	
	public void Ending(Graphics g)
	{
		g.drawString("Press R to Replay Game",75,350);
		g.drawString("Press E to Quit Playing",75,300);
		RepaintIt();
	}
	
	
}
