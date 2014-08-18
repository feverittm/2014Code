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
 * @author FRC Team 997
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

    /**
     * Main drivetrain object
     *
     * @param leftEncoderSlot1
     * @param leftEncoderSlot2
     * @param rightEncoderSlot1
     * @param rightEncoderSlot2
     * @param leftMotorSlot
     * @param rightMotorSlot
     * @param gyroSlot
     */
    public DriveTrain(int leftEncoderSlot1, int leftEncoderSlot2, int rightEncoderSlot1, int rightEncoderSlot2, int leftMotorSlot, int rightMotorSlot, int gyroSlot) {
        leftEncoder = new Encoder(leftEncoderSlot1, leftEncoderSlot2);
        leftEncoder.start();
        leftEncoder.reset();
        LiveWindow.addSensor("Drive Train", "left encoder", leftEncoder);
        rightEncoder = new Encoder(rightEncoderSlot1, rightEncoderSlot2);
        rightEncoder.start();
        rightEncoder.reset();
        LiveWindow.addSensor("Drive Train", "right encoder", rightEncoder);
        leftEncoder.setDistancePerPulse(RobotMap.LeftEncoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(RobotMap.RightEncoderDistancePerPulse);
        leftMotor = new SuperSpeedController(new Talon(leftMotorSlot));
        LiveWindow.addActuator("Drive Train", "left motor", (Talon) leftMotor.getSpeedController());
        rightMotor = new SuperSpeedController(new Talon(rightMotorSlot));
        LiveWindow.addActuator("Drive Train", "right motor", (Talon) rightMotor.getSpeedController());
        myGyro = new Gyro(gyroSlot);
        myGyro.setSensitivity(RobotMap.GyroSensitivity);
        LiveWindow.addSensor("Drive Train", "gyro", myGyro);
        UltraSonic = new AnalogChannel(RobotMap.UltrasonicSlot);
    }

    /**
     * Directly set the speed of the motors on the left side of the robot
     *
     * @param speed of the motor on the left side of the robot
     */
    public void SetLeft(double speed) {
        leftMotor.set(speed);
    }

    /**
     * Directly set the speed of the motors on the right side of the robot
     *
     * @param speed of the motor on the right side of the robot
     */
    public void SetRight(double speed) {
        rightMotor.set(-speed);
    }

    /**
     * Stop the drivetrain
     */
    public void Stop() {
        rightMotor.set(0);
        leftMotor.set(0);
    }
    
    /**
     * What do we want the robot to do if it is not in another command loop. We
     * want it to be ready to drive by the joysticks.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Reset the encoders attached to the drivetrain
     */
    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    /**
     * reset the gyro to point foreward. This function can take a while to run.
     */
    public void resetGyro() {
        myGyro.reset();
    }

    /**
     * Get the gyro value
     *
     * @return the gyro heading
     */
    public double getGyro() {
        return myGyro.getAngle();
    }

    /**
     * Get the average of the drivetrain encoder values
     *
     * @return the average encoder value
     */
    public double getAverageEncoders() {
        return (leftEncoder.get() + rightEncoder.get()) / 2;
    }

    /**
     * Get the distance to the first item in front of the ultrasonic sensor in
     * inches.
     *
     * @return distance in inches
     */
    public double getUltraSonicDistance() {
        return UltraSonic.getVoltage() / RobotMap.UltraSonicCalibration;
    }

    /**
     * Update smartdashboard to include the elements of the drivetrain
     * (encoders, gyro and ultrasonic).
     */
    public void SmartDashboard() {
        SmartDashboard.putData("Drive Train", this);
        SmartDashboard.putNumber("left Encoder", leftEncoder.get());
        SmartDashboard.putNumber("right encoder", rightEncoder.get());
        SmartDashboard.putNumber("gyro", myGyro.getAngle());
        SmartDashboard.putNumber("UltraSonic", getUltraSonicDistance());
    }
}
