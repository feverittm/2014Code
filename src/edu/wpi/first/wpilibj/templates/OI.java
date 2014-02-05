
package edu.wpi.first.wpilibj.templates;

import PersonaClassesl.Joystick997;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReverseTankDrive;
import edu.wpi.first.wpilibj.templates.commands.SetGear;
import edu.wpi.first.wpilibj.templates.commands.PrepShooter;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngle;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererOnOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   private final Button ShooterButton1;
   private final Button ShooterButton2;
   private final Button CockShooterButton;
   private final Button ToggleGathererButton;
   private final Button ToggleGathererButton2;
   private final JoystickButton ReverseDriveButton;
   private final JoystickButton TankDriveButton;
    private final JoystickButton SpitBallButton;
    private final JoystickButton SpitBallButton1;
    
    private final Joystick Leftstick;
    private final Joystick Rightstick ;   
    private final Joystick Utilitystick;
    
    
   
    public OI(){
        //Joystick layout
        Leftstick = new Joystick997(1);
        Rightstick = new Joystick997(2);
        Utilitystick = new Joystick997(3);
        
        
        //Button layout
       ShooterButton1 = new JoystickButton(Leftstick, 1);
       ShooterButton2 = new JoystickButton(Rightstick, 1);
       CockShooterButton = new JoystickButton(Utilitystick, 1); 
       ToggleGathererButton = new JoystickButton(Leftstick, 2);
       ToggleGathererButton2 = new JoystickButton(Rightstick,2);
       ReverseDriveButton = new JoystickButton(Rightstick, 8);
       TankDriveButton = new JoystickButton(Rightstick, 9);
       SpitBallButton = new JoystickButton(Leftstick, 3);
       SpitBallButton1 = new JoystickButton(Rightstick, 3);
       
       
        //Button Ports
        CockShooterButton.whenPressed(new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
        ShooterButton1.whenPressed(new Shoot());
        ShooterButton2.whenPressed(new Shoot());
        ToggleGathererButton.whenPressed(new ToggleGathererAngle());
        ToggleGathererButton2.whenPressed(new ToggleGathererAngle());
        TankDriveButton.whenPressed(new TankDrive());
        ReverseDriveButton.whenPressed(new ReverseTankDrive());
        SpitBallButton.whenPressed(new SpitBall());
        SpitBallButton1.whenPressed(new SpitBall());
        

        //SmartDashboard Buttons
        SmartDashboard.putData("Winch Shooter: ", new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
        SmartDashboard.putData("Relesase Shooter: ", new Shoot());
        SmartDashboard.putData("Toggle Gatherer Angle: ", new ToggleGathererAngle());
        SmartDashboard.putData("Toggle Gatherer On/Off: ", new ToggleGathererOnOff());
        SmartDashboard.putData("normal drive", new TankDrive());
        SmartDashboard.putData("Reverse Drive",new ReverseTankDrive());
}
     
   
    
    
    //Joystick Get y angle
    public double getLeftSpeed(){
       return Leftstick.getY();
    
        
    }
    public double getRightSpeed(){
          return Rightstick.getY();
    }
          
}

