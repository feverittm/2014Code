package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap extends RobotMapC {
   //encoders are 1540 counts for 75 inches
    
    /**
     * Drivetrain:
     */
    public static final int LeftDriveslot = PWM1;
    public static final int RightDriveslot = PWM2;
    public static final int leftEncoderSlot1 = DigitalIO_1;
    public static final int leftEncoderSlot2 = DigitalIO_2;
    public static final int rightEncoderSlot1 = DigitalIO_3;
    public static final int rightEncoderSlot2 = DigitalIO_4;
    public static final int DriveGyroSlot = Analog1;
    public static final int UltrasonicSlot = Analog2;

    /**
     * Gatherer:
     */
    public static final int GathererWheelslot = PWM3;
    
    /**
     * Catapult:
    */
    public static final int Winchslot = PWM4; 
    public static final int LimitSwitchslot = DigitalIO_14;
    public static final int LimitSwitchslot2 = DigitalIO_13;
    public static final int ShooterEncoderslot = DigitalIO_9; 
    public static final int ShooterEncoderslot2 = DigitalIO_10;
    
    /**
     * Pneumatics:
     */
    public static final int compressorSpikeSlot = Relay2;
    public static final int compressorSwitchSlot = DigitalIO_8;
    public static final int LatchPunematicslot = Pnuematics4; 
    public static final int GathererExtendSlot = Pnuematics1;
    public static final int GathererRetractSlot = Pnuematics2;
     
    //non-slot constants
    public static final double UltraSonicCalibration = 0.009766;
    public static final double LeftEncoderDistancePerPulse = 1;
    public static final double RightEncoderDistancePerPulse = 1;
    public static final double AbsolutePIDTolerance = 3;
    public static final double ShooterUnwoundLocation = 1500;
    public static final double TrussUnwoundLocation = 650;
    public static final double SpitOutLocation = 500;
    public static double GyroSensitivity = .007;
    public static double distanceToDriveDuringAutonomous = 18*12*20.533;
    public static double WinchoutFailsafeTimer = 2;
    public static double WinchoutTrussFailsafeTimer = 1.5;
    public static int redLightSlot = DigitalIO_6;
    public static int blueLightSlot = DigitalIO_5;
    public static int greenLightSlot = DigitalIO_7;
    
    
}
