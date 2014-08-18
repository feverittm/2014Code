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
 * Autonomous Routine:
 *   1 - Winch down a 1.5 secs to hold ball better during driving forward
 *   2 - Drive to the firing distance in front of the goal
 *   3 - prep the shooter for our autonomous shot.
 *   4 - Shoot!
 * 
 *   This version does not use the ultrasonic sensor since that can be fooled
 *   by anything (including another robot) in front of us.
 */
public class DriveThenShootAutonomousCommand extends CommandGroup {
public Timer myTimer;
    public DriveThenShootAutonomousCommand() {
        addSequential(new Winch1AndAHalfS());
        addSequential(new DriveToSetpoint(RobotMap.distanceToDriveDuringAutonomous));
        addSequential(new PrepShooter());
        addSequential(new Shoot());
        
    }
}
