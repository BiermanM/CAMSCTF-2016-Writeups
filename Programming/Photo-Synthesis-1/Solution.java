import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Photosynthesis1
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    
    // Create a text file containing the RGB values of each pixel, unless it already exists
    if ( !( new File("colors.txt") ).exists() )
      convertPixelsToRGBValues();
    
    // All of the reasonably possible image sizes for 55440 pixels
    // First row is the height
    // Second row is the width
    int[][] arrSizes = new int[][]
    {
      {105, 110, 112, 120, 126, 132, 140, 144, 154, 165, 168, 176, 180, 198, 210, 220, 231, 240, 252, 264, 280, 308, 315, 330, 336, 360, 385, 396, 420, 440, 462, 495, 504, 528, 560},
      {560, 528, 504, 495, 462, 440, 420, 396, 385, 360, 336, 330, 315, 308, 280, 264, 252, 240, 231, 220, 210, 198, 180, 176, 168, 165, 154, 144, 140, 132, 126, 120, 112, 110, 105}
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
      System.out.println(arrSizes[1][z] + " x " + arrSizes[0][z] + " is complete.");
    }
    
    keyboard.close();
  }
  
  public static void convertPixelsToRGBValues() throws IOException
  {
    // Creates colors.txt file and analyzes photosynthesis1.png
    PrintWriter fw = new PrintWriter(new BufferedWriter(new FileWriter("colors.txt", true)));
    BufferedImage img = ImageIO.read(new File("C:/Users/BiermanM/Desktop/Java Workspace/CAMSCTF/photosynthesis1.png"));
    
    // Each line in colors.txt will be in the format "R G B"
    for (int x = 0; x < 55440; x++)
    {
      int pixel = img.getRGB(x, 0);
      
      // Converts the pixel value to Alpha, R, G, and B
      int alpha = (pixel >> 24) & 0xff;
      int red = (pixel >> 16) & 0xff;
      int blue = (pixel >> 8) & 0xff;
      int green = (pixel) & 0xff;
      
      fw.println(red + " " + blue + " " + green);
    }
    
    fw.close();
    System.out.println("colors.txt has been created.");
  }
}

// The flag is contained in image13.jpg
// The flag is {C6H12O6}
