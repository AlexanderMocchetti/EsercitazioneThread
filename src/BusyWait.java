import java.util.Date;

public class BusyWait {
    public static void delay(long millis){
        boolean finished = false;
        Date date = new Date();
        Date now;
        while (!finished){
            now = new Date();
            if((now.getTime() - date.getTime()) >= millis)
                finished = true;
        }
    }
}
