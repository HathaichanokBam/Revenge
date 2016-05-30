/**
 * this class is used for layers (background layers) for example the moon will be all the way back and move according to that
 */
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLayer
{
   private Image image;

   private float x = 0;
   private float y = 0;

   private float d = 1;
   private int infinite[] = {0,1,2,3};
   
   int width;
   int height;


   public ImageLayer(String filename)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);
	 
	  try{
		  //need to load picture before getting height and width
		  Image i  = ImageIO.read(new File(filename));
		  this.width = i.getWidth(null);
		  this.height = i.getHeight(null);
	  }
	  catch (IOException e) {
		e.printStackTrace();
	}
	  
   }

   public ImageLayer(String filename, float distance)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);
      setDistance(distance);
      try{
		  //need to load picture before getting height and width
		  Image i  = ImageIO.read(new File(filename));
		  this.width = i.getWidth(null);
		  this.height = i.getHeight(null);
	  }
	  catch (IOException e) {
		e.printStackTrace();
	}
	  

   }

   public void setX(float x)
   {
      this.x = x;
   }

   public void setY(float y)
   {
      this.y = y;
   }

   public void setDistance(float distance)
   {
      d = distance;
   }

   public int getWidth(){
	   return image.getWidth(null);
   }
   public void draw(Graphics g){
	   for(int i = 0; i < 5; i++)
	      {
	         g.drawImage(image, i*image.getWidth(null) +(int)(x - Camera.x / d), (int)(y - Camera.y / d), null);
	      }
   }
   /**
    * @param g
    */
   public void drawInfinite(Graphics g)
   {

      for(int i = 0; i < 4; i++)
      {
    	  
    	 int pointScreenX =  infinite[i]*width +(int)(x - Camera.x / d);
         g.drawImage(image,pointScreenX, (int)(y - Camera.y / d), null);
         //endW = pointScreenX;
         
         //update the point where it is point to be draw
         //it depends a lot on which the position of the last picture drawn
         //depending on the picture you may need more or less in the array for this 4 is fine
         if(pointScreenX < -width){
        	 infinite[i]+=4;
        	 //this.x+=width;
         }
         /*
         //creating it for the opposite direction makes it flicker because of the contradiction
         else {
         	// int offset = -endW - point screen
         	 //drew it on top of the first
         	 //there is an offset that causes the flickering
         	 x -= endW;
          }
          */
         
      }
   }
   /*
   //not working
   public void drawInfiniteLeft(Graphics g)
   {

	   this.endW =  this.getWidth();
      for(int i = 0; i < 3; i++)
      {
    	  int pointScreenX =  i*image.getWidth(null) +(int)(x - Camera.x / d);
         g.drawImage(image,pointScreenX, (int)(y - Camera.y / d), null);
         
         if(pointScreenX > -endW){
        	 //int offset = -endW - point screen
        	 //drew it on top of the first
        	 //there is an offset that causes the flickering
        	 
        	 x -= endW;
         }
       
         
      }
      
   }
   */
}