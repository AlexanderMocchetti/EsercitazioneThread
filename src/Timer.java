public class Timer extends Thread{
    private Integer count;
    private EsercitazioneGUI gui;
    public Timer(EsercitazioneGUI gui){
        super("Timer");
        count = 0;
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            while(!gui.isOver()) {
                sleep(1000);
                count++;
                gui.getLabel().setText("Timer: " + count);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
