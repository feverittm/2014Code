/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import java.util.Timer;

/**
 *
 * @author 997robotics1
 */
public class Shooter extends Subsystem {

    private final PIDController myPIDController;
    private final Victor myVictor;
    private final Encoder myEncoder;
    private final DigitalInput limitSwitch;
    private final Solenoid mySolenoid;
    private final DigitalInput limitSwitch2;
    private boolean isEnabled;
    private final Timer limitSwitchChecker = new Timer();

    /**
     * global variable to indicate if we are ready to fire
     */
    public boolean isPrepped;

    /**
     *
     * @param victorSlot
     * @param encoderSlot1
     * @param encoderSlot2
     * @param limitswitchslot
     * @param limitswitchslot2
     * @param solenoidslot
     */
    public Shooter(int victorSlot, int encoderSlot1, int encoderSlot2, int limitswitchslot, int limitswitchslot2, int solenoidslot) {
        myVictor = new Victor(victorSlot);
        LiveWindow.addActuator("Shooter", "Winch", myVictor);
        myEncoder = new Encoder(encoderSlot1, encoderSlot2);
        myEncoder.start();
        myEncoder.reset();
        LiveWindow.addSensor("Shooter", "Encoder", myEncoder);

        limitSwitch = new DigitalInput(limitswitchslot);
        LiveWindow.addSensor("Shooter", "Limit Switch", limitSwitch);
        limitSwitch2 = new DigitalInput(limitswitchslot2);
        LiveWindow.addSensor("Shooter", "Limit Switch 2", limitSwitch2);
        mySolenoid = new Solenoid(solenoidslot);
        LiveWindow.addActuator("Shooter", "latch", mySolenoid);
        myPIDController = new PIDController(0, 0, 0, myEncoder, myVictor);
        LiveWindow.addActuator("Shooter", "PID", myPIDController);
        myPIDController.setAbsoluteTolerance(RobotMap.AbsolutePIDTolerance);
        myPIDController.setContinuous(false);
        isPrepped = false;
        // limitSwitchChecker.scheduleAtFixedRate(checkLimitSwitch, 0, 5);
    }

    /**
     * Simple method to run the winch until the limit switch is tripped
     */
    public void retractWinch() {
        if (!getLimitSwitch()) {
            myVictor.set(1);
        } else {
            myVictor.set(0);
        }
    }

    /**
     * stop the winch
     */
    public void stopWinch() {
        myVictor.set(0);
    }

    /**
     * Set the winch setpoint for the release point for the winch out.
     *
     * @param setpoint
     */
    public void setSetpoint(double setpoint) {
        myPIDController.setSetpoint(setpoint);
    }

    /**
     * Latch the catapult in the down position
     */
    public void latch() {
        mySolenoid.set(true);
    }

    /**
     * unlatch (fire) the catapult and then reset the LEDs to the alliance color
     */
    public void unLatch() {
        mySolenoid.set(false);
        CommandBase.myLED.AllOff();
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.kRed) {
            CommandBase.myLED.redON();
        } else {
            CommandBase.myLED.blueOn();
        }
    }

    /**
     * enable the PID to
     */
    public void enable() {
        myPIDController.enable();
        isEnabled = true;
    }

    /**
     * turn off the PID controller
     */
    public void disable() {
        myPIDController.disable();
        isEnabled = false;
    }

    /**
     * determine if the winch is at the right spot
     *
     * @return
     */
    public boolean getPIDFin() {
        return myPIDController.onTarget();
    }

    /**
     * Noting to do here...
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    private boolean lastTime;

    /**
     * check the limit switch to see if it the catapult is down
     *
     * @return
     */
    public boolean getLimitSwitch() {
        boolean value = (!limitSwitch.get() || !limitSwitch2.get());
        if (value && !lastTime) {
            resetEncoder();
        }
        lastTime = value;
        return value;
    }

    /**
     * Check limit switch 1
     *
     * @return
     */
    public boolean getRawLimit1() {
        return !limitSwitch.get();
    }

    /**
     * Check limit switch 2
     *
     * @return
     */
    public boolean getRawLimit2() {
        return !limitSwitch2.get();
    }

    /**
     * add a number of indicators to the smart dashboard that show the status of
     * the catapult
     */
    public void SmartDashboard() {
        SmartDashboard.putData("Shooter", this);
        SmartDashboard.putBoolean("Shooter limit switch", getLimitSwitch());
        SmartDashboard.putNumber("Pid setpoint", myPIDController.getSetpoint());
        SmartDashboard.putBoolean("shooter is enabled", isEnabled);
        SmartDashboard.putNumber("Shooter encoder", myEncoder.get());
        SmartDashboard.putBoolean("limit Switch 1", getRawLimit1());
        SmartDashboard.putBoolean("limit switch 2", getRawLimit2());
    }

    /**
     * Extend winch to an encoder location.
     */
    public void extendWinch() {
        if (!(getEncoder() > RobotMap.ShooterUnwoundLocation + 500)) {
            myVictor.set(-1);
        } else {
            myVictor.set(0);
        }
    }

    /**
     * reset the encoder attached to the winch gearbox
     */
    public void resetEncoder() {
        myEncoder.reset();
    }

    /**
     * return the winch encoder value.
     *
     * @return
     */
    public double getEncoder() {
        return myEncoder.get();
    }
}
