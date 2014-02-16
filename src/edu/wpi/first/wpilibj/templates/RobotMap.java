package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap extends RobotMapC {
   
    
    public static final int LeftDriveslot = PWM1;
    public static final int RightDriveslot = PWM2;
    public static final int GathererWheelslot = PWM3;
    public static final int Winchslot = PWM4; 
    public static final int LimitSwitchslot = DigitalIO_14;
    public static final int ShooterEncoderslot = DigitalIO_9; 
    public static final int ShooterEncoderslot2 = DigitalIO_10;
    public static final int leftEncoderSlot1 = DigitalIO_1;
    public static final int leftEncoderSlot2 = DigitalIO_2;
    public static final int rightEncoderSlot1 = DigitalIO_3;
    public static final int rightEncoderSlot2 = DigitalIO_4;
    
    public static final int compressorSpikeSlot = Relay2;
    public static final int compressorSwitchSlot = DigitalIO_8;
                                                                                                                                                                                               ///why would you look here?
   
    public static final int LatchPunematicslot = Pnuematics4; 
    public static final int GathererExtendSlot = Pnuematics1;
    public static final int GathererRetractSlot = Pnuematics2;
    public static final int DriveGyroSlot = Analog1;
    public static final int UltrasonicSlot = Analog2;
     
    //non-slot constants
    public static final double UltraSonicCalibration = 0.009766;
    public static final double StartingGear = 1;
    public static final double LeftEncoderDistancePerPulse = 1;
    public static final double RightEncoderDistancePerPulse = 1;
    public static final double AbsolutePIDTolerance = 3;
    public static final double ShooterUnwoundLocation = 1500;
    public static final double TrussUnwoundLocation = 650;
    public static final double SpitOutLocation = 500;
    public static double GyroSensitivity = .007;
    public static double distanceToDriveDuringAutonomous = 1000;
    
}
