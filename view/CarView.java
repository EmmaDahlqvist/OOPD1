package view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

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
    private JPanel controlPanel = new JPanel();
    private JPanel initCarPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner = new JSpinner();
    private JLabel gasLabel = new JLabel("Amount of gas");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private JButton addCarButton = new JButton("Add car");
    private JButton removeCarButton = new JButton("Remove Car");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    private World world;


    // Constructor
    public CarView(String framename, World world){
        this.world = world;
        this.X = world.width;
        this.Y = world.height;
        this.drawPanel = new DrawPanel(X, Y-240, world);
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

    public void addActionListenerToGasButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, gasButton);
    }

    public void addActionListenerToBrakeButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, brakeButton);
    }

    public void addActionListenerToTurboOnButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, turboOnButton);
    }

    public void addActionListenerToTurboOffButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, turboOffButton);
    }

    public void addActionListenerToLiftBedButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, liftBedButton);
    }

    public void addActionListenerToLowerBedButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, lowerBedButton);
    }

    public void addActionListenerToAddCarButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, addCarButton);
    }

    public void addActionListenerToRemoveCarButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, removeCarButton);
    }

    public void addActionListenerToStartButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, startButton);
    }

    public void addActionListenerToStopButton(ActionListener actionListener){
        addActionListenerToButton(actionListener, stopButton);
    }

    private void addActionListenerToButton(ActionListener actionListener, JButton button){
        button.addActionListener(actionListener);
    }

    public void addChangeListenerToGasSpinner(ChangeListener changeListener) {
        gasSpinner.addChangeListener(changeListener);
    }
}