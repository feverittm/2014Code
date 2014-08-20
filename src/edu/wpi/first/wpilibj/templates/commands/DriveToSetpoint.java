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
public class DriveToSetpoint extends CommandBase {

    double Setpoint;

    /**
     * Constructor for autonomous routine to drive to the location in front
     * of the goal in order to shoot our autonomous ball.
     *
     * @param setpoint
     */
    public DriveToSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(subDriveTrain);
        Setpoint = setpoint;
    }

    /**
     *  Setup to drive to the optimal distance in front of the goal to
     *  shoot our autonomous ball.
     */
        protected void initialize() {
        subDriveTrain.resetEncoders();
        subDriveTrain.resetGyro();
    }

    /**
     *  Drive using the gyro to drive straight
     */
        protected void execute() {
        subDriveTrain.SetLeft(.5 - gyroAdjust());
        subDriveTrain.SetRight(.5 + gyroAdjust());
    }

    /**
     * Determine if we have reached the setpoint.  This is a simple encoder
     * check routine and does not use PID.
     * @return are we there yet?
     */
        protected boolean isFinished() {
        return subDriveTrain.getAverageEncoders() > Setpoint;
    }

    /**
     * stop when we get to the shooting location
     */
        protected void end() {
        subDriveTrain.Stop();
    }

    /**
     * Stop at location
     */
        protected void interrupted() {
        subDriveTrain.Stop();
    }

    /**
     * use the gyro to determine a factor that is used to drive straight.
     * @return correction factor
     */
    private double gyroAdjust() {
        double i = subDriveTrain.getGyro() / 10;
        if (Math.abs(i) > .1) {
            if (i > 0) {
                return .1;
            } else if (i < 0) {
                return -.1;
            }
        } else {
            return i;
        }
        return 0;

    }
}
