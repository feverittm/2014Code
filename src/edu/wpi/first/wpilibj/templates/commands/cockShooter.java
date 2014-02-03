/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author 997robotics4
 */
class cockShooter extends CommandBase {

    public cockShooter() {
        requires(subShooter);
    }

    protected void initialize() {
       
    }

    protected void execute() {
        subShooter.retractWinch();
    }

    protected boolean isFinished() {
        return subShooter.getLimitSwitch();
    }

    protected void end() {
       subShooter.latch();
       subShooter.stopWinch();
    }

    protected void interrupted() {
        subShooter.stopWinch();
    }
    
}
