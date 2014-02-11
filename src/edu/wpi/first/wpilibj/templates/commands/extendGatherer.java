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
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author 997robotics4
 */
class extendGatherer extends CommandBase {

    private Timer myTimer = new Timer();

    public extendGatherer() {
        requires(subGatherer);
    }

    protected void initialize() {
        subGatherer.extendGatherer();
        myTimer.reset();
        myTimer.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return myTimer.get() > 1;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

