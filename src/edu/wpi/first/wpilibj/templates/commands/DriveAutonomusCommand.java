/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Autonomous commend
 *
 * @author Team 997
 */
public class DriveAutonomusCommand extends CommandGroup {

    /**
     * anonymous command: drive to encoder count and then fire
     */
    public DriveAutonomusCommand() {
        addSequential(new DriveToSetpoint(RobotMap.distanceToDriveDuringAutonomous));
    }
}
