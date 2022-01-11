package breakout;
import java.awt.Component;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main
{
	static JFrame obj;
	static Game game;
	
    public static void main (String [] args)
    {
        game = new Game();
        obj = new JFrame();
        
        obj.setBounds(1,1,700,600);
        obj.setTitle("BrickBreaker 2.1");
        obj.addKeyListener(game);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);
    }

    
    public static void restartGame()
    {
    	 obj.dispose();
    	 obj.remove(game);
    	 Game game = new Game();
    	 obj = new JFrame();
         obj.setBounds(1,1,700,600);
         obj.setTitle("BrickBreaker 1.1");
         obj.addKeyListener(game);
         obj.setResizable(false);
         obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 obj.add(game);
    	 obj.validate();
    }
}