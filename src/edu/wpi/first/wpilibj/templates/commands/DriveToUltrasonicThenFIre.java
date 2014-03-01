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
    
    public DriveToUltrasonicThenFIre() {
       // addSequential(new extendGathererOnly());
        addSequential(new Winch2s());
        addSequential(new driveUntilUltrasonicDistanceIN());
        addSequential(new PrepShooter());
        addSequential(new Shoot());
    }
    
}