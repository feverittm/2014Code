/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author 997robotics3
 */
public class Shoot extends CommandBase {
    Timer myTimer = new Timer();
    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        myTimer.reset();
        myTimer.start();
        subGatherer.extendGatherer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return myTimer.get()>2;
    }

    // Called once after isFinished returns true
    protected void end() {
        subShooter.unLatch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
