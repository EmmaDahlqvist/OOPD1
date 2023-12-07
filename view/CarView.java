package view;

import javax.swing.*;
import java.awt.*;
import model.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private final int X;
    private final int Y;

    private DrawPanel drawPanel;
    public JPanel controlPanel = new JPanel();
    public JPanel initCarPanel = new JPanel();
    public JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner = new JSpinner();
    public JLabel gasLabel = new JLabel("Amount of gas");
    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton turboOffButton = new JButton("Saab Turbo off");
    public JButton liftBedButton = new JButton("Scania Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Lift Bed");
    public JButton addCarButton = new JButton("Add car");
    public JButton removeCarButton = new JButton("Remove Car");

    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");

    private World world;

    // Constructor
    public CarView(String framename, DrawPanel drawPanel, World world){
        this.world = world;
        this.X = world.width;
        this.Y = world.height;
        this.drawPanel = drawPanel;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        initCarPanel.setLayout(new GridLayout(2,2));

        initCarPanel.add(startButton, 0);
        initCarPanel.add(stopButton, 1);
        initCarPanel.add(addCarButton, 2);
        initCarPanel.add(removeCarButton, 3);
        initCarPanel.setPreferredSize(new Dimension((X/5-15)*2, 200));
        this.add(initCarPanel);
        initCarPanel.setBackground(Color.YELLOW);

//        startButton.setBackground(Color.blue);
//        startButton.setForeground(Color.green);
//        startButton.setPreferredSize(new Dimension(X/5-15,100));
//        this.add(startButton);
//
//
//        stopButton.setBackground(Color.red);
//        stopButton.setForeground(Color.black);
//        stopButton.setPreferredSize(new Dimension(X/5-15,100));
//        this.add(stopButton);
//
//        addCarButton.setBackground(Color.green);
//        addCarButton.setForeground(Color.black);
//        addCarButton.setPreferredSize(new Dimension(X/5-15,100));
//        this.add(addCarButton);
//
//        removeCarButton.setBackground(Color.YELLOW);
//        removeCarButton.setForeground(Color.black);
//        removeCarButton.setPreferredSize(new Dimension(X/5-15,100));
//        this.add(removeCarButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}