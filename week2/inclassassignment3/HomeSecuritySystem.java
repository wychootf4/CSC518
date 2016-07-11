import java.util.TimerTask;
import java.util.Timer;
/**
 * Created by Yuchen Wang on 7/2/2016.
 */


class RunMeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("the test is ready to run");
    }
}

class OpenDoorTask extends TimerTask {
    @Override
    public void run() {
        HomeSecuritySystem armTest1 = new HomeSecuritySystem(false, true);
        armTest1.setSystemArmed(true);
        System.out.println("System had been armed? " + armTest1.isArmed);
        armTest1.checkDoorCondition();
    }
}

class CloseDoorTask extends TimerTask {
    @Override
    public void run() {
        HomeSecuritySystem armTest2 = new HomeSecuritySystem(true, false);
        armTest2.setSystemArmed(false);
        System.out.println("System had been armed? " + armTest2.isArmed);
        // Check status of the door
        armTest2.checkDoorCondition();
    }
}

class StopTask extends TimerTask {
    @Override
    public void run() {
        HomeSecuritySystem setDurationTest = new HomeSecuritySystem();
        setDurationTest.setOnDuration(0.2f);
        System.out.println("The duration now set is " + setDurationTest.onDuration);
        // check how long the system has been turned on
        HomeSecuritySystem durationCheckTest = new HomeSecuritySystem(0.1f, 0.6f);
        System.out.println("The duration time of the system is " + durationCheckTest.getDurationTime());
    }
}

public class HomeSecuritySystem {
    public boolean isDoorOpen;
    public boolean isArmed;
    public float onDuration;
    public float initialTime;
    public float currentTime;
    public boolean setArm;

    public HomeSecuritySystem(){}

    public HomeSecuritySystem(boolean isArmed) {
        this.isArmed = isArmed;
    }

    public HomeSecuritySystem(boolean isArmed, boolean isDoorOpen) {
        this.isArmed = isArmed;
        this.isDoorOpen = isDoorOpen;
    }

    public HomeSecuritySystem(float initialTime, float currentTime) {
        this.initialTime = initialTime;
        this.currentTime = currentTime;
    }

    public void setSystemArmed(boolean setArm) {
        if (setArm) {
            isArmed = true;
        } else if (!setArm) {
            isArmed = false;
        }
    }

    public boolean checkDoorCondition() {
        if (this.isDoorOpen) {
            System.out.println("The door is open.");
            return true;
        } else {
            System.out.println("The door is closed.");
            return false;
        }
    }

    public void setOnDuration(float durationValue) {
        onDuration = durationValue;
    }

    public float getDurationTime() {
        return this.currentTime - this.initialTime;

    }

    public static void main(String[] args) {
        TimerTask startTask = new RunMeTask();
        TimerTask openDoorTask = new OpenDoorTask();
        TimerTask closeDoorTask = new CloseDoorTask();
        TimerTask stopTask = new StopTask();
        Timer timer = new Timer();
        timer.schedule(startTask, 1000);
        timer.schedule(openDoorTask, 3000);
        timer.schedule(closeDoorTask, 4000);
        timer.schedule(stopTask, 5000);
    }
}
