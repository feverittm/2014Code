/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Team 997
 */
public class ReverseTankDrive extends CommandBase {
    
    public ReverseTankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (subDriveTrain);
   }
  

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      subDriveTrain.SetLeft(-oi.getRightSpeed());  
      subDriveTrain.SetRight(-oi.getLeftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
   subDriveTrain.SetLeft(0);
   subDriveTrain.SetRight (0);
    }
}
