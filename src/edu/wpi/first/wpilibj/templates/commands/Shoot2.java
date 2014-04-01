/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Team 997
 */
public class Shoot2 extends CommandBase {
    Timer myTimer = new Timer();
    public Shoot2() {
        requires(subShooter);
        requires(subGatherer);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        subGatherer.extendGathererArms();
        myTimer.reset();
        myTimer.start();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       
        }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return myTimer.get()>1.5;
    }

    // Called once after isFinished returns true
    protected void end() {
       if (subShooter.isPrepped){
        subShooter.unLatch();
        }
        
        
        subShooter.isPrepped = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        subShooter.isPrepped = false;
    }
}
