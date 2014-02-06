/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import PersonaClassesl.SuperSpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;

/**
 *
 * @author Administrator
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
 
    private Encoder leftEncoder;
    private Encoder rightEncoder;
    private SuperSpeedController leftMotor;
    private SuperSpeedController rightMotor;
    
    private double gear;

    public DriveTrain(int leftEncoderSlot1,int leftEncoderSlot2, int rightEncoderSlot1, int rightEncoderSlot2, int leftMotorSlot, int rightMotorSlot) {
        leftEncoder = new Encoder(leftEncoderSlot1,leftEncoderSlot2);
        LiveWindow.addSensor("Drive Train", "left encoder", leftEncoder);
        rightEncoder = new Encoder(rightEncoderSlot1,rightEncoderSlot2);
        LiveWindow.addSensor("Drive Train", "right encoder",rightEncoder);
        leftEncoder.setDistancePerPulse(RobotMap.LeftEncoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(RobotMap.RightEncoderDistancePerPulse);
        leftMotor = new SuperSpeedController(new Talon(leftMotorSlot));
        LiveWindow.addActuator("drive train", "left motor", (Talon) leftMotor.getSpeedController());
        rightMotor = new SuperSpeedController(new Talon(rightMotorSlot));
        LiveWindow.addActuator("drive train", "right motor", (Talon) rightMotor.getSpeedController());
        gear = RobotMap.StartingGear;
    }
    public void SetLeft(double speed){
    leftMotor.set(speed);   
    }
    
    public void SetRight(double speed){
    rightMotor.set(speed);  
    }
    
    public void SetGear(double gear){
      this.gear = gear;
    }
    

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void SmartDashboard(){
        SmartDashboard.putData("Drive Train",this);
    }
}
