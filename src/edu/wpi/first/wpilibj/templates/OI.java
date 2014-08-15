package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.DriveThenShootAutonomousCommand;
import edu.wpi.first.wpilibj.templates.commands.DriveToUltrasonicThenFIre;
import edu.wpi.first.wpilibj.templates.commands.GatherWheelInWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.GathererToggleAngle;
import edu.wpi.first.wpilibj.templates.commands.GathererWheelsOutWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.LatchCommand;
import edu.wpi.first.wpilibj.templates.commands.Lightup;
import edu.wpi.first.wpilibj.templates.commands.PrepShooter;
import edu.wpi.first.wpilibj.templates.commands.PrepShooter2;
import edu.wpi.first.wpilibj.templates.commands.RapidFire;
import edu.wpi.first.wpilibj.templates.commands.ResetEncoders;
import edu.wpi.first.wpilibj.templates.commands.ReverseTankDrive;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.Shoot3;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngleAndPower;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererPower;
import edu.wpi.first.wpilibj.templates.commands.TrussShot;
import edu.wpi.first.wpilibj.templates.commands.UnLatchCommand;
import edu.wpi.first.wpilibj.templates.commands.blueLED;
import edu.wpi.first.wpilibj.templates.commands.driveUntilUltrasonicDistanceIN;
import edu.wpi.first.wpilibj.templates.commands.extendGathererOnly;
import edu.wpi.first.wpilibj.templates.commands.greenLED;
import edu.wpi.first.wpilibj.templates.commands.redLED;
import edu.wpi.first.wpilibj.templates.commands.retractGathererOnly;
import edu.wpi.first.wpilibj.templates.commands.winchDownWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.winchUpWhileHeld;

/**
 * This class is the glue that bGathererInds the controls on the physical
 * operator GathererInterface to the commands and command groups that allow
 * control of the robot.
 */
public class OI {

    private final Button TrussShotButton;
    private final Button ShooterButton;
    private final Button CockShooterButton;
    private final Button ToggleGathererButton;
    private final JoystickButton ReverseDriveButton;
    private final JoystickButton TankDriveButton;
    private final JoystickButton SpitBallButton;
    private final JoystickButton GathererIn;
    private final JoystickButton GathererOut;
    private final JoystickButton GathererExtend;
    private final JoystickButton GathererRetract;
    private final JoystickButton RetractWinch;
    private final JoystickButton ExtendWinch;
    private final JoystickButton Shooter2Button;
    private final JoystickButton PrepShooter;
    //
    private final Joystick Leftstick;
    private final Joystick Rightstick;
    private final Joystick Utilitystick;
    private final JoystickButton UnLatch;
    private final JoystickButton Latch;
    private final JoystickButton ToggleGatherArms;
    private final JoystickButton QuickShotButton;
    private final JoystickButton redButton;
    private final JoystickButton blueButton;

