package esercitazione.thread.due;

import javax.swing.*;
import java.awt.*;

public class EsercitazioneGUI extends JFrame {
    private JLabel labelRed, labelBlue;
    private JButton startRed, startBlue, stopRed, stopBlue;
    private Thread threadRed, threadBlue;
    private JPanel leftPanel, rightPanel, redButtonsPanel, blueButtonsPanel;
    private Boolean blueThreadOn, redThreadOn;

    public synchronized Boolean isThreadOn(Color color){
        if(Color.RED.equals(color))
            return redThreadOn;
        else if(Color.BLUE.equals(color))
            return blueThreadOn;
        return null;
    }

    public synchronized JLabel getLabel(Color color){
        if (Color.RED.equals(color))
            return labelRed;
        else if(Color.BLUE.equals(color))
            return labelBlue;
        return null;
    }

    private synchronized void setRedThreadOn(boolean b){
        redThreadOn = b;
    }
    private synchronized void setBlueThreadOn(boolean b){
        blueThreadOn = b;
    }

    public EsercitazioneGUI(){
        setRedThreadOn(false);
        setBlueThreadOn(false);

        labelRed = new JLabel("Rosso", SwingConstants.CENTER);
        labelBlue = new JLabel("Blu", SwingConstants.CENTER);

        labelRed.setOpaque(true);
        labelBlue.setOpaque(true);

        labelRed.setBackground(Color.WHITE);
        labelBlue.setBackground(Color.WHITE);

        startRed = new JButton("Start");
        startBlue = new JButton("Start");
        stopRed = new JButton("Stop");
        stopBlue = new JButton("Stop");

        startRed.addActionListener(e -> {
            if(!isThreadOn(Color.RED)) {
                threadRed = new ColorManager(this, Color.RED);
                setRedThreadOn(true);
                threadRed.start();
            }
        });

        startBlue.addActionListener(e -> {
            if(!isThreadOn(Color.BLUE)) {
                threadBlue = new ColorManager(this, Color.BLUE);
                setBlueThreadOn(true);
                threadBlue.start();
            }
        });

        stopBlue.addActionListener(e -> setBlueThreadOn(false));
        stopRed.addActionListener(e -> setRedThreadOn(false));


        leftPanel = new JPanel();
        rightPanel = new JPanel();

        redButtonsPanel = new JPanel();
        blueButtonsPanel = new JPanel();

        redButtonsPanel.add(startRed);
        redButtonsPanel.add(stopRed);
        blueButtonsPanel.add(startBlue);
        blueButtonsPanel.add(stopBlue);

        add(leftPanel);
        add(rightPanel);

        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());

        leftPanel.add(redButtonsPanel, BorderLayout.SOUTH);
        rightPanel.add(blueButtonsPanel, BorderLayout.SOUTH);

        leftPanel.add(labelRed, BorderLayout.CENTER);
        rightPanel.add(labelBlue, BorderLayout.CENTER);

        setLayout(new FlowLayout());
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new EsercitazioneGUI();
    }
}
