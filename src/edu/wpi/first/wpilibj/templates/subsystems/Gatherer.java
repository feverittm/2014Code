/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import java.util.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import java.util.TimerTask;

/**
 *
 * @author Administrator
 */
public class Gatherer extends Subsystem {

    private boolean isExtended; // is the gatherer down or up?
    private boolean isOn; // is the gatherer roller on?
    private Victor myVictor;
    private DoubleSolenoid Actuator;

    /**
     * Create a version of the standard FRC timer class. Timer resolution is in
     * milliseconds.
     */
    public Timer myTimer = new Timer();

    /**
     * Set up to retract the gatherer after the timer expires.
     */
    public TimerTask myTimerTask = new TimerTask() {

        public void run() {
            retractGatherer();
        }
    };

    /**
     * Class: Gatherer Create the main gatherer class, use variables to define
     * electronic interface. System: Ball gets pulled into the robot by a roller
     * attached on the end of an articulated bar. Bar is moved by pneumatic
     * cylinders attached to the bar. Currently there are no sensors that
     * feedback the state of the gatherer.
     *
     * Roller is driven by motot controlled by a Victor motor controller Arm is
     * actuated by 2 pneumatic cylinders controlled by a double solenoid.
     *
     * @param intakeMotorSlot
     * @param extendSolenoidSlot
     * @param RetractSolenoidSlot
     */
    public Gatherer(int intakeMotorSlot, int extendSolenoidSlot, int RetractSolenoidSlot) {
        Actuator = new DoubleSolenoid(extendSolenoidSlot, RetractSolenoidSlot);
        LiveWindow.addActuator("Gatherer", "solenoid", Actuator);
        myVictor = new Victor(intakeMotorSlot);
        LiveWindow.addActuator("Gatherer", "motor", myVictor);
        retractGatherer();
    }

    /**
     * There is no default action for the gatherer.
     */
    public void initDefaultCommand() {
    }

    /**
     * Toggle the gatherer roller on/off
     */
    public void toggleOnOff() {
        if (isOn) {
            turnOffGather();
        } else if (!isOn) {
            turnOnGather();
        }
    }

    /**
     * Toggle the gatherer up/down
     */
    public void toggleGather() {
        if (isExtended) {
            retractGatherer();
        } else if (!isExtended) {
            extendGatherer();
        }

    }

    /**
     * lower the gatherer arm and turn the roller on to pull in a ball
     */
    public void extendGatherer() {
        isExtended = true;
        Actuator.set(DoubleSolenoid.Value.kReverse);
        turnOnGather();
    }

    /**
     * pull in the gatherer arms and turn off the roller
     */
    public void retractGatherer() {
        isExtended = false;
        Actuator.set(DoubleSolenoid.Value.kForward);
        turnOffGather();
    }

    /**
     * Only drop the gatherer arms, independent of the roller
     */
    public void extendGathererArms() {
        isExtended = true;
        Actuator.set(DoubleSolenoid.Value.kReverse);
    }

    /**
     * Retract gatherer arms independent of the roller
     */
    public void retractGathererArms() {
        isExtended = false;
        Actuator.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * Turn on the gatherer roller in the direction to pull in a ball.
     */
    public void turnOnGather() {
        myVictor.set(-.5);
        isOn = true;
    }

    /**
     * Turn off the gatherer roller motor
     */
    public void turnOffGather() {
        myVictor.set(0);
        isOn = false;
    }

    /**
     * turn on the gatherer roller in the direction to spit out a ball.
     */
    public void turnOnGatherReverse() {
        myVictor.set(.5);
        isOn = true;
    }

    /**
     * @return the position of the gatherer arm (extended or not)
     */
    public boolean getIsExtended() {
        return isExtended;
    }

    /**
     * Utility method to put gatherer variables onto the SmartDashboard.
     */
    public void SmartDashboard() {
        SmartDashboard.putData("Gatherer", this);
        SmartDashboard.putBoolean("Gatherer is on", isOn);
        SmartDashboard.putBoolean("Gatherer is extended", isExtended);
    }

}
