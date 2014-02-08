/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author 997robotics4
 */
public class DriveToSetpoint extends CommandBase {
    double Setpoint;
    public DriveToSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subDriveTrain);
        Setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        subDriveTrain.resetEncoders();
        subDriveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       subDriveTrain.SetLeft(.5-gyroAdjust());
       subDriveTrain.SetRight(.5+gyroAdjust());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return subDriveTrain.getAverageEncoders()>Setpoint;
    }

    // Called once after isFinished returns true
    protected void end() {
        subDriveTrain.SetLeft(0);
        subDriveTrain.SetRight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        subDriveTrain.SetLeft(0);
        subDriveTrain.SetRight(0);
    }

    private double gyroAdjust() {
        double i = subDriveTrain.getGyro()/10;
        if (Math.abs(i)>.1){
            return .1;
        } else {
            return i;
        }
        
    }
}
