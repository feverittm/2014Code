/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Administrator
 */
public class Catapult extends Subsystem {
    private boolean isExtended;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private boolean isOn;
    private Victor myVictor;
    
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
    private void extendGatherer() {
       //extend
        isExtended = true;
        throw new IndexOutOfBoundsException("not yet implemented");
    }
    private void retractGatherer() {
        //retract
        isExtended = false;
        throw new IndexOutOfBoundsException("not yet implemented");
    }
    private void turnOnGather() {
        myVictor.set(1);
        isOn = true;
    }
    private void turnOffGather() {
        myVictor.set(0);
        isOn = false;
    }
}
