package esercitazione.thread.due;

import javax.swing.*;
import java.awt.*;

public class EsercitazioneGUI extends JFrame {
    private JLabel labelRed, labelBlue;
    private JButton startRed, startBlue, stopRed, stopBlue;
    private Thread threadRed, threadBlue;
    private JPanel leftPanel, rightPanel, redButtonsPanel, blueButtonsPanel;

    public synchronized JLabel getLabelRed(){
        return labelRed;
    }

    public synchronized JLabel getLabelBlue(){
        return labelBlue;
    }

    public EsercitazioneGUI(){
        labelRed = new JLabel("Rosso");
        labelBlue = new JLabel("Blu");

        startRed = new JButton("Start");
        startBlue = new JButton("Start");
        stopRed = new JButton("Stop");
        stopBlue = new JButton("Stop");

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
