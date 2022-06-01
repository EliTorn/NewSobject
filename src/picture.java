import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class picture {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Eliyahu toronto\\OneDrive - edu.aac.ac.il\\Pictures\\Camera Roll\\image.jpg");
        if(file.exists()){
            System.out.println("OK");
        }
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        image.setRGB(0,0, Color.red.getRGB());

        File outPut  = new File("picture1.png");
        try {
            ImageIO.write(image,"png",outPut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i <50 ; i++) {
            image.setRGB(i,i,Color.red.getRed());
        }


    }
}
