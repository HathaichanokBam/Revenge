import java.awt.Graphics;

/**
 * this was used for testing out things such as drawInfinite
 * these are not my images, i might even delete this class later cause it's a mess
 * @author josuerojas
 *
 */
public class GreenGuyReborn extends DumbCharacter{
	//should delete later just put it in the constructor
	static String filename = "Images/GreenGuy/g", extension = ".GIF";
	static int xbound = Camera.x, ybound = 0-Camera.y, x2bound, y2bound;
	//boolean movingLeft = false; //this is to keep track of direction
	int middle;
	int speed = getSpeed();

	public GreenGuyReborn() {
		//defaults,,, not recommended. 
		super(filename,extension, 1440,900, 0, 4, 4, 4);
		this.middle = 450;
	}
	
	public GreenGuyReborn(int width, int yLowerBound, int yUpperBound,int middle){
		super(filename,extension, width,yLowerBound,yUpperBound, 4, 4, 16);
		this.middle = middle;
		//so it could walk and forth
		//x2bound = width; //27 is the width of the image
		//y2bound = height;
		
	}

	public int getSpeed() {
		return 1;
		}

	/**
	 * NEEDS TO BE FIX TO MAKE IT STATIC
	 */
	@Override
	public DumbCharacter[] getDCArray(int quantity) {
		GreenGuyReborn[] returnArray = new GreenGuyReborn[quantity];
		for(int i = 0; i < quantity; i++){
				returnArray[i] = new GreenGuyReborn(width,yLowerBound,yUpperBound,middle);
		}
		return returnArray;
	}
	
	//this should handle the movements too
	public void drawInfinite(Graphics g, int n, boolean pause){
		//seperate the movements 
		if(!pause){
		if(this.y > middle){
			this.moveLt(speed);
		}
		else this.moveRt(speed);
		
		}
		super.drawInfinite(g, n);

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
