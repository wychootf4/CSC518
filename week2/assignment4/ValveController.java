import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Yuchen Wang on 7/10/2016.
 */
class startTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Valve start.");
    }
}

class finishTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Valve finished work.");
        System.exit(0);
    }
}

public class ValveController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLease enter delay time: ");
        int delay = scanner.nextInt();
        System.out.println("Please enter duration time: ");
        int duration = scanner.nextInt();
        Timer timer = new Timer();
        timer.schedule(new startTask(), delay * 1000);
        timer.schedule(new finishTask(), duration* 1000);
    }
}
