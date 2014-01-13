/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Gatherer;

/**
 *
 * @author 997robotics1
 */
public class ToggleGathererAngle extends CommandBase {
    
    public ToggleGathererAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subGatherer);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        toggleRetract();
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
    }

    private void requires(Gatherer subGatherer) {
    }

    private void toggleRetract() {
    }
}
