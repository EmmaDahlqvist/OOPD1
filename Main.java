import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarController cc = new CarController();

        Veichle saab = new Saab95();
        saab.setY(100);

        Veichle volvo = new Volvo240();

        Veichle scania = new Scania();
        scania.setY(200);

        cc.cars.put(volvo, getBufferedImage("pics/Volvo240.jpg"));
        cc.cars.put(scania, getBufferedImage("pics/Scania.jpg"));
        cc.cars.put(saab, getBufferedImage("pics/Saab95.jpg"));


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.getTimer().start();
    }

    private static BufferedImage getBufferedImage(String imageSource) throws IOException {
        BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(imageSource));
        return image;
    }

}
