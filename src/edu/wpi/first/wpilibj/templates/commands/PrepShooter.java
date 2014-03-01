/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author 997robotics4
 */
public class PrepShooter extends CommandGroup {
    
    public PrepShooter() {
        addParallel(new UnLatchCommand());
        addParallel(new RetractGathererAndWheelsIn());
        addSequential(new WinchAndLatch());
        addSequential(new RetractGathererAndWheelsIn());
        addSequential(new gathererWheelsOff());
        addSequential(new setHasPreppedCommand());
        addSequential (new LEDSoff());
        addSequential(new greenLED());
    }
}
