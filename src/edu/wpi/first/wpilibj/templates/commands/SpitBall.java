/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author 997robotics4
 */
public class SpitBall extends CommandBase {

    public SpitBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subShooter);
        requires(subGatherer);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        subGatherer.retractGatherer();
        subGatherer.turnOnGatherReverse();
        subShooter.setSetpoint(RobotMap.SpitOutLocation);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        subShooter.enable();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return false; //subShooter.getPIDFin();

    }

    // Called once after isFinished returns true
    protected void end() {

        subShooter.disable();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

        subShooter.disable();

    }
}
