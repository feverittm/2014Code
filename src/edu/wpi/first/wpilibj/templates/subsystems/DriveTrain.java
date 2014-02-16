/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import PersonaClassesl.SuperSpeedController;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
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
    private Gyro myGyro;
    private AnalogChannel UltraSonic;
    
    private double gear;
    
    public DriveTrain(int leftEncoderSlot1,int leftEncoderSlot2, int rightEncoderSlot1, int rightEncoderSlot2, int leftMotorSlot, int rightMotorSlot, int gyroSlot) {
        leftEncoder = new Encoder(leftEncoderSlot1,leftEncoderSlot2);
        leftEncoder.start();
        leftEncoder.reset();
        LiveWindow.addSensor("Drive Train", "left encoder", leftEncoder);
        rightEncoder = new Encoder(rightEncoderSlot1,rightEncoderSlot2);
        rightEncoder.start();
        rightEncoder.reset();
        LiveWindow.addSensor("Drive Train", "right encoder",rightEncoder);
        leftEncoder.setDistancePerPulse(RobotMap.LeftEncoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(RobotMap.RightEncoderDistancePerPulse);
        leftMotor = new SuperSpeedController(new Talon(leftMotorSlot));
        LiveWindow.addActuator("Drive Train", "left motor", (Talon) leftMotor.getSpeedController());
        rightMotor = new SuperSpeedController(new Talon(rightMotorSlot));
        LiveWindow.addActuator("Drive Train", "right motor", (Talon) rightMotor.getSpeedController());
        myGyro = new Gyro(gyroSlot);
        myGyro.setSensitivity(RobotMap.GyroSensitivity);
        LiveWindow.addSensor("Drive Train", "gyro", myGyro);
        gear = RobotMap.StartingGear;
        UltraSonic = new AnalogChannel(RobotMap.UltrasonicSlot);
    }
    public void SetLeft(double speed){
    leftMotor.set(speed);   
    }
    
    public void SetRight(double speed){
    rightMotor.set(-speed);  
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
        SmartDashboard.putNumber("left Encoder", leftEncoder.get());
        SmartDashboard.putNumber("right encoder", rightEncoder.get());
        SmartDashboard.putNumber("gyro", myGyro.getAngle());
        SmartDashboard.putNumber("UltraSonic", getUltraSonicDistance());
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void resetGyro() {
        myGyro.reset();
    }

    public double getGyro() {
        return myGyro.getAngle();
    }

    public double getAverageEncoders() {
        return (leftEncoder.get()+rightEncoder.get())/2;
    }
    public double getUltraSonicDistance(){
        return UltraSonic.getVoltage()/RobotMap.UltraSonicCalibration; 
    }
}
