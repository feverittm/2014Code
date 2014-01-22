/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author 997robotics1
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Victor myVictor;
    
     public Shooter() {
        }
    public void shooterCock() {
        throw new IndexOutOfBoundsException("not yet implemented");
    
}
    public void shooterRelease() {
        throw new IndexOutOfBoundsException("not yet implemented"); 
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
