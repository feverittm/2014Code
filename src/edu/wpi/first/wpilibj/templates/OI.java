package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReverseTankDrive;
import edu.wpi.first.wpilibj.templates.commands.PrepShooter;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngle;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererOnOff;
import edu.wpi.first.wpilibj.templates.commands.gathererWheelsIn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private final Button ShooterButton;
    private final Button CockShooterButton;
    private final Button ToggleGathererButton;
    private final JoystickButton ReverseDriveButton;
    private final JoystickButton TankDriveButton;
    private final JoystickButton SpitBallButton;
    private final JoystickButton GathererOn;
    private final JoystickButton GathererOut;
    private final JoystickButton GathererExtend;
    private final JoystickButton GathererRetract;
    private final JoystickButton RetractWinch;
    private final JoystickButton ExtendWinch;
    private final JoystickButton Latch;
    
    private final Joystick Leftstick;
    private final Joystick Rightstick;
    private final Joystick Utilitystick;
    private final JoystickButton UnLatch;
    

    /**
     *
     */
    public OI() {
        //Joystick layout
        Leftstick = new Joystick(1);
        Rightstick = new Joystick(2);
        Utilitystick = new Joystick(3);

        //Button layout
        GathererOn = new JoystickButton(Leftstick, 4);
        GathererOut = new JoystickButton(Leftstick, 5);
        GathererExtend = new JoystickButton(Leftstick,2);
        GathererRetract = new JoystickButton(Leftstick,3);
        Latch = new JoystickButton(Leftstick, 1);
        UnLatch = new JoystickButton(Leftstick, 7);
        
        RetractWinch = new JoystickButton(Rightstick, 4);
        ExtendWinch = new JoystickButton(Rightstick,5);
        ShooterButton = new JoystickButton(Rightstick, 1);
        ToggleGathererButton = new JoystickButton(Rightstick, 2);
        SpitBallButton = new JoystickButton(Rightstick, 3);
        ReverseDriveButton = new JoystickButton(Rightstick, 8);
        TankDriveButton = new JoystickButton(Rightstick, 9); 
        
        
        CockShooterButton = new JoystickButton(Utilitystick, 1);

        //Button Ports
        CockShooterButton.whenPressed(new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
        ShooterButton.whenPressed(new Shoot());
        ToggleGathererButton.whenPressed(new ToggleGathererAngle());
        TankDriveButton.whenPressed(new TankDrive());
        ReverseDriveButton.whenPressed(new ReverseTankDrive());
        SpitBallButton.whenPressed(new SpitBall());
        Latch.whenPressed(new LatchCommand());
        UnLatch.whenPressed(new UnLatchCommand());
        GathererOn.whileHeld(new gathererWheelsIn());
        GathererOut.whileHeld(new gathererWheelsOut());
        GathererExtend.whenPressed(new extendGatherer());
        
        
        //SmartDashboard Buttons
        SmartDashboard.putData("Winch Shooter: ", new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
        SmartDashboard.putData("Relesase Shooter: ", new Shoot());
        SmartDashboard.putData("Toggle Gatherer Angle: ", new ToggleGathererAngle());
        SmartDashboard.putData("Toggle Gatherer On/Off: ", new ToggleGathererOnOff());
        SmartDashboard.putData("normal drive", new TankDrive());
        SmartDashboard.putData("Reverse Drive", new ReverseTankDrive());
    }

    //Joystick Get y angle
    public double getLeftSpeed() {
        return Leftstick.getY();

    }

    public double getRightSpeed() {
        return Rightstick.getY();
    }

    public void SmartDashboard() {
        SmartDashboard.putNumber("joystick left Y value", getLeftSpeed());
        SmartDashboard.putNumber("joystick right Y value", getRightSpeed());
    }

}