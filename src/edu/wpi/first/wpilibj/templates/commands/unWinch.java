/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 997
 */
public class unWinch extends CommandBase {

    Timer myTimer = new Timer();

    public unWinch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        myTimer.reset();
        myTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        subShooter.extendWinch();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (myTimer.get() > RobotMap.WinchoutFailsafeTimer) {
            System.out.println("Failsafe:  Stop Winch unwind on timer > 2.: " + myTimer.get());
        return true;
        } else{ 
            return false;
        }
    }
        // Called once after isFinished returns true
    protected void end() {
        subShooter.stopWinch();
    }


    // Called when another command which requires one or more of the same
// subsystems is scheduled to run
protected void interrupted() {
       subShooter.stopWinch();
    }
}
