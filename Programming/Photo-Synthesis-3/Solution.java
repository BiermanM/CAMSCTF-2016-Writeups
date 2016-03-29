import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Photosynthesis3 
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
		
		// All of the reasonably possible image sizes for 79704 pixels
    // First row is the height
    // Second row is the width
    int[][] arrSizes = new int[][]
		{
		  {108, 123, 162, 164, 216, 243, 246, 324, 328, 369, 486, 492, 648, 738},
		  {738, 648, 492, 486, 369, 328, 324, 246, 243, 216, 164, 162, 123, 108}
		};
		
		for (int z = 0; z < arrSizes[0].length; z++)
		{
		  // For each image size, copy and paste the contents of colors.txt into the console
		  System.out.println("Ready!");
		  BufferedImage image = new BufferedImage(arrSizes[1][z], arrSizes[0][z], BufferedImage.TYPE_INT_RGB);
		  
		  for (int y = 0; y < arrSizes[0][z]; y++)
			{
			  for (int x = 0; x < arrSizes[1][z]; x++)
			  {
			    String rgb = keyboard.nextLine();
			    
			    // Separates each line into 3 values
			    int r = Integer.valueOf(rgb.substring(0, rgb.indexOf(" ")));
			    rgb = rgb.substring(rgb.indexOf(" ") + 1);
			    int g = Integer.valueOf(rgb.substring(0, rgb.indexOf(" ")));
			    rgb = rgb.substring(rgb.indexOf(" ") + 1);
			    int b = Integer.valueOf(rgb);
			    
			    // Sets the RGB value to position (x, y)
			    image.setRGB(x, y, ( (r << 16) | (g << 8) | b ));
			  }
	    }
	    
	    // Converts the collection of pixels to a jpg
	    File outputfile = new File("image" + z + ".jpg");
	    ImageIO.write(image, "jpg", outputfile);
	  }
	  
	  keyboard.close();
  }
}

// Replace all tabs in photosynthesis3.txt with spaces
// Remove the first line: "R G B"
// The flag is contained in image9.jpg
// The flag is {4nother_l4m3_fl4g}
