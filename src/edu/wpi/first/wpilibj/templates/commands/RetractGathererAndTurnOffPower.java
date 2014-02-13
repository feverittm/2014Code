/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author 997robotics4
 */
class RetractGathererAndTurnOffPower extends CommandBase {

    private Timer myTimer = new Timer();

    public RetractGathererAndTurnOffPower() {
        requires(subGatherer);
    }

    protected void initialize() {
        subGatherer.retractGatherer();
        myTimer.reset();
        myTimer.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        //stops the command after 2 second
        return myTimer.get() >= 2;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
