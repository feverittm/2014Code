/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonaClassesl;

import edu.wpi.first.wpilibj.SpeedController;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 997robotics4
 *  Special speed controller class to manage acceleration.  If the driver 
 *  goes from full speed forward to full reverse then we could trip the breaker
 *  depending on the gearing and acceleration of the drivetrain.  Default
 *  gears in KoP drivetrain has shown issues in the past.  However, too much
 *  accel timing can make the control sluggish.  We want a trapazoidal shape
 *  to the accel profile.
 */
public class SuperSpeedController implements SpeedController {

    private double desiredSpeed;
    private double currentSpeed;
    private SpeedController mySpeedController;

    /**
     *  Create a special version of the speed controller class to handle 
     * the acceleration differently.
     * 
     * It is currently managed as only allowing changes to speed at a 
     * specific rate (the rate is specified by the task scheduling).
     * 
     * How do we initalize the variable 'currentSpeed'?
     * 
     * @param a the speed controller
     */
    public SuperSpeedController(SpeedController a) {
        mySpeedController = a;
        currentSpeed = mySpeedController.get();
        myTimer.scheduleAtFixedRate(myTimerTask, 0, 5);
    }

    /**
     * Desired target speed
     * @param a double variable denoting the target speed
     */
    public void set(double a) {
        desiredSpeed = a;
    }

    /**
     * simple return to get the speed controller class.
     * @return the speedcontroller
     */
    public SpeedController getSpeedController() {
        return mySpeedController;
    }

    /**
     * define the timer task that tracks the acceleration of the 
     * robot.  The critical parameters are the timer rate and
     * the acceleration constant.
     */
    private Timer myTimer = new Timer();
    private TimerTask myTimerTask = new TimerTask() {
        private double maxAccel = .01;

        public void run() {
            if (desiredSpeed > currentSpeed) {
                if (desiredSpeed - currentSpeed > maxAccel) {
                    currentSpeed += maxAccel;
                } else {
                    currentSpeed = desiredSpeed;
                }

            } else if (desiredSpeed < currentSpeed) {
                if (currentSpeed - desiredSpeed > maxAccel) {
                    currentSpeed -= maxAccel;
                } else {
                    currentSpeed = desiredSpeed;
                }

            }
            mySpeedController.set(currentSpeed);
        }
    };

    /** 
     * @return the current speed from the motor controller, not the setpoint
     */
    public double get() {
        return currentSpeed;
    }

    /**
     * pass through the speed controller class method
     * @param d 
     * @param b
     */
    public void set(double d, byte b) {
        mySpeedController.set(d, b);
    }

    /**
     * pass through the speed controller class method
     */
    public void disable() {
        mySpeedController.disable();
    }

    /**
     * pass through the speed controller class method
     * @param d
     */
    public void pidWrite(double d) {
        mySpeedController.pidWrite(d);
    }

}
