import javax.swing.*;

public class EsercitazioneGUI extends JFrame{
    private int timer;
    private JLabel label;
    private JPanel panelButtons;
    private JButton startButton;
    private JButton stopButton;
    public EsercitazioneGUI(){
        label = new JLabel("Timer: ");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        panelButtons = new JPanel();
        panelButtons.add(startButton);
        panelButtons.add(stopButton);
        add(label);
        add(panelButtons);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        pack();
        setVisible(true);
    }
}
