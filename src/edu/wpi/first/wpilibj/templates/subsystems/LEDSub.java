/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 997
 */
public class LEDSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    DigitalOutput redSolenoid;
    DigitalOutput blueSolenoid;
    DigitalOutput greenSolenoid;

    public LEDSub() {
    greenSolenoid = new DigitalOutput(RobotMap.greenLightSlot);
    redSolenoid = new DigitalOutput(RobotMap.redLightSlot);
    blueSolenoid = new DigitalOutput(RobotMap.blueLightSlot);
    }
    private boolean b;
    public void ToggleBlue() {
       if (b){
           b = false;
           blueSolenoid.set(true);
       } else if (!b){
           b = true;
           blueSolenoid.set(false);
       }
    }
    private boolean r;
    public void ToggleRed() {
       if (r){
           r = false;
           redSolenoid.set(true);
       } else if (!r){
           r = true;
           redSolenoid.set(false);
       }
    }
    private boolean g;
    public void ToggleGreen() {
       if (g){
           g = true;
           greenSolenoid.set(true);
       } else if (!g){
           g = false;
           greenSolenoid.set(false);
       }
    }
    public void redON(){
        r = true;
        blueSolenoid.set(false);
        greenSolenoid.set(false);
        redSolenoid.set(true);
    }
    public void blueOn() {
        b = true;
        
        redSolenoid.set(false);
        greenSolenoid.set(false);
        blueSolenoid.set(true);
    }

    public void AllOff() {
        r = false;
        redSolenoid.set(false);
        b = false;
        blueSolenoid.set(false);
        g = false;
        greenSolenoid.set(false); 
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
