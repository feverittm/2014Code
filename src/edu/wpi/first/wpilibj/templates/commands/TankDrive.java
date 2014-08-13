/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author 997robotics3
 */
public class TankDrive extends CommandBase {

    /**
     * Main command to drive robot like a tank with direct controls for each 
     * side of the robot independently.
     */
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subDriveTrain);
    }
    
    /**
     *  Called just before this Command runs the first time
     *  There is not initialization for this command.  It could
     *  cause the drivetrain to jerk.
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     *  set the speed of the robot using values from the joysticks
     */
    protected void execute() {
        subDriveTrain.SetLeft(oi.getLeftSpeed());
        subDriveTrain.SetRight(oi.getRightSpeed());
    }

    /**
     *  This command never is finished.  It is superseeded by other functions
     * in the command stack.
     * @return flag.  For the drivetrain code this is always false.
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     *  What to do when the command is finished.
     */
    protected void end() {

    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     *
     */
    protected void interrupted() {
        subDriveTrain.SetLeft(0);
        subDriveTrain.SetRight(0);
    }
}
