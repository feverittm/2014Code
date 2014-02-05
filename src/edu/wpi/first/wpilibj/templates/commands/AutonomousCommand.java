/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author 997robotics3
 */
public class AutonomousCommand extends CommandBase {
    Timer myTimer = new Timer();
    
    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(myAimer);
        requires(subShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        myAimer.LEDSOn();
        myTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return myAimer.goalIsHot() || (myTimer.get()>=7);
    }

    // Called once after isFinished returns true
    protected void end() {
        myAimer.LEDStrand.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        myAimer.LEDStrand.set(Relay.Value.kOff);
    }
}
