/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveToUltrasonicThenFIre;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;

    /**
     * Utility function to set the color of the LED's on the robot
     * to match the team's alliance color.
     */
        public void setLedColor() {
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.kRed) {
            CommandBase.myLED.redON();
        } else {
            CommandBase.myLED.blueOn();
        }
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        setLedColor();

        autonomousCommand = new DriveToUltrasonicThenFIre();

        // Initialize all subsystems
        CommandBase.init();
    }

    /**
     *  Initialize robot for autonomous period
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();

        setLedColor();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     *  carry out functions that need to occur at the end of autonomous 
     */
    public void disabledInit() {
        setLedColor();
    }

    /**
     * Set up to begin telop/human controlled period.
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();

        setLedColor();
        CommandBase.subGatherer.retractGatherer();
        CommandBase.subShooter.unLatch();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     *  Set up the callback functions to update status for the
     *  smartdashboard.
     */
    public void SmartDashboard() {
        //  CommandBase.myAimer.SmartDashboard();
        CommandBase.oi.SmartDashboard();
        CommandBase.subCompressor.SmartDashboard();
        CommandBase.subDriveTrain.SmartDashboard();
        CommandBase.subGatherer.SmartDashboard();
        CommandBase.subShooter.SmartDashboard();
    }
}
