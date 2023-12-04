import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class World {
    public int width = 800;
    public int height = 800;
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    public int gasAmount = 0;
    public HashMap<Vehicle, String> vehicles = new HashMap<>();
    public World() {

    }

    public void addCarToWorld(Vehicle vehicle, String image, int x, int y){
        vehicles.put(vehicle, image);
        vehicle.setY(y);
        vehicle.setX(x);
    }

    public Timer getTimer(){
        return timer;
    }

    private void bounceDirection(Vehicle vehicle){
        vehicle.turnRight();
        vehicle.turnRight();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles.keySet()) {
                if(vehicle.getX() <= 0 || vehicle.getX() >= 700) { //800 bredd - bilens bredd
                    bounceDirection(vehicle);
                }

                vehicle.move();

                frame.drawPanel.repaint();
            }
        }
    }
}
