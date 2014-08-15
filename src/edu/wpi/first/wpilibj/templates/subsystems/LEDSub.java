/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

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

    /**
     *  Define connections for the LED subsystem
     */
    public LEDSub() {
    greenSolenoid = new DigitalOutput(RobotMap.greenLightSlot);
    redSolenoid = new DigitalOutput(RobotMap.redLightSlot);
    blueSolenoid = new DigitalOutput(RobotMap.blueLightSlot);
    }
    private boolean b;

    /**
     * Utility function to set the color of the LED's on the robot
     * to match the team's alliance color.
     */
    public void setAllianceLedColor() {
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.kRed) {
            CommandBase.myLED.redON();
        } else {
            CommandBase.myLED.blueOn();
        }
    }
    
    /**
     * Toggle the Blue LEDS on/off
     */
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

    /**
     * Toggle the Red LEDS on/off
     */
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

    /**
     * Toggle the Green LEDS on/off
     */
    public void ToggleGreen() {
       if (g){
           g = false;
           greenSolenoid.set(true);
       } else if (!g){
           g = true;
           greenSolenoid.set(false);
       }
    }

    /**
     * turn of Red LEDs
     */
    public void redON(){
        r = true;
        blueSolenoid.set(false);
        greenSolenoid.set(false);
        redSolenoid.set(true);
    }

    /**
     * turn on Blue LEDs
     */
    public void blueOn() {
        b = true;
        
        redSolenoid.set(false);
        greenSolenoid.set(false);
        blueSolenoid.set(true);
    }

    /**
     * Turn all the LEDs off
     */
    public void AllOff() {
        r = false;
        redSolenoid.set(false);
        b = false;
        blueSolenoid.set(false);
        g = false;
        greenSolenoid.set(false); 
    }
    
    /**
     * Nothing here
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