    /**
     * initialize the operator interface
     */
    public OI() {
        //Joystick layout
        Leftstick = new Joystick(1);
        Rightstick = new Joystick(2);
        Utilitystick = new Joystick(3);

        //Define the Button layout...
        GathererIn = new JoystickButton(Leftstick, 2);
        GathererOut = new JoystickButton(Leftstick, 3);
        GathererExtend = new JoystickButton(Leftstick, 4);
        GathererRetract = new JoystickButton(Leftstick, 5);
        Shooter2Button = new JoystickButton(Leftstick, 1);
        UnLatch = new JoystickButton(Leftstick, 7);
        Latch = new JoystickButton(Leftstick, 6);

        RetractWinch = new JoystickButton(Rightstick, 4);
        ExtendWinch = new JoystickButton(Rightstick, 5);

        ShooterButton = new JoystickButton(Rightstick, 1);
        ToggleGathererButton = new JoystickButton(Rightstick, 2);
        SpitBallButton = new JoystickButton(Rightstick, 3);
        ReverseDriveButton = new JoystickButton(Rightstick, 8);
        TankDriveButton = new JoystickButton(Rightstick, 9);
        PrepShooter = new JoystickButton(Rightstick, 11);

        CockShooterButton = new JoystickButton(Utilitystick, 1);
        ToggleGatherArms = new JoystickButton(Utilitystick, 2);
        TrussShotButton = new JoystickButton(Utilitystick, 5);
        QuickShotButton = new JoystickButton(Utilitystick, 6);
        redButton = new JoystickButton(Utilitystick, 9);
        blueButton = new JoystickButton(Utilitystick, 10);

        //Now define what happens when a button even is registered...
        CockShooterButton.whenPressed(new PrepShooter2());//PrepShooter());
        TrussShotButton.whenPressed(new TrussShot());
        ShooterButton.whenPressed(new Shoot3());//Shoot());
        ToggleGathererButton.whenPressed(new ToggleGathererAngleAndPower());
        TankDriveButton.whenPressed(new TankDrive());
        ReverseDriveButton.whenPressed(new ReverseTankDrive());
        SpitBallButton.whenPressed(new SpitBall());
        Shooter2Button.whenPressed(new Shoot3());//Shoot());
        UnLatch.whenPressed(new UnLatchCommand());
        Latch.whenPressed(new LatchCommand());
        GathererIn.whileHeld(new GatherWheelInWhileHeld());
        GathererOut.whileHeld(new GathererWheelsOutWhileHeld());
        GathererExtend.whenPressed(new extendGathererOnly());
        GathererRetract.whenPressed(new retractGathererOnly());
        RetractWinch.whileHeld(new winchDownWhileHeld());
        ExtendWinch.whileHeld(new winchUpWhileHeld());
        ToggleGatherArms.whenPressed(new GathererToggleAngle());
        QuickShotButton.whenPressed(new RapidFire());
        //LightButton.whenPressed(new Lightup());
        PrepShooter.whenPressed(new PrepShooter2());//PrepShooter());

        //SmartDashboard Buttons
        SmartDashboard.putData("Winch Shooter: ", new PrepShooter());
        SmartDashboard.putData("Truss Shot", new TrussShot());
        SmartDashboard.putData("Relesase Shooter: ", new Shoot());
        SmartDashboard.putData("Toggle Gatherer", new ToggleGathererAngleAndPower());
        SmartDashboard.putData("Toggle Gatherer On/Off: ", new ToggleGathererPower());
        SmartDashboard.putData("normal drive", new TankDrive());
        SmartDashboard.putData("Reverse Drive", new ReverseTankDrive());
        SmartDashboard.putData("reset encoders", new ResetEncoders());
        SmartDashboard.putData("Fire", new Shoot());
        SmartDashboard.putData("prep shooter", new PrepShooter());
        SmartDashboard.putData("spit ball", new SpitBall());
        SmartDashboard.putData("toggle gatherer angle", new GathererToggleAngle());
        SmartDashboard.putData("drive to ultrasonic distance", new driveUntilUltrasonicDistanceIN());
        SmartDashboard.putData("rapid fire", new RapidFire());
        SmartDashboard.putData("drive to ultrasonic then fire", new DriveToUltrasonicThenFIre());
        SmartDashboard.putData("LIGHT UP THE ROBOT", new Lightup());
        SmartDashboard.putData("green LED", new greenLED());
        SmartDashboard.putData("red LED", new redLED());
        SmartDashboard.putData("blue LED", new blueLED());
        SmartDashboard.putData("Drive to Encoder distance", new DriveThenShootAutonomousCommand());

    }

    //Joystick Get y angle
    /**
     * get the value from the forward-back motion of the left joystick which
     * controls the left side wheels on the robot. Include dead band management
     * to manage the minor differences in the joysticks.
     *
     * @return left speed
     */
    public double getLeftSpeed() {
        return deadband(-Leftstick.getY());
    }

    /**
     * Deadband is set to 0.15 joystick value.
     *
     * @param a inout joystick value
     * @return return joystick value if greater than deadband
     */
    private double deadband(double a) {
        if (Math.abs(a) > .15) {
            return a;
        } else {
            return 0;
        }
    }

    /**
     *
     * @return speed for the right side wheels of the robot
     */
    public double getRightSpeed() {
        return deadband(-Rightstick.getY());
    }

    /**
     * Update SmartDashboard to include the input joystick values.
     */
    public void SmartDashboard() {
        SmartDashboard.putNumber("joystick left Y value", getLeftSpeed());
        SmartDashboard.putNumber("joystick right Y value", getRightSpeed());
    }

}
