/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team 997
 */
public class DriveToUltrasonicThenFIre extends CommandGroup {
    
    /**
     * Autonomous Routine: (Ultrasonic Version)
    */
    public DriveToUltrasonicThenFIre() {
       // addSequential(new extendGathererOnly());
        addSequential(new Winch1AndAHalfS());
        addSequential(new driveUntilUltrasonicDistanceIN());
        addSequential(new PrepShooter());
        addSequential(new Shoot());
    }
    
}