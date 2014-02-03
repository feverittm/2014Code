
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
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngle;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererOnOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   private Button ShooterButton1;
   private Button ShooterButton2;
   private Button CockShooterButton; 
   private Button ToggleOnOffButton;
   private Button ToggleGathererButton;
   private Button SetGearQuarterButton;
   private Button SetGearHalfButton;
   private Button SetGear75Button;
   private Button SetGearFullButton;
   private final JoystickButton ReverseDriveButton;
   private final JoystickButton TankDriveButton;
    
    
    private Joystick Leftstick;
    private Joystick Rightstick ;   
    private Joystick Utilitystick;
    
    
   
    public OI(){
        //Joystick layout
        Leftstick = new Joystick997(1);
        Rightstick = new Joystick997(2);
        Utilitystick = new Joystick997(3);
        
        
        //Button layout
       ShooterButton1 = new JoystickButton(Leftstick, 1);
       ShooterButton2 = new JoystickButton(Rightstick, 1);
       CockShooterButton = new JoystickButton(Utilitystick, 1);
       ToggleOnOffButton = new JoystickButton(Leftstick, 2);
       ToggleGathererButton = new JoystickButton(Utilitystick, 2);
       SetGearQuarterButton = new JoystickButton(Utilitystick, 4);
       SetGearHalfButton = new JoystickButton(Utilitystick, 5);
       SetGear75Button = new JoystickButton(Utilitystick, 6);
       SetGearFullButton = new JoystickButton(Utilitystick, 7);
       ReverseDriveButton = new JoystickButton(Utilitystick, 8);
       TankDriveButton = new JoystickButton(Utilitystick, 9);
       
        
        //Button Ports
        CockShooterButton.whenPressed(new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
        ShooterButton1.whenPressed(new Shoot());
        ShooterButton2.whenPressed(new Shoot());
        ToggleOnOffButton.whenPressed(new ToggleGathererOnOff());
        ToggleGathererButton.whenPressed(new ToggleGathererAngle());
        SetGearQuarterButton.whenPressed(new SetGear(0.25));
        SetGearFullButton.whenPressed(new SetGear(.5));
        SetGear75Button.whenPressed(new SetGear(.75));
        SetGearFullButton.whenPressed(new SetGear(1));
        TankDriveButton.whenPressed(new TankDrive());
        ReverseDriveButton.whenPressed(new ReverseTankDrive());
        
        //SmartDashboard Buttons
        SmartDashboard.putData("Set Gear Quarter: ", new SetGear(.25));
        SmartDashboard.putData("Set Gear Half: ", new SetGear(.5));
        SmartDashboard.putData("Set Gear 3/4: ", new SetGear(.75));
        SmartDashboard.putData("set Gear Full: ", new SetGear(1));
        SmartDashboard.putData("Cock Shooter: ", new PrepShooter(RobotMap.DefaultSetPointForTheShooter));
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

