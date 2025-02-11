package view;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import model.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements MovementObserver {
    private List<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, World world) {
        this.vehicles = world.vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);

        world.addMovementObservers(this);
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Vehicle vehicle: vehicles){
            try {
                g.drawImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg")), (int) vehicle.getX(), (int) vehicle.getY(), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //notifyas från world när bilen rör sig
    @Override
    public void actOnMovementChange() {
        repaint();
    }
}
