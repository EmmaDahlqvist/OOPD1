import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawingCarComponent {
    Point point = new Point(0,0);
    BufferedImage bufferedImage;

    public DrawingCarComponent(Veichle car, String image) {
        try {
            this.bufferedImage = ImageIO.read(DrawingCarComponent.class.getResourceAsStream(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.point.x = (int) car.getX();
        this.point.y = (int) car.getY();
    }

    public Point getPoint() {
        return this.point;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
