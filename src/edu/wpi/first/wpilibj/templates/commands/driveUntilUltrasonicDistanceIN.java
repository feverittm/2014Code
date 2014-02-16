/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author 997robotics3
 */
public class driveUntilUltrasonicDistanceIN extends CommandBase {
    
    public driveUntilUltrasonicDistanceIN() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    subDriveTrain.SetLeft(.5 - gyroAdjust());
    subDriveTrain.SetRight(.5 + gyroAdjust());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return subDriveTrain.getUltraSonicDistance()<100;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    private double gyroAdjust() {
        double i = subDriveTrain.getGyro() / 10;
        if (Math.abs(i) > .1) {
            if (i > 0) {
                return .1;
            } else if (i < 0) {
                return -.1;
            }
        } else {
            return i;
        }
        return 0;

    }
}
