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
    public static final int leftEncoderSlot1 = DigitalIO_1;
    public static final int leftEncoderSlot2 = DigitalIO_2;
    public static final int rightEncoderSlot1 = DigitalIO_3;
    public static final int rightEncoderSlot2 = DigitalIO_4;
     
    //non-slot constants
    public static final double StartingGear = .5;
    public static final double LeftEncoderDistancePerPulse = 1;
    public static final double RightEncoderDistancePerPulse = 1;
    
}
