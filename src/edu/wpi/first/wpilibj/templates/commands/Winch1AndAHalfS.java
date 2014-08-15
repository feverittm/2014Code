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
public class Winch1AndAHalfS extends CommandBase {

    Timer myTimer = new Timer();

    /**
     * Winch down for 1.5 second so the ball won't fall out during autonomous
     */
    public Winch1AndAHalfS() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subShooter);
    }

    /**
     * Start the timer when we want to begin this command
     */
    protected void initialize() {
        myTimer.reset();
        myTimer.start();
    }

    /**
     * start the winch...
     */
    protected void execute() {
        subShooter.retractWinch();
    }

    /**
     * Have we waited 1.5 seconds...
     *
     * @return
     */
    protected boolean isFinished() {
        return (myTimer.get() > 1.5);
    }

    /**
     * If we pulled down long enough then stop.
     */
    protected void end() {
        subShooter.stopWinch();
    }

    /**
     * If the command is ever interrupted then we need to stop too.
     */
    protected void interrupted() {
        subShooter.stopWinch();
    }
}
