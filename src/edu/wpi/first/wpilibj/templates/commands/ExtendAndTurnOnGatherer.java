/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author 997robotics4
 */
public class ExtendAndTurnOnGatherer extends CommandBase {
    private Timer myTimer = new Timer();

  ExtendAndTurnOnGatherer() {
        requires(subGatherer);
        myTimer.reset();
        myTimer.start();
    }

    protected void initialize() {
    }

    protected void execute() {
        subGatherer.extendGatherer();
    }

    protected boolean isFinished() {
        return myTimer.get() > 1;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
