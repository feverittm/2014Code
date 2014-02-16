/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author 997robotics4
 */
public class DriveThenShootAutonomousCommand extends CommandGroup {
public Timer myTimer;
    public DriveThenShootAutonomousCommand() {
        addParallel(new PrepShooter());
        addSequential(new DriveToSetpoint(RobotMap.distanceToDriveDuringAutonomous));
        addSequential(new Shoot());
        
    }
}
