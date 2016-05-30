
import java.awt.Graphics;

/**
 * this was used for testing out things such as drawInfinite
 * these are not my images, i might even delete this class later cause it's a mess
 * @author josuerojas
 *
 */
public class Moon extends Character{
	//should delete later just put it in the constructor
	static String filename = "Images/Moon/moon", extension = ".png";
	//not used here for now
	static int xbound = Camera.x, ybound = 0-Camera.y, x2bound, y2bound;
	
	int width;

	public Moon(int width) {
		super(filename,extension, 1400,30, 1, 3, 4);
		this.width = width;
	}
	/*
	public Moon(int width, int yLowerBound, int yUpperBound,int middle){
		super(filename,extension, width,yLowerBound,yUpperBound, 4, 4, 16);
		this.middle = middle;
		//so it could walk and forth
		//x2bound = width; //27 is the width of the image
		//y2bound = height;
		
	}
	

	public int getSpeed() {
		return 1;
		}

*/
	
	//this should handle the movements too
	public void drawInfinite(Graphics g, int n, boolean pause){
		if(!pause) this.moveRt(9);
		if(this.x < Camera.x){
			//made n sort of an offset
			this.x += DumbCharacter.random.nextInt(n) + width; //draw it somewhere else in the end
		
		}
		super.draw(g);
		
	}

	
	
	//public void draw(Graphics g){
		/*
		if (movingLeft){
			moveLt(speed);
			if(x <= xbound){
				movingLeft = false;
			}
		}
		else{

			moveRt(speed);
			if(x >= x2bound){
				movingLeft = true;
			}
		}
		*/
		//super.draw(g);
	//}
	
	/*
	public void drawInfinite(Graphics g){
		if(this.x < Camera.x){
			this.x += 2*x2bound;
		}
		draw(g);
	}
	*/
	

	
}
