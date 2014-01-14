/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Administrator
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Timer myTimer = new Timer();
    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public DriveTrain(int leftEncoderSlot1,int leftEncoderSlot2, int rightEncoderSlot1, int rightEncoderSlot2) {
        leftEncoder = new Encoder(leftEncoderSlot1,leftEncoderSlot2);
        rightEncoder = new Encoder(leftEncoderSlot1,leftEncoderSlot2);
        leftEncoder.setDistancePerPulse(RobotMap.LeftEncoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(RobotMap.RightEncoderDistancePerPulse);
    }
    public void SetLeft(double speed){
       throw new IndexOutOfBoundsException("not yet implemented");
    }
    
    public void SetRight(double speed){
      throw new IndexOutOfBoundsException("not yet implemented");
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
