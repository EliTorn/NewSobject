import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File image =new File("C:\\Users\\Eliyahu toronto\\OneDrive - edu.aac.ac.il\\Pictures\\Camera Roll\\image.jpg");
        BufferedImage bufferedImage = ImageIO.read(image);
        bufferedImage.setRGB(0,0, Color.red.getRGB());
        int width= bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int pixcel = bufferedImage.getRGB(0,0);
        Color color = new Color(pixcel);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j ++) {
             //   Color cruuent = new Color(BufferedImage.);
                bufferedImage.setRGB(i,j,Color.green.getRGB());
            }

        }
        File outPut  = new File("picture.png");
        ImageIO.write(bufferedImage,"png",outPut);

    }
    public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
        int imageWidth  = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double)width/imageWidth;
        double scaleY = (double)height/imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(
                image,
                new BufferedImage(width, height, image.getType()));
    }
}
