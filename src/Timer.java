public class Timer extends Thread{
    private int count;
    private EsercitazioneGUI gui;
    public Timer(){
        super("Timer");
        count = 0;
        gui = new EsercitazioneGUI();
    }

    @Override
    public void run() {
        BusyWait.delay(1000);
        count++;
    }
}
