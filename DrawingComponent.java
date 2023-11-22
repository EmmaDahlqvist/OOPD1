import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent {
    Point point = new Point(0,0);
    BufferedImage bufferedImage;

    public DrawingComponent(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void setPoint(int x, int y) {
        point.x = x;
        point.y = y;
    }
}
