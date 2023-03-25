package esercitazione.thread.uno;

import javax.swing.*;

public class EsercitazioneGUI extends JFrame{
    private JLabel label;
    private JPanel panelButtons;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private Timer timer;
    private boolean over;
    public synchronized boolean isOver() {
        return over;
    }
    private synchronized void setOver(boolean over) {
        this.over = over;
    }
    public EsercitazioneGUI(){
        setOver(true);
        label = new JLabel("Timer: 0");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        panelButtons = new JPanel();
        panelButtons.add(startButton);
        panelButtons.add(stopButton);
        panelButtons.add(resetButton);
        startButton.addActionListener(e -> {
            if(isOver()) {
                timer = new Timer(this);
                setOver(false);
                timer.start();
            }
        });
        stopButton.addActionListener(e -> setOver(true));
        resetButton.addActionListener(e -> {
            if(isOver())
                label.setText("Timer: 0");
        });
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(label);
        add(panelButtons);
        pack();
        setVisible(true);
    }
    public synchronized JLabel getLabel() {
        return label;
    }

    public static void main(String[] args) {
        new EsercitazioneGUI();
    }
}
