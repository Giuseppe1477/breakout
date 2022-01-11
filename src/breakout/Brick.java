package breakout;
import java.awt.Graphics;

public class Brick
{
	private int x, y, width = 84, length = 44;
	public boolean beenHit;
	
	public Brick(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		g.fillRect(x, y, width, length);
	}
	
	//It's constant, but technically this should be more variable
	public int intersects(int BxCord, int ByCord, int ballRad)
	{
		
		int BX = BxCord + (ballRad/2);
		int BY = ByCord;
		
		if(BX >= x && BX <= (x + width - 1) && BY >= y && BY <= (y + length - 1))
		{
			if(BX <= (x + width - 1) && BX >= x && (BY == y || BY == (y + 1) || BY == (y - 1)))
				return -1;
			if(BX <= (x + width - 1) && BX >= x && (BY == (y + length) || BY == (y + length + 1) || BY == (y + length - 1)))
				return 1;
			if(BY <= (y + length - 1) && BY >= y && (BX == x || BX == (x - 1) || BX == (x + 1)))
				return -2;
			if(BY <= (y + length - 1) && BY >= y && (BX == (x + width) || BX == (x + width - 1) || BX == (x + width + 1)))
				return 2;
		}
	
		BX = BxCord;
		BY = ByCord + (ballRad/2);
		
		if(BX >= x && BX <= (x + width) && BY >= y && BY <= (y + length))
		{
			if(BX <= (x + width - 1) && BX >= x && (BY == y || BY == (y + 1) || BY == (y - 1)))
				return -1;
			if(BX <= (x + width - 1) && BX >= x && (BY == (y + length) || BY == (y + length + 1) || BY == (y + length - 1)))
				return 1;
			if(BY <= (y + length - 1) && BY >= y && (BX == x || BX == (x - 1) || BX == (x + 1)))
				return -2;
			if(BY <= (y + length - 1) && BY >= y && (BX == (x + width) || BX == (x + width - 1) || BX == (x + width + 1)))
				return 2;
		}

		BX = BxCord + ballRad;
		BY = ByCord + (ballRad/2);
		
		if(BX >= x && BX <= (x + width) && BY >= y && BY <= (y + length))
		{
			if(BX <= (x + width - 1) && BX >= x && (BY == y || BY == (y + 1) || BY == (y - 1)))
				return -1;
			if(BX <= (x + width - 1) && BX >= x && (BY == (y + length) || BY == (y + length + 1) || BY == (y + length - 1)))
				return 1;
			if(BY <= (y + length - 1) && BY >= y && (BX == x || BX == (x - 1) || BX == (x + 1)))
				return -2;
			if(BY <= (y + length - 1) && BY >= y && (BX == (x + width) || BX == (x + width - 1) || BX == (x + width + 1)))
				return 2;
		}
		
		BX = BxCord + (ballRad/2);
		BY = ByCord + ballRad;
		
		if(BX >= x && BX <= (x + width) && BY >= y && BY <= (y + length))
		{
			if(BX <= (x + width - 1) && BX >= x && (BY == y || BY == (y + 1) || BY == (y - 1)))
				return -1;
			if(BX <= (x + width - 1) && BX >= x && (BY == (y + length) || BY == (y + length + 1) || BY == (y + length - 1)))
				return 1;
			if(BY <= (y + length - 1) && BY >= y && (BX == x || BX == (x - 1) || BX == (x + 1)))
				return -2;
			if(BY <= (y + length - 1) && BY >= y && (BX == (x + width) || BX == (x + width - 1) || BX == (x + width + 1)))
				return 2;
		}
			
		return 0;
		
	}
	
}
