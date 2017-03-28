package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Jake Nilson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  public static void testNegate()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.negate();
	  beach.explore();
  }
  
  public static void testGrayscale()
  {
	  Picture gorge = new Picture("gorge.jpg");
	  gorge.explore();
	  gorge.grayscale();
	  gorge.explore();
  }
  
  public static void testFixUnderwater()
  {
	  Picture underwater = new Picture("water.jpg");
	  underwater.explore();
	  underwater.fixUnderwater();
	  underwater.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture bike = new Picture("koala.jpg");
	  bike.explore();
	  bike.mirrorVerticalRightToLeft();
	  bike.explore();
  }
  
  public static void testMirrorHorizontalBottomToTop()
  {
	  Picture kitten = new Picture("kitten2.jpg");
	  kitten.explore();
	  kitten.mirrorHorizontalBottomToTop();
	  kitten.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testFullRandom()
  {
	  Picture msg = new Picture("msg.jpg");
	  msg.explore();
	  msg.fullRandom();
	  msg.explore();
  }
  
  public static void testFullRandomGreen()
  {
	  Picture thru = new Picture("thruDoor.jpg");
	  thru.explore();
	  thru.fullRandomGreen();
	  thru.fullRandom();
	  thru.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testUltraEdgeDetection()
  {
	Picture swan = new Picture("swan.jpg");
	swan.ultraEdgeDetection(10);
	swan.explore();
  }
  
  public static void testFilters()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.fullRandomGreen();
	  beach.mirrorVertical();
	  beach.mirrorHorizontalBottomToTop();
	  beach.mirrorArms();
	  beach.explore();
  }
  
  public static void testSteganography()
  {
	  Picture source = new Picture("ironman.png");
	  source.explore();
	  Picture hidden = new Picture("hiddenpicture.png");
	  source.encode(hidden);
	  source.explore();
	  hidden.explore();
	  source.decode();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
	//testKeepOnlyBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontalBottomToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
	//testUltraEdgeDetection();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testFullRandom();
	//testFullRandomGreen();
	//testFilters();
	  testSteganography();
  }
}