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
    private int threadCount;

    public synchronized boolean isOver() {
        return over;
    }

    private synchronized void setOver(boolean over) {
        this.over = over;
    }

    public EsercitazioneGUI(){
        threadCount = 0;
        label = new JLabel("Timer: 0");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        panelButtons = new JPanel();
        panelButtons.add(startButton);
        panelButtons.add(stopButton);
        panelButtons.add(resetButton);
        startButton.addActionListener(e -> {
            threadCount++;
            if(threadCount == 1) {
                timer = new Timer(this);
                setOver(false);
                timer.start();
            }
        });
        stopButton.addActionListener(e -> {
            setOver(true);
            threadCount--;
        });
        resetButton.addActionListener(e -> label.setText("Timer: 0"));
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
