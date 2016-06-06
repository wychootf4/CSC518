/**
 * Created by Yuchen Wang on 6/4/2016.
 */
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
        if (setArm && isDoorOpen) {
            isDoorOpen = false;
            isArmed = true;
        } else if (!setArm && !isDoorOpen) {
            isDoorOpen = true;
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
        // Door is open, system is not armed and system is set to be armed
        HomeSecuritySystem armTest1 = new HomeSecuritySystem(false, true);
        armTest1.setSystemArmed(true);
        System.out.println("System had been armed? " + armTest1.isArmed);
        // Door is not open, system is armed and not set to be disarmed
        HomeSecuritySystem armTest2 = new HomeSecuritySystem(true, false);
        armTest2.setSystemArmed(false);
        System.out.println("System had been armed? " + armTest2.isArmed);
        // Check status of the door
        armTest1.checkDoorCondition();
        armTest2.checkDoorCondition();
        // set how long the system will be turned on
        HomeSecuritySystem setDurationTest = new HomeSecuritySystem();
        setDurationTest.setOnDuration(0.2f);
        System.out.println("The duration now set is " + setDurationTest.onDuration);
        // check how long the system has been turned on
        HomeSecuritySystem durationCheckTest = new HomeSecuritySystem(0.1f, 0.6f);
        System.out.println("The duration time of the system is " + durationCheckTest.getDurationTime());
    }
}
