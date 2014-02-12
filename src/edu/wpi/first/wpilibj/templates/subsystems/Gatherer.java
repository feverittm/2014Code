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
public class Gatherer extends Subsystem{
  
    private boolean isExtended;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private boolean isOn;
    private Victor myVictor;
    private DoubleSolenoid Actuator;
    public Timer myTimer = new Timer();
    public TimerTask myTimerTask = new TimerTask() {

        public void run() {
      retractGatherer();
        }
    };
    public Gatherer(int intakeMotorSlot,int extendSolenoidSlot, int RetractSolenoidSlot) {
        Actuator = new DoubleSolenoid(extendSolenoidSlot,RetractSolenoidSlot);
        LiveWindow.addActuator("Gatherer", "solenoid", Actuator);
        myVictor = new Victor(intakeMotorSlot);
        LiveWindow.addActuator("Gatherer", "motor", myVictor);
        retractGatherer();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleOnOff() {
        if (isOn){
            turnOffGather();
        } else if (!isOn){
            turnOnGather();
        }
    }
    public void toggleRetract() {
       System.out.println("tryingToToggle");
        if (isExtended){
            System.out.println("retracting gatherer");
            retractGatherer();
        } else if (!isExtended){
            extendGatherer();
           System.out.println("extending gatherer");
        }
        
    }
    public void extendGatherer() {
       //extend
        System.out.println("extending gather");
        isExtended = true;
        Actuator.set(DoubleSolenoid.Value.kReverse);
        turnOnGather();
    }
    public void extendGathererOnly(){
        isExtended = true;
        Actuator.set(DoubleSolenoid.Value.kReverse);
    }
    public void retractGathererOnly(){
        isExtended = false;
        Actuator.set(DoubleSolenoid.Value.kForward);
    }
    
    public void upIn1Second() {
        //myTimer.schedule(null,1000);
    }
    
    public void retractGatherer() {
        //retract
        System.out.println("retracting gather");
        isExtended = false;
        Actuator.set(DoubleSolenoid.Value.kForward);
        turnOffGather();
    }
    public void turnOnGather() {
        System.out.println("turning on gather");
        myVictor.set(-.5);
        isOn = true;
    }
    public void turnOffGather() {
        myVictor.set(0);
        System.out.println("turning off gather");
        isOn = false;
    }
    public boolean getIsExtended() {
        return isExtended;
    }

    public void turnOnGatherReverse() {
        myVictor.set(.5);
        isOn = true;
    }
    public void SmartDashboard() {
        SmartDashboard.putData("Gatherer", this);
        SmartDashboard.putBoolean("Gatherer is on", isOn);
        SmartDashboard.putBoolean("Gatherer is extended", isExtended);
                }
    
}
