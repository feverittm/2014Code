/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;

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
    private DoubleSolenoid myDoubleSolenoid;
    
    
     public Shooter(int victorSlot, int encoderSlot1,int encoderSlot2, int limitswitchslot, int solenoidslot1, int solenoidslot2) {
       myVictor = new Victor(victorSlot); 
       LiveWindow.addActuator("Shooter", "Winch", myVictor);
       myEncoder = new Encoder(encoderSlot1, encoderSlot2);
       LiveWindow.addSensor("Shooter", "Encoder", myEncoder);
       limitSwitch = new DigitalInput(limitswitchslot);
       LiveWindow.addSensor("Shooter", "Limit Switch", limitSwitch);
       myDoubleSolenoid = new DoubleSolenoid(solenoidslot1, solenoidslot2);
       LiveWindow.addActuator("Shooter","latch",myDoubleSolenoid);
       myPIDController = new PIDController(0, 0, 0, myEncoder, myVictor);
       LiveWindow.addActuator("Shooter", "PID", myPIDController);
       myPIDController.setAbsoluteTolerance(RobotMap.AbsolutePIDTolerance);
       myPIDController.setContinuous(false);
     }
   
    public void retractWinch() {
        myVictor.set(-1);
    }
    public void stopWinch() {
        myVictor.set(0);
    }
    public void setSetpoint(double setpoint){
        myPIDController.setSetpoint(setpoint);
    }
    public void latch(){
        myDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } 
    public void unLatch() {
        myDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
   
    public void enable(){
        myPIDController.enable();
    }
    
    public void disable(){
        myPIDController.disable();
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean getLimitSwitch() {
        return limitSwitch.get();
    }
}
