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
public class GathererWheelsOutWhileHeld extends CommandBase {
    
    /**
     * nothing extra here.
     */
    public GathererWheelsOutWhileHeld() {
        requires(subGatherer);
    }

    /**
     * nothing to do here...
     */
    protected void initialize() {
        
    }

    /**
     * turn the gatherer on in reverse - push out a ball 
     */
    protected void execute() {
    subGatherer.turnOnGatherReverse();
    }

    /**
     * nothing to do here, we are never done.  this is controlled
     * by a operator toggle
     * @return false
     */ 
    protected boolean isFinished() {
        return false;
    }

    /**
     * shut off the gatherer when the comment is stopped by the operator.
     */
    protected void end() {
        subGatherer.turnOffGather();
    }

    /**
     * if the command is interrupted, then stop the gatherer.
     */
    protected void interrupted() {
    subGatherer.turnOffGather();
    }
}
