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
public class PrepShooter2 extends CommandGroup {
    
    public PrepShooter2() {
        addSequential(new UnLatchCommand());
        addSequential(new WinchAndLatch());
        addSequential(new unWinch());    
        addSequential(new setHasPreppedCommand());
        addSequential(new LEDSoff());
    }
}
