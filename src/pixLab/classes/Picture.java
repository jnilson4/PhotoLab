package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
			  
		  }
	  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(pixelObj.getGreen() - 255);
			  pixelObj.setBlue(pixelObj.getBlue() - 255);
			  pixelObj.setRed(pixelObj.getRed() - 255);
		  }
	  }
  }
  
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  int avg = (int)(pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen() / 3);
			  pixelObj.setGreen(avg);
			  pixelObj.setBlue(avg);
			  pixelObj.setRed(avg);
		  }
	  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(pixelObj.getBlue() - 100);
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  //Same setup for LtR
	  
	 Pixel[][] pixels = this.getPixels2D();
	 Pixel leftPixel = null;
	 Pixel rightPixel = null;
	 int width = pixels[0].length;
	 for(int row = pixels.length - 1; row >= 0; row--)
	 {
		 for(int col = width / 2 - 1; col >= 0; col --)
		 {
			 leftPixel = pixels[row][col];
			 rightPixel = pixels[row][width - 1 - col];
			 leftPixel.setColor(rightPixel.getColor());
		 }
	 }
	 
  }
  
  public void mirrorHorizontalBottomToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int col = pixels[0].length - 1; col >= 0; col--)
	  {
		  for(int row = 0; row < height / 2 - 1; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - row - 1][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms()
  {
	  int mirrorPoint = 192;
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  Pixel [][] pixels = this.getPixels2D();
	  
	  //Left
	  for(int row = 158; row < mirrorPoint; row++)
	  {
		  for(int col = 103; col < 170; col++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
	  
	  int mirrorPoint2 = 198;
	  Pixel topPixel2 = null;
	  Pixel bottomPixel2 = null;
	  
	  //Right
	  for(int row = 171; row < mirrorPoint2; row++)
	  {
		for(int col = 239; col < 294; col++)
		{
			topPixel2 = pixels[row][col];
			bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
			bottomPixel2.setColor(topPixel2.getColor());
		}
	  }
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 345;
	  Pixel rightPixel = null;
	  Pixel leftPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(int row = 235; row < 323; row++)
	  {
		  for(int col = 238; col < mirrorPoint; col++)
		  {
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void fullRandomGreen()
  {
	  Pixel[][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int green = (int)(Math.random() * 256);
			  
			  currentPixel.setColor(new Color(currentPixel.getRed(), green, currentPixel.getBlue()));
		  }
	  }
  }
  
  public void fullRandom()
  {
	  Pixel[][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int red = (int)(Math.random() * 256);
			  int green = (int)(Math.random() * 256);
			  int blue = (int)(Math.random() * 256);
			  
			  currentPixel.setGreen(green);
		  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel [][] toPixels = this.getPixels2D();
	  Pixel [][] fromPixels = fromPic.getPixels2D();
	  for(int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < endCol; fromRow++, toRow++)
	  {
		  for(int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < endCol; fromCol++, toCol++)
		      {
		        fromPixel = fromPixels[fromRow][fromCol];
		        toPixel = toPixels[toRow][toCol];
		        toPixel.setColor(fromPixel.getColor());
		      }    
	  }
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
	  Picture motorcycle = new Picture("motorcycle.jpg");
	  Picture robot = new Picture("robot.jpg");
	  this.copy(motorcycle, 0, 0);
	  this.copy(robot, 300, 0);
	  this.copy(motorcycle, 400, 0);
	  this.mirrorVertical();
	  this.write("collage.jpg");
  }
  
  //edgeDetection2
  public void ultraEdgeDetection(int edgeDist)
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel rightPixel2 = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  Color secondRight = null;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length-1; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][col+1];
			  rightPixel2 = pixels[row][col+2];
			  rightColor = rightPixel.getColor();
			  secondRight = rightPixel2.getColor();
			  if(leftPixel.colorDistance(rightColor) > edgeDist && leftPixel.colorDistance(secondRight) > edgeDist)
			  {
				  leftPixel.setColor(Color.BLACK);
			  }
			  else
			  {
				  leftPixel.setColor(Color.WHITE);
			  }
		  }
	  }
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void valentinesFilter()
  {
	  Picture valentines = new Picture("valentines5.png");
//	  this.copy(valentines, 200, 0);
//	  this.copy(valentines, 300, 0);
//	  this.copy(valentines, 700, 0);
	  this.write("valentines.jpg");
	  this.addMessage("Valentines Day aka Single Coders Write code", 1, 50);
	  this.addMessage("all day alone and fail at it day.", 1, 150);
  }
  
  public void glitchArt()
  {
	  Pixel[][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int green = (int)(Math.random() * 934);
			  int blue = (int)(Math.random() * 29475);
			  
			  currentPixel.setGreen(green);
		  }
	  }
	  
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int col = pixels[0].length - 1; col >= 0; col--)
	  {
		  for(int row = 0; row < height / 2 - 1; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - row - 5][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
	  
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width / 2; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  
  public void encode(Picture hiddenPicture)
  {
	  Pixel[][] currentPicture = this.getPixels2D();
	  Pixel[][] hiddenData = hiddenPicture.getPixels2D();
	  
	  Pixel currentPixel = null;
	  Pixel hiddenPixel = null;
	  
	  for(int row = 0; row < currentPicture.length; row++)
	  {
		  for(int col = 0; col < currentPicture[0].length; col++)
		  {
			  hiddenPixel = hiddenData[row][col];
			  currentPixel = currentPicture[row][col];
			  
			  if(hiddenPixel.getRed() == 255 && hiddenPixel.getGreen() == 255 && hiddenPixel.getBlue() == 255)
			  {
				  int currentRed = currentPixel.getRed();
				  if(currentRed % 2 == 0)
				  {
					  currentPixel.setRed(currentRed + 1);
				  }
			  }
			  else
			  {
				  int currentRed = currentPixel.getRed();
				  if(currentRed % 2 != 0)
				  {
					  currentPixel.setRed(currentRed - 1);
				  }
			  }
		  }
	  }
	  
	  this.write("encrypted.png");
	  this.explore();
  }
  
  public void decode()
  {
	  Pixel [][] decoded = this.getPixels2D();
	  Pixel currentPixel = null;
	  
	  for(int row = 0; row < decoded.length; row++)
	  {
		  for(int col = 0; col < decoded[0].length; col++)
		  {
			  //DFFF00
			  currentPixel = decoded[row][col];
			  int currentRed = currentPixel.getRed();
			  if(currentRed % 2 == 0)
			  {
				  currentPixel.setColor(new Color(0, 204, 255));
			  }
		  }
	  }
	  
	  this.explore();
  }
  
  public void chromakey(Picture fromPic)
  {
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
//    Picture beach = new Picture("beach.jpg");
//    beach.explore();
//    beach.zeroBlue();
//    beach.explore();
	  
	  Picture lion = new Picture("femaleLionAndHall.jpg");
	  lion.explore();
	  lion.glitchArt();
	  lion.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
