/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;

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
    
    public Gatherer(int intakeMotorSlot,int extendSolenoidSlot, int RetractSolenoidSlot) {
        Actuator = new DoubleSolenoid(extendSolenoidSlot,RetractSolenoidSlot);
        LiveWindow.addActuator("Gatherer", "solenoid", Actuator);
        myVictor = new Victor(intakeMotorSlot);
        LiveWindow.addActuator("Gatherer", "motor", myVictor);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleOnOff() {
        if (isOn){
            turnOffGather();
        }
        if (!isOn){
            turnOnGather();
        }
    }
    public void toggleRetract() {
        if (isExtended){
            retractGatherer();
        }
        if (!isExtended){
            extendGatherer();
        }
        
    }
    public void extendGatherer() {
       //extend
        isExtended = true;
        Actuator.set(DoubleSolenoid.Value.kForward);
    }
    public void retractGatherer() {
        //retract
        isExtended = false;
        Actuator.set(DoubleSolenoid.Value.kReverse);
    }
    private void turnOnGather() {
        myVictor.set(1);
        isOn = true;
    }
    private void turnOffGather() {
        myVictor.set(0);
        isOn = false;
    }
    public boolean getIsExtended() {
        return isExtended;
    }
    
    
}
