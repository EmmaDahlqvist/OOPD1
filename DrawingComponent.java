import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent {
    Point point = new Point(0,0);
    BufferedImage bufferedImage;

    public DrawingComponent(BufferedImage bufferedImage, Point point) {
        this.bufferedImage = bufferedImage;
        this.point = point;
    }

    public void setPoint(int x, int y) {
        point.x = x;
        point.y = y;
    }
}
