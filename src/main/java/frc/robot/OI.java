/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.DecreaseDrivetrainSpeed;
import frc.robot.commands.IncreaseDrivetrainSpeed;
import frc.robot.commands.RaiseLiftLevelOne;
import frc.robot.commands.RaiseLiftLevelThree;
import frc.robot.commands.RaiseLiftLevelTwo;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public final Joystick xboxController = new Joystick(RobotMap.XBOX_CONTROLLER);
  public final Joystick bigJoystick = new Joystick(RobotMap.BIG_JOYSTICK);
  public final Joystick buttonBoard = new Joystick(RobotMap.BUTTON_BOARD); //This one is a joystick because of the knobs
  
  private Button leftBumper = new JoystickButton(xboxController, 5);
  private Button rightBumper = new JoystickButton(xboxController, 6);
  private Button liftLevel1 = new JoystickButton(buttonBoard, 1);
  private Button liftLevel2 = new JoystickButton(buttonBoard, 2);
  private Button liftLevel3 = new JoystickButton(buttonBoard, 3);
  
  public OI() {
    leftBumper.whenPressed(new DecreaseDrivetrainSpeed());
    rightBumper.whenPressed(new IncreaseDrivetrainSpeed());

    liftLevel1.whenPressed(new RaiseLiftLevelOne());
    liftLevel2.whenPressed(new RaiseLiftLevelTwo());
    liftLevel3.whenPressed(new RaiseLiftLevelThree());
  }
}
