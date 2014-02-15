/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import java.util.Timer;


/**
 *
 * @author 997robotics1
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private PIDController myPIDController;
    private Victor myVictor;
    private Encoder myEncoder;
    private DigitalInput limitSwitch;
    private Solenoid mySolenoid;
    private boolean isEnabled;
    private Timer limitSwitchChecker = new Timer();
    public boolean isPrepped;
   

    public Shooter(int victorSlot, int encoderSlot1, int encoderSlot2, int limitswitchslot, int solenoidslot) {
        myVictor = new Victor(victorSlot);
        LiveWindow.addActuator("Shooter", "Winch", myVictor);
        myEncoder = new Encoder(encoderSlot1, encoderSlot2);
        myEncoder.start();
        myEncoder.reset();
        LiveWindow.addSensor("Shooter", "Encoder", myEncoder);
        limitSwitch = new DigitalInput(limitswitchslot);
        LiveWindow.addSensor("Shooter", "Limit Switch", limitSwitch);
        mySolenoid = new Solenoid(solenoidslot);
        LiveWindow.addActuator("Shooter", "latch", mySolenoid);
        myPIDController = new PIDController(0, 0, 0, myEncoder, myVictor);
        LiveWindow.addActuator("Shooter", "PID", myPIDController);
        myPIDController.setAbsoluteTolerance(RobotMap.AbsolutePIDTolerance);
        myPIDController.setContinuous(false);
        isPrepped = false;
        // limitSwitchChecker.scheduleAtFixedRate(checkLimitSwitch, 0, 5);
    }

    public void retractWinch() {
        if (!getLimitSwitch()) {
            myVictor.set(1);
        } else {
            myVictor.set(0);
        }
    }

    public void stopWinch() {
        myVictor.set(0);
    }

    public void setSetpoint(double setpoint) {
        myPIDController.setSetpoint(setpoint);
    }

    public void latch() {
        mySolenoid.set(true);
    }

    public void unLatch() {
        mySolenoid.set(false);
    }

    public void enable() {
        myPIDController.enable();
        isEnabled = true;
    }

    public void disable() {
        myPIDController.disable();
        isEnabled = false;
    }

    public boolean getPIDFin() {
        return myPIDController.onTarget();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
private boolean lastTime;
    public boolean getLimitSwitch() {
        boolean value = !limitSwitch.get();
        if (value && !lastTime) {
            resetEncoder();
        }
        lastTime = value;
        return value;
    }

    public void SmartDashboard() {
        SmartDashboard.putData("Shooter", this);
        SmartDashboard.putBoolean("Shooter limit switch", getLimitSwitch());
        SmartDashboard.putNumber("Pid setpoint", myPIDController.getSetpoint());
        SmartDashboard.putBoolean("shooter is enabled", isEnabled);
        SmartDashboard.putNumber("Shooter encoder", myEncoder.get());
    }

    public void extendWinch() {
       if (!(getEncoder()>RobotMap.ShooterUnwoundLocation+1000)){
               myVictor.set(-1);
       }else{
           myVictor.set(0);
       }
    }

    public void resetEncoder() {
        myEncoder.reset();
    }

    public double getEncoder() {
        return myEncoder.get();
    }
}