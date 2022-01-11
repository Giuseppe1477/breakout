import java.awt.Graphics;

public class Brick
{
	private int x,y,width = 84,length = 44;
	public boolean beenHit;
	
	public Brick(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		g.fillRect(x, y, width, length);
	}
	
	//It's constant, but technically this should be more variable
	int ballRadius = 8;
	public int intersects(int BxCenter, int ByCenter)
	{
		int BX = BxCenter + 8;
		int BY = ByCenter + 8;
		
			if(BX >= x && BX <= (x + width) && BY >= y && BY <= (y + length))
				{
					if(BX <= x + width && BX >= x && BY == y)
						return -1;
					if(BX <= x + width && BX >= x && BY == y+length)
						return 1;
					if(BY <= y+length && BY >= y && BX == x)
						return -2;
					if(BY <= y+length && BY >= y && BX == x+width)
						return 2;
				}
		
		return 0;
		
	}
	
}
