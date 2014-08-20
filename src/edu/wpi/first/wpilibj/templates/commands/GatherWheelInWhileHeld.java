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
public class GatherWheelInWhileHeld extends CommandBase {
    
    /**
     * Turn on gatherer without pulling up the gatherer bar
     */
    public GatherWheelInWhileHeld() {
        requires(subGatherer);
    }

    /**
     * Nothing to do here...
     */
        protected void initialize() {
    }

    /**
     *  Turn on the gatherer motor
     */
        protected void execute() {
        subGatherer.turnOnGather();
    }

    // Make this return true when this Command no longer needs to run execute()

    /**
     *
     * @return
     */
        protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true

    /**
     *
     */
        protected void end() {
        subGatherer.turnOffGather();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run

    /**
     *
     */
        protected void interrupted() {
    subGatherer.turnOffGather();
    }
}
