package esercitazione.thread.due;

import java.awt.*;

public class ColorManager extends Thread{
    private EsercitazioneGUI gui;
    private Color color;
    public ColorManager(EsercitazioneGUI gui, Color color) {
        super("Thread " + color);
        this.gui = gui;
        this.color = color;
    }

    @Override
    public void run() {
        while(gui.isThreadOn(color)){
            try {
                gui.getLabel(color).setBackground(color);
                sleep(500);
                gui.getLabel(color).setBackground(Color.WHITE);
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
