package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.GatherWheelInWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.LatchCommand;
import edu.wpi.first.wpilibj.templates.commands.ReverseTankDrive;
import edu.wpi.first.wpilibj.templates.commands.PrepShooter;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngleAndPower;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererPower;
import edu.wpi.first.wpilibj.templates.commands.UnLatchCommand;
import edu.wpi.first.wpilibj.templates.commands.ExtendAndTurnOnGatherer;
import edu.wpi.first.wpilibj.templates.commands.gathererWheelsIn;
import edu.wpi.first.wpilibj.templates.commands.gathererWheelsOff;
import edu.wpi.first.wpilibj.templates.commands.GathererWheelsOutWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.extendGathererOnly;
import edu.wpi.first.wpilibj.templates.commands.resetEncoder;
import edu.wpi.first.wpilibj.templates.commands.retractGathererOnly;
import edu.wpi.first.wpilibj.templates.commands.winchDownWhileHeld;
import edu.wpi.first.wpilibj.templates.commands.winchUpWhileHeld;

/**
 * This class is the glue that bGathererInds the controls on the physical operator
 GathererInterface to the commands and command groups that allow control of the robot.
 */
public class OI {

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
        GathererIn = new JoystickButton(Leftstick, 2);
        GathererOut = new JoystickButton(Leftstick, 3);
        GathererExtend = new JoystickButton(Leftstick, 4);
        GathererRetract = new JoystickButton(Leftstick, 5);
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
        CockShooterButton.whenPressed(new PrepShooter());
        ShooterButton.whenPressed(new Shoot());
        ToggleGathererButton.whenPressed(new ToggleGathererAngleAndPower());
        TankDriveButton.whenPressed(new TankDrive());
        ReverseDriveButton.whenPressed(new ReverseTankDrive());
        SpitBallButton.whenPressed(new SpitBall());
        Latch.whenPressed(new LatchCommand());
        UnLatch.whenPressed(new UnLatchCommand());
        GathererIn.whileHeld(new GatherWheelInWhileHeld());
        GathererOut.whileHeld(new GathererWheelsOutWhileHeld());
        GathererExtend.whenPressed(new extendGathererOnly());
        GathererRetract.whenPressed(new retractGathererOnly());
        RetractWinch.whileHeld(new winchDownWhileHeld());
        ExtendWinch.whileHeld(new winchUpWhileHeld());
        
        
        //SmartDashboard Buttons
        SmartDashboard.putData("Winch Shooter: ", new PrepShooter());
        SmartDashboard.putData("Relesase Shooter: ", new Shoot());
        SmartDashboard.putData("Toggle Gatherer",new ToggleGathererAngleAndPower());
        SmartDashboard.putData("Toggle Gatherer On/Off: ", new ToggleGathererPower());
        SmartDashboard.putData("normal drive", new TankDrive());
        SmartDashboard.putData("Reverse Drive", new ReverseTankDrive());
        SmartDashboard.putData("reset encoders", new resetEncoder());
    }

    //Joystick Get y angle
    public double getLeftSpeed() {
        return deadband(Leftstick.getY());

    }
    private double deadband(double a) {
        if (Math.abs(a)>.15){
            return a;
        } else {
            return 0;
        }
    }

    public double getRightSpeed() {
        return deadband(Rightstick.getY());
    }

    public void SmartDashboard() {
        SmartDashboard.putNumber("joystick left Y value", getLeftSpeed());
        SmartDashboard.putNumber("joystick right Y value", getRightSpeed());
    }

}