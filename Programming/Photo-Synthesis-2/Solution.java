import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Photosynthesis2 
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    
    // Create a text file containing the RGB values of each pixel, unless it already exists
    if ( !( new File("colors.txt") ).exists() )
      convertPixelsToRGBValues();
    
    // All of the reasonably possible image sizes for 172800 pixels
    // First row is the height
    // Second row is the width  
    int[][] arrSizes = new int[][]
    {
      {100, 108, 120, 128, 135, 144, 150, 160, 180, 192, 200, 216, 225, 240, 256, 270, 288, 300, 320, 360, 384, 400, 432, 450, 480, 540, 576, 600, 640, 675, 720, 768, 800, 864, 900, 960, 1080, 1152, 1200, 1280, 1350, 1440, 1600, 1728},
      {1728, 1600, 1440, 1350, 1280, 1200, 1152, 1080, 960, 900, 864, 800, 768, 720, 675, 640, 600, 576, 540, 480, 450, 432, 400, 384, 360, 320, 300, 288, 270, 256, 240, 225, 216, 200, 192, 180, 160, 150, 144, 135, 128, 120, 108, 100}
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
    // Creates colors.txt file
    PrintWriter fw = new PrintWriter(new BufferedWriter(new FileWriter("colors.txt", true)));
    
    // Each line in colors.txt will be in the format "R G B"
    for (int x = 0; x < 172800; x++)
    {
      // Analyzes each file in the /a/ directory
      BufferedImage img = ImageIO.read(new File("C:/Users/BiermanM/Desktop/a/" + x + ".png"));
      int pixel = img.getRGB(0, 0);
      
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

// Extract photosynthesis2.zip to /a/
// The flag is contained in image19.jpg
// The flag is {n47ur3}
