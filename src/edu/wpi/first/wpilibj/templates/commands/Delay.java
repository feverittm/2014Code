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
public class Delay extends CommandBase {

    private final Timer myTimer = new Timer();

    private final double delay;

    /**
     * Command to delay a given amount of time
     *
     * @param delay
     */
    public Delay(double delay) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.delay = delay;
    }

    /**
     * no initialization
     */
    protected void initialize() {
    }

    /**
     * we just want to wait a given delay
     */
    protected void execute() {
        myTimer.delay(delay);
    }

    /**
     * are we done yet?
     *
     * @return
     */
    protected boolean isFinished() {
        return true;
    }

    /**
     * Any Cleanup needed at the end of the command?
     */
    protected void end() {
    }

    /**
     * Do we want to do anything if the command is stopped?
     */
    protected void interrupted() {
    }
}
