import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    Point carPoint = new Point();

    HashMap<Veichle, BufferedImage> cars;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y) {
        carPoint.x = x;
        carPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, HashMap<Veichle, BufferedImage> cars) {
        this.cars = cars;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    int counter = 0;

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Veichle car: cars.keySet()){
            g.drawImage(cars.get(car), (int) car.getX(), (int) car.getY(), null);
        }
//        if (counter < 19) {
//            g.drawImage(volvoImage, 1, 100, null); // see javadoc for more info on the parameters
//            g.drawImage(scaniaImage, 0, 0, null);
//            g.drawImage(saabImage, 0, 200, null);
//        } else {
//            g.drawImage(volvoImage, 30, 100, null); // see javadoc for more info on the parameters
//            g.drawImage(scaniaImage, 0, 0, null);
//        }

        counter++;


    }
}
