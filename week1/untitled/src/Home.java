import java.util.TimerTask;
import java.util.Timer;
import java.util.Vector;

/**
 * Created by hootf on 7/3/2016.
 */

class DoorSensor {
    boolean isOpen;
    boolean isTriggered;
    public DoorSensor(){}

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean getIsTriggered() {
        return this.isTriggered;
    }
}

class TempSensor {
    boolean high;
    boolean low;
    double temp;
    public TempSensor(){};
    public void setTempSensor(double temp) {
        this.temp = temp;
    }

    public double getTempSensor() {
        return this.temp;
    }

}

class Buzzer {
    public void buzz() {
        System.out.println("Alarm triggered.");
    }
}





public class Home {
    Buzzer buzzer = new Buzzer();
    static Vector<DoorSensor> doorVector = new Vector(1, 1);
    static Vector<TempSensor> tempVector = new Vector(1, 1);

    static class DoorTriggerTask1 extends TimerTask {
        @Override
        public void run() {
            doorVector.elementAt(0).setIsTriggered(true);
        }
    }

    static class DoorTriggerTask2 extends TimerTask {
        @Override
        public void run() {
            doorVector.elementAt(1).setIsTriggered(true);
        }
    }

    static class DoorTriggerAddTask extends TimerTask {
        @Override
        public void run() {
            doorVector.addElement(new DoorSensor());
        }
    }

    static class TempTriggerAddTask extends TimerTask {
        @Override
        public void run() {
            tempVector.addElement(new TempSensor());
            tempVector.addElement(new TempSensor());
            tempVector.addElement(new TempSensor());
            tempVector.addElement(new TempSensor());
            tempVector.addElement(new TempSensor());
        }
    }

    static class TempHighTask extends TimerTask {
        @Override
        public void run() {
            tempVector.elementAt(0).high = true;
        }
    }

    static class TempLowTask extends TimerTask {
        @Override
        public void run() {
            tempVector.elementAt(0).low = true;
        }
    }

    static class FinishTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("finished.");
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask doorTriggerTask1 = new DoorTriggerTask1();
        TimerTask doorTriggerTask2 = new DoorTriggerTask2();
        TimerTask doorTriggerAddTask = new DoorTriggerAddTask();
        TimerTask tempTriggerAddTask = new TempTriggerAddTask();
        TimerTask tempHighTask = new TempHighTask();
        TimerTask tempLowTask = new TempLowTask();
        TimerTask finishTask = new FinishTask();
        timer.schedule(doorTriggerTask1, 1000);
        timer.schedule(doorTriggerAddTask, 2000);
        timer.schedule(tempHighTask, 3000);
        timer.schedule(tempLowTask, 5000);
        timer.schedule(tempHighTask, 7000);
        timer.schedule(doorTriggerTask2, 7000);
        timer.schedule(tempTriggerAddTask, 8000);
        timer.schedule(tempHighTask, 9000);
        timer.schedule(finishTask, 10000);
    }
}
